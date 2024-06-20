package com.khmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.khmall.dto.KhMember;

@Mapper
public interface KhMemberMapper {
	void insertKhMember(KhMember khMember);
	
	List<KhMember> getAllKhMember();
}
