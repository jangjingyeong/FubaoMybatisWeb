<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>공지사항 작성</title>
	</head>
	<body>
		<h1>공지사항 작성</h1>
		<form action="/notice/insert.do" method="post">
			<fieldset>
				<legend>공지사항 작성</legend>		
					<label>제목 : </label>
					<input type="text" name="noticeSubject"> <br>
					<label>내용 : </label> 
					<textarea rows="30" cols="30" name="noticeContent"></textarea> 
					<br>
					<input type="submit" value="작성"> 
					<input type="reset" value="초기화"> 
			</fieldset>
		</form>
	</body>
</html>