import axios from "axios";
import { useAppStore } from "../store/userState";

// export const API_BASE_URL = "https://matching.169.56.100.104.nip.io/match";

export const fetchUser = async (userId) => {
  const response = await axios.get(`/user/${userId}`);
  return response.data;
};

export const loadUser = async (userId) => {
  const store = useAppStore();
  
  const userData = await fetchUser(userId);
  store.user = userData;
  console.log(store.user.agreeFlag)
};


export const fetchMydata = async (userId) => {
  const response = await axios.get(`/user/mydata/${userId}`);
  return response.data;
};

export const loadMydata = async (userId) => {
  const store = useAppStore();
  
  const myDataData = await fetchMydata(userId);
  store.myData = myDataData;
  // console.log(store.myData)
};


export const setUser = (userId) => {
  const store = useAppStore();
  console.log(userId)
  console.log(store.user.agreeFlag)
  console.log(store.user.mbtiMind + store.user.mbtiRecog + store.user.mbtiJudge + store.user.mbtiTactics)

  // this.$axios.put(`/user`, store.user)
  //   .then((response) => {
  //     console.log("업데이트 완료")
  //     console.log(response.data)
  //   })
  //   .catch((err)=>{
  //     console.log(err.response);
  //   });
  //   console.log(this.user)
};
