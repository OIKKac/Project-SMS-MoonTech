


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
					<td>입고번호</td>
					<td>작성자명</td>
					<td>거래처명</td>
					<td>작성일</td>
					<td>입고품종류</td>		
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items = "${matInList}" var = "matIn" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td><a href="mat.do?command=mat_in_view&inSq=${matIn.inSq}">${matIn.inSq}</a></td>
						<td>${matIn.empNm}</td>
						<td>${matIn.purNm}</td>
						<td><fmt:formatDate value="${matIn.inDt}" pattern="yyyy.MM.dd" /></td>
						<td>${matIn.cntDe}개</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
</body>
</html>