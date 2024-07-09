package com.khmall.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.khmall.mapper.ImageUploadMapper;


public class ImageUploadUtil {

	//@Autowired
	//private ImageUploadMapper imageuploadMapper;
	
	public static void insertImageUpload(String uploadDir, String fileName, MultipartFile multipartfile) throws IOException {
		//컨트롤러에서는 MultipartFile [] > 서비스에 업로드 한 파일을 한꺼번에 html로 전달
		//서비스에서는 MultipartFile > 파일을 낱개씩 처리
		Path uploadPath = Paths.get("C:/"+uploadDir);
		if(!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		try (InputStream inputStream = multipartfile.getInputStream()){
			
			Path filePath = uploadPath.resolve(fileName);
			Files.copy(inputStream,filePath,StandardCopyOption.REPLACE_EXISTING);
	

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	/*
	 html <> db  : serivce 가 담당
	 db <> postman (벡엔드에서만 테스트) : util을 작성하여 담당
	 */
}
