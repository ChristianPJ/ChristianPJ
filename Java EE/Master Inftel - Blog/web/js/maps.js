/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var geocoder;
var map;
function initialize() {
  geocoder = new google.maps.Geocoder();
  var latlng = new google.maps.LatLng(-34.397, 150.644);
  var mapOptions = {
    zoom: 8,
    center: latlng
  }
  var mapa = document.getElementById('map-canvas');
  mapa.style.display="block";
  map = new google.maps.Map(mapa, mapOptions);
}

function codeAddress() {
   initialize();
  var address = document.getElementById('address').value;
  geocoder.geocode( { 'address': address}, function(results, status) {
    if (status == google.maps.GeocoderStatus.OK) {
      map.setCenter(results[0].geometry.location);
      var marker = new google.maps.Marker({
          map: map,
          position: results[0].geometry.location
      });
      var latitud;
      var longitud;
      latitud = results[0].geometry.location.lat();
      longitud = results[0].geometry.location.lng();
      
    $('#latitud').val(latitud);
    $('#longitud').val(longitud);
    
    } 
    else {
        var texto = "No se encuentra resultados";
      $('#address').val(texto);
    }
  });
}

function pintarMapa(){
    geocoder = new google.maps.Geocoder();
    var lat = $('#latitud').val();
    var lng = $('#longitud').val();
    console.log(lat);
    console.log(lng);
    var latlng = new google.maps.LatLng(lat, lng);
    console.log(latlng);
    var mapOptions = {
        zoom: 8,
        center: latlng
    };
    var mapa = document.getElementById('map-canvas');
    mapa.style.display = "block";
    map = new google.maps.Map(mapa, mapOptions);
    map.setCenter(latlng);
    var marker = new google.maps.Marker({
        map: map,
        position: latlng
    });
//                var latlng2 = new google.maps.LatLng(36.603448,-4.631742);
//                var marker2 = new google.maps.Marker({
//                    map: map,
//                    position: latlng2
//                });
    //google.maps.event.addDomListener(window, 'load', pintarMapa);
}

