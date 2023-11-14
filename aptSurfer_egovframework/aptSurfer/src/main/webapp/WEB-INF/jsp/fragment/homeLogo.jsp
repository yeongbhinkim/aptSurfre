<!--
'*  파 일 명 : jsp/home/homeView.jsp
'*  기    능 : home
'*  작 성 자 : 김영빈
'*  비    고 : 2023.02.20 작성
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<header th:fragment="logo" th:remove="tag">

	<div class="util-box">
		<div class="logo-box">
			<div class="logo">
				<img src="./../img/logo/logo-white.png" alt=""
					onclick="location.href='http://localhost:8080/'">
			</div>
		</div>
	</div>

	</header>
</body>
</html>