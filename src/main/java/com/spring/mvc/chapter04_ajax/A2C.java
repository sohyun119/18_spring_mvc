package com.spring.mvc.chapter04_ajax;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.mvc.dto.ProductDTO;

/*
  
    # AJAX데이터 전송
    
    - pom.xml파일에 의존성 추가
    
	<!-- jackson-core -->
	<dependency>
	    <groupId>com.fasterxml.jackson.core</groupId>
	    <artifactId>jackson-databind</artifactId>
	    <version>2.9.2</version>
	</dependency>
	
*/
@Controller
public class A2C {
	
	@GetMapping("/a2c")
	public String ajaxToController() {
		return "chapter04_AJAX/a2c";
	}
	
	
	// 1. 단일 데이터 전송
	@GetMapping("/a2cEx01") // RequestParam 어노테이션으로 데이터를 전송받는다. 
	public void a2cEx01(@RequestParam("productCd") String productCd) {
		System.out.println(productCd);
	}
	
	
	// 2. DTO 전송
	@GetMapping("/a2cEx02") // ModelAttribute 어노테이션으로 데이터를 전송받는다. 
	public void a2cEx02(@ModelAttribute ProductDTO productDTO)  {
		System.out.println(productDTO);
	}

	
	// 3. List<DTO> 전송
	@GetMapping("/a2cEx03")
	public void a2cEx03(@RequestParam("productList") String productList) throws JsonParseException, JsonMappingException, IOException {
		
		//1) ObjectMapper 객체를 생성한다.
		ObjectMapper mapper = new ObjectMapper();
		// jackson object bind (pom.xml)에서 설정했기에 사용가능 
		
		//2) readValue(데이타 , new TypeReference<타입>(){}) 메서드를 사용하여 JSON 객체를 자바의 객체로 매핑한다.
		List<ProductDTO> printDataList = mapper.readValue(productList, new TypeReference<List<ProductDTO>>(){});
		for(ProductDTO dto : printDataList) {
			System.out.println(dto);
		}
		System.out.println();
		
	}
	
	
	// 4. map 전송 // RequestParam Map<String,Object> 형태로 데이터를 전송받는다. 
	@GetMapping("/a2cEx04")
	public void a2cEx04(@RequestParam Map<String, Object> map) {
		System.out.println(map);
	}
	

	// 5. List<Map> 전송
	@GetMapping("/a2cEx05")
	public void a2cEx05(@RequestParam("mapList") String mapList) throws JsonParseException, JsonMappingException, IOException {
	
		
		//1) ObjectMapper 객체를 생성한다.
		ObjectMapper mapper = new ObjectMapper();
		  
		//2) readValue(데이타 , new TypeReference<타입>(){}) 메서드를 사용하여 JSON 객체를 자바의 객체로 매핑한다.
		List<Map<String,Object>> printMapList = mapper.readValue(mapList, new TypeReference<List<Map<String,Object>>>() {});
		for(Map<String,Object> map : printMapList) {
			System.out.println(map);
		}
		System.out.println();
		
	}

}
