package com.khmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.khmall.dto.Company;
import com.khmall.dto.SnackCompany;
import com.khmall.dto.Snacks;
import com.khmall.service.SnacksService;

@Controller
public class SnackController {
	
	@Autowired
	private SnacksService snacksService;
	
	@GetMapping("/allSnack")
	public String getAllSnacks(Model model) {
		
		List<Snacks> snackList = snacksService.getAllSnacks();
		model.addAttribute("snackList",snackList);
		return "SnackList";
	}
	
	@GetMapping("/allCompany")
	public String getAllCompany(Model model) {
		List<Company> companyList = snacksService.getAllCompany();
		model.addAttribute("companyList",companyList);
		return "CompanyList";
	}
	
	@GetMapping("/allSnackCompany")
	public String getAllSnackCompany(Model model) {
		List<SnackCompany> snackCompanyList = snacksService.getAllSnackCompany();
		model.addAttribute("snackCompanyList",snackCompanyList);
		return "SnackCompanyList";
	}
	

	
}
