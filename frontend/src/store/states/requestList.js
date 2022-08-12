import { defineStore } from "pinia";

export const useRequestListStore = defineStore("requestList", {
  state: () => ({
    selectedTab: 0,
    selectedItem: -1,
  }),
});
