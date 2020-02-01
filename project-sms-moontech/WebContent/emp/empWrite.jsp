<jsp:include page="/include/header.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!-- Page content -->
    <div class="container-fluid mt--7">
      <div class="row">
        <div class="col-xl-4 order-xl-2 mb-5 mb-xl-0">
          <div class="card card-profile shadow">
            <div class="row justify-content-center">
              <div class="col-lg-3 order-lg-2">
                <div class="card-profile-image">
                  <a href="#">
                    <img src="/resources/img/theme/team-4-800x800.jpg" class="rounded-circle">
                  </a>
                </div>
              </div>
            </div>
            <div class="card-header text-center border-0 pt-8 pt-md-4 pb-0 pb-md-4">
              <div class="d-flex justify-content-between">
                <a href="#" class="btn btn-sm btn-info mr-4">Connect</a>
                <a href="#" class="btn btn-sm btn-default float-right">Message</a>
              </div>
            </div>
            <div class="card-body pt-0 pt-md-4">
              <div class="row">
                <div class="col">
                  <div class="card-profile-stats d-flex justify-content-center mt-md-5">
                    <div>
                      <span class="heading">22</span>
                      <span class="description">Friends</span>
                    </div>
                    <div>
                      <span class="heading">10</span>
                      <span class="description">Photos</span>
                    </div>
                    <div>
                      <span class="heading">89</span>
                      <span class="description">Comments</span>
                    </div>
                  </div>
                </div>
              </div>
              <div class="text-center">
                <h3>
                  Jessica Jones<span class="font-weight-light">, 27</span>
                </h3>
                <div class="h5 font-weight-300">
                  <i class="ni location_pin mr-2"></i>Bucharest, Romania
                </div>
                <div class="h5 mt-4">
                  <i class="ni business_briefcase-24 mr-2"></i>Solution Manager - Creative Tim Officer
                </div>
                <div>
                  <i class="ni education_hat mr-2"></i>University of Computer Science
                </div>
                <hr class="my-4" />
                <p>Ryan — the name taken by Melbourne-raised, Brooklyn-based Nick Murphy — writes, performs and records all of his own music.</p>
                <a href="#">Show more</a>
              </div>
            </div>
          </div>
        </div>
        <div class="col-xl-8 order-xl-1">
          <div class="card bg-secondary shadow">
            <div class="card-header bg-white border-0">
              <div class="row align-items-center">
                <div class="col-8">
                  <h3 class="mb-0">직원등록</h3>
                </div>
                <div class="col-4 text-right">
                  <a href="#!" class="btn btn-sm btn-primary">Settings</a>
                </div>
              </div>
            </div>
            <div class="card-body">
              <form method= "post"  action = "emp.do">
                <h6 class="heading-small text-muted mb-4">User information</h6>
                <div class="pl-lg-4">
                  <div class="row">
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-email">직원번호</label>
                      <input type = "text"  name = "empNo"  class="form-control form-control-alternative"  disabled />
                      
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-username">직원명</label>
                      <input type = "text" name = "command" value = "emp_write" class="form-control form-control-alternative" > 
                      </div>
                    </div>
                  </div>
                  
                  
                  <div class="row">
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-first-name">전화번호</label>
                      <input type = "text"  name = "hp"  class="form-control form-control-alternative"/>
                      </div>
                    </div>
                    
                    
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-last-name">부서명</label>
                      <input type = "hidden"  name = "deptSq"  readonly/>
            <input type="text" name="deptNm" class="form-control form-control-alternative "/>
<div class="col text-right">
           <input type="button" value = "검색" onclick = "openPopUp()" class="btn btn-sm btn-primary"/>
                </div>
                      
                      </div>
                    </div>
                  </div>
                
                
                
                <!-- Address -->
                    <div class="row">
                      <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-last-name">직급</label>
                      <input type = "text"  name = "posi"  class="form-control form-control-alternative" />
                      
                      </div>
                    </div>
                    
                      <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-last-name">이메일</label>
                      <input type = "text"  name = "email" class="form-control form-control-alternative"/>
                      </div>
                    </div>
                    
                    </div>
                    
                    
                    
                <h6 class="heading-small text-muted mb-4">Contact information</h6>
                <div class="pl-lg-4">
                  <div class="row">
                    <div class="col-md-12">
                      <div class="form-group">
                        <label class="form-control-label" for="input-address">주소</label>
                      <input type = "text"  name = "address"  class="form-control form-control-alternative" /> <br>
                      <input type = "text"  name = "address"  class="form-control form-control-alternative" />
                      
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-lg-4">
                      <div class="form-group">
                        <label class="form-control-label" for="input-city">비밀번호</label>
                      <input type = "text" name = "pwd" class="form-control form-control-alternative"/>
                      </div>
                    </div>
               
                    
                  </div>
                </div>
                <hr class="my-4" />
                <!-- Description -->
                <div class="btn-wrapper text-center">
                <input type = "submit" value = "등록"  class="btn btn-sm btn-primary" >
                <input type = "button" value = "취소" onclick = "location.href='./emp.do?command=emp_list'" class="btn btn-sm btn-info mr-4" >
                
              </div>
              </form>
            </div>
          </div>
        </div>
      </div>
      
                </div>
                    </div>     
      
      <!-- Footer -->

<jsp:include page="/include/footer.jsp"></jsp:include>
