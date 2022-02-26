<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> --%>	
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<title>Location Outlet</title>
<jsp:include page="../../include/css-main.jsp" />
<style>
	#map{
		height: 400px;
		width: 100%;
	}
</style>
</head>
<jsp:include page="../../include/header.jsp" />
<jsp:include page="../../include/sidebar-menu.jsp" />
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			Lokasi <small>Outlet</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
		</ol>
	</section>

	<section class="content">

<div class="box box-info">
            <div class="box-header with-border">
              <h3 class="box-title">Lokasi Outlet</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form class="form-horizontal">
            
              <div class="box-body">
                   <div id="map"></div>
                   
              </div>
              <div id="output"></div>
              </form>
              
              <form class="form-horizontal">
              <div class="box-body">
              <div class="form-group">
                  <label class="col-sm-2 control-label">Masukan Alamat Anda</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="addressCustomer" placeholder="Alamat Anda">
                  </div>
               </div>
               
               <div class="box-footer">
                <input onclick="cari()" type="button"  value="cari" class="btn btn-info pull-right">
              </div>
              <div id="output"></div>
              
              </div>
              </form>
               
               
               
               
              </div>
         </section> 
         
        
         
         
         <%-- <form method="post" 
         action='<c:url value="uploadExcelFile"/>' enctype="multipart/form-data">
			    <input type="file" name="file" accept=".xls,.xlsx" /> <input
			      type="submit" value="Upload file" />
		 </form> --%>
</div>
<!-- /.content-wrapper -->
<jsp:include page="../../include/footer.jsp" />
<jsp:include page="../../include/aside.jsp" />
<jsp:include page="../../include/js-main.jsp" />
<script>
      function initMap() {
        var bounds = new google.maps.LatLngBounds;
        var markersArray = [];

        var origin1 = {lat: -6.906390, lng: 107.655655};
        var origin2 = 'Jl. Moh. Ento No.38, Padasuka, Kec. Cibeunying Kidul, Kota Bandung, Jawa Barat 40125';
        var destinationA = 'Jalan Bojong Koneng Atas.no 22, Cikutra,, cimenyan, Cibeunying, Kec. Cimenyan, Bandung, Jawa Barat 40191';
        var destinationB = {lat: -6.876933, lng:  107.632889};

        var destinationIcon = 'https://chart.googleapis.com/chart?' +
            'chst=d_map_pin_letter&chld=D|FF0000|000000';
        var originIcon = 'https://chart.googleapis.com/chart?' +
            'chst=d_map_pin_letter&chld=O|FFFF00|000000';
        var map = new google.maps.Map(document.getElementById('map'), {
          center: {lat: -6.905567, lng: 107.646580},
          zoom: 10
        });
        var geocoder = new google.maps.Geocoder;

        var service = new google.maps.DistanceMatrixService;
        service.getDistanceMatrix({
          origins: [origin1, origin2],
          destinations: [destinationA, destinationB],
          travelMode: 'DRIVING',
          unitSystem: google.maps.UnitSystem.METRIC,
          avoidHighways: false,
          avoidTolls: false
        }, function(response, status) {
          if (status !== 'OK') {
            alert('Error was: ' + status);
          } else {
            var originList = response.originAddresses;
            var destinationList = response.destinationAddresses;
            var outputDiv = document.getElementById('output');
            outputDiv.innerHTML = '';
            deleteMarkers(markersArray);

            var showGeocodedAddressOnMap = function(asDestination) {
              var icon = asDestination ? destinationIcon : originIcon;
              return function(results, status) {
                if (status === 'OK') {
                  map.fitBounds(bounds.extend(results[0].geometry.location));
                  markersArray.push(new google.maps.Marker({
                    map: map,
                    position: results[0].geometry.location,
                    icon: icon
                  }));
                } else {
                  alert('Geocode was not successful due to: ' + status);
                }
              };
            };

            for (var i = 0; i < originList.length; i++) {
              var results = response.rows[i].elements;
              geocoder.geocode({'address': originList[i]},
                  showGeocodedAddressOnMap(false));
              for (var j = 0; j < results.length; j++) {
                geocoder.geocode({'address': destinationList[j]},
                    showGeocodedAddressOnMap(true));
                outputDiv.innerHTML += originList[i] + ' to ' + destinationList[j] +
                    ': ' + results[j].distance.text + ' in ' +
                    results[j].duration.text + '<br>';
              }
            }
          }
        });
      }

      function deleteMarkers(markersArray) {
        for (var i = 0; i < markersArray.length; i++) {
          markersArray[i].setMap(null);
        }
        markersArray = [];
      }
    </script>

<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAyvCT-uW8G4yGPfKOVgJe5ZIhScKFOPyE&callback=initMap"
  type="text/javascript"></script>


</body>
</html>
