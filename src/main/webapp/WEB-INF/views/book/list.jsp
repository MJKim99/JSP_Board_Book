<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.beans.*"%>
<%@ page import="java.util.*"%>
<%
List<BookDTO> list = (List<BookDTO>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>전체 도서 목록</title>
<style>
table {
	width: 100%;
}
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	text-align: center;
}
</style>
</head>
<body>
	<h1>전체 도서 목록</h1>
	<hr><br>
	<table>
		<tr>
			<th>uid</th>
			<th>제목</th>
			<th>가격</th>
			<th>조회수</th>
			<th>등록일</th>
		</tr>
		<%
		if (list != null) {
			for (BookDTO dto : list) {
		%>
		<tr>
			<td><%=dto.getUid()%></td>
			<td><a href="view.do?uid=<%=dto.getUid()%>"><%=dto.getTitle()%></a></td>
			<td><%=dto.getPrice()%></td>
			<td><%=dto.getViewCnt()%></td>
			<td><%=dto.getRegDateTime()%></td>
		</tr>
		<%
			}
		}
		%>
	</table>
	<br>
	<button onclick="location.href='write.do'">신규 등록</button>
</body>
</html>