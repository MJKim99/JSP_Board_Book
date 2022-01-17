<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.beans.*"%>
<%@ page import="java.util.*"%>
<%
List<BookDTO> list = (List<BookDTO>) request.getAttribute("list");

if (list == null || list.size() == 0) {
%>
<script>
	alert("해당 정보가 삭제되었거나 존재하지 않습니다.");
	history.back();
</script>
<%
	return;
}
%>
<%
	BookDTO dto = list.get(0);
	int uid = dto.getUid();
	String title = dto.getTitle();
	String summary = dto.getSummary();
	int price = dto.getPrice();
	int viewCnt = dto.getViewCnt();
	String regDate = dto.getRegDateTime(); 
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>글 상세 보기</title>
</head>
<body>
	<h1><%=title%> 정보</h1>
	<hr>
	<strong>도서 제목</strong> <%=title%><br>
	<strong>도서 가격</strong> <%=price%><br>
	<strong>조회수</strong> <%=viewCnt%><br>
	<strong>등록일</strong> <%=regDate%><br><br>
	<strong>요약</strong><br>
	<%=summary%>
	<br><hr><br>
	<button type="button" onclick="chkDelete(<%=uid%>)">삭제하기</button>
	<button type="button" onclick="location.href='list.do'">목록으로</button>
	<button type="button" onclick="location.href='update.do?uid=<%=uid%>'">수정하기</button>
	<button type="button" onclick="location.href='write.do'">신규등록</button>
	
	<script>
	function chkDelete(uid) {
		let r = confirm("삭제하시겠습니까?");
		if (r) {
			location.href = "deleteOk.do?uid=" + uid;
		}
	}
	</script>
</body>
</html>