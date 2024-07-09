package com.khmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	
	@GetMapping("/imgUpload")
	public String imgUpload(Model model) {
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
		log.info("pig 업로드 확인"); //+ pig.toString());
		return "redirect:/"; //업로드 완료시 메인 페이지 디스플레이
		/*
		 index와 차이점 ?
		 redirect :/ 사용자가 새로운 url로 다시 요청하도록 지시하는 것
		 >> 뭔가 작성하고 url에 요청을 보내는 의미. react로 작성한 값을 전달할 때 주로 사용할 예정.
		 index > html 파일 index.html을 의미
		  
		 */
	}
	
	
	
	//error 경로 지정은 application.properties에서 설정할 수 있다.
	/*
	@RequestMapping("/error")
	public String getError() {
		return "error";
	}
	*/
	
}
