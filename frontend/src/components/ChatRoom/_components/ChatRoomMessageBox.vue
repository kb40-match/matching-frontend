<template>
  <div class="message-box" :style="this.cssVariables">
    <div class="message-content">{{ this.message.content }}</div>
  </div>
</template>

<script>
// {
//     messageId: 0,
//     userId: "123",
//     content: "안녕하세요.",
//     date: "20220808",
//     time: "12:30",
//   },

import { colors } from "@/store/constants/colors";

export default {
  name: "ChatRoomMessageBox",
  props: {
    onLeft: {
      type: Boolean,
      default: false,
    },
    message: {
      type: Object,
      required: true,
    },
  },
  computed: {
    cssVariables() {
      return {
        marginRight: this.onLeft ? "auto" : "0",
        marginLeft: this.onLeft ? "0" : "auto",
        backgroundColor: this.onLeft ? colors.gray[3] : colors.violet[3],
        textAlignment: this.onLeft ? "left" : "right", // TODO
      };
    },
  },
  created() {},
};
</script>

<style scoped>
.message-box {
  display: flex;
  padding: auto 0;
  align-content: center;
  justify-content: center;
  width: 50vw;
  border-radius: 20px;
  background-color: var(backgroundColor);
  margin-right: var(marginRight);
  margin-left: var(marginLeft);
  margin-bottom: 15px;

  /* margin: 100px var(marginRight) 10px var(marginLeft); */
}

.message-content {
  width: 85%;
  height: 100%;
  line-height: 100%;
  margin: 10px 0;
  text-align: var(textAlignment);
  font-size: 14px;
}
</style>
