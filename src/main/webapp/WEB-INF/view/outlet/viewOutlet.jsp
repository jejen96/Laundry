<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<title>Master Price List</title>
<jsp:include page="../../include/css-main.jsp" />
</head>
<jsp:include page="../../include/header.jsp" />
<jsp:include page="../../include/sidebar-menu.jsp" />
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			Data<small>Outlet</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			<!-- <li class="active">PIB</li> -->
		</ol>
	</section>


	<section class="content">


<div class="box box-info">
            <div class="box-header with-border">
              <h3 class="box-title">Menampilkan Data</h3>
            </div>
            <div class="box-footer">
            <a href="<c:url value="/outlet/addoutlet" />">
                <button id="tambah" type="button" class="btn btn-info pull-wight">Tambah</button>
                </a>
            </div>  
              
            <!-- /.box-header -->
            <!-- form start -->
            
              <div class="box-body">
                
                <div class="form-group">
                <table id="example1" class="table table-bordered table-striped">
                <tr>
                  	<th>No</th>
                  	<th>Nama Outlet</th>
                  	<th>Alamat Lengkap Outlet</th>
                  	<th>Kontak Outlet</th>
                  	<th>Titik Kordinat Latitude</th>
                  	<th>Titik Kordinat Longitude</th>
                  	<th>Edit</th>
                 </tr>
                 <c:forEach var="listDataOutlet" items="${listDataOutlet}">
                 <tr>
                 	<td>${no}</td>
                 	<td>${listDataOutlet.nameOutlet}</td>
                 	<td>${listDataOutlet.addressOutlet}</td>
                 	<td>${listDataOutlet.phoneNumberOutlet}</td>
                 	<td>${listDataOutlet.lat}</td>
                 	<td>${listDataOutlet.lng}</td>
                 	<td><a href="getById/${listDataOutlet.id}">Edit</a></td> 
                 </tr>
                 <c:set var="no" value="${no+1}" />
                 </c:forEach>
                 </table>
                  
                </div>
                </div>  
          </div>
	</section>
</div>
<!-- /.content-wrapper -->
<jsp:include page="../../include/footer.jsp" />
<jsp:include page="../../include/aside.jsp" />
<jsp:include page="../../include/js-main.jsp" />
<script>

</script>
</body>
</html>
