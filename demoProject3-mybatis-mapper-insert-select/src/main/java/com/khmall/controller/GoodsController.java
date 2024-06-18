package com.khmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.khmall.dto.Goods;
import com.khmall.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class GoodsController {
	@Autowired
	private ProductService productService;
	
	@PostMapping("/register-product")
	public String insertProduct(Goods goods,Model model) {
		productService.insertProduct(goods);
		model.addAttribute("msg","상품이 성공적으로 등록되었습니다.");

		List<Goods> productList = productService.getAllProduct();
		model.addAttribute("productList", productList);
		log.info("상품전체목록 : "+ productList);
		return "productList";
	}
	/*
	@GetMapping("/product-list")
	public String getAllProduct(Model model) {
		List<Goods> productList = productService.getAllProduct();
		model.addAttribute("productList", productList);
		log.info("상품전체목록 : "+ productList);
		return "productList";
	}
	*/
}
