package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
// sql 작성할 필요가 없이 사용 가능!
import org.springframework.stereotype.Repository;

import com.shop.entity.Item;

// JpaRepository - 2개의 제네릭 타입 사용
// 1 >> 엔티티 타입 클래스 넣어줌
// 2 >> 기본키 타입 넣어줌
// JpaRepository - 기본적인 CRUD 및 페이징 처리를 위한 메소드 정의되어 있음

// JpaRepository를 상속받는 ItemRepository
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
	// JpaRepository에서 지원하는 메소드 예시
	// <메소드> | <기능>
	// save() | 엔티티 저장 및 수정
	// delete() | 엔티티 삭제
	// count() | 엔티티 총 갯수 반환
	// findAll() | 모든 엔티티 조회

	// Repository 인터페이스에 간단한 네이밍 룰을 이용하여 메소드 작성 시 원하는 쿼리 실행 가능
	// - find : 데이터를 조회하는 메소드 이용 시 가장 많이 사용하는 문법
	// - find+(엔티티이름(생략가능))+By+(변수이름)

	// 상품 이름 이용하여 데이터 조회하는 예제
	List<Item> findByItemNm(String itemNm);
	// 매개변수로 검색 시 사용할 상품명 변수를 넘겨줌

	// 상품을 상품명과 상품상세설명을 OR조건을 이용하여 조회하는 쿼리 메소드
	List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);

	// 파라미터로 넘어온 price변수보다 값이 작은 상품 데이터를 조회하는 쿼리 메소드
	// * JPQL snippet
	// LessThan - where x < ? (where문에서 x보다 더 작은 값 찾음)
	List<Item> findByPriceLessThan(int price);

	// 출력 결과를 OrderBy키워드를 이용하여 오름차순 or 내림차순으로 조회
	// - 오름차순의 경우: OrderBy + 속성명 + Asc키워드
	// - 내림차순의 경우: OrderBy + 속성명 + Desc키워드
	// 상품의 가격이 높을수록 조회하는 예제
	List<Item> findByPriceLessThanOrderByPriceDesc(int price);
	
	// @Query어노테이션
	// - SQL과 유사한 JPQL(Java Persistence Query Language)
	// JPQL
	// : 엔티티 객체를 대상으로 쿼리 수행
	// - 테이블이 아닌 객체를 대상으로 검색하는 객체지향 쿼리
	// - 특정 데이터베이스에 의존하지 않음
	// - JPQL로 작성했다면 데이터베이스 변경되어도 애플리케이션에 영향 받지 않음
	
	// @Query어노테이션을 이용하여 상품 데이터 조회하는 예제
	// - 상품 상세 설명을 파라미터로 받아 해당 내용을 상품 상세 설명에 포함하는
	//   데이터를 조회하며, 정렬 순서는 가격이 높은 순으로 조회
	
	@Query(value="select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc")
	// from뒤에는 엔티티 클래스로 작성한 Item 지정
	// - Item으로부터 데이터를 select하겠다는 의미
	// 파라미터에 @Param어노테이션을 이용하여 파라미터로 넘어온 값을 JPQL에 들어갈 변수로 지정
	// - 현재는 itemDetail변수를 "like % %" 사이에 ":itemDetail"로 값이 들어가도록 작성
	List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);
	// @Param어노테이션 이용해 JPQL에 변수 전달하는 대신 파라미터 순서 이용하여 전달
	
	// 기존의 데이터베이스에서 사용하던 쿼리를 그대로 사용해야 할 때는
	// @Query의 nativeQuery속성을 사용하면 기존 쿼리 그대로 활용 가능
	@Query(value="select * from item i where i.item_detail like '상세' order by i.price desc", nativeQuery=true)
	List<Item> findByItemDetailByNative();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
