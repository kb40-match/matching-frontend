import { fetchUser } from "@/worker/user";

export const loadChatUsers = async (userId) => {
  const user = await fetchUser(`user${userId}`);
  // const companion = await fetchUser(`user${userId + 1}`);                             
  return { user };
};
