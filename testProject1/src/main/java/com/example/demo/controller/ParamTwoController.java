package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("param")
public class ParamTwoController {
	
	@RequestMapping("main")
	public String paramMain() {
		return "/param/main";
	}
	
	
	@PostMapping("test1")
	public String paramTest1(HttpServletRequest req) {
		String inputName = req.getParameter("inputName");
		int inputAge = Integer.parseInt(req.getParameter("inputAge"));
		String inputAddress = req.getParameter("inputAddress");
		
		log.debug("디버그로그");
		log.info(inputName + inputAge +inputAddress);
		
		/* Spring 에서 redirect:[요청주소] 하면 되돌아가진다. */
		return "redirect:/param/main";
	}
	
	@RequestMapping("/test2")
	public String snackParam(
			@RequestParam("snackName") String snackName,
			@RequestParam("snackCompany") String snackCompany,
			@RequestParam("snackPrice") int snackPrice,
			@RequestParam(value="snackLike",required=false,defaultValue="선호도미정") String snackLike
			) {
		log.info(snackName +snackCompany+snackPrice+snackLike);
		return "redirect:/param/main";
	}
	
	@RequestMapping("/test3")
	public String snackParam(
			@RequestParam("LikeSnack") String[] likeSnackArr,
			@RequestParam("LikeCompany") List<String> likeCompanyList
			) {
		log.info(Arrays.toString(likeSnackArr));
		log.info(likeCompanyList.toString());
		return "redirect:/param/main";
	}
	
}
