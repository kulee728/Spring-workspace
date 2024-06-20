package com.khmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.khmall.dto.SnackCompany;
import com.khmall.dto.Snacks;

@Mapper
public interface SnackCompanyMapper {
	List<SnackCompany> getAllSnackCompany();
	Snacks getSnackById(int snack_id);
	SnackCompany getCompanyById(int company_id);
}
