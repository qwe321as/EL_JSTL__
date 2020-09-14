<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
init.jsp <br>

<%
	String msg = "Hello";
	System.out.println("msg : " + msg);
	
	
%>
	<!-- company,singer,manager -->
	
<!-- ServletContext application = new ServletContext(); -->

회사1 : <%= application.getInitParameter("company")%> <br>

회사2 : ${initParam.company } <br> 

가수 : <%= application.getInitParameter("singer")%> <br>
매니저 : ${ initParam.manager } <br>




