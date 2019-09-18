<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="lee.hg.Board"%>
<%@page import="lee.hg.BoardControl"%>
<%@page import="lee.hg.FileControl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
FileControl fileControl = new FileControl();
BoardControl boardControl = new BoardControl();
String jsonStr = fileControl.readFile(Board.FILENAME);

List<Board> list;
if(jsonStr.length() > 0){
	list = boardControl.getBoardsFromString(jsonStr);
}else{
	list = new ArrayList<>();
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<td>id</td>
		<td>title</td>
	</tr>
	<%for(int i=0; i<list.size(); i++){ %>
	<%Board board = list.get(i); %>
	
		<tr>
			<td><%=i+1 %></td>
			<td><%=board.getTitle() %></td>
		<tr>
	
	<%} %>
</table>
<a href="/insert.jsp">새글작성</a>
</body>
</html>