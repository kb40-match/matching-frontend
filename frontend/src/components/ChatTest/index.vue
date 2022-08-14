<template>
  <div class="wrapper">
    <ChatTestRoom userId="user1" receiverId="user2" />
    <ChatTestRoom userId="user2" receiverId="user1" />
    <ChatTestRoom userId="user3" receiverId="user4" />
    <ChatTestRoom userId="user4" receiverId="user3" />
  </div>
</template>

<script>
import ChatTestRoom from "./_components/ChatTestRoom.vue";

export default {
  name: "ChatTest",
  components: {
    ChatTestRoom,
  },
};
</script>

<style scoped>
.wrapper {
  display: flex;
}
</style>
