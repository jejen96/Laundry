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
<title>Master Pricelist</title>
<jsp:include page="../../include/css-main.jsp" />
</head>
<jsp:include page="../../include/header.jsp" />
<jsp:include page="../../include/sidebar-menu.jsp" />
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			Edit Data<small>Price List</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			<!-- <li class="active">PIB</li> -->
		</ol>
	</section>


	<section class="content">


<div class="box box-info">
            <div class="box-header with-border">
              <h3 class="box-title">Edit Data</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form class="form-horizontal">
              <div class="box-body">
                
                    <input type="hidden" class="form-control" id="id" placeholder="id" value="${priceList.idPriceList}">
                
                 <div class="form-group">
                  <label class="col-sm-2 control-label">Nama Jasa Laundry</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="namePriceList" placeholder="Nama Jasa Laundry" value="${priceList.namePriceList}">
                  </div>
                </div>
                
                <div class="form-group">
                  <label class="col-sm-2 control-label">Harga Jasa Laundry</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="priceList" placeholder="Rp. Harga Jasa Laundry" value="${priceList.priceList}">
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
	var idPriceList = $('#id').val();
	var namePriceList = $('#namePriceList').val();
	var priceList = $('#priceList').val();
	
	if(namePriceList == ""){
		alert('Isi Nama Jasa Laundry');
		return false;
		}
	if(priceList == ""){
		alert('Isi Harga Jasa Laundry');
		return false;
		}
	
	var data = {
		'idPriceList' : idPriceList,
		'namePriceList' : namePriceList,
		'priceList' : priceList
    };
    
    var request = $.ajax({
        url: '<c:url value="${view}/savepricelist"/>',
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
        	window.location.href = '<c:url value="${view}/viewpricelist"/>';
        }
        
    });
    request.fail(function (jqXHR, textStatus) {
        
        $('#save').removeAttr('disabled');
    });
});

</script>
</body>
</html>
