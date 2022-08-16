import { defineStore } from 'pinia';

export const useAppStore = defineStore('userState', {
    state: () => ({ 
      user: null,
      myData: null,
      aiResult: null,   // 5 user and myData objects
    }),
    actions: {
    }, 
    getters: {
    }
});
