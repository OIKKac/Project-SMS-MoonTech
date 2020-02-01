<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<jsp:include page="/include/header.jsp"></jsp:include>


<jsp:useBean id="currTime" class="java.util.Date" />
<div>
	<div>입고서<hr></div>
	<fmt:formatDate value="${currTime}" pattern="yyyy년 MM월 dd일" />
	<form role="form" method= "post" action = "mat.do?command=mat_in_write">
		
		<table>
			<thead>
			<tr>
				<td><input type="text" name="empNo"  ></td>
				<td><input type="text" name="purSq"  ></td>
				
				<td><input type="hidden" name="sendValue" id="sendValue" ></td>
				<td><input type="hidden" name="inAmtValue" id="inAmtValue" ></td>
				<td>입고번호</td>
				<td><input type = "text" name = "inSq" value = "${matInSq}" readonly></td>
			</tr>
			
			<tr>
				<td>거래처</td>
				<td><input type = "text" name = "purNm"></td>
			</tr>
			</thead>
			<tr>
		
		</table>
		
		
		<div class="container">
		  <div class="row">
		    <div class="col">
		      <span>
		      
		      <div class="col-xl-auto">
		          <div class="card shadow">
		            <div class="card-header border-0">
		              <div class="row align-items-center">
		                <div class="col">
		                  <h3 class="mb-0">재료 선택</h3>
		                </div>
		               
		              </div>
		            </div>
		            <div class="table-responsive">
		             

		             
              <!-- Projects table -->
              <table class="table align-items-center table-flushr" id="stuList" >
                <thead class="thead-light">
                  <tr>
                 	 <div class="col-xl-auto">
				      <div class="form-group">
				        <div class="input-group mb-4">
				          <div class="input-group-prepend">
				            <span class="input-group-text"><i class="ni ni-zoom-split-in"></i></span>
				          </div>
				          <input class="form-control" placeholder="Search" type="text">
				        </div>
				      </div>
				      </div>
                  </tr>
                </thead>
                
                <tbody>
                	<c:forEach items = "${matStockList}" var = "mat">
                		<tr>
                			<td>
                				<input type = "checkbox" name = "check" value="${mat.matSq}">
                			<!-- 
                				<div class="custom-control custom-checkbox mb-3">
  									<input class="custom-control-input" id="customCheck1" type="checkbox">
 									<label class="custom-control-label" for="customCheck1"></label>
								</div> -->	
								
                			</td>
                			<td>
                				<a href="#" class="avatar rounded-circle mr-3">
                          			<img alt="Image placeholder" src="../assets/img/theme/bootstrap.jpg">
                        		</a>
                       		</td>
                			<th scope = "row">${mat.matNm}</th>
                			
                			<td>${mat.stockAmt}</td>
                			
                		</tr>
                	</c:forEach>
                </tbody>
              </table> 
			<input type = "button" id = "add" value = "추가">
			<input type = "button" id = "delete" value = "삭제">


            </div>
          </div>
        </div></span>
    </div>
    <div class="col">
      <span><div class="col-xl-auto">
          <div class="card shadow">
            <div class="card-header border-0">
              <div class="row align-items-center">
                <div class="col">
                  <h3 class="mb-0">Social traffic</h3>
                </div>
                <div class="col text-right">
                  <a href="#!" class="btn btn-sm btn-primary">See all</a>
                </div>
              </div>
            </div>
            <div class="table-responsive">
            
              <!-- Projects table -->
              <table class="table align-items-center table-flush" id="attList">
                <thead class="thead-light">
               
                </thead>
                
                <tbody>
                  
                </tbody>
              </table>
              
            </div>
          </div>
        </div></span>
    </div>
   	<input type="button" id="btn-submit" value="보내기">
	</form>
</div>	


<script>


 
 // 추가
 $("#add").click(function() {
       var checkbox = $("input[name=check]:checked");
       checkbox.each(function() {
          
          var tr = $(this).parent().parent();
          
          var td = tr.children();
          
          var matSq = $(this).val();
          
          
           
          var picture = td.eq(1).text();
          var matNm = td.eq(2).text();
          var stockAmt = td.eq(3).text();
          var row = "<tr>"
                + "<td>"
                + "<input type=\"checkbox\" class=\"checkBox2\" name=\"check2\" value=\"" + matSq + "\"" + ">"
                + "</td>" + "<td class=\"picture\">" + picture
                + "</td>" + "<td class=\"matNm\">" + matNm
                + "</td>" + "<td class=\"stockAmt\">" + stockAmt
                + "</td>" + "<td><input type=\"text\" class=\"inAmt\" value=\"0\"></td>" +
                "</tr>";
          // 숨긴 값의 체크박스를 false 상태로 바꿈
          $(this).prop("checked", false);
          tr.remove();
          
          $("#attList > tbody").append(row);
          
          $("#allCheck1").prop("checked", false);
          
          
       })
       
 
 });
 
 //삭제
 $("#delete").click(function() {
    var checkbox = $("input[name=check2]:checked");
    checkbox.each(function() {
       
       var tr = $(this).parent().parent();
       
       var td = tr.children();
       
       var picture = td.eq(1).text();
       
       var matNm = td.eq(2).text();
       
       var stockAmt = td.eq(3).text();
       
       var matSq = $(this).val();
       
       
       
       var row = "<tr class=\"stu"+ matSq +"\"> "
       + "<td>"
       + "<input type=\"checkbox\" class=\"checkBox\" name=\"check\" value=\"" + matSq + "\"" + ">"
       + "</td>" + "<td>" + picture
       + "</td>" + "<td>" + matNm
       + "</td>" + "<td>" + stockAmt
       + "</td>" + "</tr>";
       
 // 숨긴 값의 체크박스를 false 상태로 바꿈
 $(this).prop("checked", false);
 tr.remove();
 $("#stuList > tbody").append(row);
 
 $("#allCheck2").prop("checked", false);

 
    })
    

});
 
//submit 버튼
$(document).ready(function(){
	
	var formObj = $("form[role='form']");

	$("#btn-submit").on("click", function(){
		
		 
		var send_array1 = Array();
		var send_array2 = Array();
		
		
		var send_cnt = 0;

		var chkbox = $(".checkBox2");
		var inAmt = $(".inAmt");
		
		for(i=0; i<chkbox.length; i++) {
	        send_array1[send_cnt] = chkbox[i].value;
	        send_array2[send_cnt] = inAmt[i].value;
	        
	        send_cnt++;
		}
		$("#sendValue").val(send_array1);
		$("#inAmtValue").val(send_array2);
		formObj.submit();
		
	});
});
		
</script>



<jsp:include page="/include/footer.jsp"></jsp:include>


