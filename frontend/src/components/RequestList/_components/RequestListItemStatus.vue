<template>
  <div class="status" :style="cssVariables">{{ this.title }}</div>
</template>

<script>
export default {
  name: "RequestListItemStatus",
  props: {
    type: String, // 'success', 'waiting', 'rejected',,,
  },
  computed: {
    title: function () {
      return {
        1: "매칭 성공",
        0: "대기중",
        2: "종료",
      }[this.type];
    },
    backgroundColor: function () {
      return {
        1: "#D6E1FF",
        0: "#FFEEB1",
        2: "#F1F3F5",
      }[this.type];
    },
    titleColor: function () {
      return {
        1: "#3F73F8",
        0: "#B99720",
        2: "#DEE2E6",
      }[this.type];
    },
    cssVariables: function () {
      return {
        backgroundColor: this.backgroundColor,
        titleColor: this.titleColor,
      };
    },
  },

  created() {},
};
</script>

<style scoped>
.status {
  position: absolute;
  height: 24px;
  width: 78px;
  right: 10px;
  text-align: center;
  line-height: 24px;
  font-size: 12px;
  background-color: var(backgroundColor);
  color: var(titleColor);
  border-radius: 24px;
}
</style>
