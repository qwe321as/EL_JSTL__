<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    
Ex09_result.jsp<br>

<%
	request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="sb" class="myPkg.StudentBean"/>
<jsp:setProperty property="*" name="sb"/>

이름1 : <%= request.getParameter("name") %><br>
이름2 : ${param.name}<br>
이름3 : <%=sb.getName()%> <br>

<c:if test='${param.name == ""}'>
	입력한 이름 없음1 <br>
</c:if>

<c:if test="${ sb.name == null }">
	입력한 이름 없음2<br>
</c:if>


<c:if test="${ sb.name == '홍길동' }">
	<c:set var="msg" value="홍길동님 로그인 했습니다."/> <br>
</c:if>

<c:if test="${ sb.name != '홍길동' }">
	<c:set var="msg" value="아무개님 로그인 했습니다."/> <br>
</c:if>


before : ${msg } / <c:out value="${msg }" />
<c:remove var="msg"/>
------<br>
after : ${msg } / <c:out value="${msg }" />


<c:if test="${sb.age >= 20 }">
	<c:out value="성인입니다."/> <br>
</c:if>

<c:if test="${sb.age < 20 }">
	미성년입니다 <br>
</c:if>

성별 : ${ sb.gender } <br>

<c:if test="${param.gender eq null }">
	선택한 성별이 없습니다1<br>
</c:if>

<c:if test="${sb.gender eq null }">
	선택한 성별이 없습니다2<br>
</c:if>

<br>


<c:choose>
	<c:when test="${sb.gender eq '남' }">
		<c:out value="남자입니다."/><br>
	</c:when>
	
	<c:when test="${sb.gender == '여' }">
		<c:out value="여자입니다."/><br>
	</c:when>
	<%-- 
	<c:when test="${sb.gender == null }">
		<c:out value="선택안했습니다."/><br>
	</c:when>
	 --%>
	<c:otherwise>
		선택안했습니다.<br>
	</c:otherwise>
	 
</c:choose>


점수 : ${param.jumsu } <br>

<c:choose>
	<c:when test="${param.jumsu >=90 }">
		A학점
	</c:when>
	
	<c:when test="${param.jumsu >=80 }">
		B학점
	</c:when>
	
	<c:when test="${param.jumsu >=70 }">
		C학점
	</c:when>
	
	<c:when test="${param.jumsu >=60 }">
		D학점
	</c:when>
	
	<c:otherwise>
		F학점
	</c:otherwise>
	
</c:choose>

<br>

취미1 : ${param.hobby } <br> 
<!-- request.getParameter("hobby") 
String[] arr = request.getParameterValues("hobby")
-->

취미2 : ${paramValues.hobby } <br>

선택한 취미 갯수 :  ${fn:length(paramValues.hobby) } <br>

취미3 : 
<c:forEach var="hby" items="${paramValues.hobby }" varStatus="status">
	${hby }
	
	<c:if test="${ not status.last }">
		,
	</c:if>
</c:forEach>

<br>

취미4 : 
<c:forEach var="hby" items="${sb.hobby }" varStatus="status">
	${hby }
	
	<c:if test="${ not status.last }">
		,
	</c:if>
</c:forEach>
<br>


취미5 : 
<c:forEach var="i" begin="0" end="${fn:length(paramValues.hobby) -1 }" step="1"  varStatus="status">
	${paramValues.hobby[i]}   
	<c:if test="${ not status.last }">
		,
	</c:if> 
</c:forEach>
<br>


취미6 : 
<c:forEach var="i" begin="0" end="${fn:length(sb.hobby) -1 }" step="1"  varStatus="status">
	${sb.hobby[i]}   
	<c:if test="${ not status.last }">
		,
	</c:if> 
</c:forEach>































