package com.khmall.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.khmall.dto.Member;

@Mapper
public interface MemberMapper {
	Member getLogin(String member_email, String member_password);
}
