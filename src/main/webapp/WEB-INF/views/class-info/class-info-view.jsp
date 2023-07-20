<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
if (request.getAttribute("classInfo") == null){
%>
	<script>
		alert("게시물을 찾을 수 없습니다.");
		location.href='/class-info/list';
	</script>
<%
}
Map<String,String> classInfo = (Map<String,String>)request.getAttribute("classInfo");
%>
<table border="1">
	<tr>
		<th>번호</th>
		<td><%=classInfo.get("CI_NUM")%></td>
	</tr>
	<tr>
		<th>이름</th>
		<td><%=classInfo.get("CI_NAME")%></td>
	</tr>
	<tr>
		<th>나이</th>
		<td><%=classInfo.get("CI_AGE")%></td>
	</tr>
</table>
</body>
</html>