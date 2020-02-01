<jsp:include page="/include/header.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
              <h3 class="mb-0"> 직원 목록</h3>
            </div>
          <div class="row">
		<table class="table align-items-center table-flush">
			<thead class="thead-light">
				<tr>
					<th scope="col" >직원</th>
					<th scope="col" >직원이름</th>
					<th scope="col" >번호</th>
					<th scope="col" >부서명</th>
					<th scope="col" >직급</th>
					<th scope="col" >주소</th>
					<th scope="col" >이메일</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items = "${empList}" var = "emp">
					<tr>
					 <th scope="row">
                      <div class="media align-items-center">
                        <a href="#" class="avatar rounded-circle mr-3"> <%-- ${emp.picture} --%>
                          <img alt="Image placeholder" src="/resources/img/theme/team-1-800x800.jpg">
                        </a>
                        <div class="media-body">
                          <span class="mb-0 text-sm">${emp.empNo}</span>
                        </div>
                      </div>	
                      </th>					
						<td><a href = "emp.do?command=emp_update_form&empNo=${emp.empNo}">${emp.empNm}</a></td>
						<td>${emp.hp}</td>
						<td>${emp.deptSq}</td>
						<td>${emp.posi}</td>
						<td>${emp.address}</td>
						<td>${emp.email}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>	
			
			</div>
		
		<div class="card-footer py-4">
              <nav aria-label="...">
                <ul class="pagination justify-content-end mb-0">
                  <li class="page-item disabled">
                    <a class="page-link" href="#" tabindex="-1">
                      <i class="fas fa-angle-left"></i>
                      <span class="sr-only">Previous</span>
                    </a>
                  </li>
                  <li class="page-item active">
                    <a class="page-link" href="#">1</a>
                  </li>
                  <li class="page-item">
                    <a class="page-link" href="#">2 <span class="sr-only">(current)</span></a>
                  </li>
                  <li class="page-item"><a class="page-link" href="#">3</a></li>
                  <li class="page-item">
                    <a class="page-link" href="#">
                      <i class="fas fa-angle-right"></i>
                      <span class="sr-only">Next</span>
                    </a>
                  </li>
                </ul>
              </nav>
            </div>
		
                <div class="col-12 text-right">
                  <a href="emp.do?command=emp_write_form" class="btn btn-primary btn-lg">직원등록</a>
                </div>
                		
		
		
		</div>
		</div>
		</div>
		
	</div>
	</div>
	</div>
	</div>
<jsp:include page="/include/footer.jsp"></jsp:include>