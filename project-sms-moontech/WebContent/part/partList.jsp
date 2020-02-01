<jsp:include page="/include/header.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

	<!-- <div onclick = "location.href='mat.do?command=mat_update_form'">
		 -->
<div class="header bg-gradient-primary pb-8 pt-5 pt-md-8">
      <div class="container-fluid">
        <div class="header-body">
          <!-- Card stats -->
          <div class="row">
           <!-- Card stats -->
            <div class="col-lg-12">
              <div class="card card-stats mb-4 mb-xl-0">
             <div class="card-body">
             <div class="row align-items-center">
                <div class="col-8">
                  <h3 class="mb-5">부품</h3>
                </div>
                <div class="col-4 text-right">
                  <a href="part.do?command=part_write_form" class="btn btn-primary btn-lg">부품 등록</a>
                </div>
              </div>
                  <div class="row">
		<table class="table align-items-center table-flush">
			<thead class="thead-light">
				<tr>
					<th scope="col" >부품 번호</th>
					<th scope="col" >부품명</th>
					<th scope="col" >사이즈</th>
					<th scope="col" >무게</th>
					<th scope="col" >표준가격</th>	
					<th scope="col" >재료번호</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items = "${partList}" var = "part">
					<tr>
						<td>${part.partSq}</td>
						<td><a href = "part.do?command=part_update_form&partSq=${part.partSq}">${part.partNm}</a></td>
						<td>${part.partSize}</td>
						<td>${part.weight}</td>
						<td>${part.stanPrice}</td>
						<td>${part.matSq}</td>
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
		</div>
		</div>
		</div>
	</div>
	</div>
	</div>
	</div>
	
<jsp:include page="/include/footer.jsp"></jsp:include>