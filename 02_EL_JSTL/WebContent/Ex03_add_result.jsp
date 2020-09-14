<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
Ex03_add_result.jsp<br>

${param.num1} + ${param.num2} = ${param.num1 + param.num2} <br>
<%-- ${param.num1} + ${param.num2} = ${param.num1} + ${param.num2}<br> --%>

<%
	int n1 = Integer.parseInt(request.getParameter("num1"));
	int n2 = Integer.parseInt(request.getParameter("num2"));
%>

<%=n1%> + <%=n2%> = <%=n1 + n2%> <br>