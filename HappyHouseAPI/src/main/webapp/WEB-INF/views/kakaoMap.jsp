<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<!-- javascript key=  2fb21910a1c6cdfb288e3da097ea7bab -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d116344b3fb196256cab17af15427d19"></script>
<body>
	<div id="map" style="width:500px;height:400px;"></div>
	<script
  src="https://code.jquery.com/jquery-3.5.1.js"
  integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
  crossorigin="anonymous"></script>
	<script>
	$(document).ready(function(){
			//// 지도 생성 파트 ///
			var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = { 
		        center: new kakao.maps.LatLng(37.668140, 127.049940), // 지도의 중심좌표
		        level: 3 // 지도의 확대 레벨
		    };  
		
			var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
			
			/// 비동기 요청 //
			$.get("${pageContext.request.contextPath}/cctv/list"
				,function(data, status){
					$.each(data, function(index, cctv) {
						
						var circle = new kakao.maps.Circle({
						    center : new kakao.maps.LatLng(cctv.lat, cctv.lon),  // 원의 중심좌표 입니다 
						    radius: 25, // 미터 단위의 원의 반지름입니다 
						    strokeWeight: 3, // 선의 두께입니다 
						    strokeColor: '#FDBACB', // 선의 색깔입니다
						    strokeOpacity: 1, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
						    strokeStyle: 'none', // 선의 스타일 입니다
						    fillColor: '#FDBACB', // 채우기 색깔입니다
						    fillOpacity: 0.7  // 채우기 불투명도 입니다   
						}); 
						
						circle.setMap(map);
					});//each
					 
				}//function
				, "json"
			);//get
	});
		
		// 지도에 표시할 원을 생성합니다
		
	
		// 지도에 원을 표시합니다 
		
			
	</script>
</body>
</html>