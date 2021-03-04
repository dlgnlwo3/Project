<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="header.jsp" %>

  <main id="main">

    <!-- ======= Breadcrumbs Section ======= -->
    <section class="breadcrumbs">
      <div class="container">

        <div class="d-flex justify-content-between align-items-center">
          <h2>MYPAGE</h2>
          <ol>
            <li><a href="index.do">HOME</a></li>
            <li>MYPAGE</li>
          </ol>
        </div>

      </div>
    </section><!-- End Breadcrumbs Section -->

    <section class="inner-page">

      <div class="container" align="center">
        <h2>${loginUser.id}님 환영합니다!</h2>
        <div class="card" style="width:400px">
          <div class="card-body">
            <h4 class="card-title">${loginUser.id}</h4>
            <p class="card-text">${loginUser.name}</p>
            <p class="card-text">${loginUser.tel}</p>
            <p class="card-text">${loginUser.email}</p>
            <p class="card-text">${loginUser.birth}</p>
          </div>
        </div>
        <br>
        <div>
        <button class="btn btn-primary" onclick="location.href='userupdate.do?id=${loginUser.id}'">프로필 편집</button>
        <button class="btn btn-primary" onclick="location.href='userdelete.do?id=${loginUser.id}'">탈퇴</button>
        </div>
        <br>
        
      </div>


    </section>

  </main><!-- End #main -->

<%@ include file="footer.jsp" %>