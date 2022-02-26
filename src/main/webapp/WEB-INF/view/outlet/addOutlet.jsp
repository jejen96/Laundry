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
<title>Master Outlet</title>
<jsp:include page="../../include/css-main.jsp" />
</head>
<jsp:include page="../../include/header.jsp" />
<jsp:include page="../../include/sidebar-menu.jsp" />
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			Input Data<small>Outlet</small>
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
                  <label class="col-sm-2 control-label">Nama Outlet</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="nameOutlet" placeholder="Nama Outlet">
                  </div>
                </div>
                
                <div class="form-group">
                  <label class="col-sm-2 control-label">Alamat Lengkap Outlet</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="addressOutlet" placeholder="Alamat Outlet Lengkap">
                  </div>
                </div>
                
                <div class="form-group">
                  <label class="col-sm-2 control-label">Kontak Outlet</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="phoneNumberOutlet" placeholder="Kontak Outlet">
                  </div>
                </div>
                
                <div class="form-group">
                  <label class="col-sm-2 control-label">Titik Kordinat Latitude</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="lat" placeholder="-6.906281">
                  </div>
                </div>
                
                <div class="form-group">
                  <label class="col-sm-2 control-label">Titik Kordinat Longitude</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="lng" placeholder="107.597680">
                  </div>
              </div>
              
              </div>
              <!-- /.box-body -->
              <div class="box-footer">
                <button id="save" type="button" class="btn btn-info pull-right">Simpan</button>
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
	var id = $('#id').val();
	var nameOutlet = $('#nameOutlet').val();
	var addressOutlet = $('#addressOutlet').val();
	var phoneNumberOutlet = $('#phoneNumberOutlet').val();
	var lat = $('#lat').val();
	var lng = $('#lng').val();
	
	if(nameOutlet == ""){
		alert('Isi Nama Outlet');
		return false;
		}
	if(addressOutlet == ""){
		alert('Isi Alamat Outlet');
		return false;
		}
	if(phoneNumberOutlet == ""){
		alert('Isi Kontak Outlet');
		return false;
		}
	if(lat == ""){
		alert('Titik Kordinat Latitude');
		return false;
		}
	if(lng == ""){
		alert('Titik Kordinat Longitude');
		return false;
		}
	
	var data = {
		'id' : id,
		'nameOutlet' : nameOutlet,
		'addressOutlet' : addressOutlet,
		'phoneNumberOutlet' : phoneNumberOutlet,
		'lat':lat,
		'lng':lng
		
    };
	
    var request = $.ajax({
        url: '<c:url value="${view}/saveoutlet"/>',
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
        	window.location.href = '<c:url value="${view}/viewoutlet"/>';
        }
        
    });
    request.fail(function (jqXHR, textStatus) {
        
        $('#save').removeAttr('disabled');
    });
});

</script>
</body>
</html>
