<template>
  <v-app>
    <StatusBar />
    <MenuBar />
    <div style="margin-top: 50px; padding-top: 20px; height: calc(100% - 73px)">
      <router-view></router-view>
    </div>
  </v-app>
</template>

<script>
import { loadUser, loadMydata } from "./worker/user";
import MenuBar from "./components/MenuBar";
import StatusBar from "./components/_common/StatusBar.vue";

export default {
  name: "App",

  components: {
    MenuBar,
    StatusBar,
  },

  data: () => ({
    //
  }),
  created() {
    loadUser("user1");
    loadMydata("user1");
  },
};
</script>

<style lang="scss">
@font-face {
  font-family: "S-CoreDream-5Medium";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_six@1.2/S-CoreDream-5Medium.woff")
    format("woff");
  font-weight: normal;
  font-style: normal;
}

#app {
  font-family: "S-CoreDream-5Medium";
  background-color: colors.$GRAY2;
}
</style>
