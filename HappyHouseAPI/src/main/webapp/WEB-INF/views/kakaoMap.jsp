<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d116344b3fb196256cab17af15427d19&libraries=services"></script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=d116344b3fb196256cab17af15427d19">
</script>
<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous">
</script>
<style>
body {
	margin: 0;
	padding: 0;
}
#map{
	border: black solid 1px;
	width:50%;
	margin-left: auto; 
	margin-right: auto;
	margin-top : 30px;
}
</style>
<!-- font -->
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">

<title>여성안심귀가서비스</title>

<script>
	$(document).ready(function(){
			//// 지도 생성 파트 ///
			var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = { 
		        center: new kakao.maps.LatLng(37.532969, 126.997944), // 지도의 중심좌표
		        level: 6 // 지도의 확대 레벨
		    };  
		
			var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
			
			/// 비동기 요청 //
			$.get("${pageContext.request.contextPath}/cctv/list"
				,function(data, status){
					$.each(data, function(index, cctv) {
						
						var circle = new kakao.maps.Circle({
						    center : new kakao.maps.LatLng(cctv.lat, cctv.lon),  // 원의 중심좌표 입니다 
						    radius: 30, // 미터 단위의 원의 반지름입니다 
						    strokeWeight: 3, // 선의 두께입니다 
						    strokeColor: '#FDBACB', // 선의 색깔입니다
						    strokeOpacity: 1, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
						    strokeStyle: 'none', // 선의 스타일 입니다
						    fillColor: '#FDBACB', // 채우기 색깔입니다
						    fillOpacity: 0.7  // 채우기 불투명도 입니다   
						}); 
						
						circle.setMap(map);
					});//each
////////////////////////////////지도 + 원그리기 완료  아래 코드는 마커 표시 //////////////////////////////
					
					let colorArr = ['table-primary', 'table-success', 'table-danger']; 
				                    $(document).ready(function () {
				                        $.get("${pageContext.request.contextPath}/map.do/sido"
				                            , {command: "sido"}
				                            , function (data, status) {
				                                $.each(data, function (index, vo) {
				                                    $("#sido").append("<option value='" + vo.sido_code + "'>" + vo.sido_name + "</option>");
				                                });//each
				                                if ($("#userid").val() != "") 
				                                {
				                                   $('#sido').val($("#usersido").val()).trigger('change');
				                                }
				                            }//function
				                            , "json"
				                        );//get
				                    });//ready
				                    $(document).ready(function () {
				                        $("#sido").change(function () {
				                            $.get("${pageContext.request.contextPath}/map.do/gugun"
				                                , {command: "gugun", sido: $("#sido").val()}
				                                , function (data, status) {
				                                    $("#gugun").empty();
				                                    $("#gugun").append('<option value="0">선택</option>');
				                                    $.each(data, function (index, vo) {
				                                        $("#gugun").append("<option value='" + vo.gugun_code + "'>" + vo.gugun_name + "</option>");
				                                    });//each
				                                    if ($("#userid").val() != "") 
				                                    {
				                                       $('#gugun').val($("#usergugun").val()).trigger('change');
				                                    }
				                                }//function
				                                , "json"
				                            );//get
				                        });//change
				                        $("#gugun").change(function () {
				                            $.get("${pageContext.request.contextPath}/map.do/dong"
				                                , {command: "dong", gugun: $("#gugun").val()}
				                                , function (data, status) {
				                                    $("#dong").empty();
				                                    $("#dong").append('<option value="0">선택</option>');
				                                    $.each(data, function (index, vo) {
				                                        $("#dong").append("<option value='" + vo.dong + "'>" + vo.dong + "</option>");
				                                    });//each
				                                    if ($("#userid").val() != "") 
				                                    {
				                                       $('#dong').val($("#userdong").val()).trigger('change');
				                                    }
				                                }//function
				                                , "json"
				                            );//get
				                        });//change
				                        $("#dong").change(function () {
				                            $.get("${pageContext.request.contextPath}/map.do/apt"
				                                , {command: "apt", dong: $("#dong").val()}
				                                , function (data, status) {
				                                   $("#gmap").empty();
				                                    $.each(data, function (index, vo) {
				                                    	
				                                    	//////////////////////////지도로 검색 핡게요 .//////////////////////
				                                    	
				                                    	var geocoder = new kakao.maps.services.Geocoder();
				                                    	geocoder.addressSearch(vo.dong+vo.jibun, function(result, status) {

				                                    	    // 정상적으로 검색이 완료됐으면 
				                                    	     if (status === kakao.maps.services.Status.OK) {

				                                    	        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

				                                    	        // 결과값으로 받은 위치를 마커로 표시합니다
				                                    	        var marker = new kakao.maps.Marker({
				                                    	            map: map,
				                                    	            position: coords
				                                    	        });

				                                    	        // 인포윈도우로 장소에 대한 설명을 표시합니다
				                                    	        var iwContent = vo.no+vo.dong+vo.aptName+vo.jibun, // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
																    iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다
																
																// 인포윈도우를 생성합니다
																var infowindow = new kakao.maps.InfoWindow({
																    content : iwContent,
																    removable : iwRemoveable
																});
																
																// 마커에 클릭이벤트를 등록합니다
																kakao.maps.event.addListener(marker, 'click', function() {
																      // 마커 위에 인포윈도우를 표시합니다
																      infowindow.open(map, marker);  
																});
																				                                    	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
				                                    	        map.setCenter(coords);
				                                    	    } 
				                                    	});    
				                                    	
				                                    	//// /////////////////////////////// ////////////////////////////////////////
				                                    	
				                                    	let str = "<tr style=\"cursor:pointer;\" class=" + colorArr[index % 3] + " onClick=\"location.href='${root }/apt.do/dongjibun&dong= " +vo.dong+"&jibun="+vo.jibun + "&aptname=" + vo.aptName +" '\" "+">"
				                                            + "<td>"+ vo.no + "</td>"
				                                            + "<td>" + vo.dong + "</td>"
				                                            + "<td>" + vo.aptName + "</td>"
				                                            + "<td>" + vo.jibun + "</td></tr>"
				                                        $("#gmap").append(str);
				                                    });//each
				                     
				                                }//function
				                                , "json"
				                            );//get
				                        });//change
				                    });//ready 
				}//function
				, "json"
			);//get
	});
	
                   
