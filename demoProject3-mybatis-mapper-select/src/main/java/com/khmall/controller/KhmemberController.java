package com.khmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.khmall.dto.KhMember;
import com.khmall.service.KhMemberService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class KhmemberController {
	
	@Autowired
	private KhMemberService khMemberService;
	
	@GetMapping("/signUp")
	public String inserKhMemberPage(Model model) {
		//List<SnackCompany> snackCompanyList = snacksService.getAllSnackCompany();
		model.addAttribute("khMem",new KhMember());
		return "signUp";
	}
	
	@PostMapping("/khMemberList")
	public String getKhMemberAll(Model model,KhMember khMember) {
		
		khMemberService.insertKhMember(khMember);
		List<KhMember> khMemberList = khMemberService.getAllKhMember();
		log.info(khMemberList.toString());
		model.addAttribute("khMemberList",khMemberList);
		return "khmemberList";
	}
}
