import socketio from "socket.io";
import http from "http";

export const initSocket = (app) => {
  const server = http.createServer(app);
  const socket = socketio(server);

  socket.on('join', ({username, room}, callback) => {
    const { error, user } = addUser({ id: socket.id, username, room })

    if (error) {
        return callback(error) // acknoledgement. error를 client side로 보냄.
    }
    socket.join(user.room)

    socket.emit('message', generateMessage({text: 'Welcome!', username: 'Admin'}))
    socket.broadcast.to(user.room).emit('message', generateMessage({text: `${user.username} has joined!`, username: 'Admin'}))
    io.to(user.room).emit('roomData', {
        room: user.room,
        users: getUsersInRoom(user.room)
    })
    
    callback() // acknowledgement without error
})

  // socket.on("connection", socket => {
  //   // either with send()
  //   socket.send("Hello!");
  
  //   // or with emit() and custom event names
  //   socket.emit("greetings", "Hey!", { "ms": "jane" }, Buffer.from([4, 3, 3, 1]));
  
  //   // handle the event sent with socket.send()
  //   socket.on("message", (data) => {
  //     console.log(data);
  //   });
  
  //   socket.on("salutations", (elem1, elem2, elem3) => {
  //     console.log(elem1, elem2, elem3);
  //   });
  // });
};
