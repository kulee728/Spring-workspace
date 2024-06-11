package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("param")
public class ParamController {
	
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
}
