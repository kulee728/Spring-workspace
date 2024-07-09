package com.khmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.khmall.dto.Pig;

@Mapper
public interface PigMapper {
	
	//1. 돼지 정보 전체 리스트
	List<Pig> getAllPigs();
	
	//2. 돼지 정보 하나만 가져오기
	Pig getPigById(int pig_id);
	
	//3. 돼지 정보 DB에 업로드 하기
	void uploadPig(Pig pig);
	
}
