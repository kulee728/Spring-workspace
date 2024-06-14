/*
 package com.example.demo.controller;
 

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("example")
public class Example2Controller {
	
	@PathVariable
	- 주소 중 일부분을 변수 값처럼 사용
	- 해당 어노테이션으로 얻어온 값은 request scope에 세팅
	
	
	@GetMapping("/ex2/{number}")
	public String pathVariableTest(
			@PathVariable("number") int number
			){
		return "example/ex2";
	}
	
	@GetMapping("ex3")
	public String ex3(Model model) {
		model.addAttribute("boardNo",10);
		model.addAttribute("key","제목");
		model.addAttribute("query","검색어");
		return "example/ex3";
	}
	
}
*/
