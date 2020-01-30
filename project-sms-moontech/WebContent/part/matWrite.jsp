<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


 <!-- Favicon -->
 <link href="../bootstrap/argon-dashboard-master/assets/img/brand/favicon.png" rel="icon" type="image/png">
 <!-- Fonts -->
 <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
 <!-- Icons -->
 <link href="../bootstrap/argon-dashboard-master/assets/js/plugins/nucleo/css/nucleo.css" rel="stylesheet" />
 <link href="../bootstrap/argon-dashboard-master/assets/js/plugins/@fortawesome/fontawesome-free/css/all.min.css" rel="stylesheet" />
 <!-- CSS Files -->
 <link href="../bootstrap/argon-dashboard-master/assets/css/argon-dashboard.css?v=1.1.1" rel="stylesheet" />
  
    <!--   Core   -->
  <script src="../bootstrap/argon-dashboard-master/assets/js/plugins/jquery/dist/jquery.min.js"></script>
  <script src="../bootstrap/argon-dashboard-master/assets/js/plugins/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
  <!--   Optional JS   -->
  <script src="../bootstrap/argon-dashboard-master/assets/js/plugins/chart.js/dist/Chart.min.js"></script>
  <script src="../bootstrap/argon-dashboard-master/assets/js/plugins/chart.js/dist/Chart.extension.js"></script>
  <!--   Argon JS   -->
  <script src="../bootstrap/argon-dashboard-master/assets/js/argon-dashboard.min.js?v=1.1.1"></script>
  <script src="https://cdn.trackjs.com/agent/v3/latest/t.js"></script>
  <script>
    window.TrackJS &&
      TrackJS.install({
        token: "ee6fab19c5a04ac1a32a645abde4613a",
        application: "argon-dashboard-free"
      });
  </script>



</head>
<body>
	
	<form>
  <div class="row">
    <div class="col-md-6">
      <div class="form-group">
        <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com">
      </div>
    </div>
    <div class="col-md-6">
      <div class="form-group">
        <input type="text" placeholder="Regular" class="form-control" disabled />
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-md-6">
      <div class="form-group">
        <div class="input-group mb-4">
          <div class="input-group-prepend">
            <span class="input-group-text"><i class="ni ni-zoom-split-in"></i></span>
          </div>
          <input class="form-control" placeholder="Search" type="text">
        </div>
      </div>
    </div>
    <div class="col-md-6">
      <div class="form-group">
        <div class="input-group mb-4">
          <input class="form-control" placeholder="Birthday" type="text">
          <div class="input-group-append">
            <span class="input-group-text"><i class="ni ni-zoom-split-in"></i></span>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-md-6">
      <div class="form-group has-success">
        <input type="text" placeholder="Success" class="form-control is-valid" />
      </div>
    </div>
    <div class="col-md-6">
      <div class="form-group has-danger">
        <input type="email" placeholder="Error Input" class="form-control is-invalid" />
      </div>
    </div>
  </div>
</form>
	
	

	<form method= "post"  action = "mat.do">
		<input type = "hidden" name = "command" value = "mat_write">		
		<table>
			<tr>
				<td>재료번호</td>
				<td><input type = "text" name = "matSq" value = "${matSq}" /></td>
			</tr>
			<tr>
				<td>재료명</td>
				<td><input type = "text" name = "matNm" value = "${mat.matNm}"/></td>
			</tr>
			<tr>	
				<td>사이즈</td>
				<td><input type = "text" name = "matSize" value = "${mat.matSize}"/></td>	
			</tr>	
			<tr>
				<td>무게</td>
				<td><input type = "text" name = "weight" value = "${mat.weight}"/></td>
			</tr>
			<tr>
				<td>표준가격</td>
				<td><input type = "text" name = "stanPrice" value = "${mat.stanPrice}"/></td>
			</tr>
		</table>
		<input type = "submit" value = "등록" >
		<input type = "button" value = "취소" onclick = "location.href='../mat.do?command=mat_list'">
	</form>
<!-- 
	<div id="wrap" align="center">
		<h1>게시글 등록</h1>
		<form name="frm" method="post" action="BoardServlet">
			<input type="hidden" name="command" value="board_write">
			<table>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="matNm"> * 필수</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pass"> * 필수 (게시물 수정
						삭제시 필요합니다.)</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" size="70" name="title"> * 필수</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea cols="70" rows="15" name="content"></textarea></td>
				</tr>
			</table>
			<br>
			<br> <input type="submit" value="등록"
				onclick="return boardCheck()"> <input type="reset"
				value="다시 작성"> <input type="button" value="목록"
				onclick="location.href='mat.do?command=mat_list'">
		</form>
	</div>
	
	 -->
</body>
</html>