package com.khmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.khmall.dto.SnackCompany;
import com.khmall.dto.Snacks;
import com.khmall.service.SnackCompanyService;

@Controller
public class SnackCompanyController {
	
	@Autowired
	private SnackCompanyService snackCompanyService;
	
	@GetMapping("/") //메인 페이지 실행시 실행되는 메서드
	public String IndexGetAllSnackCompany(Model model) {
		List<SnackCompany> scList = snackCompanyService.getAllSnackCompany();
		model.addAttribute("scList",scList);
		return "index";
	}
	@GetMapping("/snack/{snack_id}") //@{'/snack/' + ${sc.snack_id}} 의 참조는 이쪽으로 간다.
	public String getSnackDetails(Model model, @PathVariable("snack_id") int snack_id) {
		Snacks snack = snackCompanyService.getSnackById(snack_id);
		model.addAttribute("snack",snack);
		return "snackDetail";
	}
	@GetMapping("/company/{company_id}") //@{'/snack/' + ${sc.snack_id}} 의 참조는 이쪽으로 간다.
	public String getCompanyDetails(Model model, @PathVariable("company_id") int company_id) {
		SnackCompany sc= snackCompanyService.getCompanyById(company_id);
		model.addAttribute("company",sc);
		return "companyDetail";
	}
	
	
}
