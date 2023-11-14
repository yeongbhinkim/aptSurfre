<!--
'*  파 일 명 : jsp/content/contentItem.jsp
'*  기    능 : content -> contentItem
'*  작 성 자 : 김영빈
'*  비    고 : 2023.03.05 작성
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>content</title>
</head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
	<main>
		<!-- container -->
		<div class="container">

			<!-- Apt_info -->
			<div class="Apt_info_wrap">
				<div class="Apt-info">

					<!--   Apt-info_img  차트 박스-->
					<div class="Apt-info_img">
						<div class="chart_canvas_box">
							<canvas id="chart-canvas"></canvas>
						</div>
					</div><!--   Apt-info_img  차트 박스-->


					<!-- Apt-info_content-wrap 상세정보 박스-->
					<div class="Apt-info-content-wrap">
						<div class="Apt-info-content Apt-title-sub-box">
							<div class="Apt-title-sub">
								<h1 id="AptName">${myHomePriceListForm.DAN_GI_MYEONG}</h1>
								<a href="javascript:void(0)" class="link-btn">현재 url 복사</a>
							</div>
						</div>

						<div class="Apt-info-content Apt-location-sub-box">
							<div class="Apt-location-icon-box icon-box">
								<span class="mainHashtag">주소</span>
							</div>
							<div class="location-txt txt-box">
								<span class="AptAddress">${myHomePriceListForm.CITY}</span>
							</div>
						</div>

						<div class="Apt-info-content Apt-location-sub-box">
							<div class="Apt-location-icon-box icon-box">
								<span class="mainHashtag">도로명</span>
							</div>
							<div class="location-txt txt-box">
								<span id="AptAddressRoad" class="AptAddress">${myHomePriceListForm.ROAD_NAME}</span>
							</div>
						</div>

						<div class="Apt-info-content Apt-call-sub-box">
							<div class="Apt-location-icon-box icon-box">
								<span class="mainHashtag">전용면적(㎡)</span>
							</div>
							<div class="call-txt txt-box">
								<span class="AptAddress">${myHomePriceListForm.SQUARE_METER}</span>
							</div>
						</div>

						<div class="Apt-info-content Apt-hashtag-sub-box">
							<div class="Apt-hashtag-icon-box icon-box">
								<span class="mainHashtag">기타</span>
							</div>
							<div class="hashtag-txt txt-box" style="display: contents;">
								<div>
									<span class="mainHashtag">건축년도</span> 
									<span class="AptAddress">${myHomePriceListForm.CONSTRUCTION_DATE}</span>
								</div>
								<div>
									<span class="mainHashtag">층</span>
									<span class="AptAddress">${myHomePriceListForm.LAYER}</span>
								</div>
								<div>
									<span class="mainHashtag">번지</span>
									<span class="AptAddress">${myHomePriceListForm.STREET}</span>
								</div>
								<div>
									<span class="mainHashtag">본번</span>
									<span class="AptAddress">${myHomePriceListForm.BON_BUN}</span>
								</div>
								<div>
									<span class="mainHashtag">부번</span>
									<span class="AptAddress">${myHomePriceListForm.BU_BUN}</span>
								</div>
							</div>
						</div>
					</div><!-- End of Apt-info_content-wrap 상세정보 박스-->

					<!-- map-box  지도박스    -->
					<div class="map-box">
						<!-- 지도를 표시할 div 입니다 -->
						<div id="map" style="width: 100%; height: 100%;"></div>
						<p class="map_info">마커를 클릭하면 카카오맵으로 이동합니다.</p>
					</div>

				</div><!-- Apt-info-->
			</div><!-- End of Apt_info -->

			<div class="Apt-header">
				<table class="Apt-content">
					<thead>
						<tr>
							<th class="Apt-content-th">계약<br>년월일</th>
							<th class="Apt-content-th">거래금액<br>(만원)</th>
							<th class="Apt-content-th">거래<br>유형</th>
							<th class="Apt-content-th">중개사<br>소재지</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${list}">
							<tr>
								<td class="Apt-content-td"><c:out value="${item.CONTRACT_DATE}"/><c:out value="."/><c:out value="${item.CONTRACT_DAY}"/></td>
								<td class="Apt-content-td"><c:out value="${item.AMOUNT}"/></td>
								<td class="Apt-content-td"><c:out value="${item.TRANSACTION_TYPE}"/></td>
								<td class="Apt-content-td"><c:out value="${item.LOCATION_AGENCY}"/></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</div><!-- End of container -->

	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=410b3a83564f0bac127be038fded443b&libraries=services">
	</script>
	
	<script>
      // const $AptName = AptName.textContent;
      //road_name으로 변경
      const $AptAddress = AptAddressRoad.textContent;
      var mapContainer = document.getElementById('map'), // 지도를 표시할 div
          mapOption = {
              center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
              level: 4 // 지도의 확대 레벨
          };

      // 지도를 생성합니다
      var map = new kakao.maps.Map(mapContainer, mapOption);

      // 주소-좌표 변환 객체를 생성합니다
      var geocoder = new kakao.maps.services.Geocoder();

      // 주소로 좌표를 검색합니다
      geocoder.addressSearch($AptAddress, function (result, status) {

          // 정상적으로 검색이 완료됐으면
          if (status === kakao.maps.services.Status.OK) {

              var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

              // 결과값으로 받은 위치를 마커로 표시합니다
              var marker = new kakao.maps.Marker({
                  map: map,
                  position: coords,
                  clickable: true
              });

              // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
              map.setCenter(coords);

              // 마커를 클릭하면 카카오맵으로 이동
              kakao.maps.event.addListener(marker, 'click', (evt) => {
                  // window.open(`https://map.kakao.com/?q=${$AptName}`)
                  window.open(`https://map.kakao.com/?q=${$AptAddress}`)
              });
          }
      });

  </script> 
  <script type="text/javascript">
      /* Function to create the chart */
      function createChart(item) {
          /* Data for the chart */
          var data = {
              //시간
              // labels: contractArr,
              datasets: [{
                  label: '거래금액',
                  data: item,
                  backgroundColor: 'rgba(255, 99, 132, 0.2)',
                  borderColor: 'rgba(255, 99, 132, 1)',
                  borderWidth: 1
              }]
          };
          /* Options for the chart */
          var options = {
              scales: {
                  xAxes: [{
                      type: 'linear',
                      position: 'bottom'
                  }]
              }
          };

          /* Get the canvas element */
          var ctx = document.getElementById('chart-canvas').getContext('2d');

          /* Create the chart */
          new Chart(ctx, {
              type: 'scatter',
              data: data,
              options: options
          });
      }

      /* Loop through the chart data */
      createChart([${chart}]);
  </script> 
 </main>
</body>
</html>
