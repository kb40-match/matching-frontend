<template>
  <div id="app">
    <!-- <StatusBar /> -->
    <!-- <GNB /> -->
    <!-- <img alt="Vue logo" src="./assets/logo.png" /> -->
    <!-- <HelloWorld msg="Welcome to Your Vue.js App" /> -->
    <!-- <RequestList isIn /> -->
    <!-- <ChatRoom /> -->
    <ChatRoom />
  </div>
</template>

<script>
// import HelloWorld from "./components/HelloWorld.vue";
// import RequestList from "./components/RequestList";
import ChatRoom from "./components/ChatRoom";
// import ChatTest from "./components/ChatTest";
// import StatusBar from "./components/_common/StatusBar.vue";
// import GNB from "./components/_common/GNB.vue";

export default {
  name: "App",
  components: {
    // HelloWorld,
    // RequestList,
    ChatRoom,
    // StatusBar,
    // GNB,
  },
};
</script>

<style lang="scss">
#app {
  font-family: "S-CoreDream-5Medium";
  background-color: colors.$GRAY2;
  overflow-y: scroll;
  overflow-x: none;
}
</style>
