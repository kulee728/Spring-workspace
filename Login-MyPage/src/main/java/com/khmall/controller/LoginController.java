package com.khmall.controller;

import java.util.List;

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
//@RestController -> 추후 리액트를 사용할 때 사용 예정
public class LoginController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login")
	public String showLogin(Model model) {
		model.addAttribute("m",new Member());
		return "login";
	}
	
	@PostMapping("/login")
	public String getLogin(Model model,
		@RequestParam("member_name") String member_name,
		@RequestParam("member_phone") String member_phone,
		HttpSession session
			) {
		Member member = memberService.getLogin(member_name, member_phone);
		//만약 로그인 정보와 일치한다면
		//그대로 db에서 가져올 것. 하지만 못가져오면 null
		if(member != null) {
			session.setAttribute("loginSession", member);
			return "redirect:/";
		}
		else {
			model.addAttribute("e","일치하는 아이디 비밀번호가 존재하지 않습니다.");
			model.addAttribute("m",new Member());
			return "login";
		}
	}
	
	@GetMapping("/myPage")
	public String showMyPage(HttpSession session,Model model) {
		//현재 로그인이 된 세션의 정보를 가져와 멤버 정보 조회하는 코드
		Member member = (Member)session.getAttribute("loginSession");
		if(member==null) {
			return "redirect:/login";
		}
		//세션에서 가져온 값 (==로그인한 유저의 정보) 를 model 에 넣어 display 할 용도.
		model.addAttribute("member",member);
		return "myPage";
	}
	
	@GetMapping("/modifyProfile")
	public String modifyMyPage(HttpSession session,Model model) {
		Member member = (Member)session.getAttribute("loginSession");
		if(member==null) {
			return "redirect:/login";
		}
		//세션에서 가져온 값 (==로그인한 유저의 정보) 를 model 에 넣어 display 할 용도.
		model.addAttribute("member",member);
		return "modifyProfile";
	}
	
	@PostMapping("/modifyProfile")
	public String modifyMyPageSubmission(HttpSession session,Member updateMember) {
		Member member = (Member)session.getAttribute("loginSession");
		if(member==null) {
			return "redirect:/login";
		}
		//member.setMember_id()
		//세션에서 가져온 값 (==로그인한 유저의 정보) 를 model 에 넣어 display 할 용도.
		updateMember.setMember_id(member.getMember_id());
		memberService.updateMember(updateMember);
		session.setAttribute("loginSession", updateMember);
		return "myPage";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("deleteMember")
	public String deleteMember(HttpSession session){
		Member deleteMember = (Member)session.getAttribute("loginSession");
		if(deleteMember==null) {
			return "redirect:/login";
		}
		memberService.deleteMember(deleteMember.getMember_id());
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/search")
	public String showSearchForm(Model model, HttpSession session) {
		model.addAttribute(session);
		return "search";
	}
	@PostMapping("/search")
	public String showSearchForm(Model model, @RequestParam("keyword") String keyword) {
		List<Member> memberList = memberService.searchMembers(keyword);
		model.addAttribute("results",memberList);
		
		return "search";
	}

}
