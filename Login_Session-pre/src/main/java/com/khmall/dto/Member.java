package com.khmall.dto;

import lombok.*;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Member {
	private int member_id;
	private String member_name;
	private String member_password;
	private String member_email;
	private String member_created_at;
	
}
