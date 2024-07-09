package com.khmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khmall.dto.Member;
import com.khmall.mapper.MemberMapper;

@Service
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	public Member getLogin(String member_email,String member_password) {
			return memberMapper.getLogin(member_email, member_password);
	}	
}
