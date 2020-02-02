


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>재료</title>
</head>
<body>











		<table>
			<thead>
				<tr>
					<td>순번</td>
					<td>사진</td>
					<td>제품번호</td>
					<td>제품명</td>
					<td>입고수량</td>		
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items = "${deList}" var = "de" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td>${de.picture}</td>
						<td>${de.matSq}</td>
						<td>${de.matNm}</td>
						<td>${de.inAmt}개</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
</body>
</html>