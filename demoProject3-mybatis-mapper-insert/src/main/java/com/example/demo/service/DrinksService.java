package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Drinks;
import com.example.demo.mapper.DrinksMapper;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class DrinksService {
	@Autowired
	private DrinksMapper drinksMapper;
	
	public void insertDrinks(Drinks drinks) {
		log.info(drinks.toString());
		drinksMapper.insertDrinks(drinks);
		
	}
}
