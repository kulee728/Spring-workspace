package com.khmall.controller;

import java.util.Arrays;
import java.util.Objects;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.khmall.util.FileUploadUtil;

/*
 @Controller : HTML (View)에 정보를 띄우기 위해 사용
 @RestController : Controller 에 ResponseBody 가 합쳐진 형태로
 json 형태의 객체 데이터를 반환
 벡엔드 개발자가 보이는 화면 (view, html)이 없을 때
 데이터에 대한 중간 값을 확인하기 위해 사용하는 컨트롤러
 - React 에 FrontEnd 작성할 때 사용하기도 한다.

 */

//@RequestMapping("api/v1/img")
@RequestMapping("api/v2/img")
@RestController //> 벡엔드 용으로 작성하는 controller 
public class FileUploadController {
	
	@GetMapping("/upload")
	public String get() {
		
		return "반환할 HTML 주소";
	} //> GET API api/v1/img/upload .. controller 내 1개의 mapping 된 메서드가 곧 1개의 api 이다.
	
	
	@PostMapping("/upload")
	public void saveImage(@RequestParam("files") MultipartFile[] files) {
		String uploadFolderDir = "imgFolder2"; // /static/imgFolder
		
		
		//배열로 이미지를 담아 한번에 전송한다.
		Arrays.asList(files).stream().forEach(file->{
			
			//파일 이름에서 경로를 깔끔하게 정리
			//StringUtils 에서 cleanPath : 파일 이름에 포함될 수 있는 잠재적인 허수 값을 제거 할 수있다.
			String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
			try {
				FileUploadUtil.saveFile(uploadFolderDir, fileName, file);
				//업로드 파일 위치에 fileName으로 file 을 올리겠다
			}catch(Exception E){
				
			}
		});
	}
}
