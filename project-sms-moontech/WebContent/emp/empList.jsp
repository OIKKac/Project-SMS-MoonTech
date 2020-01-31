<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>직원</title>
</head>
<body>


	<!-- <div onclick = "location.href='emp.do?command=emp_update_form'">
		 -->
		<table>
			<thead>
				<tr>
					<td>직원번호</td>
					<td>직원이름</td>
					<td>번호</td>
					<td>부서명</td>
					<td>직급</td>
					<td>주소</td>
					<td>사진</td>
					<td>이메일</td>
					<td>비밀번호</td>		
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items = "${empList}" var = "emp">
					<tr>
						<td>${emp.empNo}</td>
						<td><a href = "emp.do?command=emp_update_form&empNo=${emp.empNo}">${emp.empNm}</a></td>
						<td>${emp.hp}</td>
						<td>${emp.deptSq}</td>
						<td>${emp.posi}</td>
						<td>${emp.address}</td>
						<td>${emp.picture}</td>
						<td>${emp.email}</td>
						<td>${emp.pwd}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>	
			
			
<!-- 			
			<tr>
				<td>직원번호</td>
				<td><input type = "text" name = "empNo" value = "${emp.empNo}" disabled/></td>
			</tr>
			<tr>
				<td>직원명</td>
				<td><input type = "text" name = "empNm" value = "${emp.empNm}"/></td>
			</tr>
			<tr>	
				<td>번호</td>
				<td><input type = "text" name = "hp"  value = "${emp.hp}"/></td>	
			</tr>	
			<tr>
				<td>부서명</td>
				<td><input type = "text" name = "deptSq" value = "${emp.deptSq}"/></td>
			</tr>
			<tr>
				<td>계급</td>
				<td><input type = "text" name = "posi" value = "${emp.posi}"/></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type = "text" name = "address" value = "${emp.address}"/></td>
			</tr>
			<tr>
				<td>사진</td>
				<td><input type = "text" name = "picture" value = "${emp.picture}"/></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type = "text" name = "email" value = "${emp.email}"/></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type = "text" name = "pwd" value = "${emp.pwd}"/></td>
			</tr>
		</table>
	
	
	<a href = "emp.do?command=emp_write_form">가자가자</a>
 -->	
	
</body>
</html>