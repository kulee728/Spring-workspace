package com.khmall.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.khmall.dto.Pig;
import com.khmall.mapper.PigMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PigService {
	
	@Autowired
	private PigMapper pigMapper;
	
	/*
	 * Autowired는 다음 코드가 생략된 것임
	 public PigService(PigMapper pigMapper){
	 	this.pigMapper = pigMapper;
	 }
	 */
	public List<Pig> getAllPigs(){
		return pigMapper.getAllPigs();
	}
	
	//2. 돼지 정보 하나만 가져오기
	public Pig getPigById(int pig_id) {
		return pigMapper.getPigById(pig_id);
	}
	
	//3. 돼지 정보 DB에 업로드 하기
	//Pig 자체를 업로드 하기 전에 이미지 저장 처리를 해줘야 한다.
	public void uploadPig(String pig_name, int pig_age, MultipartFile file) {
		
		// 만약에 파일이름을 저장하길 원한다면 이미지 업로드 때
		// 임시저장 이미 파일이름 가져옴.
		String fileName = file.getOriginalFilename();
		
		File imageStoreDirectory = new File("C:/Users/user1/Desktop/pigImg/");
		
		if(!imageStoreDirectory.exists()) {
			imageStoreDirectory.mkdirs();
		}
		File destFile = new File(imageStoreDirectory.getPath()+"/"+fileName);
		try {
			file.transferTo(destFile);
			Pig pig = new Pig();
			pig.setPig_name(pig_name);
			pig.setPig_age(pig_age);
			pig.setPig_image_path(destFile.getAbsolutePath());
			pigMapper.uploadPig(pig);
			log.info("Service > Mapper 전달 성공");
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
}
