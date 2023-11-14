<!--
'*  파 일 명 : jsp/home/homeView.jsp
'*  기    능 : home
'*  작 성 자 : 김영빈
'*  비    고 : 2023.02.27 작성
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./../css/page/home-page-style.css" />
<link rel="stylesheet" type="text/css" href="./../css/page/home-body.css" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<script defer src="./../js/homeJs/searchBar.js"></script>
</head>

<body>

  <div class="global-wrap">
    <div class="upm">
      <div class="inner upm-inner">
      
      </div>
    </div>
    <div class="hdr">
      <div class="inner hdr-inner">
    	<jsp:include page="./../fragment/homeLogo.jsp" />
      </div>
    </div>
    <div class="gnb">
      <div class="inner gnb-inner">
    	<jsp:include page="./../fragment/homeCenter.jsp" />
      </div>
    </div>
    <div class="main">
      <div class="inner main-inner">
        <main></main>
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