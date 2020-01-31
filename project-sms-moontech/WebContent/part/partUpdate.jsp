<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<script type="text/javascript" src="script/board.js"></script>
</head>
<body>

	<form method= "post" name = "frm" action = "part.do">
		<input type = "hidden" name = "command" value = "part_update">		
		<table>
			<tr>
				<td>제품번호</td>

				<td><input type = "text" name = "partSq" value = "${part.partSq}" /></td>

			</tr>
			<tr>
				<td>제품명</td>
				<td><input type = "text" name = "partNm" value = "${part.partNm}"/></td>
			</tr>
			<tr>	
				<td>사이즈</td>
				<td><input type = "text" name = "partSize" value = "${part.partSize}"/></td>	
			</tr>	
			<tr>
				<td>무게</td>
				<td><input type = "text" name = "weight" value = "${part.weight}"/></td>
			</tr>
			<tr>
				<td>표준가격</td>
				<td><input type = "text" name = "stanPrice" value = "${part.stanPrice}"/></td>
			</tr>
			<tr>
				<td>재료번호</td>
				<td><input type = "text" name = "matSq" value = "${part.matSq}"/></td>
			</tr>
		</table>
		<input type = "submit" value = "수정" onclick = "return emptyCheck()">	
		<input type = "button" value = "삭제" onclick = "location.href='part.do?command=part_delete&partSq=${part.partSq}'">
	</form>
</body>
</html>