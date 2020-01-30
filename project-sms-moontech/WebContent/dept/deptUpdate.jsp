<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>직원</title>
</head>
<body>
	<form method="post" action="dept.do">
		<input type="hidden" name="command" value="dept_update">

		<table>
			<tr>
				<td>부서번호</td> 
				<td><input type="text" name="deptSq" value="${dept.deptSq}"
					readonly /></td>
			</tr>
			<tr> 
				<td>부서명</td>
				<td><input type="text" name="deptNm" value="${dept.deptNm}" /></td>
			</tr>			
		</table>
		
		<input type="submit" value="수정" >
		<input type="button" value="삭제"  onclick=  "location.href='./dept.do?command=dept_delete&deptSq=${dept.deptSq}'">
	</form>


</body>
</html>