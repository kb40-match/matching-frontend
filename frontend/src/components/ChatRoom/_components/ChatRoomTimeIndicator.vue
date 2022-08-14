<template>
  <div class="time-indicator">{{ hour }}:{{ minute }}</div>
</template>

<script>
export default {
  name: "ChatRoomTimeIndicator",
  props: {
    date: {
      type: String,
      required: true,
    },
  },
  computed: {
    hour() {
      return this.date.slice(8, 10);
    },
    minute() {
      return this.date.slice(10, 12);
    },
  },
};
</script>

<style lang="scss" scoped>
.time-indicator {
  color: colors.$GRAY7;
  font-size: 10px;
  position: relative;
  line-height: 100%;
  vertical-align: bottom;
  transform: translateX(100%);
}
</style>
