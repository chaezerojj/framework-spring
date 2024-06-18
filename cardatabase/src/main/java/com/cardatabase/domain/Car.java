package com.cardatabase.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String brand, model, color, registerNumber;
	private int year, price;
	
	// 일대다 관계 추가하려면 @ManyToOne 및 @OneToMay 어노테이션 이용
	// Car 엔티티 클래스에서는 @ManyToOne 어노테이션으로 관계 정의
	@ManyToOne(fetch=FetchType.EAGER) // 다대일 관계
	// - FetchType: 데이터베이스에서 데이터를 검색하는 전략을 정의
	// - FetchType.LAZY: 지연 검색을 의미 
	//       (== 데이터베이스에서 소유자 검색 시 필요할 때 해당 소유자와 연관된 모든 자동차 검색)
	// - FetchType.EAGER: 지정 가능한 값은 즉시 검색 
	@JoinColumn(name = "owner")
	private Owner owner;
	
	public Car(String brand, String model, String color, 
			String registerNumber, int year, int price, Owner owner) {
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.registerNumber = registerNumber;
		this.year = year;
		this.price = price;
		this.owner = owner;
	}
	
}
