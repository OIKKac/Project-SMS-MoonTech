


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>재료구매</title>
</head>
<body>



		<table>
			<thead>
				<tr>
					<td>순번</td>
					<td>재료구입번호</td>
					<td>구입일자</td>
					<td>직원번호</td>
					<td>매입처번호</td>
						
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items = "${matBuyList}" var = "matBuy" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td>${matBuy.empNm}</td>
						<td>${matBuy.purNm}</td>
						<td><fmt:formatDate value="${matBuy.BuyDt}" pattern="yyyy.MM.dd" /></td>
						<td>${matBuy.cntDe}개</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
</body>
</html>