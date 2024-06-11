package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExampleController {
	@GetMapping("example")
	public String exampleMethod() {
		/* 요청 주소를 매핑 하는 방법
		 	1) @RequestMapping("url")
		 	
		 	2) HTTP 요청 방식
		 	@GetMapping("url") : GET 방식 요청 매핑
		 	@PostMapping("url") : POST 방식 요청 매핑
		 	@PutMapping("url") > form, js, a 태그 요청 불가. POST 대체 가능
		 	@DeletMapping("url") > form, js, a태그 요청 불가. POST 대체 가능 
		 */
		 
		return "example";
	}
}
