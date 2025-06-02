package com.example.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.demo.Message1;

@Controller
public class ChatController {

	@MessageMapping("/super1")
	@SendTo("/topic/content")
	public Message1 chat(@Payload Message1 message ) {
		return message;
		
	}
}
