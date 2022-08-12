<template>
  <div class="screen">
    <main>
      <h1>매칭 요청 목록</h1>
      <p>지난 요청 목록을 모두 볼 수 있어요.</p>
      <RequestListItemToggle />
      <ul>
        <RequestListItem
          v-for="item in this.items"
          :key="item.id"
          :item="item"
        />
      </ul>
    </main>
  </div>
</template>

<script>
import RequestListItem from "./_components/RequestListItem.vue";
import RequestListItemToggle from "./_components/RequestListItemToggle.vue";

const dummyItems = [
  {
    id: 0,
    name: "위대한재규어",
    status: "rejected",
  },
  {
    id: 1,
    name: "머리좋은루시퍼벌새",
    status: "success",
  },
  {
    id: 2,
    name: "호주푸른맷새",
    status: "rejected",
  },
  {
    id: 3,
    name: "점박이올빼미",
    status: "waiting",
  },
];

export default {
  name: "RequestList",
  data() {
    return {
      items: dummyItems,
      selectedTab: 0,
      selectedItem: -1,
    };
  },
  components: {
    RequestListItem,
    RequestListItemToggle,
  },
  created() {},
};
</script>

<style lang="scss" scoped>
.screen {
  width: 100vw;
  height: 100vh;
}

h1 {
  margin: 7px 0;
}

p {
  font-weight: 300;
  font-size: 14px;
}

main {
  padding: 0 20px;
}

ul {
  all: unset;
  width: 90%;
  /* position: relative; */
  margin: 0 auto;
  background-color: violet;
}
</style>
