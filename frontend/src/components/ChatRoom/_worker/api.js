import axios from "axios";
import { chatDataDummy, receiverDummy, userDummy } from "./dummy";

const API_URL_BASE = "/kafka-server";

export const fetchPrevList = async () => {
  const matchId = 1;
  const startRow = 0;
  const rowNum = 10;

  const response = await axios.get(
    `${API_URL_BASE}/${matchId}/${startRow}/${rowNum}`,
  );
  
  return response.data;
};

export const prevData = chatDataDummy;
export const receiver = receiverDummy;
export const user = userDummy;
