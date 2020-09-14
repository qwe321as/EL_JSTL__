<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
Ex04_memberForm.jsp<br>

<form action="Ex04_memberResult.jsp" method="post">

	<table border="1">
		
		<tr>
			<td>이름</td>
			<td> <input type="text" name="name" value="길동"></td>
		</tr>
		
	
		<tr>
			<td>나이</td>
			<td> <input type="text" name="age" value="30"></td>
		</tr>
		
		<tr>
			<td>몸무게</td>
			<td> <input type="text" name="weight" value="70"></td>
		</tr>
		
		<tr>
			<td>키</td>
			<td> <input type="text" name="height" value="175"></td>
		</tr>
		
		<tr>
			<td>성별</td>
			<td> 남 <input type="radio" name="gender" value="남">
				여 <input type="radio" name="gender" value="여">			
			</td>
		</tr>
		
		<tr>
			<td colspan="2">
				<input type="submit" value="전송하기">
			</td>
		</tr>
	</table>
	
</form>    

<%
	pageContext.setAttribute("pname","페이지네임"); // pname=페이지네임
	request.setAttribute("rname","리퀘스트네임"); // rname=리퀘스트네임
	session.setAttribute("sname","세션네임"); // sname=세션네임
	application.setAttribute("aname","어플리케이션네임"); // aname=어플리케이션네임
	
%>
















<%
pageContext.setAttribute("name", "페이지네임"); 
request.setAttribute("name", "리퀘스트네임1"); 
request.setAttribute("reqname", "리퀘스트네임2"); 
session.setAttribute("name", "세션네임");   
application.setAttribute("name", "어플리케이션네임");
 %>