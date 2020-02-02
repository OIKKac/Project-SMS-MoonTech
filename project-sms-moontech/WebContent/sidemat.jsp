
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/include/header.jsp"></jsp:include>

<div></div>

<div>
<a href = "mat.do?command=mat_list">Mat list</a><br>

<a href = "mat.do?command=mat_update">matUpdate</a><br>

<a href = "mat.do?command=mat_write_form">regist</a><br>

<a href = "emp.do?command=emp_list">Emp list</a><br>

<a href = "emp.do?command=emp_update">empUpdate</a>

<a href = "part.do?command=part_write_form">partWrite</a>

<a href = "mat.do?command=mat_in_write_form">matInWrite</a><br>

<a href="mat.do?command=mat_in_list">matInList</a>
</div>



<jsp:include page="/include/footer.jsp"></jsp:include>


