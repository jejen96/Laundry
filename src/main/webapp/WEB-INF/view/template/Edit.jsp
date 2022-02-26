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
<title>Master Sparepart</title>
<jsp:include page="../../include/css-main.jsp" />
</head>
<jsp:include page="../../include/header.jsp" />
<jsp:include page="../../include/sidebar-menu.jsp" />
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			Input Data<small>Sparepart</small>
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
                 
                <input type="hidden" class="form-control" id="id" name= "id" value="${bank.id}">
                
               <div class="form-group">
                  <label class="col-sm-2 control-label">Nama Bank</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="name" placeholder="Bank Name" value="${bank.name}">
                  </div>
                </div>
                
                <div class="form-group">
                  	<label class="col-sm-2 control-label">Supervisor</label>
                  	<div class="col-sm-4">
						<select id="supervisor" class="form-control pull-left">
							<c:forEach items="${supervisor}" var="supervisor">
								<c:choose>
									<c:when test="${supervisor.id == division.supervisor.id}">
											<option value="${supervisor.id}" selected="selected">${supervisor.nameSupervisor}</option>
									</c:when>
									<c:otherwise>
											<option value="${supervisor.id}" >${supervisor.nameSupervisor}</option>
									</c:otherwise>
								</c:choose>
							 </c:forEach>
						</select>
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
	var descpart = $('#descpart').val();
	var nopart = $('#nopart').val();
	var stockpart = $('#stockpart').val();
	var pricepart = $('#pricepart').val();
	var supplier = $('#supplier').val();
	var grouppart = $('#grouppart').val();
	
	var data = {
		'id' : id,
		'descpart' : descpart,
		'nopart' : nopart,
		'stockpart' : stockpart,
		'pricepart': pricepart,
		'supplier' : supplier,
		'grouppart' : grouppart
    };
    
    var request = $.ajax({
        url: '<c:url value="${view}/editpart"/>',
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
            alert('Gagal !!!');
        	alert(response.message); 
        }else{
        	alert("Berhasil disimpan!"); //jika berhasil save
        	window.location.href = '<c:url value="${view}/viewpart"/>';
        }
        
    });
    request.fail(function (jqXHR, textStatus) {
        
        $('#save').removeAttr('disabled');
    });
});

</script>
</body>
</html>
