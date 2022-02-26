<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<title>From Order</title>
<jsp:include page="../../include/css-main.jsp" />
</head>
<jsp:include page="../../include/header.jsp" />
<jsp:include page="../../include/sidebar-menu.jsp" />
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			Input Data<small>Order</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			<!-- <li class="active">PIB</li> -->
		</ol>
	</section>

	<section class="content">

<div class="box box-info">
            <div class="box-header with-border">
              <h3 class="box-title">Tambah Data</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form class="form-horizontal">
              <div class="box-body">
                
                <div class="form-group">
                  <label class="col-sm-2 control-label">Nama Pelanggan</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="nameOrder" placeholder="Nama Pelanggan">
                  </div>
                </div>
                
                <div class="form-group">
                  <label class="col-sm-2 control-label">Alamat Pelanggan</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="addressOrder" placeholder="Alamat Pelanggan">
                  </div>
                </div>
                
                <div class="form-group">
                  <label class="col-sm-2 control-label">Kontak Pelanggan</label>
                  <div class="col-sm-10">
                    <input type="number" class="form-control" id="phoneNumberOrder" placeholder="Kontak Pelanggan">
                  </div>
                </div>
                
                 <div class="form-group">
                  <label class="col-sm-2 control-label">Tanggal Penjemputan</label>
                  <div class="col-sm-10">
                    <input type="date" class="form-control" id="date" >
                  </div>
                </div>
               
               
               </div>
              <!-- /.box-body -->
              <div class="box-footer">
                <button id="save" type="button" class="btn btn-info pull-right"><i class="fa fa-save"></i>Simpan</button>
              </div>
              <!-- /.box-footer -->
            </form>
          </div>
	</section>
</div>
<!-- /.content-wrapper -->
<jsp:include page="../../include/footer.jsp" />
<jsp:include page="../../include/aside.jsp" />
<jsp:include page="../../include/js-main.jsp" />
<script>

$('#save').click(function () {
	var idOrderTransaction = $('#id').val();
	var nameOrder = $('#nameOrder').val();
	var addressOrder = $('#addressOrder').val();
	var phoneNumberOrder = $('#phoneNumberOrder').val();
	var timePickup = $('#date').val();
	
	if(nameOrder == ""){
		alert('Isi Nama Pelanggan');
		return false;
		}
	if(addressOrder == ""){
		alert('Isi Alamat Pelanggan');
		return false;
		}
	if(phoneNumberOrder == ""){
		alert('Isi Kontak Pelanggan');
		return false;
		}
	if(phoneNumberOrder == "String"){
		alert('Isi angka Kontak pelanggan');
		return false;
		}
	if(timePickup == ""){
		alert('Isi Tanggal Penjemputan');
		return false;
		}
	
	var data = {
		'idOrderTransaction' : idOrderTransaction,
		'nameOrder' : nameOrder,
		'addressOrder' : addressOrder,
		'phoneNumberOrder' : phoneNumberOrder,
		'timePickup' : timePickup
		
    };
	
    var request = $.ajax({
        url: '<c:url value="${view}/saveorder"/>',
        timeout: 60000,
        datatype: 'json',
        contentType: 'application/json',
        type: 'post',
        data : JSON.stringify(data)
    });

    request.always(function () {
        $('#save').attr('disabled', true);
    });
    request.done(function (response) {
        
        $('#save').removeAttr('disabled');
	    
        if(!response.success){//jika gagal save
        	alert(response.message); 
        }else{
        	alert("Berhasil disimpan!"); //jika berhasil save
        	window.location.href = '<c:url value="${view}/vieworder"/>';
        }
        
    });
    request.fail(function (jqXHR, textStatus) {
        
        $('#save').removeAttr('disabled');
    });
});

</script>
</body>
</html>
