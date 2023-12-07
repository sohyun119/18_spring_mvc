package com.spring.mvc.chapter02_mapper;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BasicMapper {

	
	@Autowired
	private SqlSession sqlSession;
	
	// selectList("namepsace.id") 예시
	public void ex01() {
	}
	
	// selectOne("namepsace.id") 예시
	public void ex02() {
	}
	
	// insert("namepsace.id") 예시
	public void ex03() {
	}
	
	// update("namepsace.id") 예시
	public void ex04() {
	}
	
	// delete("namepsace.id") 예시
	public void ex05() {
	}
	
	
	
}
