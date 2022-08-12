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
        success: "매칭 성공",
        waiting: "대기중",
        rejected: "거절",
      }[this.type];
    },
    backgroundColor: function () {
      return {
        success: "#D6E1FF",
        waiting: "#FFEEB1",
        rejected: "#F1F3F5",
      }[this.type];
    },
    titleColor: function () {
      return {
        success: "#3F73F8",
        waiting: "#B99720",
        rejected: "#DEE2E6",
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
