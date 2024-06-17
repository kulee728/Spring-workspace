package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.Drinks;
import com.example.demo.service.DrinksService;

@Controller
public class DrinksController {
	@Autowired
	public DrinksService drinksService; 

	@PostMapping("/drinks-register")
	public String insertDrinks(Drinks drinks, Model model) {
		drinksService.insertDrinks(drinks);
		model.addAttribute("msg","상품(음료)가 성공적으로 등록되었습니다.");
		return "registerSuccess";
	}
}
