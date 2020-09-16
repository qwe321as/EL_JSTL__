<%@page import="myPkg.MemberBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    

    
Ex01_mymemList.jsp <br>

<%
   ArrayList<MemberBean> lists = (ArrayList<MemberBean>)request.getAttribute("lists");
%> 

<table border="1">
   <tr>
      <td>아이디</td>
      <td>이름</td>
      <td>비번</td>
   </tr>
   
   <c:forEach var="bean" items="${lists}">
      <tr>
         <td>${bean.id }</td>
         <td>${bean.getName()}</td>
         <td>${bean["password"]}</td>
      </tr>
   </c:forEach>
   
</table>

<hr>

<table border="1">
   <tr>
      <td>아이디</td>
      <td>이름</td>
      <td>비번</td>
   </tr>
   
    <c:forEach var="i" 	begin="0" end="${fn:length(lists)-1 }" ste	p="1">
      <tr>
         <td>${lists[i].id }</td>
         <td>${lists[i].getName() }</td>
         <td>${lists[i].["password"]}</td>
      </tr>
   </c:forEach>
    
</table>







