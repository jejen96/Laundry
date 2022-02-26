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
<title>Order Item</title>
<jsp:include page="../../include/css-main.jsp" />
</head>
<jsp:include page="../../include/header.jsp" />
<jsp:include page="../../include/sidebar-menu.jsp" />
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			Edit Item<small>Order</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			<!-- <li class="active">PIB</li> -->
		</ol>
	</section>


	<section class="content">

<div class="box box-info">
            <div class="box-header with-border">
              <h3 class="box-title">Item Order</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form class="form-horizontal">
            
              <div class="box-body">
                
                	<input type="hidden" class="form-control" id="idSubOrderTransaction" value="${subOrderTransactions.idSubOrderTransaction}">
                	<input type="hidden" class="form-control" id="idOrder" value="${idOder}">
                	
                <div class="form-group">
                  <label class="col-sm-2 control-label">Price List</label>
                  <div class="col-sm-10">
                    <select class="form-control" id=priceOrder>
                     <c:forEach var="pricelist" items="${pricelist}">
	                    	<c:choose>
	                    		<c:when test="${pricelist.idPriceList == subOrderTransactions.priceOrder.idPriceList}">
	                    			<option value="${pricelist.idPriceList}" selected="selected"> ${pricelist.namePriceList} </option>
	                    		</c:when>
	                    		<c:otherwise>
	                    			<option value="${pricelist.idPriceList}"> ${pricelist.namePriceList} </option>
	                    		</c:otherwise>
	                    	</c:choose>
	                    </c:forEach>
                    </select>
                  </div>
                  </div>
                
                <div class="form-group">
                  <label class="col-sm-2 control-label">Berat / Satuan</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="kiloGram" placeholder="Berat / Satuan" value="${subOrderTransactions.kiloGram}">
                  </div>
                </div>
              </div>
              
              <!-- /.box-body -->
              <div class="box-footer">
              <c:if test="${orderTransaction.id == null}">
                	<button id="tambah" type="button" class="btn btn-info pull-right"><i class="fa fa-edit"></i>Edit Item</button>
               </c:if>
               
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

$('#tambah').click(function () {
	var idOrderTransaction = $('#idOrder').val();
	var idSubOrderTransaction = $('#idSubOrderTransaction').val();
	var priceOrder = $('#priceOrder').val();
	var kiloGram = $('#kiloGram').val();
	
	if(priceOrder == ""){
		alert('Pilih PriceList');
		return false;
		}
	if(kiloGram == ""){
		alert('Isi KG atau Satuan');
		return false;
		}
	
	var data = {
		'idOrderTransaction' : idOrderTransaction,
		'idSubOrderTransaction' : idSubOrderTransaction,
		'priceOrder' : priceOrder,
		'kiloGram' : kiloGram
		
    };
	
    var request = $.ajax({
        url: '<c:url value="${view}/tambah"/>',
        timeout: 60000,
        datatype: 'json',
        contentType: 'application/json',
        type: 'post',
        data : JSON.stringify(data)
    });
   
    request.always(function () {
        $('#tambah').attr('disabled', true);
        
    });
    
    request.done(function (response) {
        
        $('#tambah').removeAttr('disabled');
        
        if(!response.success){//jika gagal save
        	alert(response.message); 
        }else{
        	alert("Berhasil disimpan!"); //jika berhasil save
        	window.location.href = '<c:url value="${view}/getById/${idOrder}"/>';
        }
        
    });
    request.fail(function (jqXHR, textStatus) {
        
        $('#tambah').removeAttr('disabled');
    });
});

</script>
</body>
</html>
