<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	session.getAttribute("loginUser");
	String uri = request.getRequestURI();
	System.out.println("현재 페이지의 uri : " + uri);
	System.out.println("----------------------------------------------------------------------------------------------");
%>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Comicssion</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="<%=request.getContextPath()%>/pages/sample/images/logoonly.png" rel="icon">
  <link href="<%=request.getContextPath()%>/pages/sample/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,600,600i,700,700i,900" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="<%=request.getContextPath()%>/pages/sample/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/pages/sample/assets/vendor/icofont/icofont.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/pages/sample/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/pages/sample/assets/vendor/animate.css/animate.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/pages/sample/assets/vendor/venobox/venobox.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/pages/sample/assets/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/pages/sample/assets/vendor/aos/aos.css" rel="stylesheet">
  <script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>

  <!-- Template Main CSS File -->
  <link href="<%=request.getContextPath()%>/pages/sample/assets/css/style.css" rel="stylesheet">

</head>

<body>


  <!-- ======= Header ======= -->
  <header id="header">
    <div class="container">

      <div class="logo float-left">
        <h1 class="text-light"><a href="index.do"><img src="<%=request.getContextPath()%>/pages/sample/images/mainlogo.png"></a></h1>
      </div>

      <nav class="nav-menu float-right d-none d-lg-block">
      <br><br><br>
        <ul>
          <li><a href="BuyServlet?command=buy">의뢰게시판</a></li>
          <li><a href="SellServlet?command=sell">작가게시판</a></li>
          
          <c:if test="${empty loginUser}">
			<li><a href="login.do">LOGIN</a></li>
          	<li><a href="join.do">JOIN</a></li>
		  </c:if>
		  
		  <c:if test="${!empty loginUser}">
			<li><a href="mypage.do">MYPAGE</a></li>
	        <li><a href="logout.do" onclick="return confirm('로그아웃 하시겠습니까?');">LOGOUT</a></li>
		  </c:if>

        </ul>
      </nav><!-- .nav-menu -->
    </div>
  </header><!-- End Header -->