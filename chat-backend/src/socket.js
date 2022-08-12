import { app } from ".";

const server = http.createServer(app);
const io = socketio(server);
