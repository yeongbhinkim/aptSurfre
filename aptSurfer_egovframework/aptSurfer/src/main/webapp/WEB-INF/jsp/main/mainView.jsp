<!--
'*  파 일 명 : jsp/main/mainView.jsp
'*  기    능 : main
'*  작 성 자 : 김영빈
'*  비    고 : 2023.03.03 작성
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="./../css/page/home-page-style.css" />
<link rel="stylesheet" type="text/css" href="./../css/page/main-page-style.css" />
<!--차트-->
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.3/dist/Chart.min.js"></script>
<!--   fontawesome-->
<script src="https://kit.fontawesome.com/023d8f21ed.js" crossorigin="anonymous"></script>
<script defer src="./../js/homeJs/searchBar.js"></script>
<script defer src="./../js/homeJs/main.js"></script>
</head>

<body>

  <div class="global-wrap">
    <div class="upm">
      <div class="inner upm-inner">
     	 <jsp:include page="./../fragment/homeCenter.jsp" />
      </div>
    </div>
    <div class="hdr">
      <div class="inner hdr-inner">
    	
      </div>
    </div>
    <div class="gnb">
      <div class="inner gnb-inner">
    	
      </div>
    </div>
    <div class="main">
      <div class="inner main-inner">
        <jsp:include page="./../fragment/mainList.jsp" />
      </div>
    </div>
      <div class="foot">
        <div class="inner foot-inner">
          <footer></footer>
        </div>
      </div>
  </div>

</body>
</html>