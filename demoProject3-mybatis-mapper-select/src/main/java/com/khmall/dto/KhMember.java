package com.khmall.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class KhMember {
	private int member_id;
	private String username;
	private String password;
	private String email;
	private String created_at;
}
