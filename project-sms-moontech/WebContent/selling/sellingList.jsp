<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
			<thead>
				<tr>
					<td>매출처번호</td>
					<td>매출처명</td>
					<td>번호</td>
					<td>대표자명</td>
					<td>주소</td>
					<td>번호</td>
					<td>이메일</td>
					<td>사업자번호</td>	
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items = "${sellingList}" var = "selling">
					<tr>
						<td>${selling.selSq}</td>
						<td><a href = "selling.do?command=selling_update_form&selSq=${selling.selSq}">${selling.selNm}</a></td>
						<td>${selling.repNm}</td>
						<td>${selling.address}</td>
						<td>${selling.hp}</td>
						<td>${selling.email}</td>												
						<td>${selling.bunUm}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>	
</body>
</html>