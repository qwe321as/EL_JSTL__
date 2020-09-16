<%@page import="svy.Surveybean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	request.setCharacterEncoding("utf-8");
	ArrayList<Surveybean> list = (ArrayList<Surveybean>) request.getAttribute("list");
	String no = request.getParameter("no");
%>
Ex02_surveyupdateForm.jsp
<br>
<form action="update.sv" method="post">
	수정하기<br> <b>개인 정보 :</b><br>
	<c:forEach var="bean" items="${list }">
   이름 　　　　<input type="text" name="name" value="${bean.name }">
		<input type="hidden" name="no" value="<%=no %>">
		<br>
   소속 회사　　<input type="text" name="company" value="${bean.company }">
		<br>
   이메일 주소　<input type="text" name="email" value="${bean.email }">
		<br>
		<p>
			<b>본 교육 과정을 수강하고 과정에 만족도를 선택해 주세요.</b><br> <input type="radio"
				name="satisfaction" value="매우만족"
				<c:if test="${bean.satisfaction=='매우만족' }">
checked="checked"
    </c:if>>매우
			만족 <input type="radio" name="satisfaction" value="만족"
				<c:if test="${bean.satisfaction=='만족' }">
checked="checked"
    </c:if>>만족
			<input type="radio" name="satisfaction" value="보통"
				<c:if test="${bean.satisfaction=='보통' }">
checked="checked"
    </c:if>>보통
			<input type="radio" name="satisfaction" value="불만족"
				<c:if test="${bean.satisfaction=='불만족' }">
checked="checked"
    </c:if>>불만족
			<input type="radio" name="satisfaction" value="매우불만족"
				<c:if test="${bean.satisfaction=='매우불만족' }">
checked="checked"
    </c:if>>매우불만족


		
		<p>
			<b>관심있는 분야는 무엇입니까?</b><br> <input type="checkbox" name="part"
				value="JAVA"
				<c:if test="${fn:contains(bean.part,'JAVA') }">
			checked="checked"
			</c:if>>JAVA
			<input type="checkbox" name="part" value="Spring"
				<c:if test="${fn:contains(bean.part,'Spring') }">
			checked="checked"
			</c:if>>Spring
			<input type="checkbox" name="part" value="UML"
				<c:if test="${fn:contains(bean.part,'UML') }">
			checked="checked"
			</c:if>>UML<br>
			<input type="checkbox" name="part" value="JDBC"
				<c:if test="${fn:contains(bean.part,'JDBC') }">
			checked="checked"
			</c:if>>JDBC
			<input type="checkbox" name="part" value="서블릿"
				<c:if test="${fn:contains(bean.part,'서블릿') }">
			checked="checked"
			</c:if>>서블릿
			<input type="checkbox" name="part" value="JSP" <c:if test="${fn:contains(bean.part,'JSP') }">
			checked="checked"
			</c:if>>JSP<br>
		<p>
			정보 발송 방법 <select name="howto">
				<option value="email"
					<c:if test="${bean.howto=='email' }">
 selected="selected"
    </c:if>>email
				
				<option value="우편"
					<c:if test="${bean.howto=='우편' }">
 selected="selected"
    </c:if>>우편
				
			</select>
		<p>
			<input type="checkbox" name="agree"
				<c:if test="${bean.agree==1 }">
checked="checked"
    </c:if>
				value="1"> 정보 발송에 동의합니다.<br>
	</c:forEach>
	<input type="submit" value="수정하기">
</form>