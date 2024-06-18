package com.cardatabase.domain;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j // log객체 사용 가능
// System.out.println() - 리소스를 많이 사용하여 실제 코드에 로그 출력하려면 라이브러리 사용
// 로깅 수준에는 7가지가 있음 (trace, debug, info, warn, error, fatal, off)
class OwnerRepositoryTest {
	@Autowired
	OwnerRepository oRepository;
	
	@Autowired
	CarRepository cRepository;

	@Test
	void putOwner() {
		// 소유자 객체 추가 후 데이터베이스에 저장
		Owner owner1 = new Owner();
		owner1.setFirstname("John");
		owner1.setLastname("Johnson");
		Owner owner2 = new Owner();
		owner2.setFirstname("Mary");
		owner2.setLastname("Robinson");
		// saveAll메소드 : 여러 엔티티를 저장
		oRepository.saveAll(Arrays.asList(owner1, owner2));
		// 자동차 객체를 추가하고 소유자와 연결한 후 데이터베이스에 저장
		Car car1 = new Car(
				"Ford", "Mustang", "Red", "ADF-1121", 2021, 59000, owner1);
		Car car2 = new Car(
				"Nissan", "Leaf", "White", "SSJ-3002", 2019, 29000, owner2);
		Car car3 = new Car(
				"Toyota", "Prius", "Silver", "KKO-0212", 2020, 39000, owner2);
		cRepository.saveAll(Arrays.asList(car1, car2, car3));
		
		for(Car car : cRepository.findAll()) {
			log.info(car.toString());
		}
	}

}
