<%@page import="java.util.ArrayList"%>
<%@page import="myPkg.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<% 
request.setCharacterEncoding("utf-8");
ArrayList<MemberBean> list =  (ArrayList<MemberBean>)request.getAttribute("list");%>
<table border="1">
<tr>
<th>번호</th>
<th>아이디</th>
<th>비번</th>
<th>이름</th>
<th>가입일</th>
<th>수정</th>
<th>삭제</th>
</tr>
<c:forEach var="bean" items="${list }">
<tr>
<th>${bean.num }</th>
<th>${bean['id'] }</th>
<th>${bean['passwd'] }</th>
<th>${bean['name'] }</th>
<th>${bean['register'] }</th>
<th>수정</th>
<th>삭제</th>
</tr>
</c:forEach>


</table>
<a href="insertForm.jsp">삽입</a>