package com.khmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khmall.dto.Clothes;
import com.khmall.mapper.ClothesMapper;

@Service
public class ClothesService {
	@Autowired
	private ClothesMapper clothesMapper;
	
	public void insertClothes(//Clothes clothes 파일 받는 곳 필요
			) {
		
		Clothes clothes = new Clothes();
		clothesMapper.insertClothes(clothes);
	}
	public List<Clothes> getAllClothes(){
		
		return clothesMapper.getAllClothes();
	}

}
