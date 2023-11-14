<!--
'*  파 일 명 : jsp/home/homeView.jsp
'*  기    능 : home
'*  작 성 자 : 김영빈
'*  비    고 : 2023.02.27 작성
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<body>
<nav>
  <div class="util-wrap">
    <div class="util-box">
      <div class="search-box-wrap">
        <div class="input_tag">
          <div class="first_tag">
            <div class="d-inline-block">
              <label class="viewLabel">계약일자</label>
              <input id="contractDate" name="contractDate" class="input_search" type="date"
                     style="text-align: right">~
              <input id="contractDateTo" name="contractDateTo" class="input_search" type="date"
                     style="text-align: right">
            </div>

            <div class="d-inline-block">
              <label>면적</label>
              <select id="searchArea" name="searchArea" class="select_search">
                <option value="0">전체</option>
                <option value="1">60㎡이하</option>
                <option value="2">60㎡초과~85㎡이하</option>
                <option value="3">85㎡초과~102㎡이하</option>
                <option value="4">102㎡초과~135㎡이하</option>
                <option value="5">135㎡초과</option>
              </select>
            </div>
          </div>

          <div class="second_tag">
            <div class="d-inline-block">
              <label>시도</label>

        		<select id="searchSidoCd" name="searchSidoCd" class="select_search" onchange="sidoCd(this.value)">
				    <option value="">전체</option>
				     <c:forEach items="${RegionCity}" var="regionCity">
				        <option value="${regionCity.CITY_CODE}">${regionCity.CITY_NM}</option>
				    </c:forEach>
				</select>

            </div>

            <div class="d-inline-block">
              <label>시군구</label>
              <select id="searchGugunCd" name="searchGugunCd" onchange="gugunCd(this.value)">
                <option value="" selected="selected">전체</option>
              </select>
            </div>

            <div class="d-inline-block">
              <label>읍면동</label>
              <select id="searchDongCd" name="searchDongCd">
                <option value="" selected="selected">전체</option>
              </select>
            </div>
          </div>

          <div class="third_tag">
            <div class="d-inline-block">
              <label class="viewLabel">금액선택(만원)</label>
              <input id="searchFromAmount" name="searchFromAmount" class="input_search" type="text" value=""
                     maxlength="15"><label class="textLabel">~</label>
              <input id="searchToAmnount" name="searchToAmount" class="input_search" type="text" value=""
                     maxlength="15">
            </div>

            <div class="d-inline-block" style="width: 100%;">
              <div class="search-box">
                <button id="searchBtn" style="width: 29px;height: 31px;">검색</button>
              </div>
            </div>

          </div>


        </div><!--input_tag-->
      </div><!--search-box-wrap-->
    </div><!--util-box-->
  </div><!--util-wrap-->
</nav>
</body>

</html>