package com.khmall.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
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
	
	public List<Pig> getAllpigs(){
		
		return pigMapper.getAllpigs();
	}
	
	public Pig getPigById(int pig_id) {
		return pigMapper.getPigById(pig_id);
	}
	public void uploadPig(String pig_name, int pig_age, MultipartFile file) {
		//파일 이름을 가져온 후, 우리가 저장하고자 하는 파일 경로를 설정하는 과정
		String fileName = file.getOriginalFilename();
		System.out.println("file Name : "+fileName);

		Path directoryPath = Paths.get("src", "main", "resources","static", "img");// "user", String.valueOf(user_id));
		
		String uploadDir = "C:/DEV_ANTON/spring-workspace/demoProject3-mybatis-mapper-select-image/src/main/resources/static/images/";
	
		File imgFile = new File(uploadDir+fileName);
					  //new File(directoryPath+"/"+fileName);
		log.info("이미지 저장 경로"+ imgFile.getPath());
		try {
			file.transferTo(imgFile);
			//log.info("파일")
			Pig pig = new Pig();
			pig.setPig_name(pig_name);
			pig.setPig_age(pig_age);
			//pig.setPig_image_path(uploadDir);
			pig.setPig_image_path("/images/"+fileName);
			pigMapper.uploadPig(pig);
			
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//imgFile 용 폴더가 존재 하지 않는다면..

	}
	
	//public String folder유무/image 파일 체크해주는 메서드 작성 필요
	
}
