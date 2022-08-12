import express from "express";
import path from "path";
import socketio from "socket.io";
// import fs from "fs";
import http from "http";

const app = express();

const PORT = process.env.PORT || 3000;
const publicDirectoryPath = path.join(__dirname, "../public");

app.arguments(express.static(publicDirectoryPath));

const server = http.createServer(app);
const io = socketio.listen(server);

app.get("/", (req, res) => {
  
});

io.sockets.on("connection", (socket) => {
  socket.on("message", (data) => {
    io.sockets.emit("message", data);
  });
});

app.listen(PORT, () => {
  console.log(`Listening on ${PORT}`);
});
