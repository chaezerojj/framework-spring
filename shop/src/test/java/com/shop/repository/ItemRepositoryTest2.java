package com.shop.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.constant.ItemSellStatus;
import com.shop.entity.Item;

@SpringBootTest
class ItemRepositoryTest2 {

	@Autowired
	ItemRepository itemRepository;

//	@Test
//	@DisplayName("가격 LessThan 테스트")
//	void findByPriceLessThanTest() {
//		this.createItemList();
//		List<Item> itemList = itemRepository.findByPriceLessThan(100005);
//		for(Item item : itemList) {
//			System.out.println(item);
//		}
//	}
	
	@Test
	@DisplayName("가격 내림차순 조회 테스트")
	public void findByPriceLessThanOrderByPriceDesc() {
		this.createItemList();
		List<Item> itemList = 
				itemRepository.findByPriceLessThanOrderByPriceDesc(10005);
		for (Item item : itemList) {
			System.out.println(item);
		}
	}

	// 상품 10개 등록하기
	@Test
	public void createItemList() {
		for (int i = 1; i <= 10; i++) {
			Item item = new Item();
			item.setItemNm("테스트 상품" + i);
			item.setPrice(10000);
			item.setItemDetail("테스트 상품 상세 설명");
			item.setItemSellStatus(ItemSellStatus.SELL);
			item.setStockNumber(100);
			item.setRegTime(LocalDateTime.now());
			item.setUpdateTime(LocalDateTime.now());
			Item savedItem = itemRepository.save(item);
		}

	}

}
