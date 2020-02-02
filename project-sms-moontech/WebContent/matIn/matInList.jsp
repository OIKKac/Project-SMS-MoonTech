

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
              <h3 class="mb-0">재료구매</h3>
            </div>
          <div class="row">
		<table class="table align-items-center table-flush">
			<thead class="thead-light">
				<tr>
					<th scope="col" >순번</th>
					<th scope="col" >입고번호</th>
					<th scope="col" >작성자명</th>
					<th scope="col" >거래처명</th>
					<th scope="col" >작성일</th>
					<th scope="col" >입고품종류</th>
					
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items = "${empList}" var = "emp">
					<tr>
					 <th scope="row">
                      <div class="media align-items-center">
                        <a href="#" class="avatar rounded-circle mr-3"> <%-- ${emp.picture} --%>
                          
                          <c:if test = "${emp.picture ne null}" >
								<img src="displayFile?fileName=${emp.picture}">
						</c:if>
						<c:if test = "${emp.picture eq null}" >
                        		  <img alt="Image placeholder" src="/resources/img/theme/team-1-800x800.jpg">
                          </c:if>
                          
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







































<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>재료</title>
</head>
<body>











		<table>
			<thead>
				<tr>
					<td>순번</td>
					<td>입고번호</td>
					<td>작성자명</td>
					<td>거래처명</td>
					<td>작성일</td>
					<td>입고품종류</td>		
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items = "${matInList}" var = "matIn" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td><a href="mat.do?command=mat_in_view&inSq=${matIn.inSq}">${matIn.inSq}</a></td>
						<td>${matIn.empNm}</td>
						<td>${matIn.purNm}</td>
						<td><fmt:formatDate value="${matIn.inDt}" pattern="yyyy.MM.dd" /></td>
						<td>${matIn.cntDe}개</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
</body>
</html>