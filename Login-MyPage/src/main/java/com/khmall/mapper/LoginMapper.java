package com.khmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.khmall.dto.Member;

@Mapper
//@MapperScan mapper 위치가 찾아지지 않을 때 Main 메서드에
//Mapper의 주소를 작성해주는 annotation.
//사용법 : @MapperScan("com.khmall.mapper.LoginMapper")
//사용법 : @MapperScans("com.khmall.mapper.*")
public interface LoginMapper {
	Member getLogin(@Param("member_name") String member_name,
					@Param("member_phone") String member_phone
			);
	void updateMember(Member member);
	void deleteMember(int member_id);
	List<Member> searchMembers(@Param("keyword") String keyword );
}

