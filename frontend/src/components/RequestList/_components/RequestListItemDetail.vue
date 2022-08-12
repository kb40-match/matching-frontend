<template>
  <dl>
    <div
      class="pair"
      v-for="({ type, detail }, index) in contents"
      :key="index"
    >
      <dt>{{ type }}</dt>
      <dd>{{ detail }}</dd>
    </div>
  </dl>
</template>

<script>
export default {
  name: "RequestListItemDetail",
  props: {
    contents: Object,
  },
};
</script>

<style scoped>
dl {
  /* background-color: pink; */
  height: 180px;
  width: 100%;
  border-top: 1px solid #dcdfe3;
  margin: 10px 0;
  animation: 100ms grow;
}

.pair {
  display: flex;
  justify-content: space-between;
  align-content: center;
  width: 100%;
  /* height: 18px; */
  margin: 10px 0;
}

dt {
  color: #808080;
  font-size: 14px;
}

dd {
  color: #000;
  font-size: 14px;
  font-weight: 700;
}

@keyframes grow {
  0% {
    height: 0;
  }

  100% {
    height: 180px;
  }
}
</style>
