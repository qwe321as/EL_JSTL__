<%@page import="myPkg.MymemBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- pageContext
request
session
application    ->이순서로 사용해 나간다.
 -->
Ex01_mymemUPdate.jsp
<br>
<% MymemBean mb =(MymemBean)request.getAttribute("mb"); %>
<h3>회원 수정</h3>
<!-- select.mem update.mem delete.mem -->
<form action="update.mem" method="post" name="myform">
<input type="hidden" name="id" value="${mb.id }">
	<table border="1">
		<%-- <tr>
			<td>번호</td>
			<td><input type="text" name="id" value="${mb.id }"></td>
		</tr> --%>

		<tr>
			<td>이름</td>
			<td><input type="text" name="name" value="${mb.getName()}"></td>
		</tr>

		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="password" value="${mb['password']}"></td>
		</tr>

		<tr>
			<td colspan="2">
				<input type="submit" value="수정하기">
			</td>
		</tr>

	</table>

</form>
