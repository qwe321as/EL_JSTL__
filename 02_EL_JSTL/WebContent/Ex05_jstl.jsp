<%@page import="myPkg.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>      
Ex05_jstl.jsp<br>


<c:out value="Hello World"/><br>

<%
	String msg = "Hi~";
	out.println("msg:" + msg + "<br>");
	pageContext.setAttribute("msg1","Hello"); // 
%>

\${msg} : ${msg} <br> <!-- 공백 -->
\${msg1} : ${msg1} <br>

<c:set var="msg2"  value="JSTL"/> <!-- msg2=JSTL -->
\${msg2} : ${msg2}<br>
\${msg2} : <c:out value="${msg2}"/><br> 

<c:set var="msg3">
EL
</c:set>
\${msg3} : ${msg3}<br>
\${msg3} : <c:out value="${msg3}"/><br> 


<hr> 

객체만들기1 <br>
<% 
	//Person per = new Person("윤아",30,"여");
	
	Person per = new Person(); 
	per.setName("윤아");
	per.setAge(30);
	per.setGender("여");
	
	pageContext.setAttribute("abcd" , per); // 이름,값 abcd=per
%>

name1 : <%= per.getName()%> <br>
name2 : <% out.println(per.getName()) ; %> <br> 
name3 : ${ abcd.name }  <br>
name4 : <c:out value="${ abcd.name }"/> <br>
name5 : <c:out value="<%= per.getName()%>"/> <br>
name6 : ${ per.name }  <br> <!-- 공백 -->


<br>
객체만들기2 <br>

<!-- useBean 액션태그
per2
태연,30,"여" -->

<jsp:useBean id="per2" class="myPkg.Person"/>
<jsp:setProperty property="name" name="per2" value="태연"/>
<jsp:setProperty property="age" name="per2" value="40"/>
<jsp:setProperty property="gender" name="per2" value="여"/>

age1 : <jsp:getProperty property="age" name="per2"/> <br>
age2 : <%= per2.getAge() %><br>
age3 : ${per2.age } <br>


<br>
객체만들기3 <br>

<!-- Person per3 = new Person();  -->
<c:set var="per3" value="<%= new Person() %>"/> 

<!-- per3.setName("써니"); -->
<c:set target="${per3 }" property="name" value="써니"/>
<c:set target="${per3 }" property="age" value="50"/>
<c:set target="${per3 }" property="gender" >
남
</c:set>

gender1: ${per3.gender } <br>
gender2: <%-- <%=per3.getGender() %>--%><br> 
gender3: <%-- <jsp:getProperty property="gender" name="per3" /> --%> <br>
gender4: <c:out value="${per3.gender }"/>


























