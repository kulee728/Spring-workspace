package com.khmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.khmall.dto.Goods;

@Controller
public class IndexController {

	
	@GetMapping("/productRegister")
	public String goodsRegister(Model model) {
		model.addAttribute("goods", new Goods());
		
		return "productRegister";
	}
	/*
	@GetMapping("/")
	public String mainPageDisplay(Model model) {
		
	}
	*/
}
