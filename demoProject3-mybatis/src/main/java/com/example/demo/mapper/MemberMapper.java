package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.Member;

/*
db에 어떤 값을 조회/삽입/삭제/수정을
작성만 해주는 공간
 */

@Mapper //Mapper 명칭 지정
public interface MemberMapper { //매퍼는 보통 인터페이스다.
	//멤버가 새로 가입하면 db에 넣어주기,
	void insertMember(Member member);
}
