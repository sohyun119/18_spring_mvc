package com.spring.mvc.chapter01_form;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class C2V_Ex02 {
	
	/*
	 * 
	 *	# 예시 1) @ResponseBody  
	 *	
	 *	- ResponseEntity와 기능이 같으며 헤더와 상태 코드를 제외한 HTML 본문만 전송한다.
	 * 	- 한글 데이터가 전송이 되지 않아서 한글 데이터 전송시 ReponseEntity에 헤더를 추가하여 사용한다.
     *
	 */
	@GetMapping("/responseBodyEx")
	@ResponseBody
	public String responseBodyEx() {
		
		//String jsScript = "<h1>테스트 테이터</h1>"; // 한글 데이터는 전송이 안된다. 
		
		String jsScript = "<script>";
			   jsScript += "alert('success');";
			   jsScript += "location.href='requestEx';";
			   jsScript += "</script>";
		
		return jsScript;
	}
	
	
	/*
	 * 
	 *	 # 2) ResponseEntity  // Body + a (header)
	 *	 
	 *	 - HTTP에서 Request와 Response 동작시 전송되는 정보는 크게 body(몸체) , headers(헤더), status code(상태 코드)가 있다.
	 *	 - @ResponseBody에 없는 헤더와 상태코드를 함께 반환한다.
	 *		
	 *	 - body (옵션)
	 *		- HTTP의 request 또는 response가 전송하는 데이터(본문)
	 *		
	 *	 - headers (옵션)
	 *		- HTTP의 request 또는 response에 대한 부가적인 정보
	 *		
	 *		(한글 헤더 참고)
	 *		HttpHeaders responseHeaders = new HttpHeaders();
	 *		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
	 *
	 *	 - status code (필수)
	 *		- 클라이언트의 요청이 성공적으로 처리되었는지 상태를 알려주는 것
	 * 
	 */
	@GetMapping("/responseEntityEx")
	public ResponseEntity<Object> responseEntiryEx() {
		
		// 1) 기본
		//return new ResponseEntity<Object>(HttpStatus.OK);
	
		// 2) 한글 데이터 전송 불가
		String jsScript = "<script>";
		   jsScript += "alert('한글 데이터');";
		   jsScript += "location.href='requestEx';";
		   jsScript += "</script>";
		
		//return new ResponseEntity<Object>(jsScript, HttpStatus.OK);
		
		// 3) header를 붙여서 한글 데이터 전송이 가능하게 한다!! 
		HttpHeaders header = new HttpHeaders();
					
		header.add("Content-Type", "text/html; charset=UTF-8");
		
		return new ResponseEntity<Object>(jsScript, header, HttpStatus.OK);
	
	}
	
	
	
	
	
}

/*
*
*	# 3) @RestController 이용 
*
*  - @ResponseController 어노테이션이 추가된 컨트롤러는 기본 반환 타입(String)이 뷰 경로로 구현되지 않고 @ResponseBody로 구현된다.	
*	- ResponseBody와 기능이 같으며 헤더와 상태 코드를 제외한 HTML 본문만 전송한다.
*	- 메서드가 아닌 '클래스'에 @RestController어노테이션을 작성하여 구현한다.  
*
*/

@RestController  // ResponseBody + Controller // 데이터만 보내는 컨트롤러 jsp:X
class RestControllerEx{
	
	
	@GetMapping("/restControllerEx")
	public String restControllerEx() {
		
		//String jsScript = "<h1>테스트 테이터</h1>"; // 한글 데이터는 전송이 안된다. 
		
		String jsScript = "<script>";
			   jsScript += "alert('success!!');";
			   jsScript += "location.href='requestEx';";
			   jsScript += "</script>";
		
		return jsScript;
	}
	
	
	
}




