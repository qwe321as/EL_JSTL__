<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
  
Ex07_if_result.jsp <br>

<%request.setCharacterEncoding("UTF-8"); %>
선택한 음식 : ${param.food } <br>

<!-- if 피자
피자 빨간색으로 출력

if 짜장면
짜장면 orange색으로 출력

if 떡볶이
떡볶이 green색으로 출력

if 치킨
치킨 blue색으로 출력
 -->
 
<c:if test="${param.food == '피자' }" >
	<span style="color:red">피자</span>
</c:if>

<c:if test="${param.food eq '짜장면' }" >
	<span style="color:orange">짜장면</span>
</c:if>

<c:if test="${param.food eq '떡볶이' }" >
	<span style="color:green">떡볶이</span>
</c:if>


<c:if test="${ not (param.food eq '피자' || param.food eq '짜장면' || param.food eq '떡볶이') }" >
	<span style="color:blue">${param.food }</span>
</c:if>

<hr>
<!-- 
switch
case 1:
case 2 : 
default : 
 -->
<c:choose>
	
	<c:when test="${param.food == '피자' }">
		<span style="color:red">피자</span>
	</c:when>
	
	<c:when test="${param.food eq '짜장면' }">
		<span style="color:orange">짜장면</span>
	</c:when>
	
	<c:when test="${param.food eq '떡볶이' }">
		<span style="color:green">떡볶이</span>
	</c:when>
	
	<c:otherwise>
		<span style="color:blue">${param.food }</span>
	</c:otherwise>
	
</c:choose>






















