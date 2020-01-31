<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>제품</title>
</head>
<body>
<table>
			<thead>
				<tr>
					<td>제품번호</td>
					<td>제품명</td>
					<td>사이즈</td>
					<td>무게</td>
					<td>표준가격</td>		
					<td>재료번호</td>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items = "${partList}" var = "part">
					<tr>
						<td>${part.partSq}</td>
						<td><a href = "part.do?command=part_update_form&partSq=${part.partSq}">${part.partNm}</a></td>
						<td>${part.partSize}</td>
						<td>${part.weight}</td>
						<td>${part.stanPrice}</td>
						<td>${part.matSq}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>	
</body>
</html>