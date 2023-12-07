package com.spring.mvc.chapter01_form;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class V2C_Ex02 {
	
	
	/* 
	 *	3) @RequestParam
	 *
	 *	- @RequestParam어노테이션을 사용하여 파라메타의 개별적인 값에 접근 할 수 있다. 
	 *	 
	 * [ @RequestParam 어노테이션의 속성 ]	
	 *		name 		 : 파라메타의 이름을 지정한다. ( 다른 옵션을 사용하지 않을 경우 name 키워드생략가능)
	 *		required	 : 필수 여부를 지정한다. 기본값은 true이며 요청값이 없으면 익셉션이 발생한다.
	 *		defaultValue : 요청 파라메타의 값이 없을때 사용할 값을 지정한다.
	 *	
	 *	- @RequestParam을 생략하여 parameter에 직접 요청파라메타의 name값만 입력하여 데이터를 전달받을 수 있다.
	 *
	 */
	@GetMapping("requestParam")
	//public String requestParam(int productCd, int orderQty) {
	
/*	public String requestParam(@RequestParam(name = "productCd", defaultValue="0x000") int productCd
							  ,@RequestParam(name = "orderQty", defaultValue="777") int orderQty){*/
	
	public String requestParam(@RequestParam("productCd") int productCd
			   ,@RequestParam("orderQty") int orderQty) { 
		
		System.out.println("\n @RequestParam \n");
		System.out.println("productCd : " + productCd);
		System.out.println("orderQty : " + orderQty);
		System.out.println();
		
		return "redirect:input";
	}
	
	
	
	/* 
	 * 	4) HttpServletRequest
	 * 
	 *  - HttpServletRequest를 직접 이용하여 getParameter메서드를 이용하여 파라메타의 값에 접근 할 수 있다.
	 *  - JSP HttpServletRequest과 사용방법이 같다.
	 * 
	 */
	@GetMapping("/httpServletRequest")
	public String httpServletRequest(HttpServletRequest request) {
		
		System.out.println("\n httpSevletRequest \n");
		System.out.println("productCd : " + request.getParameter("productCd"));
		System.out.println("orderQty : " + Long.parseLong(request.getParameter("orderQty")));
		
		return "redirect:input";
	}
	
	
	
	/*
	 *  5) @PathVariable
	 *   
	 *  - Spring을 사용하다보면 클라이언트에서 URL에 파라메타를 같이 전달하는 경우가 생긴다.
	 *	- 아래와 같이 두 가지 형식으로 url이동과 함께 파라메타값들을 전달할 수 있다.
	 *
	 *		1) http://localhost:8080/mvc/viewToController/transfer5?isProduct='yes'&isSession='no'
	 *		2) http://localhost:8080/mvc/viewToController/transfer5/yes/no
	 *	
	 *	- 1) 방법은 @RequestParam을 통해서 데이터에 접근하고 , 2) 방법은 @PathVariable을 통해서 데이터에 접근한다.
	 *  - 2) 방법은 {}로 패턴을 매칭하여 데이터에 접근 한다. 
	 * */
	@GetMapping("/pathVariable/{productCd}/{orderQty}") // ?를 사용하지 않고 변수값을 받는 방법
	public String pathVariable(@PathVariable String productCd,
							   @PathVariable long orderQty) {
		
		System.out.println("\n @PathVariable \n");
		System.out.println("productCd : " + productCd);
		System.out.println("orderQty : " + orderQty);
		System.out.println();
		
		return "home";
	}
	
	
	

}
