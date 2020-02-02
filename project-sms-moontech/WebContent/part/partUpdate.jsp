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
              <h3 class="mb-0"> 부품 수정</h3>
            </div>
				<div class="card-body">
				<form method= "post"  action = "part.do" enctype="multipart/form-data">
				<input type = "hidden" name = "command" value = "part_update">		
				<input type = "hidden" name = "partSq"  value = "${part.partSq}">		
				<div class="row">
								<div class="col-lg-6">
									<div class="form-group">
										<label class="form-control-label" for="input-email">부품 번호</label>
										<input type="text" value = "${part.partSq}" class="form-control form-control-alternative" disabled />
									</div>
								</div>
								<div class="col-lg-6">
									<div class="form-group">
										<label class="form-control-label" for="input-username">부품명</label>
										<input type="text" name="partNm"  value="${part.partNm}"
											class="form-control form-control-alternative">
									</div>
								</div>
							</div>
				
							<div class="row">
								<div class="col-lg-6">
									<div class="form-group">
										<label class="form-control-label" for="input-email">사이즈</label>
										<input type="text"  name="partSize"  value="${part.partSize}"  class="form-control form-control-alternative"  />
									</div>
								</div>
								<div class="col-lg-6">
									<div class="form-group">
										<label class="form-control-label" for="input-username">무게</label>
										<input type="text" name="weight"  value="${part.weight}" 
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
											<input type="file" value="${part.picture}" name="picture" id="file" onchange="changeValue(this)" style="display:none;"/>
										<c:if test = "${part.picture ne null}" >
												<img src="displayFile?fileName=${part.picture}">
										</c:if>
										</div>
									</div>
									<div class="col-lg-3">
										<div class="form-group">
										<input type="text" id="filename" class="form-control" value="${part.picture}"  disabled />
										</div>
									</div>
								<div class="col-lg-6">
									<div class="form-group">
										<label class="form-control-label" for="input-username">표준가격</label>
										<input type="text" name="stanPrice"  value="${part.stanPrice}" 
											class="form-control form-control-alternative">
									</div>
								</div>
							</div>						
							<div class="row">
								<div class="col-lg-8">
									<div class="form-group">
										<label class="form-control-label" for="input-username">재료명</label>
										<input type="text" name="matNm"   id="matNm"  value="${part.matNm}" 
											class="form-control form-control-alternative">
										<input type="hidden" name="matSq" id="matSq"  value="${part.matSq}"  />
									</div>
								</div>
								<div class="col-lg-4">
									<div class="form-group">
									<br>
										<input type="button" value = "검색" onclick = "openPopUp()"  class="btn btn-icon btn-3 btn-primary"/>											
									</div>
								</div>
							</div>				
				
							<hr class="my-4" />
							<!-- Description -->
							<div class="btn-wrapper text-center">
								<input type="button" value=삭제 onclick="location.href='part.do?command=part_delete&partSq=${part.partSq}'" class="btn btn-danger btn-lg">
								<input type="submit" value="수정" class="btn btn-primary btn-lg">
								<input type="button" value="취소" onclick="location.href='part.do?command=part_list'" class="btn btn-info btn-lg">
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
	document.getElementById("filename").value =obj.value;
 }

function openPopUp() {
    // window.name = "부모창 이름"; 
    window.name = "parentForm";
    // window.open("open할 window", "자식창 이름", "팝업창 옵션");
    var width = "800";
    var height = "500";
    var top = (window.screen.height - height) / 2;
    var left = (window.screen.width - width) / 2;
    var url = "mat.do?command=mat_select_form";
    var title = "재료 등록";
    var status = "toolbar=no,directories=no,scrollbars=no,resizable=no,status=no,menubar=no,width="
          + width + ",height=" + height + ",top=" + top + ",left=" + left;

    window.open(url, title, status);
 }
</script>
