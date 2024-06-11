package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@Controller
public class IndexController{
	@RequestMapping("test")
	public String testMethod() {
		log.info("test로 이동");
		return "test";
	}
	/*
	@RequestMapping("index")
	public String indexMethod() {
		log.info("index로 이동");
		return "index";
	}
	*/
	@RequestMapping("home")
	public String homeMethod() {
		log.info("홈페이지로 이동 확인");
		return "index";
	}
}
