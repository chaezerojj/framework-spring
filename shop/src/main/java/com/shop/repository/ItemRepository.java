package com.shop.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// sql 작성할 필요가 없이 사용 가능!
import org.springframework.stereotype.Repository;

import com.shop.constant.ItemSellStatus;
import com.shop.entity.Item;

// JpaRepository - 2개의 제네릭 타입 사용
// 1 >> 엔티티 타입 클래스 넣어줌
// 2 >> 기본키 타입 넣어줌
// JpaRepository - 기본적인 CRUD 및 페이징 처리를 위한 메소드 정의되어 있음

// JpaRepository를 상속받는 ItemRepository
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
	// JpaRepository에서 지원하는 메소드 예시
	//   <메소드>  |    <기능>
	// save()    | 엔티티 저장 및 수정
	// delete()  | 엔티티 삭제
	// count()   | 엔티티 총 갯수 반환
	// findAll() | 모든 엔티티 조회

	// Repositoy 인터페이스에 간단한 네이밍 룰을 이용하여 메소드 작성 시 원하는 쿼리 실행 가능
	// - find : 데이터를 조회하는 메소드 이용 시 가장 많이 사용하는 문법
	// - find+(엔티티이름(생략가능))+By+(변수이름)
	
	// 상품 이름 이용하여 데이터 조회하는 예제
	List<Item> findByItemNm(String itemNm);
	// 매개변수로 검색 시 사용할 상품명 변수를 넘겨줌
	
	// 상품을 상품명과 상품상세설명을 OR조건을 이용하여 조회하는 쿼리 메소드
	List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);
	
	}
	
