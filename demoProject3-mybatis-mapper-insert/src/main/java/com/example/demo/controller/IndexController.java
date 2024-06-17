package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dto.Drinks;
import com.example.demo.dto.Goods;

@Controller
public class IndexController {
	
	@GetMapping("/") //맨 앞 페이지에서 볼 화면
	public String registerform(Model model) {
		model.addAttribute("goods",new Goods()); //DB에 값을 넣을 수 있는 객체 생성
		model.addAttribute("drinks",new Drinks());
		return "index";
	}
}
