'use strict';
var now = new Date();

//계약일자 오늘날짜
document.getElementById('contractDate').value = new Date(now.setMonth(now.getMonth() - 1)).toISOString().substring(0, 10);
document.getElementById('contractDateTo').value = new Date().toISOString().substring(0, 10);

// 주소구분 라디오 이벤트
const $searchDongCd = document.getElementById("searchDongCd");
const $searchLoad = document.getElementById("searchLoad");

function fn_select_check(e) {
    if (e == 1) {
        $searchDongCd.style.cssText = "display: block; ";
    } else if (e == 2) {
        $searchDongCd.style.cssText = "display: none; ";
    }
}

//주소 셀렉트 박스 이벤트
const $searchSidoCd = document.getElementById('searchSidoCd');
$searchSidoCd.addEventListener('click', sidoCd)
const $searchGugunCd = document.getElementById("searchGugunCd");
$searchGugunCd.addEventListener('click', gugunCd)

//시도
function sidoCd(e) {
    if (e != '[object PointerEvent]') {
        const url = '/getRegionCounty';

        var param = { CITY_CODE: e };
        fn_sgg_search(url, param, cbSidoCd);
    }
}

//시군구
function gugunCd(e) {
    if (e != '[object PointerEvent]') {
        const url = '/getRegionDistricts';

        var param = { COUNTY_CODE: e };
        fn_sgg_search(url, param, cbGugunCd);
    }
}

function fn_sgg_search(reqeustUrl, paramObject, cbSuccess) {

    var param = JSON.stringify(paramObject);

    $.ajax({
        type: 'POST',
        contentType: "application/json",
        url: "http://localhost:8080" + reqeustUrl + ".json",
        data: param,
        dataType: 'json',
        success: function (data) { 	  //요청 성공시 실행될 메서드
            console.log("통신성공");
            cbSuccess(data);
        },
        error: function () {			  //요청 실패시 에러 확인을 위함
            console.log("통신에러");
        }
    });
}


//시도 -> 시군구 데이터 셋
function cbSidoCd(res) {
    $searchGugunCd.add = res;
    $searchGugunCd.innerHTML = "";
    $searchDongCd.innerHTML = "";

    var opt2 = document.createElement("option");
    opt2.value = "";
    opt2.innerHTML = "전체";
    $searchGugunCd.appendChild(opt2);

    var opt3 = document.createElement("option");
    opt3.value = "";
    opt3.innerHTML = "전체";
    $searchDongCd.appendChild(opt3);

    for (var i = 0; i < res.length; i++) {
        var opt = document.createElement("option");
        opt.value = res[i].COUNTY_CODE;
        opt.innerHTML = res[i].COUNTY_NM;
        $searchGugunCd.appendChild(opt);
    }
}

//시군구 -> 읍면동 데이터 셋
function cbGugunCd(res) {
    $searchDongCd.add = res;
    $searchDongCd.innerHTML = "";

    var opt3 = document.createElement("option");
    opt3.value = "";
    opt3.innerHTML = "전체";
    $searchDongCd.appendChild(opt3);

    for (var i = 0; i < res.length; i++) {
        var opt = document.createElement("option");
        opt.value = res[i].DISTRICTS_CODE;
        opt.innerHTML = res[i].DISTRICTS_NM;
        $searchDongCd.appendChild(opt);
    }
}

//검색
const $contractDate = document.getElementById('contractDate');              //시작 계약일자
const $contractDateTo = document.getElementById('contractDateTo');          //종료 계약일자
const $searchArea = document.getElementById('searchArea');                  //면적
const $searchFromAmount = document.getElementById('searchFromAmount');      //시작 금액
const $searchToAmnount = document.getElementById('searchToAmnount');        //종료 금액
const $searchBtn = document.getElementById('searchBtn');                    //검색버튼
var $searchAreaValue = "";  //시작 면적
var $searchAreaValueTo = "";  //종료 면적

$searchBtn?.addEventListener('click', search_f);							//검색 버튼 클릭시


function search_f(e) {
    //날짜 필수값 체크
    if ($contractDate.value == "" || $contractDateTo.value == "") {
        alert('계약일자를 입력하세요');
        if ($contractDate.value == "") {
            $contractDate.focus();
            $contractDate.select(); //커서이동
        }
        if ($contractDateTo.value == "") {
            $contractDateTo.focus();
            $contractDateTo.select(); //커서이동
        }
        return false;
    }

    //면적 값
    if ($searchArea.value == 1) {
        $searchAreaValue = 0;
        $searchAreaValueTo = 60;
    } else if ($searchArea.value == 2) {
        $searchAreaValue = 60;
        $searchAreaValueTo = 85;
    } else if ($searchArea.value == 3) {
        $searchAreaValue = 85;
        $searchAreaValueTo = 102;
    } else if ($searchArea.value == 4) {
        $searchAreaValue = 102;
        $searchAreaValueTo = 135;
    } else if ($searchArea.value == 5) {
        $searchAreaValue = 135;
        $searchAreaValueTo = 10000;
    } else if ($searchArea.value == 0) {
        $searchAreaValue = 0;
        $searchAreaValueTo = 10000;
    }

    //조건 검색
    const url = "/MainController/mainView.do?CONTRACTDATE=" + $contractDate.value +
        "&CONTRACTDATETO=" + $contractDateTo.value +
        "&SEARCHSIDOCD=" + $searchSidoCd.options[$searchSidoCd.selectedIndex].text +
        "&SEARCHGUGUNCD=" + $searchGugunCd.options[$searchGugunCd.selectedIndex].text +
        "&SEARCHDONGCD=" + $searchDongCd.options[$searchDongCd.selectedIndex].text +
        "&SEARCHAREA=" + $searchArea.value +
        "&SEARCHAREAVALUE=" + $searchAreaValue +
        "&SEARCHAREAVALUETO=" + $searchAreaValueTo +
        "&SEARCHFROMAMOUNT=" + $searchFromAmount.value +
        "&SEARCHTOAMNOUNT=" + $searchToAmnount.value;
    console.log(url)
    location.href = url;
}
