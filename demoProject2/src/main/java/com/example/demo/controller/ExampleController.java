package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("example")
public class ExampleController {
	/*
	 Model
	 - Spring 에서 데이터 전달 역할을 하는 객체
	 - org.springframework.ui 패키지
	 - @SessionAttributes 와 함께 사용할 경우 session scope 반환
	 
	 Model [사용법]
	 Model.addAttribute("key",value);
	 Model.addAttribute("html에 전달 가능한 이름",전달할 값을 작성)
	 */
	@GetMapping("ex1")
	public String ex1(HttpServletRequest req, Model model){
		
		//나중에 DB에서 가져온 값을 보여줄 때 사용하는 메서드
		req.setAttribute("test1", "HttpServletRequest로 전달한 값");
		model.addAttribute("test2","Model로 전달한 값");
		
		// 단일 값(순자, 문자열) Model 을 이용, html 전달
		model.addAttribute("productName", "종이컵");
		
		model.addAttribute("productPrice","2000");
		model.addAttribute("productCompany", "KH_company");
		List<String> fruitList = new ArrayList<>();
		fruitList.add("사과");
		fruitList.add("딸기");
		fruitList.add("바나나");
		
		model.addAttribute("fruitList",fruitList);
		//String [] animalList = {"호랑이","토끼","거북이"};
		List<String> animalList = new ArrayList<>();
		animalList.add("호랑이");
		animalList.add("토끼");
		animalList.add("거북이");
		model.addAttribute("animalList",animalList);
		
		
		return "example/ex1"; //templates/example/ex1.html 파일이 바라보는 값
	}
}
