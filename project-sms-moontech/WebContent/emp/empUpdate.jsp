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
              <h3 class="mb-0"> 직원 수정</h3>
            </div>
			<div class="card-body">
			<form method="post" action="emp.do" name="frm" >
			<input type="hidden" name="command" value="emp_update">
					<input type="hidden"  name="empNo" value="${emp.empNo}" >
						<h6 class="heading-small text-muted mb-4">User information</h6>
							<div class="row">
								<div class="col-lg-6">
									<div class="form-group">
										<label class="form-control-label" for="input-email">직원번호</label>
										<input type="text"  value="${emp.empNo}" class="form-control form-control-alternative" readonly="readonly" />
									</div>
								</div>
								<div class="col-lg-6">
									<div class="form-group">
										<label class="form-control-label" for="input-username">직원명</label>
										<input type="text" name="empNm"  value="${emp.empNm}"
											class="form-control form-control-alternative">
									</div>
								</div>
							</div>


							<div class="row">
								<div class="col-lg-6">
									<div class="form-group">
										<label class="form-control-label" for="input-first-name">전화번호</label>
										<input type="text" name="hp" value="${emp.hp}"
											class="form-control form-control-alternative" />
									</div>
								</div>


								<div class="col-lg-6">
									<div class="form-group">
										<label class="form-control-label" for="input-last-name">부서명</label>
										<select class="form-control"  name="deptSq">
										<c:forEach items = "${deptList}" var = "dept"> 
													<c:if test="${dept.deptSq eq emp.deptSq}"><option value="${dept.deptSq}" selected>${dept.deptNm}</option></c:if>
													<c:if test="${dept.deptSq ne emp.deptSq}"><option value="${dept.deptSq}" >${dept.deptNm}</option></c:if>
								      </c:forEach>
									</select>
									</div>
								</div>
							</div>

							<!-- Address -->
							<div class="row">
								<div class="col-lg-6">
									<div class="form-group">
										<label class="form-control-label" for="input-last-name">직급</label>
										<input type="text" name="posi" value="${emp.posi}"
											class="form-control form-control-alternative" />
									</div>
								</div>

								<div class="col-lg-6">
									<div class="form-group">
										<label class="form-control-label" for="input-last-name">이메일</label>
										<input type="text" name="email" value="${emp.email}"
											class="form-control form-control-alternative" id="exampleFormControlInput1" placeholder="name@example.com">
									</div>
								</div>
							</div>
							
							<h6 class="heading-small text-muted mb-4">Contact information</h6>
							
								<div class="row">
									<div class="col-lg-12">
										<div class="form-group">
											<label class="form-control-label" for="input-address">주소</label>
											<input type="text" name="address" value="${emp.address}"
												class="form-control form-control-alternative" />
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
											<input type="file" value="${emp.picture}" name="picture" id="file" onchange="changeValue(this)" style="display:none;"/>
										<c:if test = "${emp.picture ne null}" >
												<img src="displayFile?fileName=${emp.picture}">
										</c:if>
										
										
										
										</div>
									</div>
									<div class="col-lg-3">
										<div class="form-group">
										<input type="text" id="filename" class="form-control" disabled />
										</div>
									</div>
									<div class="col-lg-6">
										<div class="form-group">
											<label class="form-control-label" for="input-city">비밀번호</label>
											<input type="password" name="pwd" value="${emp.pwd}"
												class="form-control form-control-alternative"
												placeholder="Password " />
										</div>
									</div>
								</div>
								
							<hr class="my-4" />
							<!-- Description -->
							<div class="btn-wrapper text-center">
							<input type="button" class="btn btn-danger btn-lg" value="삭제"  onclick=  "location.href='./emp.do?command=emp_delete&empNo=${emp.empNo}'">
							<input type="button" value="수정" class="btn btn-primary btn-lg" onclick="updateEmp()">
							<input type="button" value="취소" onclick="location.href='emp.do?command=emp_list'" 	class="btn btn-info btn-lg">
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

function updateEmp(){
	
		var empNm = frm.empNm.value;
		var pwd =frm.pwd.value;
		var hp =frm.hp.value;
		var deptSq =frm.deptSq.value;
		var posi =frm.posi.value;
		var email =frm.email.value;
		var picture = frm.picture.value;
		
		if (empNm == "") {
			alert("이름을 입력해주세요.");
			frm.empNm.focus();
			return false;
		}
		if (pwd == "") {
			alert("비밀번호를 입력해주세요.");
			frm.pwd.focus();
			return false;
		}
		if (deptSq == "") {
			alert("부서명을 선택해주세요.");
			frm.deptSq.focus();
			return false;
		}
		if (hp == "") {
			alert("휴대폰 번호를 입력해주세요.");
			frm.hp.focus();
			return false;
			
		} else if (confirm("정말로 등록하시겠습니까?")) {
			
			var form = frm;
			var data = new FormData(form);
			
			$.ajax({

				type : 'POST',
				enctype: 'multipart/form-data',
				url: 'emp.do?command=emp_update', 

				processData : false,
				contentType : false,

				cache : false,
				timeout : 600000,
				data : data,

				success : function(data) {
					alert("수정 완료되었습니다.");
					location.href = "emp.do?command=emp_list";
				},
				error : function(data) {
					alert("오류:: 다시 시도해주세요.");
					return false;
				}
			})
		} else {
			return false;
		}
	}
</script>


<jsp:include page="/include/footer.jsp"></jsp:include>