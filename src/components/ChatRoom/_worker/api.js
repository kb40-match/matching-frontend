import axios from "axios";
import { chatDataDummy, receiverDummy, userDummy } from "./dummy";

export const prevData = chatDataDummy;
export const receiver = receiverDummy;
export const user = userDummy;

const API_URL_BASE = "http://matching.169.56.100.104.nip.io";

export const fetchPrevList = async ({ matchId, startRow, rowNum }) => {
  const response = await axios.get(
    `${API_URL_BASE}/kafka-server/${matchId}/${startRow}/${rowNum}`,
  );
  return response.data;
};

export const fetchReceiverId = async (userId) => {
  const response = await axios.get(
    `${API_URL_BASE}/match/matching/receiverId/${userId}`
  )
  return response.data;
}

export const fetchMatchId = async (userId) => {
  const response = await axios.get(
    `${API_URL_BASE}/match/matching/matchId/${userId}`
  )
  return response.data;
}