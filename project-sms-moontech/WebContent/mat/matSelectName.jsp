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
		 <form method= "GET"  action = "mat.do">
		 	<input type = "hidden" name = "command" value = "mat_select">		
		 	<input type="text" name="selectNm" placeholder = "재료명을 검색하시오"/>
		 	<input type = "submit"  value="검색"></input>
		 </form>
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
					<td>
					<a href="#" onclick="sendToParent('${mat.matSq}','${mat.matNm}')"> ${mat.matSq}</a></td>
                     <td>
                    <a href="" onclick="sendToParent('${mat.matSq}','${mat.matNm}')">${mat.matNm}</a></td>	
					<td>${mat.matSize}</td>
					<td>${mat.weight}</td>
					<td>${mat.stanPrice}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>	
			
</body>
<script>
function sendToParent(matSq,matNm) {
    alerm("matSq : " + matSq + " matNm : " + matNm)
    opener.document.getElementById("matSq").value = matSq;
    opener.document.getElementById("matNm").value = matNm;
    window.close();
 }
</script>
</html>