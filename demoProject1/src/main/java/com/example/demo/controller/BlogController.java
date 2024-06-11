package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("blog")
public class BlogController {
	@GetMapping("main")
	public String blogMainMethod() {
		log.info("blog-main으로 이동");
		return "blog/blog-index";
	}
	
	@GetMapping("board")
	public String blogBoardMethod() {

		log.info("blog-board로 이동");
		return "blog/blog-board";
	}
}
