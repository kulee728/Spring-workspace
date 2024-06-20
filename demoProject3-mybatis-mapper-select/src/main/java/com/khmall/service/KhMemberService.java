package com.khmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khmall.dto.KhMember;
import com.khmall.mapper.KhMemberMapper;

@Service
public class KhMemberService {
	
	@Autowired
	public KhMemberMapper khMemberMapper;
	
	public void insertKhMember(KhMember khMember) {
		khMemberMapper.insertKhMember(khMember);
	}
	
	public List<KhMember> getAllKhMember(){
		return khMemberMapper.getAllKhMember();
	}
}
