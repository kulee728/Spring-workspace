package com.khmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.khmall.dto.Pig;
import com.khmall.service.PigService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PigController {

	@Autowired
	private PigService pigService;
	
	@GetMapping("/")
	public String getAllpigs(Model model) {
		List<Pig> pigList = pigService.getAllpigs();
		model.addAttribute("pigList",pigList);
		log.info(pigList.toString());
		return "index";	
	}
	
	@GetMapping("/pigDetail/{pig_id}")
	public String getPigById(@PathVariable int pig_id,Model model) {
		Pig pig = pigService.getPigById(pig_id);
		model.addAttribute("pig",pig);
	return "pigDetail";	
	}
}
