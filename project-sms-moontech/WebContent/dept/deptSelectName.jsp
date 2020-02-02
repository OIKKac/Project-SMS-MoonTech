<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>부서</title>
</head>
<body>


	<!-- <div onclick = "location.href='mat.do?command=mat_update_form'">
		 -->
		 <form method= "GET"  action = "dept.do">
		 	<input type = "hidden" name = "command" value = "dept_select">		
		 	<input type="text" name="selectNm" placeholder = "부서명을 검색하시오"/>
		 	<input type = "submit"  value="검색"></input>
		 </form>
		<table>
			<thead>
				<tr>
					<td>부서번호</td>					
					<td>부서명</td>				
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items = "${deptList}" var = "dept">
					<tr>
					<td>
					<a  onclick="sendToParent('${dept.deptSq}','${dept.deptNm}')"> ${dept.deptSq}</a></td>
					<td>
                    <a onclick="sendToParent('${dept.deptSq}','${dept.deptNm}')">${dept.deptNm}</a></td>	
					</tr>
				</c:forEach>
			</tbody>
		</table>	
			
</body>
<script>
function sendToParent(matSq,matNm) {
    alerm("deptSq : " + deptSq + " deptNm : " + deptNm)
    opener.document.getElementById("deptSq").value = deptSq;
    opener.document.getElementById("deptNm").value = deptNm;
    window.close();
 }
</script>
</html>