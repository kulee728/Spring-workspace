package com.example.demo.dto;

import lombok.*;


/*
 * Spring 의 경우 getter가 필수로 있어야하고, 
 * ${StudentDTO.name} 으로 필드명 getter를 호출할 수 있다. (get 함수랑 같다) 
 * 
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentDTO {
	private String studentNo;
	private String name;
	private int age;
}


