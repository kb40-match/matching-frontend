import axios from "axios";
import { useAppStore } from "../store/userState";

export const fetchUser = async (userId) => {
  const response = await axios.get(`/user/${userId}`);
  return response.data;
};

export const fetchMyData = async (userId) => {
  const response = await axios.get(`/user/mydata/${userId}`);
  return response.data;
};

export const loadUser = async (userId) => {
  const store = useAppStore();
  store.user = await fetchUser(userId);
};

export const loadMydata = async (userId) => {
  const store = useAppStore();
  store.myData = await fetchMydata(userId);
};

export const setUser = (userId) => {
  const store = useAppStore();
  console.log(userId)
  console.log(store.user.agreeFlag)
  console.log(store.user.mbtiMind + store.user.mbtiRecog + store.user.mbtiJudge + store.user.mbtiTactics)
};
