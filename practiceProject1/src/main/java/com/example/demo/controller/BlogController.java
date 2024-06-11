package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

//Controller 밑에 blog 폴더 만들어 블로그 관련 컨트롤러 작성
@Controller
@RequestMapping("blog")
@Slf4j
public class BlogController {
	
	@GetMapping("index")
	public String blogMainMethod() {
		return "blog/blog-index";
	}
	
	@GetMapping("board")
	public String blogBoardMethod() {
		return "blog/blog-board";
	}
	
}
