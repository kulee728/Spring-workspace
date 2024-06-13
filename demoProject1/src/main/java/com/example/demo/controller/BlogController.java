package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.dto.BlogDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("blog")
public class BlogController {
	@GetMapping("main")
	public String blogMainMethod() {
		log.info("blog-main으로 이동");
		return "/blog/blog-index";
	}
	
	@GetMapping("board")
	public String blogBoardMethod() {
		log.info("blog-board로 이동");
		return "/blog/blog-board";
	}
	/*
	@PostMapping("visitorComments")
	public String blogComments(@RequestParam("commentName") String commentName
			,@RequestParam("commentOpinion") String commentOpinion) {
		log.debug(commentName);
		log.debug(commentOpinion);
		System.out.println("comment Name : "+commentName);
		System.out.println("comment Opinion : "+commentOpinion);
		return "redirect:/blog/main";
	}
	*/
	@PostMapping("visitorComments")
	public String blogComments(BlogDTO blog) {
		String commentName = blog.getCommentName(); 
		String commentOpinion = blog.getCommentOpinion(); 
		log.info(commentName);
		log.info(commentOpinion);
		System.out.println("comment Name : "+commentName);
		System.out.println("comment Opinion : "+commentOpinion);
		return "redirect:/blog/main";
	}
}
