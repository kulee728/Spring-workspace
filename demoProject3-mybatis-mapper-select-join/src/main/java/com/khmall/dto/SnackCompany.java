package com.khmall.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SnackCompany {
	private int snack_id;
	private String snack_name;
	private int price;
	private int company_id;
	private String company_name;
	private String company_phone;
	private String company_address;
}
