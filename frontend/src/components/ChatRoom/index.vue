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
              messages[message.messageId - 1].date !== message.date
            "
            :date="message.date"
          />
          <ChatRoomMessageBox
            :message="message"
            :onLeft="message.userId === receiver.userId"
          />
        </div>
      </div>
      <ChatRoomMessageInput @sentMessageContent="this.addSentMessage" />
    </main>
  </div>
</template>

<script>
// import { io } from "socket.io-client";

import SockJS from "sockjs-client";
import Stomp from "webstomp-client";

import { prevData, user, receiver } from "./_worker/api";
import { useUserStore } from "@/store/states/userState";
import { loadUser } from "@/worker/user";
import ChatRoomMyProfile from "./_components/ChatRoomMyProfile.vue";
import ChatRoomDateDivider from "./_components/ChatRoomDateDivider.vue";
import ChatRoomMessageBox from "./_components/ChatRoomMessageBox.vue";
import ChatRoomMessageInput from "./_components/ChatRoomMessageInput.vue";

// messageId: 1,
// userId: "345",
// content: "반가워요.",
// date: "20220808",
// time: "12:35",

export default {
  name: "ChatRoom",
  setup() {
    const store = useUserStore();
    return { store };
  },
  data() {
    return {
      dummyTurn: 0,
      dummyId: prevData.length,
      messages: prevData,
      user,
      receiver,
    };
  },
  components: {
    ChatRoomMyProfile,
    ChatRoomMessageBox,
    ChatRoomDateDivider,
    ChatRoomMessageInput,
  },
  methods: {
    setDummyInterval() {
      setInterval(() => {
        this.dummyId += 1;
      });
    },
    addSentMessage(sentMessageContent) {
      this.messages.push({
        messageId: this.messages[this.messages.length() - 1] + 1,
        userId: this.user.userId,
        content: sentMessageContent,
        date: "20220809",
        time: "1234",
      });
    },
    testSocket() {
      // const sock = new SockJS("http://10.214.3.43:8081/match/chatWebSocket");
      // sock.onopen = () => {
      //   console.log("open");
      //   sock.send("test");
      // };
      // const socket = io("/chatSocket", {
      //   withCredentials: false,
      //   // extraHeaders: {
      //   //   "Access-Control-Allow-Origin": "*",
      //   // },
      // });

      const socket = new SockJS("http://10.214.3.43:8081/match/chatSocket");

      console.log("sucess");

      this.stompClient = Stomp.over(socket);

      this.stompClient.connect(
        {},
        () => {
          // 소켓 연결 성공
          this.connected = true;
          // console.log('소켓 연결 성공', frame);
          // 서버의 메시지 전송 endpoint를 구독합니다.
          // 이런형태를 pub sub 구조라고 합니다.
          // console.log(this.teamId)
          this.stompClient.subscribe(
            "/chatSocket/" + this.teamId,
            (res) => {
              // console.log('구독으로 받은 메시지 입니다.', res.body);
              // 받은 데이터를 json으로 파싱하고 리스트에 넣어줍니다.
              // console.log(JSON.parse(res.body));
              this.recvList.push(JSON.parse(res.body));
              this.scrolltoBottom();
            },
          );
        },
        // on error
        () => {
          // 소켓 연결 실패
          // console.log('소켓 연결 실패', error);
          this.connected = false;
        },
      );

      // socket.on("connect", () => {
      //   console.log("connecting");
      //   console.log(socket.id); // x8WIv7-mJelg7on_ALbx
      // });

      // socket.on("disconnect", () => {
      //   console.log(socket.id); // undefined
      // });
    },
  },
  created() {
    this.testSocket();
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
