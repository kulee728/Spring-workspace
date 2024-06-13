package com.example.demo.model.dto;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class BlogDTO {
	private String commentName;
	private String commentOpinion;
}