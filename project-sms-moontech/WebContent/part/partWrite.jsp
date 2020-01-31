<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<script type="text/javascript" src="script/board.js"></script>
</head>
<body>
<form method= "post"  action = "part.do">
		<input type = "hidden" name = "command" value = "part_write">		
		<table>
			<tr>
				<td>제품번호</td>
				<td><input type = "text" name = "partSq" /></td>
			</tr>
			<tr>
				<td>제품명</td>
				<td><input type = "text" name = "partNm"/></td>
			</tr>
			<tr>	
				<td>사이즈</td>
				<td><input type = "text" name = "partSize" /></td>	
			</tr>	
			<tr>
				<td>무게</td>
				<td><input type = "text" name = "weight"/></td>
			</tr>
			<tr>
				<td>표준가격</td>
				<td><input type = "text" name = "stanPrice"/></td>
			</tr>
			<tr>
				<td>재료명</td>
				<td><input type = "text" name = "matNm"  readonly/>
				<input type="hidden" name="matSq"/>
				<input type="button" value = "검색" onclick = "openPopUp()"/></td>
			</tr>
		</table>
		<input type = "submit" value = "등록" >
		<input type = "button" value = "취소" onclick = "location.href='./part.do?command=part_list'">
	</form>
</body>
<script>
function openPopUp() {
    // window.name = "부모창 이름"; 
    window.name = "parentForm";
    // window.open("open할 window", "자식창 이름", "팝업창 옵션");
    var width = "800";
    var height = "500";
    var top = (window.screen.height - height) / 2;
    var left = (window.screen.width - width) / 2;
    var url = "./mat.do?command=mat_select_form";
    var title = "재료 등록";
    var status = "toolbar=no,directories=no,scrollbars=no,resizable=no,status=no,menubar=no,width="
          + width + ",height=" + height + ",top=" + top + ",left=" + left;

    window.open(url, title, status);
 }
</script>
</html>