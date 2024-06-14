package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.MemberDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("member")
@Slf4j
public class MemberController {
	
	@RequestMapping("memberInfo")
	public String memberInfo(Model model) {
		List<MemberDTO> memList = new ArrayList<>(); 
		memList.add(new MemberDTO("이강욱","010-1111-2222",10));
		memList.add(new MemberDTO("안건휘","010-3333-4444",20));
		memList.add(new MemberDTO("권성혁","010-4444-5555",30));
		model.addAttribute("memList",memList);
		return "member/memberInfo";
	}
	
}
