package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Goods;
import com.example.demo.mapper.GoodsMapper;

import lombok.extern.slf4j.Slf4j;
/*
	상세 기능을 작성해주는 공간 (service)
	정규식이나 비밀번호 암호처리와 같은 기능을 세부적으로 작성
*/
@Service
@Slf4j
public class GoodsService {

	@Autowired // 이걸 해줘야 xml과 service <> mapper, xml 연동해주는 내용을 생략해도 된다.
	private GoodsMapper goodsMapper;
	
	public void insertGoods(Goods goods) {
		log.info(goods.toString());
		goodsMapper.insertGoods(goods);
	}
	
	//Mapper.xml 파일에 존재하는 메서드 id 값을 참조해서 메서드를 작성해준다.
	//Insert id를 넣어주는 경우 비밀번호 정규식. 설정. 일치여부 같은 기능을 작성한다.
	//if문이 많겠죠?
}
