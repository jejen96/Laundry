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
			Data<small>User</small>
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
              
            <!-- /.box-header -->
            <!-- form start -->
            
              <div class="box-body">
                
                <div class="form-group">
                <table id="example1" class="table table-bordered table-striped">
                <tr>
                  	<th>ID</th>
                  	<th>Username</th>
                  	<th>Password</th>
                  	<th>Email</th>
                  	<th>Phone</th>
                  	<th>Country</th>
                  	<th>City</th>
                  	<th>Post Code</th>
                  	<th>Name </th>
                  	<th>Address</th>
                 </tr>
                 <c:forEach var="listUser" items="${listUser}">
                 <tr>
                 	<td>${listUser.id}</td>
                 	<td>${listUser.username}</td>
                 	<td>${listUser.password}</td>
                 	<td>${listUser.email}</td>
                 	<td>${listUser.phone}</td>
                 	<td>${listUser.country}</td>
                 	<td>${listUser.city}</td>
                 	<td>${listUser.postcode}</td>
                 	<td>${listUser.name}</td>
                 	<td>${listUser.address}</td>
                 </tr>
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
