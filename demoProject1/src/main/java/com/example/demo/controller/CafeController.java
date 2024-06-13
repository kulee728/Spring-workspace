package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.dto.CafeDTO;

import lombok.extern.slf4j.Slf4j;

@Controller 
@Slf4j
@RequestMapping("cafe")
public class CafeController {
	
	@GetMapping("main")
	public String cafeMainMethod() {
		log.info("cafe-index로 이동");
		return "/cafe/cafe-index";
	}
	
	@GetMapping("board")
	public String cafeBoardMethod() {
		log.info("cafe-board로 이동");
		return "/cafe/cafe-board";
	}
	/*
	@PostMapping("comment")
	public String cafeMainComment(@RequestParam("cafeCommentName") String cafeCommentName,
			@RequestParam("cafeCommentOpinion") String cafeCommentOpinion) {
		
		log.info(cafeCommentOpinion +" "+ cafeCommentName);
		return "redirect:/cafe/main";
	}
	*/
	@PostMapping("comment")
	public String cafeMainComment(CafeDTO cdto) {
		log.info(cdto.toString());
		return "redirect:/cafe/main";
	}
	
}
