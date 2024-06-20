package com.khmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khmall.dto.SnackCompany;
import com.khmall.dto.Snacks;
import com.khmall.mapper.SnackCompanyMapper;

@Service
public class SnackCompanyService {
	
	@Autowired
	private SnackCompanyMapper snackCompanyMapper;
	
	public List<SnackCompany> getAllSnackCompany(){
		return snackCompanyMapper.getAllSnackCompany();
	}
	public Snacks getSnackById(int snack_id) {
		return snackCompanyMapper.getSnackById(snack_id);
	}
	
	public SnackCompany getCompanyById(int company_id) {
		return snackCompanyMapper.getCompanyById(company_id);
	}
}
