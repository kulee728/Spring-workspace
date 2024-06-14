package com.example.demo.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberDTO {
	private String memberName;
	private String memberPhoneNum;
	private int memberAge;
}
