<%@page import="svy.Surveybean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<% 
request.setCharacterEncoding("utf-8");
ArrayList<Surveybean> list = (ArrayList<Surveybean>)request.getAttribute("list"); %>
Ex02_surveylist.jsp
<br>
<br>
<table border="1">
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>소속 회사</th>
		<th>이메일</th>
		<th>만족도</th>
		<th>관심있는 분야</th>
		<th>정보 발송 방법</th>
		<th>정보 발송에 동의</th>
		<th>삭제</th>
		<th>수정</th>
	</tr>
	<c:forEach var="bean" items="${list }">
		<tr>
			<td>${bean.no }</td>
			<td>${bean.name }</td>
			<td>${bean["company"] }</td>
			<td>${bean.email }</td>
			<td>${bean.satisfaction }</td>
			<td>${bean.part }</td>
			<td>${bean.howto }</td>
			<td>
			<c:if test="${bean.agree==1 }">
    동의함
    </c:if>
			<c:if test="${bean.agree==0 }">
    동의안함
    </c:if>

			</td>
			<td align="center"><a href="delete.sv?no=${bean.no }">삭제</a></td>
			<td align="center"><a href="updateForm.sv?no=${bean.no }">수정</a>
			</td>
		</tr>
	</c:forEach>
</table>
<a href="Ex02_surveyInputForm.jsp">삽입</a>
