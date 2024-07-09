package com.khmall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.khmall.dto.Member;
import com.khmall.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login")
	public String showLoginForm(Model model) {
		model.addAttribute("m",new Member());
		return "login";
	}
	
	@PostMapping("/login")
	public String getLogin(Model model,
			@RequestParam("member_name") String member_name,
			@RequestParam("member_phone") String member_phone,
			HttpSession session
			){
		Member member = memberService.getLogin(member_name, member_phone);
		if(member != null) {
			session.setAttribute("loginSession", member);
			return "redirect:/";
		}
		else { //존재하는 매칭이 없는 경우
			model.addAttribute("error","일치하는 아이디 비밀번호가 없습니다.");
			Member m = new Member();
			m.setMember_name("그런 이름 또 없습니다.");
			model.addAttribute("m", m);
			return "login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	/*
	 클라이언트 <> 서버 간 상태를 유지하는데 사용하는 객체
	 상태를 유지,식별 하고 데이터를 저장하거나 클라이언트의 수명을 관리할 수 있다. 
		데이터를 전달 받은 값이 일치하는지 식별하고, 일정한 기간동안
		데이터를 저장하고 일정 시간이 지나면
		세션이 종료되도록 수명을 관리할 수도 있다.
	 */
}
