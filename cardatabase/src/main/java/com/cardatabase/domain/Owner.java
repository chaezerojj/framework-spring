package com.cardatabase.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 차 소유자
@Entity
@Getter
@Setter
@ToString
public class Owner {
	// car 테이블과 일대다 관계에 있는 owner라는 새 엔티티 추가
	// 일대다 관계 > 소유자 한명이 자동차 여러 대 가질 수 있지만
	//            한 자동차의 소유주는 한 명이라는 뜻
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long ownerid;
	private String firstname, lastname;
	
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner") // 일대다관계
	// cascade: 삭제 또는 업데이트 시 연속 효과가 적용되는 방법 지정
	// - .ALL: 모든 작업이 연속 적용됨
	//        e.g., 소유자 삭제 시 그 소유자와 연결된 모든 자동차도 함께 삭제됨
	// mappedBy = "owner": Car클래스에 있는 owner필드가 이 관계의 기본키임을 지정
//	private List<Car> cars;
	
	
}





