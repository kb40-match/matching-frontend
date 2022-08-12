<template>
  <li @click="toggleIsOpen">
    <div class="baseButton" type="button">
      <div class="profile"></div>
      <p class="name">{{ this.item.name }}</p>
      <RequestListItemStatus :type="this.item.status" />
    </div>
    <RequestListItemDetail v-if="this.isOpen" />
  </li>
</template>

<script>
// import { useRequestListStore } from "../../../store/states/requestList";
import RequestListItemStatus from "./RequestListItemStatus.vue";
import RequestListItemDetail from "./RequestListItemDetail.vue";

export default {
  name: "RequestListItem",
  props: {
    item: Object, // id, name, status(success->1/waiting->0/rejected->2), ...detail
    // TODO rejected -> terminated 변경하기
  },
  data: function () {
    return { isOpen: false };
  },
  components: {
    RequestListItemStatus,
    RequestListItemDetail,
  },
  methods: {
    toggleIsOpen() {
      this.isOpen = !this.isOpen;
    },
  },
  created() {
  },
};
</script>

<style lang="scss" scoped>

li {
  position: relative;
  width: calc(100% - 30px);
  line-height: 78px;
  margin: 10px 0;
  padding: 0 15px;
  /* display: flex; */
  /* align-items: center; */
  list-style: none;
  border-radius: 15px;
  background-color: colors.$WHITE;
  transition: height 1s;
  cursor: pointer;
  transition: background-color 100ms;

  &:hover {
    background-color: colors.$GRAY0;
  }
}

/* li:hover {
  background-color: #fafafa;
} */

.baseButton {
  display: flex;
  align-items: center;
  height: 78px;
}

.profile {
  width: 40px;
  height: 40px;
  /* background-color: violet; */
  border-radius: 50%;
  border: 1px solid #aba;
}

.name {
  margin-left: 15px;
  font-size: 16px;
  font-weight: 500;
  min-width: 50px;
  min-height: 20px;
}
</style>
