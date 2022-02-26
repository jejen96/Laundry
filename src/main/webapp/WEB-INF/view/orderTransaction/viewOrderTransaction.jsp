<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<title>Transaksi Order</title>
<jsp:include page="../../include/css-main.jsp" />
</head>
<jsp:include page="../../include/header.jsp" />
<jsp:include page="../../include/sidebar-menu.jsp" />
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			Data<small>Order</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			<!-- <li class="active">PIB</li> -->
		</ol>
	</section>


	<section class="content">


<div class="box box-info">
            <div class="box-header with-border">
              <h3 class="box-title">List Data Order</h3>
            </div>
            <div class="box-footer">
            <a href="<c:url value="/order/addorder" />">
                <button id="tambah" type="button" class="btn btn-info pull-wight"><i class="fa fa-input"></i>Input Pelanggan</button>
                </a>
            </div>  
              
            <!-- /.box-header -->
            <!-- form start -->
            
            
              <div class="box-body">
               
               <fmt:setLocale value = "en_US"/>
                
                <div class="form-group">
                <table id="example1" class="table table-bordered table-striped">
                <tr>
                  	<th>ID</th>
                  	<th>Nama Pelanggan</th>
                  	<th>Alamat Alamat Pelanggan</th>
                  	<th>Kontak Pelanggan</th>
                  	<th>Tanggal PickUp</th>
                  	<th>Total Harga</th>
                  	<th>Status</th>
                  	<th>Aksi</th>
                 </tr>
                 <c:forEach var="listDataOrder" items="${listDataOrder}">
                 <tr>
                 	<td>${no}</td>	
                 	<td>${listDataOrder.nameOrder}</td>
                 	<td>${listDataOrder.addressOrder}</td>
                 	<td>${listDataOrder.phoneNumberOrder}</td>
                 	<td><fmt:formatDate pattern = "dd-MM-yyyy" value="${listDataOrder.timePickup}"/></td>
                 	<td><fmt:formatNumber value = "${listDataOrder.totalAmountOrder}" type = "currency" currencySymbol="Rp."/></td>
                 	<td>${listDataOrder.roleTransaction.nameRoleTransaction}</td>
                 	
                 	<c:if test = "${listDataOrder.roleTransaction.id=='1'}">
                 	<td><a href="getById/${listDataOrder.id}" class="btn btn-default">Tambah Item</a></td> 
                 	</c:if>
                 	
                 	<c:if test = "${listDataOrder.roleTransaction.id=='2'}">
                 	<td><a href="${listDataOrder.id}" class="btn btn-default"><i class="fa fa-play"></i>Selesai Pencucian</a></td> 
                 	</c:if>
                 	
                 	<c:if test = "${listDataOrder.roleTransaction.id=='3'}">
                 	<td> <button type="button" class="btn btn-info pull-wight" data-toggle="modal" data-target="#myModal">Bayar</button></td> 
                 	
                 	 <div class="modal fade" id="myModal" role="dialog">
					    <div class="modal-dialog modal-sm">
					      <div class="modal-content">
					        <div class="modal-header">
					          <button type="button" class="close" data-dismiss="modal">&times;</button>
					          <h4 class="modal-title">Pembayaran</h4>
					        </div>
					        <div class="modal-body">
					        
					        <div class="form-group">
			                  <p>Harus Dibayar : <br>
					          <input type="text" id="total" value = "${listDataOrder.totalAmountOrder}" disabled>
							  </p>
							</div>
							<div class="form-group">
			                  <p>Uang Customer : <br>
			                   <input type="text" id="pay" placeholder="Rp.">
			                   </p>
			                </div>
			                <div class="form-group">
			                  <p>Kembalian : <br>
			                    <input type="text" id="change" placeholder="Rp." disabled>
			                   </p>
			                </div>
					        </div>
					        <div class="modal-footer">
					          <a href="${listDataOrder.id}" class="btn btn-default">Bayar</a>
					          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					        </div>
					      </div>
					    </div>
					  </div>
					  </c:if>

                 	<c:if test = "${listDataOrder.roleTransaction.id=='4'}">
                 	<td><a href="report" class="btn btn-default">Kwitnasi</a></td> 
                 	</c:if>
                 	
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
                 	 
                 <script type="text/javascript">
                    $(document).ready(function() {
                        $("#total, #pay").keyup(function() {
                            var total  = $("#total").val();
                            var pay = $("#pay").val();

                            var change = parseInt(pay) - parseInt(total);
                            $("#change").val(change);
                        });
                    });
                </script>
</body>
</html>
