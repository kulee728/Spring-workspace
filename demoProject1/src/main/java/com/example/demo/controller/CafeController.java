package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller 
@Slf4j
@RequestMapping("cafe")
public class CafeController {
	
	@GetMapping("main")
	public String cafeMainMethod() {
		log.info("cafe-index로 이동");
		return "cafe/cafe-index";
	}
	
	@GetMapping("board")
	public String cafeBoardMethod() {
		log.info("cafe-board로 이동");
		return "cafe/cafe-board";
	}
}
