<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/insert/save" method="POST">
	<table>
		<colgroup>
			<col width="20%">
			<col width="80%">
		</colgroup>
		<tbody>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" placeholder="제목을 입력하세요."/></td>
			</tr>
			<tr>
				<td>글쓴이</td>
				<td><input type="text" name="writerName" placeholder="작성자 이름을 입력하세요."/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" name="content" placeholder="내용을 입력하세요."/></td>
			</tr>
		</tbody>
	</table>
	<input type="submit" value="저장">
</form>
</body>
</html>