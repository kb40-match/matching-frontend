<template>
  <div class="screen">
    <ChatTestRoomMyProfile :userId="userId" />
    <main>
      <div class="messages">
        <div
          class="message-wrapper"
          v-for="message in messages"
          :key="message.messageId"
        >
          <!-- <ChatTestRoomDateDivider
            v-if="
              message.messageId === 0 ||
              messages[message.messageId - 1].createdDate !==
                message.createdDate
            "
            :date="message.date"
          /> -->
          <ChatTestRoomMessageBox
            :message="message"
            :onLeft="userId === receiverId"
          />
        </div>
      </div>
      <ChatTestRoomMessageInput @sentMessageContent="this.addSentMessage" />
    </main>
  </div>
</template>

<script>
// import { io } from "socket.io-client";

import SockJS from "sockjs-client";
import Stomp from "webstomp-client";
import dayjs from "dayjs";

import ChatTestRoomMyProfile from "./ChatTestRoomMyProfile.vue";
// import ChatTestRoomDateDivider from "./ChatTestRoomDateDivider.vue";
import ChatTestRoomMessageBox from "./ChatTestRoomMessageBox.vue";
import ChatTestRoomMessageInput from "./ChatTestRoomMessageInput.vue";
// import { fetchUser } from "@/worker/user";

export default {
  name: "ChatTestRoom",
  props: {
    userId: {
      type: String,
      required: true,
    },
    receiverId: {
      type: String,
      required: true,
    },
  },
  data() {
    return {
      messages: [],
    };
  },
  components: {
    ChatTestRoomMyProfile,
    ChatTestRoomMessageBox,
    // ChatTestRoomDateDivider,
    ChatTestRoomMessageInput,
  },
  methods: {
    addSentMessage(sentMessageContent) {
      const matchId = Math.round(
        Number(this.userId.slice(this.userId.length - 1)) / 2,
      );
      const message = {
        matchId,
        userId: this.userId,
        content: sentMessageContent,
        createdDate: dayjs().format("YYYYMMDDhhmmss"),
      };
      this.messages.push(message);
      this.stompClient.send(
        `/app/chat.sendMessage/${matchId}`,
        JSON.stringify(message),
        {},
      );
      // this.messages.push({
      //   // messageId: this.messages[this.messages.length() - 1] + 1,
      //   matchId: this.userId,
      //   userId: this.userId,
      //   content: sentMessageContent,
      //   // date: "20220809",
      //   // time: "1234",
      //   createdDate: dayjs().format("YYYYMMDDhhmmss"),
      // });
    },
    testSocket() {
      const socket = new SockJS("http://10.214.4.235:8081/chat/ws");

      this.stompClient = Stomp.over(socket);

      this.stompClient.connect(
        {},
        () => {
          const matchId = Math.round(
            Number(this.userId.slice(this.userId.length - 1)) / 2,
          );

          this.connected = true;
          // console.log('소켓 연결 성공', frame);
          // 서버의 메시지 전송 endpoint를 구독합니다.
          // 이런형태를 pub sub 구조라고 합니다.
          // console.log(this.teamId)

          this.stompClient.subscribe(`/topic/${matchId}`, (res) => {
            // console.log('구독으로 받은 메시지 입니다.', res.body);
            // 받은 데이터를 json으로 파싱하고 리스트에 넣어줍니다.
            // console.log(JSON.parse(res.body));
            if (JSON.parse(res.body).userId !== this.userId) {
              this.messages.push(JSON.parse(res.body));
            }
            // this.scrolltoBottom();
          });
          console.log("success");

          // const newChat = {
          //   matchId,
          //   userId: `user${this.userId}`,
          //   content: "hihihihihi",
          //   createdDate: "20220811140128",
          // };

          // this.stompClient.send(
          //   `/app/chat.sendMessage/${matchId}`,
          //   JSON.stringify(newChat),
          //   {},
          // );
        },
        // on error
        () => {
          console.log("failed");
          // 소켓 연결 실패
          // console.log('소켓 연결 실패', error);
          this.connected = false;
        },
      );

      console.log("!!!success");

      // socket.on("connect", () => {
      //   console.log("connecting");
      //   console.log(socket.id); // x8WIv7-mJelg7on_ALbx
      // });

      // socket.on("disconnect", () => {
      //   console.log(socket.id); // undefined
      // });

      console.log("send: success");
    },
  },
  created() {
    // const { user, companion } = await loadChatUsers(this.userId);

    // this.user = await fetchUser(`user${this.userId}`);
    this.testSocket();
  },
  // async mounted() {
  //   await loadUser("user1");
  // },
  // watch: {
  //   currentMessage: function () {},
  // },
};
</script>

<style scoped>
.screen {
  width: 100vw;
  height: 100vh;
}

main {
  height: calc(100% - 58px);
}

.message-wrapper {
  width: calc(100% - 30px);
  margin: 0 auto;
}

.messages {
  height: calc(100% - 156px);
}

h1 {
  margin: 7px 0;
}
</style>
