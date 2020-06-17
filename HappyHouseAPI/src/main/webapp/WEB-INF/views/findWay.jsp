<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>지도 표시</title>
<meta name="viewport"
	content="initial-scale=1,maximum-scale=1,user-scalable=no" />
<script src="https://api.mapbox.com/mapbox-gl-js/v1.11.0/mapbox-gl.js"></script>
<link href="https://api.mapbox.com/mapbox-gl-js/v1.11.0/mapbox-gl.css"
	rel="stylesheet" />
<style>
body {
	margin: 0;
	padding: 0;
}

#map {
	position: absolute;
	top: 0;
	bottom: 0;
	width: 100%;
}
</style>
</head>
<body>
	<script
		src="https://api.mapbox.com/mapbox-gl-js/plugins/mapbox-gl-directions/v4.0.2/mapbox-gl-directions.js"></script>
	<link rel="stylesheet"
		href="https://api.mapbox.com/mapbox-gl-js/plugins/mapbox-gl-directions/v4.0.2/mapbox-gl-directions.css"
		type="text/css" />
	<div id="map"></div>

	<script>
		mapboxgl.accessToken = 'pk.eyJ1Ijoic2V4a2luZyIsImEiOiJja2JqM2U5dm8wbDBwMnRsanQ5MXhsZHQ1In0.dEp2SWwyzti6zB020Q33ZA';
		var map = new mapboxgl.Map({
			container : 'map',
			style : 'mapbox://styles/mapbox/streets-v11',
			center : [ -79.4512, 43.6568 ],
			zoom : 13
		});

		map.addControl(new MapboxDirections({
			accessToken : mapboxgl.accessToken
		}), 'top-left');
	</script>

</body>
</html>
