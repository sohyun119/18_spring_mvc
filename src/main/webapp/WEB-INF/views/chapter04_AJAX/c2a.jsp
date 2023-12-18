<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>controllerToAjax</title>
<script src="resources/jquery/jquery-3.6.1.min.js"></script>
<script>

	$().ready(function(){
		
		
		// (경우의 수 1) 단일데이터 return
		$("#btn1").click(function(){
			
			$.ajax({
				
				url : "c2aEx01",
				type : "get",
				success : function(data) {
					/*
						
						[형식]
					
						파라메타
						
					*/
					console.log("--- single data ---");
					console.log(data);
					console.log("");
				}
			});
			
		});
		
		
		// (경우의 수 2) DTO return
		$("#btn2").click(function(){
			
			$.ajax({
				
				url : "c2aEx02",
				type : "get",
				success : function(data) {
					/*
					
						[형식]

						파라메타.속성명
						
					*/
					console.log("--- DTO ---");
					console.log(data);
					console.log("");
				}
				
			});
			
		});
		
		
		// (경우의 수 3) List<DTO> return
		$("#btn3").click(function(){
					
			$.ajax({
				
				url : "c2aEx04",
				type : "get",
				success : function() {
					
					/*
					
						[형식]	
					
						$(파라메타).each(function{
							this.속성명
						});
						
					*/
					
					console.log("--- DTO List ---");
					
					
				}
				
			});
					
		});
		
		
		
		// (경우의 수 4) Map return
		$("#btn4").click(function(){
			
			$.ajax({
				
				url : "c2aEx04",
				type : "get",
				success : function() {
					
					/*
					
						[형식]
	
						파라메타.키
						
					*/
					console.log("--- map ---");
				}
				
			});
			
		});
		
		
	
		
		// (경우의 수 5) List<Map> return
		$("#btn5").click(function(){
			
			$.ajax({
				
				url : "c2aEx05",
				type : "get",
				success : function(data) {
					
					/*
					
						[형식]
					
						$(파라메타).each(function{
							this.키
						});
					
					*/
					console.log("--- map List ---");
					
				}
				
			});
			
		});
		
	});
</script>
</head>
<body>
	<fieldset>
		<legend>ControllerToAjax</legend>
	    <input type="button" id="btn1" value="1) 단일데이터" >
	    <input type="button" id="btn2" value="2) DTO" >
	    <input type="button" id="btn3" value="3) List(DTO)" >
	    <input type="button" id="btn4" value="4) map" >
	    <input type="button" id="btn5" value="5) List(map)" >
	</fieldset>
</body>
</html>