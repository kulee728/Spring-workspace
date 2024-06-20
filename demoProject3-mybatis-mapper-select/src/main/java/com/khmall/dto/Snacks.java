package com.khmall.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Snacks {
	private int s_id;//snack_id;
	private String snack_name;
	private int price;
	
	//원래는 company_id도 존재한다.
}
