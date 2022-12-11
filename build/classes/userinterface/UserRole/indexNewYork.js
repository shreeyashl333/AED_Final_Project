// This example adds an animated symbol to a polyline.

function initMap() {
  var map = new google.maps.Map(document.getElementById('map'), {
    center: {
      lat: 41.5536306,
      lng: -71.0877243
    },
    zoom: 7,
    mapTypeId: 'terrain'
  });

  var lineSymbol = {
    path: google.maps.SymbolPath.CIRCLE,
    fillOpacity: 1,
    scale: 3
  };
  
  
  // Define the symbol, using one of the predefined paths ('CIRCLE')
  // supplied by the Google Maps JavaScript API.
  var myMarker = {
    path: google.maps.SymbolPath.CIRCLE,
    scale: 5,
    strokeColor: '#e53935',
   
    
    animation : google.maps.Animation.BOUNCE

  };
  
  

  var directionsService = new google.maps.DirectionsService();

  var start = "Vessel, New York, NY 10001";
  var end = "Animal Care Centers of NYC - Manhattan, 326 E 110th St, New York, NY 10029 ";
  var method = 'DRIVING';
  var request = {
    origin: start,
    destination: end,
    travelMode: google.maps.DirectionsTravelMode[method]
  };

  directionsService.route(request, function(response, status) {
    if (status == google.maps.DirectionsStatus.OK) {

      
      var line = new google.maps.Polyline({
        path: response.routes[0].overview_path,
        icons: [{
          icon: lineSymbol,
          offset: '0',
          repeat: '10px'
        },
        {
          icon: myMarker,
          offset: '100%'
        }],
        strokeColor: '#0eb7f6',
        map: map
      });

    
      animateCircle(line);
      
      
      var content = "<h2> New York Pet Shelter  </h2>"+
						  "<p> Address: Animal Care Centers of NYC</p>"+
						  "<p> Manhattan, NY-10029 </p>"+
						  "<p> Cell : 857-498-3342 </p>"+
						  "<p> Email : shreeyash.lahane97@gmail.com </p>";
    const infowindow = new google.maps.InfoWindow({
    content: content,
    ariaLabel: "Location Info"
  });
      var marker = new google.maps.Marker({
        position: response.routes[0].overview_path[0],
        map: map,
        title: 'Hello World!',
       
        animation : google.maps.Animation.BOUNCE

      });
      var marker = new google.maps.Marker({
        position: response.routes[0].overview_path[response.routes[0].overview_path.length - 1],
        map: map,
        title: 'Hello World!',
       
        animation : google.maps.Animation.BOUNCE

      });
      
      marker.addListener("click", () => {
    infowindow.open({
      anchor: marker,
      map,
    });
  });
    }
  });
}

function animateCircle(line) {
  var count = 0;
  window.setInterval(function() {
    count = (count + 1) % 200;
    var icons = line.get('icons');
    icons[1].offset = (count / 2) + '%';
    // icons[1].offset = (count / 2) + '%'; //+++++++++++++++++++++User this line for non dotted path and comment above line.
    line.set('icons', icons);
  }, 100);
}
