package com.khmall.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khmall.dto.Member;
import com.khmall.mapper.LoginMapper;

@Service
public class MemberService {

	@Autowired
	private LoginMapper memberMapper;
	
	public Member getLogin(String member_name,
			String member_phone){
		return memberMapper.getLogin(member_name, member_phone);
	} //추후 서비스에 비밀번호 암호화 해서 DB에 저장하고
	// 암호화 된 비밀번호 가져와서 로그인하는 코드를 작성할 예정
	public void updateMember(Member member) {
		memberMapper.updateMember(member);
	}
	
	public void deleteMember(int member_id) {
		memberMapper.deleteMember(member_id);
	}
	public List<Member>searchMembers(@Param("keyword") String keyword){
		return memberMapper.searchMembers(keyword);
	}
}
