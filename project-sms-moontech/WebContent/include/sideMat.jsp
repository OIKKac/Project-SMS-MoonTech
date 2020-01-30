<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//reN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">



 <!-- Favicon -->
 <link href="../bootstrap/argon-dashboard-master/assets/img/brand/favicon.png" rel="icon" type="image/png">
 <!-- Fonts -->
 <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
 <!-- Icons -->
 <link href="../bootstrap/argon-dashboard-master/assets/js/plugins/nucleo/css/nucleo.css" rel="stylesheet" />
 <link href="../bootstrap/argon-dashboard-master/assets/js/plugins/@fortawesome/fontawesome-free/css/all.min.css" rel="stylesheet" />
 <!-- CSS Files -->
 <link href="../bootstrap/argon-dashboard-master/assets/css/argon-dashboard.css?v=1.1.1" rel="stylesheet" />
  
    <!--   Core   -->
  <script src="../bootstrap/argon-dashboard-master/assets/js/plugins/jquery/dist/jquery.min.js"></script>
  <script src="../bootstrap/argon-dashboard-master/assets/js/plugins/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
  <!--   Optional JS   -->
  <script src="../bootstrap/argon-dashboard-master/assets/js/plugins/chart.js/dist/Chart.min.js"></script>
  <script src="../bootstrap/argon-dashboard-master/assets/js/plugins/chart.js/dist/Chart.extension.js"></script>
  <!--   Argon JS   -->
  <script src="../bootstrap/argon-dashboard-master/assets/js/argon-dashboard.min.js?v=1.1.1"></script>
  <script src="https://cdn.trackjs.com/agent/v3/latest/t.js"></script>
  <script>
    window.TrackJS &&
      TrackJS.install({
        token: "ee6fab19c5a04ac1a32a645abde4613a",
        application: "argon-dashboard-free"
      });
  </script>
  
  
</head>

<body class="">
  <nav class="navbar navbar-vertical fixed-left navbar-expand-md navbar-light bg-white" id="sidenav-main">
    <div class="container-fluid">
      <!-- Toggler -->
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#sidenav-collapse-main" aria-controls="sidenav-main" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <!-- Brand -->
      <a class="navbar-brand pt-0" href="./index.html">
        <img src="../bootstrap/argon-dashboard-master/assets/img/brand/blue.png" class="navbar-brand-img" alt="...">
      </a>
      <!-- User -->
      <ul class="nav align-items-center d-md-none">
        <li class="nav-item dropdown">
          <a class="nav-link nav-link-icon" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="ni ni-bell-55"></i>
          </a>
          <div class="dropdown-menu dropdown-menu-arrow dropdown-menu-right" aria-labelledby="navbar-default_dropdown_1">
            <a class="dropdown-item" href="#">Action</a>
            <a class="dropdown-item" href="#">Another action</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">Something else here</a>
          </div>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <div class="media align-items-center">
              <span class="avatar avatar-sm rounded-circle">
                <img alt="Image placeholder" src="../bootstrap/argon-dashboard-master/assets/img/theme/team-1-800x800.jpg
">
              </span>
            </div>W
          </a>

        </li>
      </ul>
      <!-- Collapse -->
      <div class="collapse navbar-collapse" id="sidenav-collapse-main">
        <!-- Collapse header -->
        <div class="navbar-collapse-header d-md-none">
          <div class="row">
            <div class="col-6 collapse-brand">
              <a href="./index.html">
                <img src="../bootstrap/argon-dashboard-master/assets/img/brand/blue.png">
              </a>
            </div>
            <div class="col-6 collapse-close">
              <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#sidenav-collapse-main" aria-controls="sidenav-main" aria-expanded="false" aria-label="Toggle sidenav">
                <span></span>
                <span></span>
              </button>
            </div>
          </div>
        </div>
        <!-- Form -->
        <form class="mt-4 mb-3 d-md-none">
          <div class="input-group input-group-rounded input-group-merge">
            <input type="search" class="form-control form-control-rounded form-control-prepended" placeholder="Search" aria-label="Search">
            <div class="input-group-prepend">
              <div class="input-group-text">
                <span class="fa fa-search"></span>
              </div>
            </div>
          </div>
        </form>
        
        
        
        <!-- Divider -->
        <hr class="my-3 text-blue">
        
    	<ul class = "navbar-nav">
    	
        	<li class="nav-item  ">
            	<a class="nav-link   " href="./index.html">
            		<i class="ni "></i>내부 정보
           		</a>
         	</li>
          
        	<li class="nav-item  active ">
            	<a class="nav-link  active " href="../mat.do?command=mat_list">
            		<i class="ni text-primary"></i>재료d
           		</a>
         	</li>
          
        	<li class="nav-item  ">
            	<a class="nav-link   " href="./index.html">
            		<i class="ni "></i>부품
           		</a>
         	</li>          
          
        </ul>
        
      	<!-- Divider -->
        <hr class="my-3">
        

        
        
        <!-- Navigation -->
        <ul class="navbar-nav">
          <li class="nav-item  active ">
            <a class="nav-link  active " href="../mat.do?command=mat_list">
              <i class="ni ni-bullet-list-67 text-primary"></i> 재료 목록
            </a>
          </li>
          
          <li class="nav-item">
            <a class="nav-link " href="./examples/icons.html">
              <i class="ni ni-curved-next text-blue"></i> 구매요청
            </a>
          </li>   
          <li class="nav-item">
            <a class="nav-link " href="./examples/icons.html">
              <i class="ni ni-curved-next text-blue"></i> 출고지시
            </a>
          </li>   
          <li class="nav-item">
            <a class="nav-link " href="../mat.do?command=mat_buy">
              <i class="ni ni-basket text-blue"></i> 구매
            </a>
          </li> 
          <li class="nav-item">
            <a class="nav-link " href="../mat.do?command=mat_in">
              <i class="ni ni-bold-down text-blue"></i> 입고
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link " href="../mat.do?command=mat_out">
              <i class="ni ni-bold-up text-blue"></i> 출고
            </a>
          </li>
          
        </ul>
      </div>
    </div>
  </nav>
 

</body>

</html>