/////////////////////////////////////////////////////////////////////////////////////////////
	
	</script>
</head>
<body>
<div>
	<jsp:include page="header.jsp"></jsp:include>
	
	<input type="hidden" name="userid" id="userid" value="${userinfo}">
	<input type="hidden" name="userid" id="usersido" value="${usersido}">
	<input type="hidden" name="userid" id="usergugun" value="${usergugun}">
	<input type="hidden" name="userid" id="userdong" value="${userdong}">

	<section id="index_section" >
		<div class="card w-50 p-4 mt-4 mb-4" style="margin-left:auto; margin-right: auto">
			<div style="text-align: center">
				<h2 style=""font-family: 'Jua', sans-serif;>시 군 읍.동을 선택해주세요..</h2>
			</div>
			<hr>
			<div class="form-select" id="default-select">
				<div class="mt-2">
					<div>
						<p style="display: inline; font-size: 16px; font-family: 'Jua', sans-serif;">시도:<p>
						<svg class="bi bi-arrow-right-circle" width="2em" height="2em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg" style="bottom: 3em">
		  					<path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
		  					<path fill-rule="evenodd" d="M7.646 11.354a.5.5 0 0 1 0-.708L10.293 8 7.646 5.354a.5.5 0 1 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0z"/>
		  					<path fill-rule="evenodd" d="M4.5 8a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1H5a.5.5 0 0 1-.5-.5z"/>
						</svg> 
					</div>
					
					<select class="form-control btn-info" id="sido" style="height: 35px; display: inline;">
						<option value="0" style="height: 30px">선택</option>
					</select> 
				</div>
				<div class="mt-2">
					<div>
						<p style="display: inline; font-size: 16px; font-family: 'Jua', sans-serif;">구군<p>
						<svg class="bi bi-arrow-right-circle" width="2em" height="2em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg" style="bottom: 3em">
		  					<path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
		  					<path fill-rule="evenodd" d="M7.646 11.354a.5.5 0 0 1 0-.708L10.293 8 7.646 5.354a.5.5 0 1 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0z"/>
		  					<path fill-rule="evenodd" d="M4.5 8a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1H5a.5.5 0 0 1-.5-.5z"/>
						</svg>
					</div>
					
					<select class="form-control btn-info" id="gugun" style="height: 35px">
						<option value="0" style="height: 30px">선택</option>
					</select>
				</div>
				<div class="mt-2">
					<div>
						<p style="display: inline; font-size: 16px; font-family: 'Jua', sans-serif;">읍면동<p>
						<svg class="bi bi-arrow-right-circle" width="2em" height="2em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg" style="bottom: 3em">
		  					<path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
		  					<path fill-rule="evenodd" d="M7.646 11.354a.5.5 0 0 1 0-.708L10.293 8 7.646 5.354a.5.5 0 1 1 .708-.708l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0z"/>
		  					<path fill-rule="evenodd" d="M4.5 8a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1H5a.5.5 0 0 1-.5-.5z"/>
						</svg>
					</div>
					<select class="form-control btn-info" id="dong" style="height: 35px">
						<option value="0" style="height: 30px">선택</option>
					</select>
				</div>
			</div>
		</div>
	</section>
	<hr>
	<div class="mb-5">
		<div class="pl-3 pr-3" id="tablecover" style="width: 48%"%>
		<table class="table table-info text-center">
			<thead>
				<tr>
					<th scope="col">번호</th>
					<th scope="col">법정동</th>
					<th scope="col">아파트이름</th>
					<th scope="col">지번</th>
				</tr>
			</thead>
			<tbody id="gmap">
			</tbody>
		</table>
	</div>
	<div id="map" class="pl-3 pr-3 " style="width: 48%; height: 400px;" align="right"></div>
	</div>
	
	<div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>