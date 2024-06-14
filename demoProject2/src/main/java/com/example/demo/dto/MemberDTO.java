package com.example.demo.dto;

import lombok.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MemberDTO {
	private String memberNo;
	private String memberName;
	private String memberAge;
}
