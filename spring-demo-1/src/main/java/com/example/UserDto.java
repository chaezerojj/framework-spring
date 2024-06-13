package com.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// * LomBok 라이브러리
// - getter, setter, ToString과 같은 반복적인 자바 코드를 
//   컴파일 & 개발환경에서 자동 생성해주는 라이브러리
// - 

@Getter
@Setter
@ToString
public class UserDto {
	private String name;
	private int age;
	
}
