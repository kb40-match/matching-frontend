import SockJS from "sockjs-client";
import Stomp from "webstomp-client";

export const connectSocket = (target) => {
  // const CHAT_TARGET =
  //   "http://matching.169.56.100.104.nip.io/websocket-server/ws";

  const chatSocket = new SockJS(target);

  this.stompClient = Stomp.over(chatSocket);

  console.log(`Try to connect to: ${target}`);

  this.stompClient.connect(
    {},
    () => {
      this.connected = true;

      this.stompClient.subscribe(`/topic/${this.matchId}`, (res) => {
        const receivedMessage = JSON.parse(res.body);
        console.log(receivedMessage);
        if (receivedMessage.userId !== this.store.user.userId) {
          this.messages.push(receivedMessage);
        }
      });
    },
    () => {
      console.log("FAILED");
      this.connected = false;
    },
  );
}