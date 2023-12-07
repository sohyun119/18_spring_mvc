package com.spring.mvc.chapter02_mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc.dto.BrandDTO;
import com.spring.mvc.dto.ProductDTO;

@Repository
public class M2D {
	
	/*
	 * 
	 *   Mapper To DAO
	 * 
	 *  - select 쿼리 조회 결과 데이터가 반드시 1row인 경우 .selectOne("namespace.id") 메서드를 사용한다. (primary key 조건 , sum() , avg() , count())
	 *  - select 쿼리 조회 결과 데이터가 1row 이상일 경우   .selectList("namespace.id") 메서드를 사용하며 반환데이터는 List<반환타입>으로 데이터를 매핑한다.
	 *      
	 *  - insert 쿼리를 사용할 경우 .insert("namespace.id") 메서드를 사용한다.
	 *  - update 쿼리를 사용할 경우 .update("namespace.id") 메서드를 사용한다.
	 *  - delete 쿼리를 사용할 경우 .delete("namespace.id") 메서드를 사용한다.
	 *  
	 *  - select 쿼리는 resultType , resultMap 속성(필수)과 반드시 같이 사용하며
	 *    select , insert , update , delete 쿼리에서 파라메타 전달은 parameterType속성(옵션)과 같이 사용한다.
	 *    
	 *  - DAO로직에서 하나의 메서드는 하나의 쿼리문과 1 : 1 관계로 매핑하며 Service와 DAO 관계에서 1 : N관계로 매핑한다.
	 *  
	 * */
	
	
	@Autowired  // @Inject
	private SqlSession sqlSession;
	
	// DTO List 반환 예시1
	public void ex01() {
		
		System.out.println("\n - ex01 - \n");
		List<ProductDTO> productList = sqlSession.selectList("m2d.ex01");
		for(ProductDTO productDTO : productList) {
			System.out.println(productDTO);
		}
		
	}
	
	
	// DTO List 반환 예시2
	public void ex02() {
		
		System.out.println("\n - ex02 - \n");
		List<BrandDTO> brandList = sqlSession.selectList("m2d.ex02");
		for(BrandDTO brandDTO : brandList) {
			System.out.println(brandDTO);
		}
		
	}
	
	
	
	// DTO 반환 예시1
	public void ex03() {
		
		System.out.println("\n - ex03 - \n");
		ProductDTO productDTO = sqlSession.selectOne("m2d.ex03");
		System.out.println(productDTO);
		
	}
	
	
	// DTO 반환 예시2
	public void ex04() {
		
		System.out.println("\n - ex04 - \n");
		BrandDTO brandDTO = sqlSession.selectOne("m2d.ex04");
		System.out.println(brandDTO);
		
	}
	
	
	// 단일 데이터 반환 예시1
	public void ex05() {
		
		System.out.println("\n - ex05 - \n");
		int productCnt = sqlSession.selectOne("m2d.ex05");
		System.out.println("productCnt = " + productCnt);
		
	}
	
	
	
	// 단일 데이터 반환 예시2
	public void ex06() {
		
		System.out.println("\n - ex06 - \n");
		double avgPrice = sqlSession.selectOne("m2d.ex06");
		System.out.println("avgPrice = " + avgPrice);
		
	}
	
	
	// 단일 데이터 반환 예시3
	public void ex07() {
		
		System.out.println("\n - ex07 - \n");
		String productNm = sqlSession.selectOne("m2d.ex07");
		System.out.println(productNm);
		
	}
	
	
	// <![CDATA[]]> 사용예시
	public void ex08() {
		
		System.out.println("\n - ex08 - \n");
		List<ProductDTO> productList = sqlSession.selectList("m2d.ex08");
		for(ProductDTO productDTO : productList) {
			System.out.println(productDTO);
		}
		
	}
	
	
	// 테이블 컬럼과 자바 프로퍼티 바인딩 예시1
	public void ex09() {
		
		System.out.println("\n - ex09 - \n");
		List<Map<String, Object>> productMapList = sqlSession.selectList("m2d.ex09");
		for(Map<String, Object> map : productMapList) {
			System.out.println(map);
		}
		
	}

	
	// 테이블 컬럼과 자바 프로퍼티 바인딩 예시2
	public void ex10() {
		
		System.out.println("\n - ex10 - \n");
		List<Map<String, Object>> productMapList = sqlSession.selectList("m2d.ex10"); 
		for(Map<String, Object> map : productMapList) {
			System.out.println(map);
		}
		
	}
	
	
	// 테이블 컬럼과 자바 프로퍼티 바인딩 예시3
	public void ex11() {
		
		System.out.println("\n - ex11 - \n");
		List<Map<String, Object>> productMapList = sqlSession.selectList("m2d.ex11"); 
		for(Map<String, Object> map : productMapList) {
			System.out.println(map);
		}
		
	}
	
	

}
