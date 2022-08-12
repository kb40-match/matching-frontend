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
  },
  async mounted() {
    await loadUser('user1');
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
