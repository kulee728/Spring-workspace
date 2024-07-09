package com.khmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.khmall.dto.Clothes;
import com.khmall.service.ClothesService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ClothesController {

	@Autowired
	private ClothesService clothesService;
	
	@GetMapping("/getAllClothes")
	public String getAllclothes(Model model) {

		List<Clothes> clothesList = clothesService.getAllClothes();
		model.addAttribute("clothesList",clothesList);
		log.info(clothesList.toString());
		
		return "clothesList";
	}
	
	@GetMapping("/insertClothes")
	public String insertClothes(Model model) {
		Clothes c = new Clothes();
		model.addAttribute("c",c);
		return "insertClothes";
	}
	
	@PostMapping("/insertClothesSubmit")
	public String insertClothesSubmit(
			@PathVariable("clothes_name") String clothes_name,
			@PathVariable("clothes_price") int clothes_price,
			@PathVariable("clothes_category") String clothes_category,
			@PathVariable("clothes_") MultipartFile file,
			Model model
			) {
		/*
		 파일 처리해주는 곳
		 */
		String uploadDirectory = ;
		String fileName = file.getOriginalFilename();
		
		Clothes c = new Clothes();
		c.setClothes_name(clothes_name);
		c.setClothes_price(clothes_price);
		c.setClothes_category(clothes_category);
		
		
		return "clothesList";
	}
}
