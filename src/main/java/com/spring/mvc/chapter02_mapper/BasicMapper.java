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
		sqlSession.selectList("basic.ex01");
	}
	
	// selectOne("namepsace.id") 예시
	public void ex02() {
		sqlSession.selectOne("basic.ex02");
	}
	
	// insert("namepsace.id") 예시
	public void ex03() {
		sqlSession.insert("basic.ex03", "전달데이터");
	}
	
	// update("namepsace.id") 예시
	public void ex04() {
		sqlSession.update("basic.ex04", "전달데이터");
	}
	
	// delete("namepsace.id") 예시
	public void ex05() {
		sqlSession.delete("basic.ex05", "전달데이터");
	}
	
	
	
}
