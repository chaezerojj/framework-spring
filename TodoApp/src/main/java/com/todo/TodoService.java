package com.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // 자동으로 롬복에서 생성자 대입되게 해줌
public class TodoService {
	
	@Autowired
	TodoRepo tRepo;
	
	// DB에 있는 전체 데이터 가져오기
	public List<TodoEntity> getTodos() {
		// 할일 가져와서 리턴
		return tRepo.findAll();
	}
	
	// 사용자에게 입력받은 데이터를 DB에 저장
	public void putTodo(TodoEntity tEntity) {
		tRepo.save(tEntity);
	}
	
	// 받은 id값으로 삭제하기
	public void deleteTodo(Integer id) {
		tRepo.deleteById(id);
	}

	// id값을 이용하여 1개의 todo를 가져오기
	public TodoEntity getTodo(Integer id) {
		return tRepo.findById(id).get();
	}
}
