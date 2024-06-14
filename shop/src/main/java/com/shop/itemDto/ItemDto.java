package com.shop.itemDto;

import java.time.LocalDateTime;

import lombok.*;

@Getter
@Setter
public class ItemDto {
	private Long id;
	private String itemNm;
	private Integer price;
	private String itemDetail;
	private String sellStatCd;
	private LocalDateTime regTime;
	private LocalDateTime updateTime;
	
}
