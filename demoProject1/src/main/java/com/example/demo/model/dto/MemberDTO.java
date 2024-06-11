package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter // lombok annotation
public class MemberDTO {
//model.dto 에서..db랑 연결할 모델들을 작성해줄 것이다.
	/*
	 Getter 와 Setter는 Lombok 라이브러리를 활용해
	 축약된 약어로 작성 가능하다.
	 
	 ---lombok 자동완성 메서드들---
	 Getter > @Getter
	 Setter > @Setter
	 기본생성자 > @NoArgsConstructor
	 필수생성자 > @AllArgsConstructor 
	 toString >  @ToString
	*/
	private String memberId;
	private String memberPw;
	private String memberName;
	private int memberAge;
}
