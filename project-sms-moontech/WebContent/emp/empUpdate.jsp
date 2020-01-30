<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>직원</title>
</head>
<body>
	<form method="post" action="emp.do">
		<input type="hidden" name="command" value="emp_update">

		<table>
			<tr>
				<td>직원번호</td>
				<td><input type="text" name="empNo" value="${emp.empNo}"
					readonly /></td>
			</tr>
			<tr>
				<td>직원명</td>
				<td><input type="text" name="empNm" value="${emp.empNm}" /></td>
			</tr>
			<tr>
				<td>번호</td>
				<td><input type="text" name="hp" value="${emp.hp}" /></td>
			</tr>
			<tr>
				<td>부서명</td>
				<td><input type="text" name="deptSq"  value="${emp.deptSq}" /></td>
			</tr>
			<tr>
				<td>계급</td>
				<td><input type="text" name="posi"  value="${emp.posi}" /></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address"  value="${emp.address}" /></td>
			</tr>
			<tr>
				<td>사진</td>
				<td><input type="text" name="picture" value="${emp.picture}" /></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email"  value="${emp.email}" /></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pwd"  value="${emp.pwd}" /></td>
			</tr>
		</table>
		
		<input type="submit" value="수정" >
		<input type="button" value="삭제"  onclick=  "location.href='./emp.do?command=emp_delete&empNo=${emp.empNo}'">
	</form>


</body>
</html>