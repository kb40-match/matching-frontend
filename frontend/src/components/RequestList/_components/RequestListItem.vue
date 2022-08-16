<template>
  <li @click="toggleIsOpen" style="text-align:center">
    <div class="baseButton" type="button">
      <div class="ml-2"><v-img class="profile" :src=getImg(this.item.profileFilename)  /></div>
      <p class="name">{{ this.item.nickname }}</p>
      <RequestListItemStatus :type="this.item.activeFlag" />
    </div>
    <RequestListItemDetail v-if="this.isOpen" :contents=this.item :tab="this.tab" />
  </li>
</template>

<script>
import RequestListItemStatus from "./RequestListItemStatus.vue";
import RequestListItemDetail from "./RequestListItemDetail.vue";

export default {
  name: "RequestListItem",
  props: {
    item: Object, // id, name, status(success->1/waiting->0/rejected->2), ...detail
    tab: Boolean,
  },
  data: function () {
    return {
      isOpen: false,
    };
  },
  components: {
    RequestListItemStatus,
    RequestListItemDetail,
  },
  methods: {
    toggleIsOpen() {
      this.isOpen = !this.isOpen;
    },
    getImg(filename){
      if(filename != undefined) return require("@/assets/"+filename)
    },
  },
};
</script>

<style lang="scss" scoped>

li {
  position: relative;
  // width: calc(100% - 30px);
  line-height: 78px;
  margin: 10px 0;
  padding: 0 15px;
  /* display: flex; */
  /* align-items: center; */
  list-style: none;
  border-radius: 15px;
  // background-color: #f3f0ff;
  box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.1);
  border:1px solid;
  transition: height 1s;
  cursor: pointer;
  transition: background-color 100ms;
  

  // &:hover {
  //   background-color: colors.$GRAY0;
  // }
}

/* li:hover {
  background-color: #fafafa;
} */

.baseButton {
  display: flex;
  align-items: center;
  height: 78px;
  margin-bottom:10px;
  // border:1px solid;
  // border-radius:15px;
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
