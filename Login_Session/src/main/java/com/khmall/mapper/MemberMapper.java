package com.khmall.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.khmall.dto.Member;

@Mapper
public interface MemberMapper {
	public Member getLogin(@Param("member_name") String member_name, @Param("member_phone")String member_phone);
	
}
