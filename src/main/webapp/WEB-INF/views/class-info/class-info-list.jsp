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
<table border="1">
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>나이</th>
	</tr>
<%
List<Map<String,String>> classInfoList = (List<Map<String,String>>)request.getAttribute("classInfoList");
for(Map<String,String> classInfo : classInfoList){
%>
	<tr>
		<td><%=classInfo.get("CI_NUM")%></td>
		<td><a href='/class-info/view?ciNum=<%=classInfo.get("CI_NUM")%>'><%=classInfo.get("CI_NAME")%></td>
		<td><%=classInfo.get("CI_AGE")%></td>
	</tr>
<%
}
%>
</table>
</body>
</html>