<jsp:include page="/include/header.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="header bg-gradient-primary pb-8 pt-5 pt-md-8">
      <div class="container-fluid">
        <div class="header-body">
          <!-- Card stats -->
          <div class="row">
           <!-- Card stats -->
            <div class="col-lg-12">
              <div class="card card-stats mb-4 mb-xl-0">
                <div class="card-body">
            <div class="card-header border-0">
              <h3 class="mb-0"> 재료 수정</h3>
            </div>
	<div class="card-body">
	<form method="post" name="frm" action="mat.do"  enctype="multipart/form-data">
		<input type = "hidden" name = "command" value = "mat_update">		
		<input type = "hidden" name = "matSq"  value = "${mat.matSq}">		
				<div class="row">
								<div class="col-lg-6">
									<div class="form-group">
										<label class="form-control-label" for="input-email">재료 번호</label>
										<input type="text" value ="${mat.matSq}" class="form-control form-control-alternative" disabled />
									</div>
								</div>
								<div class="col-lg-6">
									<div class="form-group">
										<label class="form-control-label" for="input-username">재료명</label>
										<input type="text" name="matNm"  value="${mat.matNm}"
											class="form-control form-control-alternative">
									</div>
								</div>
							</div>
				
							<div class="row">
								<div class="col-lg-6">
									<div class="form-group">
										<label class="form-control-label" for="input-email">사이즈</label>
										<input type="text"  name="matSize" value="${mat.matSize}" class="form-control form-control-alternative"  />
									</div>
								</div>
								<div class="col-lg-6">
									<div class="form-group">
										<label class="form-control-label" for="input-username">무게</label>
										<input type="text" name="weight"  value="${mat.weight}"
											class="form-control form-control-alternative">
									</div>
								</div>
							</div>				
							<div class="row">
								<div class="col-lg-3">
										<div class="form-group">
											<label class="form-control-label" for="input-city">사진</label>
											<button class="btn btn-icon btn-3 btn-primary"  type="button"  id="btn-upload" class="form-control form-control-alternative">
											<span class="btn-inner--icon"><i class="ni ni-cloud-upload-96"></i></span>
  											 <span class="btn-inner--text">사진 등록하기</span>
											</button>
											<input type="file" value="${mat.picture}" name="picture" id="file" onchange="changeValue(this)" style="display:none;"/>
										<c:if test = "${mat.picture ne null}" >
												<img src="displayFile?fileName=${mat.picture}">
										</c:if>
										</div>
									</div>
									<div class="col-lg-3">
										<div class="form-group">
										<input type="text" id="fileName" name="fileName" class="form-control"  value="${mat.picture}"  disabled />
										</div>
									</div>
								<div class="col-lg-6">
									<div class="form-group">
										<label class="form-control-label" for="input-username">표준가격</label>
										<input type="text" name="stanPrice"  value="${mat.stanPrice}"
											class="form-control form-control-alternative">
									</div>
								</div>
							</div>				
							
							<hr class="my-4" />
							<!-- Description -->
							<div class="btn-wrapper text-center">
								<input type="button" class="btn btn-danger btn-lg" value="삭제"  onclick=  "location.href='mat.do?command=mat_delete&matSq=${mat.matSq}'">
								<input type="submit" value="수정"  class="btn btn-primary btn-lg" >
								<input type="button" value="취소" onclick="location.href='mat.do?command=mat_list'" class="btn btn-info btn-lg">
							</div>	
					</form>
				</div>
				</div>
			</div>
		</div>
	</div>
</div>
</div>
</div>
  <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
$(function () {
$('#btn-upload').click(function (e) {
e.preventDefault();

$('#file').click();
});
});

function changeValue(obj){
	document.getElementById("fileName").value =obj.value;
 }

</script>

<jsp:include page="/include/footer.jsp"></jsp:include>














