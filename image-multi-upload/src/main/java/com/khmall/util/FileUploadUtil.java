package com.khmall.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {

	public static void saveFile(String uploadDir, 
			String fileName, MultipartFile mpFile) throws IOException {
		//폴더에 파일을 업로드 하기 위해 경로 설정
		//Path uploadPath = Paths.get("C:\\"+uploadDir);
		
		//바탕화면에 imageFolder 넣는 version
		Path uploadPath = Paths.get("C:\\Users\\user1\\Desktop\\"+uploadDir);
		
		//만약 이미지 저장할 폴더가 존재하지 않다면 폴더 생성
		//String 으로 변환, 파일경로를 읽고 저장 폴더가 존재하지 않으면 폴더를 생성한다.
		if(!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
				//1. inpustStream, 파일 저장 스트림 객체 생성
			try (InputStream inputStream = mpFile.getInputStream()){
				//try 조건을 소괄호 안으로 넣어주면 메모리가 절약된다.
				//try with resource
				/*
				 stream > buffer 이미지를 사용자에게 그 때 마다 
				 디스플레이 할 수 있도록 데이터를 저장하는 공간
				Stream 의 경우 다른 코드 보다 메모리 사용량이 높기에
				try with resource 처리가 좋다. 
				 */
			
				//uploadPath.resolve(fileName) > 2.경로와 파일명을 한번에 제작
				Path filePath = uploadPath.resolve(fileName);
				
				//3.파일들을 복사, inputStream 의 내용을 filePath에 붙여넣기. 동명의 파일 존재시 덮어씌 
				/*
				 - 덮어씌기 에러 안나게 설정
				 - 기존 파일 존재시 파일 copy에 대한 정책 설정 가능
				 - 숫자/업로드날짜 추가
				 - copy 안함
				 - 덮어씌우기 등등
				 */
				
				Files.copy(inputStream,filePath,StandardCopyOption.REPLACE_EXISTING);
		
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}
