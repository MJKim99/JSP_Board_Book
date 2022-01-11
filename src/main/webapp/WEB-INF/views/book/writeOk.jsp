<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.beans.*" %>
<%
	int cnt = (Integer)request.getAttribute("result");
	BookDTO dto = (BookDTO)request.getAttribute("dto");
%>
<% if (cnt == 0) { %>
	<script>
		alert("등록 실패");
		history.back();
	</script>
<% } else { %>
	<script>
		alert("등록 성공");
		location.href = "view.do?uid=<%=dto.getUid()%>";
	</script>
<% } %>