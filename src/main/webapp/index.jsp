<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Google Maps</title>
    <!-- Include Google Maps API with API key -->
    <script src="https://maps.googleapis.com/maps/api/js?key=${google.maps.api.key}"></script>
    <style>
        #map {
            height: 400px;
            width: 100%;
        }
    </style>
</head>
<body>
    <h1>Google Maps</h1>
    <div id="map"></div>

    <script>
        // Initialize the map
        function initMap() {
            // Specify initial map center coordinates
            var center = { lat: -34.397, lng: 150.644 };
            // Create a new map object
            var map = new google.maps.Map(document.getElementById('map'), {
                center: center,
                zoom: 8 // Initial zoom level
            });
        }
    </script>

    <!-- Call the initMap function to initialize the map -->
    <script>
        initMap();
    </script>
</body>
</html>
