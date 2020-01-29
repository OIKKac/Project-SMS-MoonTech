<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>재료</title>
</head>
<body>
	<form method = "post" action = "mat.do">
		<input type = "hidden" name = "command" value = "mat_update">
		
		<table>
			<tr>
				<td>재료번호</td>
				<td><input type = "text" name = "matSq" value = "${mat.matSq}"></td>
			</tr>
			<tr>
				<td>재료명</td>
				<td><input type = "text" name = "matNm" value = "${mat.matNm}" ></td>
			</tr>
			<tr>
				<td>사이즈</td>
				<td><input type = "text" name = "matSize" value = "${mat.matSize}" ></td>
			</tr>
			<tr>
				<td>무게</td>
				<td><input type = "text" name = "weight" value = "${mat.weight}" ></td>
			</tr>
			<tr>
				<td>표준가격</td>
				<td><input type = "text" name = "stanPrice" value = "${mat.stanPrice}" ></td>
			</tr>
			<tr>
				<td>사진</td>
				<td><input type = "text" name = "picture" value = "${mat.picture}" ></td>
			</tr>
		</table>
		
		
		<input type = "submit" value = "수정">
	</form>
	
	
</body>
</html>