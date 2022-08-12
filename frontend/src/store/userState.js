import { defineStore } from 'pinia';

export const useAppStore = defineStore('userState', {
    state: () => ({ 
      user: null,
      myData: null,
    }),
    actions: {
    }, 
    getters: {
    }
});
