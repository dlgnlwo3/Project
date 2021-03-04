<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="header.jsp" %>    
    

  <main id="main">

    <style>
      .portfolio-details-carousel img{
        width: 100%;
        height: fit-content;
        object-fit: cover;
      }
    </style>
        
    <!-- ======= Breadcrumbs Section ======= -->
    <section class="breadcrumbs">
      <div class="container">

        <div class="d-flex justify-content-between align-items-center">
          <h2><strong style="font-weight: bold">${sell.id}</strong>님의 작품</h2>
          <ol>
            <li><a href="index.do">HOME</a></li>
            <li><a href="SellServlet?command=sell">작가 게시판</a></li>
            <li>작가 게시판</li>
          </ol>
        </div>

      </div>
    </section><!-- Breadcrumbs Section -->

    <!-- ======= Portfolio Details Section ======= -->
    <section class="portfolio-details">
      <div class="container">

        <div class="portfolio-details-container">

          <div class="owl-carousel portfolio-details-carousel">
            <img src="sell_upload/${sell.sell_image1}" class="img-fluid" alt="">
            
            <c:if test="${!empty sell.sell_image2}">
            	<img src="sell_upload/${sell.sell_image2}" class="img-fluid" alt="">  
            </c:if>
            
            <c:if test="${!empty sell.sell_image3}">
            	<img src="sell_upload/${sell.sell_image3}" class="img-fluid" alt="">  
            </c:if>
          </div>

          <div class="portfolio-info">
            <h3>${sell.sell_title}</h3>
            <ul>
              <li><strong>장르</strong>: ${sell.sell_genre}</li>
              <li><strong>작성자</strong>: ${sell.id}</li>
              <li><strong>조회수</strong>: ${sell.sell_count}</li>
              <li><strong>연락처</strong>: ${sell.tel}</li>
              <li><strong>이메일</strong>: <a href="#">${sell.email}</a></li>
            </ul>
          </div>

        </div>

        <div class="portfolio-description">
          <h2>설명</h2>
          <p>
            ${sell.sell_content}
          </p>
        </div>

        <div align="right">
        <a href="SellServlet?command=sell" class="btn btn-primary">목록</a>
       
        
        <c:if test="${sell.id == loginUser.id}">
        	<a href="SellServlet?command=sell-update-form&sell_no=${sell.sell_no}" class="btn btn-primary">수정</a>
        	<a href="SellServlet?command=sell-delete&sell_no=${sell.sell_no}" class="btn btn-primary" onclick="return confirm('정말 삭제하시겠습니까?');">삭제</a>
		</c:if>
		 </div>
		 
      </div>

        <!-- 댓글창 --------------------------------------------------------------------------------------->
        <div id="content4" class="container" style="margin-top:80px; margin-bottom:50px; border: 1px solid #f7f7f7; border-radius: 30px">

          <div class="title_area">
            <h3 id="comment_title">
              <strong>COMMENT</strong>
            </h3>
            
            <c:if test="${!empty loginUser}">
            	<button id="write_comment" class="btn btn-primary" data-toggle="modal" data-target="#myModal">댓글쓰기</button>
            </c:if>
            
          </div>


          <div class="result" style="margin-top:80px;">     
          
            <ul>       
            
            	<c:forEach var="replyList" items="${replyList}" varStatus="status">
            		<li>
		                <div style="border-bottom: solid 1px #f7f7f7; height: 50px">
		                  <b>
		                  	${replyList.sr_content}
		                  </b>
		                  	${replyList.sr_date} / ${replyList.id}
		                  	<c:if test="${replyList.id == loginUser.id}">
			                	<div align="right"><a href="SellServlet?command=sell-reply-delete&sr_no=${replyList.sr_no}&sell_no=${replyList.sell_no}" class="btn btn-danger" style="margin-top: -22px;" type="button" onclick="return confirm('정말 삭제하시겠습니까?')">삭제</a></div>           	
		                  	</c:if>		                
		                </div>
              		</li>
            	</c:forEach>            
            
            </ul>            
            
          </div>
        </div>
        <!-- 댓글창 끝 -->
      
      
      
      
        <!-- 댓글입력 모달 ----------------------------------------------------------------------------------->
        <div class="modal fade" id="myModal">

          <div class="modal-dialog">
            <div class="modal-content">

              <form name="frm" action="SellServlet?command=sell-reply-write" method="post">

                <!-- Modal Header -->
                <div class="modal-header">
                  <h4 class="modal-title">댓글 입력</h4>
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                  <label for="comment">댓글:</label>
                  <textarea class="form-control" rows="5" name="sr_content" id="comment"></textarea>
                  <input type="hidden" name="sell_no" value="${sell.sell_no}">
                  <input type="hidden" name="id" value="${loginUser.id}">
                </div>

                <!-- Modal footer -->
                <div class="modal-footer">
                  <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                  <input type="submit" value="submit" class="btn btn-primary"></input>
                </div>

              </form>

            </div>
          </div>

        </div>
        <!-- 모달 끝 -->



    </section><!-- End Portfolio Details Section -->

  </main><!-- End #main -->

<%@ include file="footer.jsp" %>