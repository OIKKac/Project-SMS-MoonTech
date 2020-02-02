<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<jsp:include page="/include/header.jsp"></jsp:include>


<jsp:useBean id="currTime" class="java.util.Date" />
<div>
	<div>입고서<hr></div>
	<fmt:forpartDate value="${currTime}" pattern="yyyy년 MM월 dd일" />
	<form role="form" method= "post" action = "part.do?command=part_in_write" name="frm" enctype="multipart/form-data">
		
		<table>
			<thead>
			<tr>
				<td><input type="text" name="empNo"  ></td>
				<td><input type="text" name="purSq"  ></td>
				
				<td><input type="hidden" name="sendValue" id="sendValue" ></td>
				<td><input type="hidden" name="inAmtValue" id="inAmtValue" ></td>
				<td>입고번호</td>
				<td><input type = "text" name = "inSq" value = "${partBuyInSq}" readonly></td>
			</tr>
			
			<tr>
				<td>매입처</td>
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
		                  <h3 class="mb-0">부품 선택</h3>
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
                	<c:forEach items = "${partStockList}" var = "part">
                		<tr>
                			<td>
                				<input type = "checkbox" name = "check" value="${part.partSq}">
                			<!-- 
                				<div class="custom-control custom-checkbox mb-3">
  									<input class="custom-control-input" id="customCheck1" type="checkbox">
 									<label class="custom-control-label" for="customCheck1"></label>
								</div> -->	
								
                			</td>
                			<td>
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
                       		</td>
                			<th scope = "row">${part.partNm}</th>
                			
                			<td>${part.stockAmt}</td>
                			
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
          
          var partSq = $(this).val();
          
          
           
          var picture = td.eq(1).text();
          var partNm = td.eq(2).text();
          var stockAmt = td.eq(3).text();
          var row = "<tr>"
                + "<td>"
                + "<input type=\"checkbox\" class=\"checkBox2\" name=\"check2\" value=\"" + partSq + "\"" + ">"
                + "</td>" + "<td class=\"picture\">" + picture
                + "</td>" + "<td class=\"partNm\">" + partNm
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
       
       var partNm = td.eq(2).text();
       
       var stockAmt = td.eq(3).text();
       
       var partSq = $(this).val();
       
       
       
       var row = "<tr class=\"stu"+ partSq +"\"> "
       + "<td>"
       + "<input type=\"checkbox\" class=\"checkBox\" name=\"check\" value=\"" + partSq + "\"" + ">"
       + "</td>" + "<td>" + picture
       + "</td>" + "<td>" + partNm
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


