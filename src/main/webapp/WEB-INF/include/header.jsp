<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> --%>

<body class="hold-transition skin-green sidebar-mini">
<div class="wrapper">

  <header class="main-header">
    <!-- Logo -->
    <a href="<c:url value="/"/>" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><img src="<c:url value="/resources/img/logo-icon.png" />" style="height:40px;" alt="logo"></span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><img src="<c:url value="/resources/img/laundry.png" />" style="height:40px;" alt="logo"></span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>

      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <c:if test="${session.isAuthorized(1)}">
	          <li class="dropdown notifications-menu">
	            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
	              <i class="fa fa-gears"></i>
	            </a>
	            <ul class="dropdown-menu">
	              <li>
	                <!-- inner menu: contains the actual data -->
	                <ul class="menu">
	                  <li>
	                    <a href="<c:url value='/setting/sftp'/>">
	                      <i class="fa fa-gears text-aqua"></i> Pengaturan SFTP
	                    </a>
	                  </li>
	                </ul>
	              </li>
	            </ul>
	          </li>
          </c:if>
          
         
          <!-- User Account: style can be found in dropdown.less -->
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <img src="<c:url value="/resources/img/user2-160x160.jpg" />" class="user-image" alt="User Image">
              <span class="hidden-xs">${session.user.fullname}</span>
            </a>
            <ul class="dropdown-menu">
              <!-- User image -->
              <li class="user-header">
                <img src="<c:url value="/resources/img/user2-160x160.jpg" />" class="img-circle" alt="User Image">

                <p>
                  ${session.user.fullname}
                  <small>${session.user.roleNames}</small>
                </p>
              </li>
              <!-- Menu Body -->
              <!-- <li class="user-body">
                <div class="row">
                  <div class="col-xs-4 text-center">
                    <a href="#">Followers</a>
                  </div>
                  <div class="col-xs-4 text-center">
                    <a href="#">Sales</a>
                  </div>
                  <div class="col-xs-4 text-center">
                    <a href="#">Friends</a>
                  </div>
                </div>
                /.row
              </li> -->
              <!-- Menu Footer-->
              <li class="user-footer">
                <!-- <div class="pull-left">
                  <a href="#" class="btn btn-warning btn-flat">Profile</a>
                </div> -->
                <div class="pull-right">
                  <a href="<c:url value="/doLogout"/>" class="btn btn-danger btn-flat">Sign out</a>
                </div>
                <div class="pull-left">
                  <a href="<c:url value="/user-management/change-profile"/>" class="btn btn-warning btn-flat">Profile</a>
                </div>
                <div class="pull-left">
                  <a href="<c:url value="/user-management/change-password"/>" class="btn btn-warning btn-flat">Ubah Password</a>
                </div>
              </li>
            </ul>
          </li>
          <!-- Control Sidebar Toggle Button -->
          <!-- <li>
            <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
          </li> -->
        </ul>
      </div>
    </nav>
  </header>