package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {

	@GetMapping(path="/city1")
	public String loginCity() {
		return "city"; 
	}
	
	@GetMapping(path="/chatroom")
	public String chat0() {
		return "chatroom"; 
	}
	
	@GetMapping(path="/pay2")
	public String pay2() {
		return "pay"; 
	}
}
