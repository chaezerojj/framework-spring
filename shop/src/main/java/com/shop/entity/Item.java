package com.shop.entity;

import java.time.LocalDateTime;

import com.shop.constant.ItemSellStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 상품 엔티티 설계하기
// ? 엔티티(Entity)
// : 데이터베이스의 테이블에 대응하는 클래스
// - @Entity가 붙은 클래스는 JPA에서 관리하며 엔티티라고 부름
// - @Entity 어노테이션: 클래스 상단 입력 시 JPA에 엔티티 클래스라는 것을 알려줌

@Entity
@Table(name = "item")
// - @Table어노테이션 - 어떤 테이블과 매핑할지 지정함
@Getter
@Setter
@ToString
public class Item {
	// 상품 코드
	@Id
	// - @Id어노테이션 - id멤버 변수를 상품테이블의 기본키로 설정
	@GeneratedValue(strategy = GenerationType.AUTO)
	// - @GeneratedValue어노테이션 - 기본키 생성 전략(방법)
	// - Auto - JAP구현체가 자동으로 생성 전략 결정
	// - MySQL 데이터베이스의 경우, auto_increment 사용하여 기본키 생성함
	@Column(name = "item_id")
	// - @Column
	// - 추가속성 name - 필드와 매핑할 컬럼의 이름 설정, 기본값: 객체의 필드 이름
	private Long id;

	// 상품명
	@Column(nullable = false, length = 50)
	// - nullable: null값의 허용 여부 설정
	// - length: String 타입의 문자길이 제약조건 설정
	private String itemNm;

	// 가격
	@Column(name = "price", nullable = false)
	private int price;
	
	// 재고수량
	@Column(nullable = false)
	private int stockNumber;
	
	// 상품 상세 설명
	@Column(nullable = false)
	private String itemDetail;
	
	// 상품 판매 상태
	@Enumerated(EnumType.STRING)
	// - @Enumerated어노테이션 - enum타입 엔티티 매핑할 때 사용
	// - EnumType.ORIGINAL: enum순서(숫자)값을 DB에 저장
	// - EnumType.STRING: enum이름 값을 DB에 저장
	private ItemSellStatus itemSellStatus;
	
	// 등록 시간
	private LocalDateTime regTime;
	
	// 수정 시간
	private LocalDateTime updateTime;
}
