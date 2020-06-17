<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${ pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Main</title>


<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
   src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<script>

        function markerbase() {
            document.location.href = "${root}/api/apt"
        }
       
    </script>
</head>
<body>
   <input type="hidden" name="userid" id="userid" value="${userinfo}">
   <input type="hidden" name="userid" id="usersido" value="${usersido}">
   <input type="hidden" name="userid" id="usergugun" value="${usergugun}">
   <input type="hidden" name="userid" id="userdong" value="${userdong}">


   <section id="index_section">
      <div class="card col-sm-12 mt-1" style="min-height: 850px;">
         <div class="card-body">

            <!-- here start -->
            <script>
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
                                    $("#searchResult").empty();
                                    $.each(data, function (index, vo) {
                                        let str = "<tr style=\"cursor:pointer;\" class=" + colorArr[index % 3] + " onClick=\"location.href='${root }/apt.do/dongjibun&dong= " +vo.dong+"&jibun="+vo.jibun + "&aptname=" + vo.aptName +" '\" "+">"
                                            + "<td>"+ vo.no + "</td>"
                                            + "<td>" + vo.dong + "</td>"
                                            + "<td>" + vo.aptName + "</td>"
                                            + "<td>" + vo.jibun + "</td></tr>"
                                        $("#gmap").append(str);
                                        $("#searchResult").append(vo.dong + " " + vo.aptName + " " + vo.jibun + "<br>");
                                    });//each
//                                    geocode(data);
                                }//function
                                , "json"
                            );//get
                        });//change
                    });//ready
                    function geocode(jsonData) {
                        let idx = 0;
                        $.each(jsonData, function (index, vo) {
                            let tmpLat;
                            let tmpLng;
                            $.get("https://maps.googleapis.com/maps/api/geocode/json"
                                , {
                                    key: 'AIzaSyD4T_jNYPKmnznjXlTrrl96eAZ3Hw-AZqI'
                                    , address: vo.dong + "+" + vo.aptName + "+" + vo.jibun
                                }
                                , function (data, status) {
                                    //alert(data.results[0].geometry.location.lat);
                                    tmpLat = data.results[0].geometry.location.lat;
                                    tmpLng = data.results[0].geometry.location.lng;
                                    $("#lat_" + index).text(tmpLat);
                                    $("#lng_" + index).text(tmpLng);
                                    addMarker(tmpLat, tmpLng, vo.aptName);
                                }
                                , "json"
                            );//get
                        });//each
                    }

                </script>

            <!-- HTML -->
            <div class="form-select" id="default-select" align="center">
               시도 : <select id="sido">
                  <option value="0">선택</option>
               </select> 구군 : <select id="gugun">
                  <option value="0">선택</option>
               </select> 읍면동 : <select id="dong">
                  <option value="0">선택</option>
               </select>
            </div>
            <div>
               <div align="left"
                  style="width: 400px; height: 100%; margin: 8% 5% 5% 0;">
                  <table align="left" class="pinktable">
                     <thead>
                        <tr>
                           <th>번호</th>
                           <th>법정동</th>
                           <th>아파트이름</th>
                           <th>지번</th>
                        </tr>
                     </thead>
                     <tbody id="gmap">


                     </tbody>
                  </table>
               </div>

               <!-- here end -->

vo.no, vo.dong , vo.aptName, vo.jibun
              
            </div>
         </div>
      </div>
   </section>
   <!-- section end -->
   
</body>
</html>