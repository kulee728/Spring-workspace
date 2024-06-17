package com.example.demo.dto;

import lombok.*;

/*
 * VALUES(goods_seq.NEXTVAL, #{goodsName}, #{goodsPrice}, #{goodsQuantity});
 * 에서 불러올 변수 작성하기
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
	private int goodsId; // goodsId 는 어떻게 가져올까? SEQ...
	private String goodsName;
	private int goodsPrice;
	private int goodsQuantity;
}
