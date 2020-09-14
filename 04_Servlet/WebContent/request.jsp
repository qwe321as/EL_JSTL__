<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	function movePage(){
		//alert("1");
		location.href = "Request.do";
	}
</script>    
request.jsp <br>

<a href="Request.do">링크</a>
<!-- http://localhost:8080/04_Servlet/Request.do -->

<br>

<input type="button" value="버튼" onClick="movePage()"/>
<br><br>

<form action="Request.do" method="get">
	<input type="submit" value="get전송">
</form>
<br>

<form action="Request.do" method="post">
	<input type="submit" value="post전송">
</form>
<br>









