package com.khmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.khmall.dto.Clothes;

@Mapper
public interface ClothesMapper {
	void insertClothes(Clothes clothes);
	List<Clothes> getAllClothes();

}
