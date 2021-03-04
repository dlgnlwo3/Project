<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="header.jsp" %>

  <!-- ======= Hero Section ======= -->
  <section id="hero">
    <div class="hero-container">
      <div id="heroCarousel" class="carousel slide carousel-fade" data-ride="carousel">

        <ol class="carousel-indicators" id="hero-carousel-indicators"></ol>

        <div class="carousel-inner" role="listbox">

          <!-- Slide 1 -->
          <div class="carousel-item active" style="background-image: url('<%=request.getContextPath()%>/pages/sample/assets/img/slide/slide-1.jpg');">
            <div class="carousel-container">
              <div class="carousel-content container">
                <h2 class="animate__animated animate__fadeInDown">WELCOME TO COMICSSION!!<span></span></h2>
                <p class="animate__animated animate__fadeInUp">의뢰게시판에서 의뢰하고, 작가게시판에서 작가로 등록하세요!</p>
              </div>
            </div>
          </div>

          <!-- Slide 2 -->
          <div class="carousel-item" style="background-image: url('<%=request.getContextPath()%>/pages/sample/assets/img/slide/slide-2.jpg');">
            <div class="carousel-container">
              <div class="carousel-content container">
                <h2 class="animate__animated animate__fadeInDown">의뢰 게시판</h2>
                <p class="animate__animated animate__fadeInUp">원하는 그림을 작가들에게 의뢰하세요.</p>
                <a href="BuyServlet?command=buy" class="btn-get-started animate__animated animate__fadeInUp scrollto">의뢰하기</a>
              </div>
            </div>
          </div>

          <!-- Slide 3 -->
          <div class="carousel-item" style="background-image: url('<%=request.getContextPath()%>/pages/sample/assets/img/slide/slide-3.jpg');">
            <div class="carousel-container">
              <div class="carousel-content container">
                <h2 class="animate__animated animate__fadeInDown">작가 게시판</h2>
                <p class="animate__animated animate__fadeInUp">Comicssion은 많은 작가님들을 기다리고 있습니다.</p>
                <a href="SellServlet?command=sell" class="btn-get-started animate__animated animate__fadeInUp scrollto">작가 등록하러 가기</a>
              </div>
            </div>
          </div>

        </div>

        <a class="carousel-control-prev" href="#heroCarousel" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon icofont-rounded-left" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#heroCarousel" role="button" data-slide="next">
          <span class="carousel-control-next-icon icofont-rounded-right" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>

      </div>
    </div>
  </section><!-- End Hero -->

  <main id="main">


    <!-- ======= Our Portfolio Section ======= -->
    <section id="portfolio" class="portfolio">
          <div class="container" data-aos="fade-up" data-aos-delay="100">

            <div class="section-title">
              <h2>CATEGORY</h2>
            </div>

            <div class="row">
              <div class="col-lg-12">
                <ul id="portfolio-flters">
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


    <!-- ======= Frequently Asked Questions Section ======= -->
    <section id="faq" class="faq section-bg">
      <div class="container">

        <div class="section-title">
          <h2>NOTICE</h2>
        </div>

        <div class="row  d-flex align-items-stretch">

          <div class="col-lg-6 faq-item" data-aos="fade-up">
            <h4>의뢰게시판 이용 안내</h4>
            <p>
              <strong>의뢰시 이하의 내용에 반드시 따라주시길 부탁드립니다.</strong><br><br>
              1. 이미지 등록시에는 출처를 분명하게 남겨주세요.<br><br>
              2. 사용 의도를 분명하게 기입해주세요.<br><br>
              3. 성인물 의뢰는 등록하실 수 없습니다.<br><br>
              4. 작업 완료 기한은 최종 작업물 완료 기한입니다.<br><br>
              5. 부담 가능한 예산을 반드시 기입 후, 작가와 합의해주세요.
            </p>
          </div>

          <div class="col-lg-6 faq-item" data-aos="fade-up" data-aos-delay="100">
            <h4>작가게시판 이용 안내</h4>
            <p>
              1. 도용된 작품이 아닌 반드시 본인의 작품만 업로드해주세요.</p>
            <p>  2. 2차 저작물에 대한 샘플을 올리는 것은 가능하지만,<br> 2차 저작물으로 이익을 창출하는 상업적인 용도는 제한되므로 의뢰를 받을 수 없습니다.</p>
             <p> 3. 게임 캐릭터를 의뢰 받으실 때는 의뢰자의 캐릭터가 의뢰자의 캐릭터가 맞는지 확인해주시길 바랍니다.
            </p>
            <p>4. 아동청소년보호법 2조 5호에 의거하여 불이익을 받지 않도록 면밀히 검토하여 의뢰를 받아주시길 바랍니다.</p>
            <strong>이로 인해 발생하는 문제는 Comicssion에서 책임지지 아니하며,<br> 본인(작가)에게 책임이 있음을 알려드립니다.</strong>
          </div>

        </div>

      </div>
    </section><!-- End Frequently Asked Questions Section -->


    <!-- ======= Contact Us Section ======= -->
    <section id="contact" class="contact">
      <div class="container">

        <div class="section-title">
          <h2>C/S CENTER</h2>
        </div>

        <div class="row">

          <div class="col-lg-4 d-flex align-items-stretch" data-aos="fade-up">
            <div class="info-box">
              <i class="bx bx-map"></i>
              <h3>Our Address</h3>
              <p>126, Jangja-daero, Guri-si <br>
              Gyonggi-do, Republic of Korea</p>
            </div>
          </div>

          <div class="col-lg-4 d-flex align-items-stretch" data-aos="fade-up" data-aos-delay="100">
            <div class="info-box">
              <i class="bx bx-envelope"></i>
              <h3>Email Us</h3>
              <p>dlgnlwo3@naver.com
            </div>
          </div>

          <div class="col-lg-4 d-flex align-items-stretch" data-aos="fade-up" data-aos-delay="200">
            <div class="info-box ">
              <i class="bx bx-phone-call"></i>
              <h3>Call Us</h3>
              <p>+82 010-9817-9590
            </div>
          </div>
          

    </section><!-- End Contact Us Section -->

  </main><!-- End #main -->

<%@ include file="footer.jsp" %>