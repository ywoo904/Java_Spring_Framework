<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JQuery연습	</title>
</head>
<body>

<input tpye="text" id="apple" value="홍길자"> 
<input tpye="text" id="melon" value="홍길숙"> 
<input tpye="text" id="grape" value="홍길동"> 

<button onclick = "check()">확인</button>

<script type="text/javascript" src ="//code.jquery.com/jquery-3.4.0.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		alert("화면 접속시 바로 실행")
		
	});

	function check() {
		
		$.ajax({ 
			type : "post", 
			url: "checkId", 
			data: { 
				"id": "kim"
			}, 
			success : function(result){ 
				alert("비동기 성공!"); 
				
				
			} 
			
			
		})
		
		
		$("#apple").attr("type","password");
		$("#grape").attr("type","password");
		$("#melon").focus(); 
		var a = $("#melon").val(); 
		
		alert(a); 
		
	
	} 

</script>


</body>
</html>