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
			<form method="post" action="emp.do">
			<input type="hidden" name="command" value="emp_update">
					<input type="hidden"  name="empNo" value="${empNo}" >
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
											<input type="text" name="address1" value="${emp.address}"
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
											<input type="file" value="파일선택" name="picture" id="file" onchange="changeValue(this)" style="display:none;"/>
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
							<input type="submit" value="수정"  class="btn btn-primary btn-lg" >
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
<jsp:include page="/include/footer.jsp"></jsp:include>