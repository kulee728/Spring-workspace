package com.khmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khmall.dto.Goods;
import com.khmall.mapper.ProductMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductService {

	@Autowired
	private ProductMapper productMapper;
	
	public void insertProduct(Goods goods) {
		log.info(goods.toString());
		productMapper.insertProduct(goods);
	}
	
	//상품 목록 controller에 던져주기
	public List<Goods> getAllProduct(){
		return productMapper.getAllProduct();
	}
	
}
