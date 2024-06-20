package com.khmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khmall.dto.Company;
import com.khmall.dto.SnackCompany;
import com.khmall.dto.Snacks;
import com.khmall.mapper.SnacksMapper;

@Service
public class SnacksService {

	@Autowired
	private SnacksMapper snacksMapper;
	
	//@Autowired
	//private CompanyMapper companyMapper;
	
	public List<Snacks> getAllSnacks(){
		return snacksMapper.getAllSnacks();
	}
	
	public List<Company> getAllCompany(){
		return snacksMapper.getAllCompany();
	}
	public List<SnackCompany> getAllSnackCompany(){
		return snacksMapper.getAllSnackCompany();
	}
}
