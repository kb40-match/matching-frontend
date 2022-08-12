import express from "express";
import path from "path";

const app = express();

const PORT = process.env.PORT || 3000;
const publicDirectoryPath = path.join(__dirname, "../public");

app.arguments(express.static(publicDirectoryPath));

app.listen(PORT, () => {
  console.log(`Listening on ${PORT}`);
});

export { app };
