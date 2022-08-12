<template>
  <div class="toggleTab">
    <button type="button" data-id="0"><span class="title">요청한 내역</span></button>
    <button type="button" data-id="1"><span class="title">요청 받은 내역</span></button>
    <div class="selected"></div>
  </div>
</template>

<script>
export default {
  name: "RequestListItemToggle",
  data: function () {
    return {
      selectedTabIndex: 0,
    };
  },
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
  background-color: #fff;
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

.selected {
  position: absolute;
  width: 156px;
  height: 36px;
  top: 0;
  left: 0;
  background-color: #dee2e6;
  border-radius: 24px;
  z-index: 0;
}

/* .selected[data-id='0'] {
  left: 0;
}

.selected[data-id='1'] {
  left: 156px;
} */

.title {
  font-size: 14px;
  font-weight: 300;
  color: #000;
  z-index: 102;
}
</style>
