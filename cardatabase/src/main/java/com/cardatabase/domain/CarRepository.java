package com.cardatabase.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
//													<dto, 데이터타입>
	// 브랜드로 자동차 검색
	List<Car> findByBrand(String brand);
}
