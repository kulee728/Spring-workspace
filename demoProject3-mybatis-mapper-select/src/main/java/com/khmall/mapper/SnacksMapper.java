package com.khmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.khmall.dto.Company;
import com.khmall.dto.SnackCompany;
import com.khmall.dto.Snacks;

@Mapper
public interface SnacksMapper {
	
	@Autowired
	public List<Snacks> getAllSnacks();
	
	@Autowired
	public List<Company> getAllCompany();
	
	@Autowired
	public List<SnackCompany> getAllSnackCompany();
	
}
