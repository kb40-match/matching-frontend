<template>
  <div class="toggleTab">
    <button type="button" @click="selectTab(true)"><span id="title">요청한 내역</span></button>
    <button type="button" @click="selectTab(false)"><span id="title">요청 받은 내역</span></button>
    <div :class="{'left-selected':selectedTabIndex, 'right-selected':!selectedTabIndex}"></div>
  </div>
</template>

<script>
export default {
  name: "RequestListItemToggle",
  data: function () {
    return {
      selectedTabIndex: true,
    };
  },
  methods:{
    selectTab(i){
      this.selectedTabIndex = i
      this.$emit("selectedTab", this.selectedTabIndex)
    }
  }
};
</script>

<style scoped>
.toggleTab {
  position: relative;
  display: flex;
  width: 312px;
  height: 36px;
  margin: 24px auto;
  border-radius: 24px;
  /* border: 0.5px solid #ced4da; */
  background-color: #f3f0ff;
}

button {
  all: unset;
  height: 36px;
  /* font-size: 14px;
  font-weight: 300; */
  text-align: center;
  position: relative;
  width: calc(100% / 2);
  border-radius: 24px;
  z-index: 100;
}

.left-selected {
  position: absolute;
  width: 156px;
  height: 36px;
  top: 0;
  left: 0;
  background-color: #845ef7;
  border-radius: 24px;
  z-index: 0;
}

.right-selected {
  position: absolute;
  width: 156px;
  height: 36px;
  top: 0;
  left: 156px;
  background-color: #845ef7;
  border-radius: 24px;
  z-index: 0;
}

/* .selected[data-id='0'] {
  left: 0;
}

.selected[data-id='1'] {
  left: 156px;
} */

#title {
  font-size: 14px;
  font-weight: 300;
  z-index: 102;
}
</style>
