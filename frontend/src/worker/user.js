import axios from "axios";
import { useUserStore } from "@/store/states/userState";

// export const API_BASE_URL = "https://matching.169.56.100.104.nip.io/match";

export const fetchUser = async (userId) => {
  const response = await axios.get(`/user/${userId}`);
  return response.data;
};

export const fetchMyData = async (userId) => {
  const response = await axios.get(`/user/mydata/${userId}`);
  return response.data;
};

export const loadUser = async (userId) => {
  const store = useUserStore();

  store.user = await fetchUser(userId);
  store.mydata = await fetchMyData(userId);
};
