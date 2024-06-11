package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * Spring 에서는 annotation을 많이 쓴다.'@'
 * Java 객체 : new 연산자에 의해 Heap 영역에 클래스에서 작성된 내용대로 생성된 것
 * 
 * instance : 개발자가 만들고 관리하는 객체
 * 
 * bean : Spring container (=Spring) 스프링이 만들고 관리하는 객체
 * 
 */

@Controller //요청이나 응답을 제어할 controller 역할을 명시
// bean 으로 등록(*객체로 생성해서 Spring이 관리)
//@RequestMapping("naver")
public class HelloController {
	//기존 Servlet : 클래스 단위로 하나의 요청만 가능하다
	// Spring : 메서드 단위로 요청 처리 가능하다
	
	//@RequestMapping("요청주소")
	// - 요청 주소를 처리할 메서드를 매핑하는 명시 Annotation
	
	/*
	 * 1) 메서드에 작성한다
	 * - 요청 주소, 메서드를 매핑
	 * - GET / POST 상관 없이 매핑 (속성값을 통해)
	 * 
	 * 2) 공통으로 매핑하는 방법 > "클래스에 작성"
	 * - 공통으로 사용하는 주소는 한번에 매핑
	 * ex) 네이버/쇼핑 네이버/블로그 네이버/카페 >>>>>> class 바로 위에 annotation 
	 * @RequestMapping("naver")
	 * 이후
	 * 카페 메서드 위에는 @RequestMapping("카페")
	 */
	@RequestMapping("/test")
	public String testMehod() {
		System.out.println("/test 요청 받았습니다");
		return "test";
	}
	
	@RequestMapping("/index")
	public String indexMehod() {
		System.out.println("/index 요청 받았습니다");
		return "index";
	}
	
} //spring은 중간중간 서버를 키지 않아도 잡는게 있다.



