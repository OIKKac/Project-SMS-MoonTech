  <jsp:include page="/include/header.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
  <div class="header bg-gradient-primary pb-8 pt-5 pt-md-8">
      <div class="container-fluid">
        <div class="header-body">
          <!-- Card stats -->
          <div class="row">
            <div class="col-xl-3 col-lg-6">
              <div class="card card-stats mb-4 mb-xl-0">
                <div class="card-body">
                  <div class="row">
                    <div class="col">
                    
                      <h5 class="card-title text-uppercase text-muted mb-0">재료구매요청서</h5>
                      <span class="h2 font-weight-bold mb-0">${matBuyReqCount }</span>
                    </div>
                    <div class="col-auto">
                      <div class="icon icon-shape bg-danger text-white rounded-circle shadow">
                        <i class="fas fa-chart-bar"></i>
                      </div>
                    </div>
                  </div>
                  
                </div>
              </div>
            </div>
            <div class="col-xl-3 col-lg-6">
              <div class="card card-stats mb-4 mb-xl-0">
                <div class="card-body">
                  <div class="row">
                    <div class="col">
                      <h5 class="card-title text-uppercase text-muted mb-0">부품생산지시서</h5>
                      <%-- <span class="h2 font-weight-bold mb-0">${partPdcOrdCount }</span> --%>
                    </div>
                    <div class="col-auto">
                      <div class="icon icon-shape bg-warning text-white rounded-circle shadow">
                        <i class="fas fa-chart-pie"></i>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-xl-3 col-lg-6">
              <div class="card card-stats mb-4 mb-xl-0">
                <div class="card-body">
                  <div class="row">
                    <div class="col">
                      <h5 class="card-title text-uppercase text-muted mb-0">부품출고지시서</h5>
                      <%-- <span class="h2 font-weight-bold mb-0">${partOutOrdCount }</span> --%>
                    </div>
                    <div class="col-auto">
                      <div class="icon icon-shape bg-yellow text-white rounded-circle shadow">
                        <i class="fas fa-users"></i>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-xl-3 col-lg-6">
              <div class="card card-stats mb-4 mb-xl-0">
                <div class="card-body">
                  <div class="row">
                    <div class="col">
                      <h5 class="card-title text-uppercase text-muted mb-0">부품구매지시서</h5>
                      <%-- <span class="h2 font-weight-bold mb-0">${partBuyReqCount }</span> --%>
                    </div>
                    <div class="col-auto">
                      <div class="icon icon-shape bg-info text-white rounded-circle shadow">
                        <i class="fas fa-percent"></i>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="container-fluid mt--7">
      <!-- Table -->
      <div class="row">
        <div class="col">
          <div class="card shadow">
            <div class="card-header border-0">
              <h3 class="mb-0">신규 재료 목록</h3>
            </div>
           <div class="table-responsive">
              <table class="table align-items-center table-flush">
                <thead class="thead-light">
				<tr>
					<th scope="col" >재료번호</th>
					<th scope="col" >재료명</th>
					<th scope="col" >사이즈</th>
					<th scope="col" >무게</th>
					<th scope="col" >표준가격</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items = "${matList}" var = "mat"   begin="0" end="4" >
					<tr>
						<td>${mat.matSq}</td>
						<td><a href = "mat.do?command=mat_update_form&matSq=${mat.matSq}">${mat.matNm}</a></td>
						<td>${mat.matSize}</td>
						<td>${mat.weight}</td>
						<td>${mat.stanPrice}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>	
		<br>
		</div>           
            </div>
            </div>
            </div>
            </div>
  <jsp:include page="/include/footer.jsp"></jsp:include>          
            
            