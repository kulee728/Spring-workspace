package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.Goods;
import com.example.demo.service.GoodsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class GoodsController {
	
	@GetMapping("/") //맨 앞 페이지에서 볼 화면
	public String registerform(Model model) {
		model.addAttribute("goods",new Goods()); //DB에 값을 넣을 수 있는 객체 생성
		return "index";
	}
	
	//GoodsService에 숫자값이 아니면 들어가지 못하게 방지를 하거나, 비밀번호 암호화 설정과 같은
	//상세 기능을 넣고 service 를 호출해서 mapper java 파일에 값을 전달할 수 있도록 작성해주기.
	
	@Autowired
	private GoodsService goodsService;
	
	@PostMapping("/register")
	public String insertGoods(Goods goods, Model model) {
		/* 
		 parameter 설명 : 
		 goods > html form 에 name으로 시작하는 변수 명이 있으면
		 Goods.java 의 변수명 (goodsName 등) 과
		 name="goodsName" 같이 일치하는 경우
		 자동으로 Goods.java 변수명에 폼 작성값이 바로바로 임시저장(할당됨)
		 Model model = 돌아가기를 하거나, 새로고침을 사용하는경우 html에 데이터를 다시 전달하는 역할
		 .. 또 다른 의미로는 임시저장을 하는 기능이다.
		 */
		
		goodsService.insertGoods(goods);
		log.debug(goods.toString());
		model.addAttribute("msg", "상품(굿즈) 성공적으로 등록되었습니다.");
		return "registerSuccess";
	}
}
