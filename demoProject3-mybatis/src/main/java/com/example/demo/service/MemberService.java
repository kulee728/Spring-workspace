package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Member;
import com.example.demo.mapper.MemberMapper;

/*
 	상세 기능을 작성해주는 공간 (service)
 	정규식이나 비밀번호 암호처리와 같은 기능을 세부적으로 작성
 */

@Service
public class MemberService {
	
	@Autowired //알아서 잘 매핑해서 전달해줘. (의존성 주입)
	private MemberMapper memberMapper;
	
	//Mapper.xml 파일에 존재하는 insert id 값으로 변경해서 작성해주기
	public void insertMember(Member member) {
		//비밀번호 정규식. 설정. 일치여부 같은 기능을 작성한다.
		//if문이 많겠죠?
		memberMapper.insertMember(member);		
	}
	
}
