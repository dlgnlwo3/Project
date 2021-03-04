<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="header.jsp" %>
    

  <main id="main">


    <!-- ======= Breadcrumbs Section ======= -->
    <section class="breadcrumbs">
      <div class="container">

        <div class="d-flex justify-content-between align-items-center">
          <h2>작가 게시판</h2>
          <ol>
            <li><a href="index.do">HOME</a></li>
            <li>작가 게시판</li>
          </ol>
        </div>

      </div>
    </section><!-- End Breadcrumbs Section -->



    <section class="inner-page">
      <div class="container">

        <h3 style="margin-top: 5%;">Artist List</h3>
        <hr style="margin-bottom: 2%;">

        <div class="container" style="padding: 0;">

		  <c:if test="${!empty loginUser}">
		  	<div class="float-right" style="margin-bottom: 2%;">
            	<a href="SellServlet?command=sell-write-form" class="btn btn-primary">글쓰기</a>
          	</div>  
		  </c:if>


        </div>
        
        <!-- ======= Our Portfolio Section ======= -->
        <section id="portfolio" class="portfolio">
          <div class="container" data-aos="fade-up" data-aos-delay="100">

            <div class="section-title">
              <h2>CATEGORY</h2>
            </div>

            <div class="row">
              <div class="col-lg-12">
                <ul id="portfolio-flters">
                <!-- 캐릭터 일러스트 / 일러스트 / 웹툰,만화 / 디자인 / 기타 -->
                  <li data-filter="*" class="filter-active">All</li>
                  <li data-filter=".filter-일러스트">일러스트</li>
                  <li data-filter=".filter-만화">만화</li>
                  <li data-filter=".filter-도트">도트</li>
                  <li data-filter=".filter-기타">기타</li>
                </ul>
              </div>
            </div>


            <div class="row portfolio-container">


			  <c:forEach var="sell" items="${sell}">  
				  <div class="col-lg-4 col-md-6 portfolio-item filter-${sell.sell_genre}">
	                <div class="portfolio-wrap">
	                  <img src="sell_upload/${sell.sell_image1}" class="img-fluid" alt="">
	                  <div class="portfolio-info">
	                    <h4>${sell.sell_title}</h4>
	                    <p>${sell.id}</p>
	                    <div class="portfolio-links">
	                      <a href="sell_upload/${sell.sell_image1}" data-gall="portfolioGallery" class="venobox" title="${sell.id}"><i class="icofont-eye"></i></a>
	                      <a href="SellServlet?command=sell-detail&sell_no=${sell.sell_no}" title="More Details"><i class="icofont-external-link"></i></a>
	                    </div>
	                  </div>
	                </div>
	              </div>
			  </c:forEach>


            </div>

          </div>
        </section><!-- End Our Portfolio Section -->


    </div>
    </section>

  </main><!-- End #main -->

<%@ include file="footer.jsp" %>