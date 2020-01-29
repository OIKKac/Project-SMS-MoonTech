<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>재료</title>
</head>
<body>


	<!-- <div onclick = "location.href='mat.do?command=mat_update_form'">
		 -->
		<table>
			<thead>
				<tr>
					<td>재료번호</td>
					<td>재료명</td>
					<td>사이즈</td>
					<td>무게</td>
					<td>표준가격</td>		
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items = "${matList}" var = "mat">
					<tr>
						<td>${mat.matSq}</td>
						<td><a href = "mat.do?command=mat_update_form&matSq=${mat.matSq}">${mat.matNm}</a></td>
						<td>${mat.matSize}</td>
						<td>${mat.weight}</td>
						<td>${mat.stanPrice}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>	
			
			
<!-- 			
			<tr>
				<td>재료번호</td>
				<td><input type = "text" name = "matSq" value = "${mat.matSQ}" disabled/></td>
			</tr>
			<tr>
				<td>재료명</td>
				<td><input type = "text" name = "matNm" value = "${mat.matNm}"/></td>
			</tr>
			<tr>	
				<td>사이즈</td>
				<td><input type = "text" name = "matSize" value = "${mat.matSize}"/></td>	
			</tr>	
			<tr>
				<td>무게</td>
				<td><input type = "text" name = "weight" value = "${mat.weight}"/></td>
			</tr>
			<tr>
				<td>표준가격</td>
				<td><input type = "text" name = "stanPrice" value = "${mat.stanPrice}"/></td>
			</tr>
		</table>
	
	
	<a href = "mat.do?command=mat_write_form">asdf</a>
 -->	
	
</body>
</html>