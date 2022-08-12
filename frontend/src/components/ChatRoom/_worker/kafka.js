// import ip from 'ip';
import { Kafka, CompressionTypes, logLevel } from "kafkajs";

const CLINET_ID_BASE = "clientId-consumer";

const USER_ID = "user08";
const MATCH_ID = "consumer_group-4";

const topic = 1;

const kafka = new Kafka({
  logLevel: logLevel.DEBUG,
  clientId: `${CLINET_ID_BASE}-${USER_ID}_${MATCH_ID}`,
  brokers: ["169.56.100.104:30011"],
  ssl: false,
});

export const produceKafkaChat = async (
  content = "안녕하세요 반갑습니다. 영이혀니이니우니워니",
) => {
  const producer = kafka.producer();

  await producer.connect();

  await producer.send({

    topic,
    compression: CompressionTypes.GZIP,
    messages: [
      {
        matchId: 1,
        userId: "user1",
        content,
        createdDate: "20220811033230",
      },
    ],
  });

  await producer.disconnect();
};

export const consumeKafkaChat = async () => {
  const consumer = kafka.consumer({ groupId: "chatting" });

  await consumer.connect();
  await consumer.subscribe({ topic: "1", fromBeginning: true });
  await consumer.run({
    eachMessage: async ({ message }) => {
      console.log({
        value: message.value.toString(),
      });
    },
  });
};
