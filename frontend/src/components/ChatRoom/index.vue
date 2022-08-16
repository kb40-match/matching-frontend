<template>
  <div class="screen">
    <ChatRoomMyProfile :user="this.user" />
    <main>
      <div class="messages">
        <div
          class="message-wrapper"
          v-for="message in this.messages"
          :key="message.messageId"
        >
          <ChatRoomDateDivider
            v-if="
              message.messageId === 0 ||
              messages[message.messageId - 1].createdDate.slice(0, 8) !==
                message.createdDate.slice(0, 8)
            "
            :date="message.createdDate"
          />
          <div class="box-wrapper">
            <ChatRoomMessageBox
              :message="message"
              :onLeft="message.userId === receiver.userId"
            />
            <!-- <ChatRoomTimeIndicator :date="message.createdDate" /> -->
          </div>
        </div>
      </div>
      <ChatRoomMessageInput @sentMessageContent="this.addSentMessage" />
    </main>
  </div>
</template>

<script>
import SockJS from "sockjs-client";
import Stomp from "webstomp-client";
import dayjs from "dayjs";

import { prevData, user, receiver } from "./_worker/api";
import { useUserStore } from "@/store/states/userState";
import { loadUser } from "@/worker/user";
import ChatRoomMyProfile from "./_components/ChatRoomMyProfile.vue";
import ChatRoomDateDivider from "./_components/ChatRoomDateDivider.vue";
import ChatRoomMessageBox from "./_components/ChatRoomMessageBox.vue";
import ChatRoomMessageInput from "./_components/ChatRoomMessageInput.vue";
// import ChatRoomTimeIndicator from "./_components/ChatRoomTimeIndicator.vue";

export default {
  name: "ChatRoom",
  setup() {
    const store = useUserStore();
    return { store };
  },
  async data() {
    return {
      dummyTurn: 0,
      dummyId: prevData.length,
      // messages: await fetchPrevList(),
      messages: [],
      user,
      receiver,
    };
  },
  components: {
    ChatRoomMyProfile,
    ChatRoomMessageBox,
    ChatRoomDateDivider,
    ChatRoomMessageInput,
    // ChatRoomTimeIndicator,
  },
  methods: {
    addSentMessage(sentMessageContent) {
      const { userId } = this.store.user;
      // const matchId = Math.round(
      //   Number(userId.slice(userId.length - 1)) / 2,
      // );
      const matchId = 1;
      const message = {
        matchId,
        userId,
        content: sentMessageContent,
        createdDate: dayjs().format("YYYYMMDDHHmmss"),
      };
      
      this.messages.push({
        ...message,
        messageId: this.messages ? this.messages.length : 0,
      });
      this.stompClient.send(
        `/app/chat.sendMessage/${matchId}`,
        JSON.stringify(message),
        {},
      );
    },
    connectSocket() {
      const CHAT_TARGET = "http://10.214.5.187:8082/websocket-server/ws";
      const matchId = 1;

      const chatSocket = new SockJS(CHAT_TARGET);

      this.stompClient = Stomp.over(chatSocket);

      this.stompClient.connect(
        {},
        () => {
          this.connected = true;
          const { user } = this.store;

          this.stompClient.subscribe(`/topic/${matchId}`, (res) => {
            const receivedMessage = JSON.parse(res.body);
            if (receivedMessage.userId !== user.userId) {
              this.messages.push(receivedMessage);
            }
          });
        },
        () => {
          console.log("FAILED");
          this.connected = false;
        },
      );
    },
  },
  created() {
    this.connectSocket();
  },
  async mounted() {
    await loadUser("user1");
  },
};
</script>

<style scoped>
.screen {
  width: 100vw;
  height: 100vh;
  overflow: hidden;
}

main {
  height: calc(100% - 58px);
  overflow-y: scroll;
}

.message-wrapper {
  width: 90%;
  margin: 0 auto;
}

.messages {
  height: calc(100% - 126px);
}

h1 {
  margin: 7px 0;
}
</style>
