<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

 <!-- Favicon -->
 <link href="./bootstrap/argon-dashboard-master/assets/img/brand/favicon.png" rel="icon" type="image/png">
 <!-- Fonts -->
 <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
 <!-- Icons -->
 <link href="./bootstrap/argon-dashboard-master/assets/js/plugins/nucleo/css/nucleo.css" rel="stylesheet" />
 <link href="./bootstrap/argon-dashboard-master/assets/js/plugins/@fortawesome/fontawesome-free/css/all.min.css" rel="stylesheet" />
 <!-- CSS Files -->
 <link href="./bootstrap/argon-dashboard-master/assets/css/argon-dashboard.css?v=1.1.1" rel="stylesheet" />
 
 
<body class = "">
<div>
	<%@include file = "./include/sideMat.jsp" %>
</div>
	<div>
<a href = "mat.do?command=mat_list">Mat list</a><br>

<a href = "mat.do?command=mat_update">matUpdate</a><br>

<a href = "mat.do?command=mat_write_form">regist</a><br>
</div>
      <!-- Footer -->
<footer class="footer">


<%@ include file = "./include/footer.jsp"%>

</footer>
</body>
</html>