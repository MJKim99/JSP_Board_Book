<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>신규 도서 등록</title>
</head>
<body>
	<h2>신규 도서 등록</h2>
	<form name="frm" action="writeOk.do" method="post" onsubmit="return chkSubmit()">
	도서 제목 <input type="text" name="title"/><br>
	도서 가격 <input type="number" name="price"/><br><br>
	내용 <br>
	<textarea name="summary"></textarea>
	<br><br>
	<input type="submit" value="등록하기"/>
	</form>
	<br>
	<button type="button" onclick="location.href='list.do'">목록으로</button>
	
	<script>
		function chkSubmit() {
			frm = document.forms['frm'];

			let title = frm['title'].value.trim();

			if (title == '') {
				alert("도서 제목은 반드시 입력해야 합니다");
				frm['title'].focus();
				return false;
			}

			return true;
		}
	</script>
</body>
</html>