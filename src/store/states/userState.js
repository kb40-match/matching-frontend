import { defineStore } from "pinia";

export const useUserStore = defineStore("#user", {
  state: () => ({
    user: null, // TODO null | User
    mydata: null, // TODO null | MyData
  }),
});

// interface MyData {
//   name: String;
//   gender: String;
//   age: String;
//   address: String;
//   assets: String;
//   consumPtn1: String;
//   consumPtn2: String;
//   consumPtn3: String;
//   investProp: String;
// }

// interface User {
//   agreeFlag: String;
//   job: String;
//   mbtiMind: String;
//   mbtiRecog: String;
//   mbtiJudge: String;
//   mbtiTactics: String;
//   profile: String;
//   point: String;
//   petPrefer: String;
// }
