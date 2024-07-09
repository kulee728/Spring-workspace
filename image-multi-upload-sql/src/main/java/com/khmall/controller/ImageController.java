package com.khmall.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.khmall.mapper.ImageUploadMapper;
import com.khmall.service.ImageUploadUtil;

import lombok.extern.slf4j.Slf4j;
//import com.khmall.util.FileUploadUtil;
@Slf4j
//@RestController
@Controller
//@RequestMapping("/api/v1/img")
public class ImageController {
	
	@Autowired
	private ImageUploadMapper imageUploadMapper;
	
	@GetMapping("/api/v1/img/upload") //api 1개 > get api > select 등 보여주기 위한 주소 1개
	public String showUploadForm(Model model) {
		return "upload";
	}
	
	
	@PostMapping("/api/v1/img/upload")
	public String saveImage(@RequestParam("files") MultipartFile[] files, Model model) {
		String uploadFolderDir = "img"; // /static/imgFolder
		/*
		for(MultipartFile file : files) {
			String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
			// fileName 무사히 나오는지 확인해야 한다면
			log.info(file.toString());
			imageUploadService.insertImageUpload(uploadFolderDir, fileName, file);
		}*/
		Arrays.asList(files).forEach(file ->{
			String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
			log.info(file.toString());
			try {
				ImageUploadUtil.insertImageUpload(uploadFolderDir, fileName, file);
				Map<String,Object> paramMap = new HashMap<>();
				paramMap.put("file_name",fileName);
				paramMap.put("upload_dir",uploadFolderDir);
				
				
				// Mybatis를 사용한 Mapper를 이용해서 DB 삽입
				//The method insertImageUpload(ImageUpload) in the type ImageUploadMapper is not applicable for the arguments (Map<String,Object>)
				//paramMap 의 경우 Map<String, Object> 로 값을 전달해주지만
				//Mapper는 Map<String, Object>로 값을 가져오지 않기 때문에 발생
				imageUploadMapper.insertImageUpload(paramMap);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		});
		return "upload";
	}
}
