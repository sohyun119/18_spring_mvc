<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajaxToController</title>
<script src="resources/jquery/jquery-3.6.1.min.js"></script>
<script>

	$().ready(function(){
		
		// 1. 단일 데이터 전송
		$("#btn1").click(function(){
			
			$.ajax({
				
				url:"a2cEx01",
				type:"get",
				data:{"productCd":"0x1234"}
				
			});
			
		});
		
		
		// 2. DTO 전송
		$("#btn2").click(function(){
			
			var param = {
				"productCd" : 1,
				"productNm" : "기계식키보드",
				"price" : 45000,
				"deliveryPrice" : 2500,
				"enrollDt" : "2023-01-01",
				"brandCd" : "b1"
			};
			
			$.ajax({
				
				url:"a2cEx02",
				type:"get",
				data:param
				
			});
			
		});
		
		
		// 3. List<DTO> 전송
		$("#btn3").click(function(){
			
			/*
			
				1) javascript배열에 데이터를 추가한다.
				2) {"키" : JSON.stringify(JSON 배열) } 형태로 컨트롤러로 전송한다.
				
			*/
			
			var productList = [];
			for (var i = 1; i < 11; i++) {
				var param = {
						"productCd" : i,
						"productNm" : "무소음마우스" + i,
						"price" : 10000 * i,
						"deliveryPrice" : i,
						"enrollDt" : "2023-01-01",
						"brandCd" : "b" + i
				}
				productList.push(param);
			}
			
			$.ajax({
				
				url:"a2cEx03",
				type:"get",
				data:{"productList":JSON.stringify(productList)}
				
			});
			
		});
		
		// 4. map 전송
		$("#btn4").click(function(){
			
			var param = {
				"orderCd" : "order1",
				"orderQty" : 2,
				"cartCd" : "cart3",
				"cartQty" : 4
			};
			
			$.ajax({
				
				url:"a2cEx04",
				type:"get",
				data:param
				
			});
					
		});
	
		
		
		
		// 5. List<Map> 전송
		$("#btn5").click(function(){
			
			/*
			
				1) javascript배열에 데이터를 추가한다.
				2) {"키" : JSON.stringify(JSON 배열) } 형태로 컨트롤러로 전송한다.
				
			*/
			
			
			var mapList = [];
			for (var i = 1; i < 11; i++) {
				var param = {
						"orderCd" : "order" + i,
						"orderQty" : i,
						"cartCd" : "cart" + i,
						"cartQty" : i
					};
				mapList.push(param);
			}
			
			$.ajax({
				
				url:"a2cEx05",
				type:"get",
				data:{"mapList":JSON.stringify(mapList)}
				
			});
			
		});
		
	});
</script>
</head>
<body>
	<fieldset>
		<legend>AjaxToController</legend>
	    <input type="button" id="btn1" value="1) 단일데이터" >
	    <input type="button" id="btn2" value="2) DTO" >
	    <input type="button" id="btn3" value="3) List(DTO)" >
	    <input type="button" id="btn4" value="4) map" >
	    <input type="button" id="btn5" value="5) List(map)" >
	</fieldset>
</body>
</html>