<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> --%>
<!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="<c:url value="/resources/img/user2-160x160.jpg" />" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>${session.user.fullname}</p>
          <a href="#"><i class="fa fa-circle text-success"></i> ${session.user.roleNames} </a>
        </div>
      </div>
      
      <!-- /.search form -->
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu" data-widget="tree">
      	<c:if test="${session.isAuthorized(1) || session.isAuthorized(2)}">
	      	<c:choose>
	        <c:when test="${menu == 200}">
		        <li class="active">
	        </c:when>
	        <c:otherwise>
		    	<li>    
	        </c:otherwise>
	        </c:choose>
	          <a href="<c:url value="/dashboard/summary" />">
	            <i class="fa fa-dashboard"></i> <span>Dashboard</span>
	          </a>
	        </li>
        </c:if>
        
       <!-- SIDEBAR USER MANAGEMENT -->
        <%-- <c:choose>
	        <c:when test="${menu == 1}">
		        <li class="active">
	        </c:when>
	        <c:otherwise>
		<li>    
	        </c:otherwise>
        </c:choose>
          <a href="<c:url value="/dashboard" />">
            <i class="fa fa-user"></i> <span>Dashboard Management</span>
            <span class="pull-right-container">
              <!-- <small class="label pull-right bg-red">3</small> -->
            </span>
          </a>
        </li> --%>
       
        
        <!-- SIDEBAR USER MANAGEMENT -->
		
		<li class="treeview">
          <a href="#">
            <i class="fa fa-pie-chart"></i>
            <span>Master Data</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
             <c:choose>
	        <c:when test="${menu == 2}">
		        <li class="active">
	        </c:when>
	        <c:otherwise>
			    <li>    
	        </c:otherwise>
        </c:choose>
          <a href="<c:url value="/pricelist/viewpricelist" />">
            <i class="fa fa-user"></i> <span>Master Price List</span>
            <span class="pull-right-container">
              <!-- <small class="label pull-right bg-red">3</small> -->
            </span>
          </a>
          
          <c:choose>
	        <c:when test="${menu == 4}">
		        <li class="active">
	        </c:when>
	        <c:otherwise>
			    <li>    
	        </c:otherwise>
	    </c:choose>
	          <a href="<c:url value="/outlet/viewoutlet" />"> <!-- change value -->
	            <i class="fa fa-tags"></i> <span>Master outlet</span>
	          </a>
          
          </ul>
        </li>
        
        
        
        <!-- SIDEBAR USER MANAGEMENT -->
		
		<li class="treeview">
          <a href="#">
            <i class="fa fa-pie-chart"></i>
            <span>Transaksi</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
             
		<c:choose>
	        <c:when test="${menu == 3}">
		        <li class="active">
	        </c:when>
	        <c:otherwise>
		    	<li>    
	        </c:otherwise>
	    </c:choose>
	    <a href="<c:url value="/order/addorder" />"> <!-- change value -->
	            <i class="fa fa-tags"></i> <span>Input Order</span>
	          </a>
        </li>
        
       
        <c:choose>
	        <c:when test="${menu == 4}">
		        <li class="active">
	        </c:when>
	        <c:otherwise>
			    <li>    
	        </c:otherwise>
	    </c:choose>
	          <a href="<c:url value="/order/vieworder" />"> <!-- change value -->
	            <i class="fa fa-folder-open-o"></i> <span>Lihat Order</span>
	          </a>
        </li>
        
        <c:choose>
	        <c:when test="${menu == 5}">
		        <li class="active">
	        </c:when>
	        <c:otherwise>
			    <li>    
	        </c:otherwise>
	    </c:choose>
	          <a href="<c:url value="/location/viewlocation" />"> <!-- change value -->
	            <i class="fa fa-folder"></i> <span>Lihat Lokasi</span>
	          </a>
        </li>
        
     
    <!-- REPORT NAVIGATION -->   

	<li class="treeview">
          <a href="#">
            <i class="fa fa-align-center"></i>
            <span>Transactional Menu</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
		       <li><a href="<c:url value="/employee" />"> <!-- change value --><i class="fa fa-male"></i> <span>Karyawan</span></a></li> 
		       <li><a href="<c:url value="/sallary"/>"> <i class="fa fa-share-square-o"></i> <span>Gaji</span></a></li>
		       <li><a href="<c:url value="/holiday"/>"> <i class="fa fa-crosshairs"></i> <span>Cuti</span></a></li>
		       <li><a href="<c:url value="/loan"/>"> <i class="fa fa-crosshairs"></i> <span>Pinjaman</span></a></li>
          </ul>
    </li>
 --%>
</section>
    <!-- /.sidebar -->
  </aside>