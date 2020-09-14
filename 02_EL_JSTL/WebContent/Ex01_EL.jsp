<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>  
<html>
<head>   
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	Hello<br>           
	<%="Hello" %> <br>
	<%out.println("Hello"); %> <br>
	${"Hello"} <br>
	\${5+7 } = ${5+7 }<br> 
	${"5+7" }<br> 
	${10 == 20}<br>
	${10 eq 20 } <br> 
</body>  
</html>   
  