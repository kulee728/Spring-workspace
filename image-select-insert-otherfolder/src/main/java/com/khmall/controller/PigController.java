package com.khmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.khmall.dto.Pig;
import com.khmall.service.PigService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PigController {
	
	@Autowired
	private PigService pigService;
	
	@GetMapping("/pig-all-list")
	public String getAllpigs(Model model) {
		List<Pig> pigList = pigService.getAllPigs();
		model.addAttribute("pigList",pigList);
		log.info(pigList.toString());
		return "pigAllList";
	}
	
	//2. 돼지 정보 하나만 가져오기
	@GetMapping("/pigDetail/{pig_id}")
	public String getPigById(@PathVariable int pig_id,Model model) {
		Pig pig = pigService.getPigById(pig_id);
		model.addAttribute("pig",pig);
	return "pigDetail";	
	}
	
	
	//3. 돼지 정보 DB에 업로드 하기
	@GetMapping("/pig-image-upload")
	public String uploadPig(Model model) {
		model.addAttribute("p",new Pig());
		return "imgUpload";
	}
	
	@PostMapping("/upload")
	public String uploadPig(//Pig pig, Model model
			@RequestParam("pig_name") String pig_name,
			@RequestParam("pig_age") int pig_age,
			@RequestParam("pig_image_path") MultipartFile file,
			Model model) 
	{
		pigService.uploadPig(pig_name,pig_age,file);
		log.info("pig 업로드 확인");
		return "redirect:/";

	}
	
}
