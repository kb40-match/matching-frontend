<template>
  <div class="wrapper">
    <ChatRoomMyProfile :user="receiver" />
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
      <ChatRoomMessageInput @sentMessageContent="addSentMessage" />
    </main>
  </div>
</template>

<script>
import SockJS from "sockjs-client";
import Stomp from "webstomp-client";
import dayjs from "dayjs";

import { fetchPackUserAndMyData } from "./_worker/user";
import { useAppStore } from "@/store/userState";
import ChatRoomMyProfile from "./_components/ChatRoomMyProfile.vue";
import ChatRoomDateDivider from "./_components/ChatRoomDateDivider.vue";
import ChatRoomMessageBox from "./_components/ChatRoomMessageBox.vue";
import ChatRoomMessageInput from "./_components/ChatRoomMessageInput.vue";

export default {
  name: "ChatRoom",
  setup() {
    const store = useAppStore();
    return { store };
  },
  data() {
    return {
      messages: [],
      user: {},
      receiver: {},
      showMore: false,
    };
  },
  mounted() {
    this.prepareUser({ userId: "user5", receiverId: "user131" });
  },
  created() {
    this.connectSocket();
  },
  watch: {},
  components: {
    ChatRoomMyProfile,
    ChatRoomMessageBox,
    ChatRoomDateDivider,
    ChatRoomMessageInput,
  },
  methods: {
    async prepareUser({ userId, receiverId }) {
      this.user = await fetchPackUserAndMyData(userId);
      this.receiver = await fetchPackUserAndMyData(receiverId);
      console.log(this.user.user.userId, this.receiver.user.userId);
    },
    addSentMessage(sentMessageContent) {
      const { userId } = this.user.user;
      const matchId = 15;
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
      const CHAT_TARGET =
        "http://matching.169.56.100.104.nip.io/websocket-server/ws";
      const matchId = 1;

      const chatSocket = new SockJS(CHAT_TARGET);

      this.stompClient = Stomp.over(chatSocket);

      console.log(CHAT_TARGET);

      this.stompClient.connect(
        {},
        () => {
          this.connected = true;

          this.stompClient.subscribe(`/topic/${matchId}`, (res) => {
            const receivedMessage = JSON.parse(res.body);
            console.log(receivedMessage);
            if (receivedMessage.userId !== this.store.user.userId) {
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
};
</script>

<style scoped>
.wrapper {
  width: 100vw;
  height: 100%;
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
