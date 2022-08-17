import { fetchUser, fetchMyData } from "@/worker/user";
import { fetchMatchId, fetchReceiverId } from "./api";

export const fetchPackUserAndMyData = async (userId) => {
  const dataUser = await fetchUser(userId);
  const dataMyData = await fetchMyData(userId);
  console.log(dataUser, dataMyData);
  return { user: dataUser, myData: dataMyData };
};

export const prepareUser = async ({ userId, receiverId }) => {
  const user = await fetchPackUserAndMyData(userId ?? "user1");
  const receiver = await fetchPackUserAndMyData(receiverId ?? "user2");
  return { user, receiver };
};

export const prepareChatInfo = async (userId) => {
  const matchId = await fetchMatchId(userId);
  const receiverId = await fetchReceiverId(userId);
  return { matchId, receiverId };
}
