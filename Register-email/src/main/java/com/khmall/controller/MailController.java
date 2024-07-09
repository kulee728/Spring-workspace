package com.khmall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khmall.service.EmailService;
import lombok.RequiredArgsConstructor;

/*
 * @RequiredArgsConstructor > final 로 작성된 필드를 도와주는 생성자
 * 
 * @ResponseBody = service.java 에서 메일 content로  작성한 html 내용을
 * json으로 변환, 사용자에게 전달할 떄 씀
 * json  형식
 * {[
 * nubmer(key) : value,
 * ]}
 * 
 * 
 * */

@Controller
@RequiredArgsConstructor
public class MailController {
	@Autowired
	private EmailService mailService;
	
	@GetMapping("/")
	public String MailPage() {
		return "index";
	}
	
	@ResponseBody 
	@PostMapping("/mail") //메일에서 인증번호를 전송받은 값이 일치하는지 확인
	public String mailSend(String mail) {
		int number = mailService.sendMail(mail);
		String num = "" + number;
		return num;
	}
	
}
