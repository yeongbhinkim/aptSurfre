<!--
'*  파 일 명 : src\main\resources\templates\fragment\mainList.html
'*  기    능 : 메인 -> 메인 리스트
'*  작 성 자 : 김영빈
'*  비    고 : 2023.03.03 작성
  -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main</title>
</head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
	<main>
	<div class="Apt-list-wrap">
		<div class="Apt-list-box">
			<ul class="Apts-box">
				<c:forEach var="item" items="${list}">
					<li class="Apt-each">
						<div class="Apt-container">
							<div class="Apt-container-util Apt-each_img Apt-img-rd ">
								<canvas id="chart-${item.APT_ID} canvas" width="240"
									height="170"></canvas>
							</div>
							<div class="Apt-container-util Apt-each_title">
								<span> <a href="/ContentController/contentView.do?APT_ID=${item.APT_ID}">
										${item.DAN_GI_MYEONG} ${item.LAYER}층</a>
								</span>
							</div>
							<div class="Apt-container-util Apt-each_hashtag">
								<ul>
									<li class="Apt-hashtag-rep rep1">
										<div>
											<span class="mainHashtag">${item.CITY}</span> <br> <span
												class="mainHashtag">${item.SQUARE_METER}</span> <span
												class="mainHashtag">${item.AMOUNT}</span> <span
												class="mainHashtag">${item.CONSTRUCTION_DATE}</span>
										</div>
									</li>
									<br>
								</ul>
							</div>
						</div>
					</li>
				</c:forEach>

			</ul>
		</div>
	</div>

	<div class="AptPrice-page page">
	
		<!-- 이전페이지 정보 -->
		<c:if test="${fc.prev}">
			<a class="AptPrice-page-item"
					href="/MainController/mainView.do?
										ReqPage=1
										&CONTRACTDATE=${fc.contractDate}
										&CONTRACTDATETO=${fc.contractDateTo}
										&SEARCHSIDOCD=${fc.searchSidoCd}
										&SEARCHGUGUNCD=${fc.searchGugunCd}
										&SEARCHDONGCD=${fc.searchDongCd}
										&SEARCHAREA=${fc.searchArea}
										&SEARCHAREAVALUE=${fc.searchAreaValue}
										&SEARCHAREAVALUETO=${fc.searchAreaValueTo}
										&SEARCHFROMAMOUNT=${fc.searchFromAmount}
										&SEARCHTOAMNOUNT=${fc.searchToAmnount}"
				title="처음 페이지로 이동">
				<i class="fas fa-angle-double-left"></i>
			</a>
			<a class="AptPrice-page-item"
					href="/MainController/mainView.do?
										ReqPage=${fc.startPage-1}
										&CONTRACTDATE=${fc.contractDate}
										&CONTRACTDATETO=${fc.contractDateTo}
										&SEARCHSIDOCD=${fc.searchSidoCd}
										&SEARCHGUGUNCD=${fc.searchGugunCd}
										&SEARCHDONGCD=${fc.searchDongCd}
										&SEARCHAREA=${fc.searchArea}
										&SEARCHAREAVALUE=${fc.searchAreaValue}
										&SEARCHAREAVALUETO=${fc.searchAreaValueTo}
										&SEARCHFROMAMOUNT=${fc.searchFromAmount}
										&SEARCHTOAMNOUNT=${fc.searchToAmnount}"
				title="이전 페이지로 이동"> <i class="fas fa-angle-left"></i>
			</a>
		</c:if>
		<!-- 페이지 표시 -->
		<c:forEach begin="${fc.startPage}" end="${fc.endPage}" var="pnum">
			<c:if test="${pnum != 0}">
				<a 	class="AptPrice-page-item <c:if test='${fc.rc.reqPage == pnum}'>active</c:if>"
					href="/MainController/mainView.do?
										ReqPage=${pnum}
										&CONTRACTDATE=${fc.contractDate}
										&CONTRACTDATETO=${fc.contractDateTo}
										&SEARCHSIDOCD=${fc.searchSidoCd}
										&SEARCHGUGUNCD=${fc.searchGugunCd}
										&SEARCHDONGCD=${fc.searchDongCd}
										&SEARCHAREA=${fc.searchArea}
										&SEARCHAREAVALUE=${fc.searchAreaValue}
										&SEARCHAREAVALUETO=${fc.searchAreaValueTo}
										&SEARCHFROMAMOUNT=${fc.searchFromAmount}
										&SEARCHTOAMNOUNT=${fc.searchToAmnount}"
					title="페이지 ${pnum}"> <c:out value="${pnum}" />
				</a>
			</c:if>
		</c:forEach>
		<!-- 다음페이지 정보 -->
		<c:if test="${fc.next}">
			<a class="AptPrice-page-item"
					href="/MainController/mainView.do?
										ReqPage=${fc.endPage+1}
										&CONTRACTDATE=${fc.contractDate}
										&CONTRACTDATETO=${fc.contractDateTo}
										&SEARCHSIDOCD=${fc.searchSidoCd}
										&SEARCHGUGUNCD=${fc.searchGugunCd}
										&SEARCHDONGCD=${fc.searchDongCd}
										&SEARCHAREA=${fc.searchArea}
										&SEARCHAREAVALUE=${fc.searchAreaValue}
										&SEARCHAREAVALUETO=${fc.searchAreaValueTo}
										&SEARCHFROMAMOUNT=${fc.searchFromAmount}
										&SEARCHTOAMNOUNT=${fc.searchToAmnount}"
				title="다음 페이지로 이동"> 
				<i class="fas fa-angle-right"></i>
			</a>
			<a class="AptPrice-page-item"
					href="<c:url value='/MainController/mainView.do?
								ReqPage=" + ${fc.finalEndPage} + 
								"&CONTRACTDATE" + "${fc.contractDate}" +
								"&CONTRACTDATETO=" + "${fc.contractDateTo}" +
								"&SEARCHSIDOCD=" + "${fc.searchSidoCd}" + 
								"&SEARCHGUGUNCD=" + "${fc.searchGugunCd}" + 
								"&SEARCHDONGCD=" + "${fc.searchDongCd}" + 
								"&SEARCHAREA=" + "${fc.searchArea}"  + 
								"&SEARCHAREAVALUE=" + "${fc.searchAreaValue}"  + 
								"&SEARCHAREAVALUETO=" + "${fc.searchAreaValueTo}" + 
								"&SEARCHFROMAMOUNT=" + "${fc.searchFromAmount}" + 
								"&SEARCHTOAMNOUNT=" + "${fc.searchToAmnount}" ' />" 
				title="마지막 페이지로 이동"> 
				<i class="fas fa-angle-double-right"></i>
			</a>
		</c:if>
		
	</div>

	<script>
      // 대표 해시태그 정보 텍스트 앞에 # 붙이기
      const $mainHashtag = document.querySelectorAll('.mainHashtag');

      $mainHashtag.forEach(ele => {
          if (ele.textContent.trim().length > 1) {
              const $hashtagView = " #" + ele.textContent;
              ele.textContent = $hashtagView;
          }
      });
  </script> <script type="text/javascript">
	
  /* Function to create the chart */

  function createChart(item) {
      const transactioncountlist = item.TRANSACTIONCOUNTLIST;
      const transactioncountlistArr = transactioncountlist.split(',');

      const contract = item.CONTRACT;
      const contractArr = contract.split(',');
      /* Data for the chart */
      var data = {
          labels: contractArr,
          datasets: [{
              label: '거래금액',
              data: transactioncountlistArr,
              backgroundColor: 'rgba(255, 99, 132, 0.2)',
              borderColor: 'rgba(255, 99, 132, 1)',
              borderWidth: 1
          }]
      };
      // console.log(data);
      /* Options for the chart */
      var options = {};

      /* Get the canvas element */
      var ctx = document.getElementById('chart-' + item.APT_ID + ' canvas').getContext('2d');

      /* Create the chart */
      new Chart(ctx, {
          type: 'line',
          data: data,
          options: options
      });
  }

  /* Loop through the chart data */
  <c:forEach var="item" items="${list}">
      createChart(${item});
  </c:forEach>
  </script> </main>
</body>
</html>