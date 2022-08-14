package com.matching.kb40.chatting.chattingserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import com.matching.kb40.chatting.chattingserver.model.NewChat;
import com.matching.kb40.chatting.chattingserver.model.ReadChat;

import lombok.extern.slf4j.Slf4j;

import com.google.gson.Gson;

@Slf4j
@RestController
public class ChattingController {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Value("${param.kafka.topic.total.insert}")
	private String insertTopic;

	@Value("${param.kafka.topic.total.update}")
	private String updateTopic;

	@MessageMapping("/chat.sendMessage/{matchId}")
    @SendTo("/topic/{matchId}")
    public NewChat sendMessage(@Payload NewChat newChat, @DestinationVariable Long matchId) {
		log.info("sendMessage로 들어옴!!!!");
		log.info(newChat.toString());
		Gson gson = new Gson();
		String chat = gson.toJson(newChat);
		kafkaTemplate.send(insertTopic,chat);
        return newChat;
    }

    @MessageMapping("/chat.updateReadMessage/{matchId}")
    @SendTo("/topic/{matchId}")
    public ReadChat updateReadMessage(@Payload ReadChat readChat, @DestinationVariable Long matchId){
		log.info("updateReadMessage로 들어옴!!!!");
		log.info(readChat.toString());
		Gson gson = new Gson();
		String chat = gson.toJson(readChat);
		kafkaTemplate.send(updateTopic,chat);
        return readChat;
    }
}
