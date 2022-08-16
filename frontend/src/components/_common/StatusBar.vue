<template>
  <div class="statusBar">
    <div class="left">{{ this.currentTime }}</div>
    <div class="right">
      {{ this.dummyRightText }}
    </div>
  </div>
</template>

<script>
import dayjs from "dayjs";

export default {
  name: "StatusBar",
  data() {
    return {
      currentTime: dayjs().format("hh:mm"),
      dummyRightText: "righty",
    };
  },
};
</script>

<style scoped>
.statusBar {
  height: 28px;
  width: 100%;
  display: flex;
  justify-content: space-between;
  align-content: center;
  font-weight: 700;
  font-size: 12px;
  padding: 0 20px;
  background-color:#845ef7
}

.left,
.right {
  height: 15px;
  font-size: 15px;
  line-height: 15px;
  margin: auto 0px;
  display: flex;
  justify-content: center;
  align-content: center;
  /* border: 1px solid black; */
  color:white;
}
</style>
