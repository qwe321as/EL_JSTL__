<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

Ex04_memberResult.jsp<br>
<%request.setCharacterEncoding("UTF-8"); %>
<%-- 
<%
String name = request.getParameter("name");
String age = request.getParameter("age");
myPkg.MemberBean bean = new myPkg.MemberBean();
bean.setName(name);
bean.setAge(age);
%>
 --%>
<jsp:useBean id="bean" class="myPkg.MemberBean"/>
<jsp:setProperty property="*" name="bean"/>
<!-- request.getParameter("name") -->
이름1 : <jsp:getProperty property="name" name="bean"/> <br>
이름2 : ${param.name } <br>
이름3 : ${bean.name } <br>
이름4 : <%=bean.getName() %> 


<br><br>
나이1 : <jsp:getProperty property="age" name="bean"/> <br>
나이2 : ${bean.age } <br>

몸무게 : <jsp:getProperty property="weight" name="bean"/> <br>
몸무게2 : <%=bean.getWeight() %> <br>

키 : <jsp:getProperty property="height" name="bean"/> <br>
성별 : <jsp:getProperty property="gender" name="bean"/> <br>

<hr>


pname : <%= pageContext.getAttribute("pname") %> <br>
rname : <%= request.getAttribute("rname") %> <br>
sname : <%= session.getAttribute("sname") %> <br>
aname : <%= application.getAttribute("aname") %> <br>

myname : ${ initParam.myname } <br>
friendName : ${initParam.friendName } <br>
aname : ${applicationScope.aname } <br>
myname : ${applicationScope.myname } <br> <!-- 공백 -->
aname : ${ initParam.aname } <br> <!-- 공백 -->

초기화 파라미터 <br>
<%
Enumeration<String> initEnum = application.getInitParameterNames();
while(initEnum.hasMoreElements()){
	String initName = initEnum.nextElement();
%>
		<%= initName %> : <%=application.getInitParameter(initName) %> <br>
<%	
} // while
%>







