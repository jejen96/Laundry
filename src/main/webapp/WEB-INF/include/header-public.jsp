<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> --%>

<body class="hold-transition skin-green sidebar-mini">
<div class="wrapper">

  <header class="main-header">
    <!-- Logo -->
    <a href="<c:url value="/public"/>" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><img src="<c:url value="/resources/img/logo-icon.png" />" style="height:40px;" alt="logo"></span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><img src="<c:url value="/resources/img/logo-vertical.png" />" style="height:40px;" alt="logo"></span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <li class="notifications-menu">
            <a href="<c:url value="/login"/>">
              <i class="fa fa-user"></i> &nbsp;&nbsp;<b>Login</b>
            </a>
          </li>
          <!-- User Account: style can be found in dropdown.less -->
        </ul>
      </div>
    </nav>
  </header>