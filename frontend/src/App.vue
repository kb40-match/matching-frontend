<template>
  <v-app>
    <StatusBar />
    <div style="margin-top: 40px;height: calc(100% - 73px)">
      <router-view></router-view>
    </div>
  </v-app>
</template>

<script>
import { loadUser, loadMydata } from "./worker/user";
import StatusBar from "./components/_common/StatusBar.vue";

export default {
  name: "App",

  components: {
    StatusBar,
  },

  data: () => ({
    //
  }),
  created() {
    loadUser("user5");
    loadMydata("user5");
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
  // background-color: colors.$GRAY1;
}
</style>
