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
          <h2><strong style="font-weight: bold">${buy.id}</strong>님의 의뢰글</h2>
          <ol>
            <li><a href="index.do">HOME</a></li>
            <li><a href="BuyServlet?command=buy">의뢰 게시판</a></li>
            <li>${buy.id}님의 의뢰글</li>
          </ol>
        </div>

      </div>
    </section><!-- End Breadcrumbs Section -->

    <section class="inner-page">
      

      <!-- 게시판 -->
      <div class="container">

        <div class="row">
            <table class="table table-borderless" style="text-align: center; border: 1px solid #f7f7f7">
              
              <thead>
                <tr>
                  <th colspan="3" style="background-color: #f7f7f7; text-align: center;">글 보기 </th>
                </tr>
              </thead>

              <tbody>
              
                <tr>
                  <td style="width: 20%;"> 글 번호 </td>
                  <td colspan="2">${buy.buy_no}</td>
                </tr>
              
                <tr>
                  <td style="width: 20%;"> 글 제목 </td>
                  <td colspan="2">${buy.buy_title}</td>
                </tr>

                <tr>
                  <td>작성자</td>	
                  <td colspan="2">${buy.id}</td>
                </tr>

                <tr>
                  <td>조회수</td>	
                  <td colspan="2">${buy.buy_count}</td>
                </tr>

                <tr>
                  <td>작성일</td>	
                  <td colspan="2">${buy.buy_date}</td>
                </tr>

                <tr>
                  <td>완료기한</td>	
                  <td colspan="2">${buy.buy_deadline}</td>
                </tr>

				<c:if test="${!empty buy.buy_image}">
	                <tr>
	                  <td>첨부파일</td>	
	                  <td colspan="2">${buy.buy_image}</td>
	                </tr>
				</c:if>
				
                <tr>
                  <td>내용</td>	
                  <td colspan="2" style="min-height: 200px; text-align: left;">
                  
                  	<c:if test="${!empty buy.buy_image}">
                  		<div>
                      		<img src="buy_upload/${buy.buy_image}" style="max-width: 100%;">
                    	</div>
                  	</c:if>
                  
                    ${buy.buy_content}
                  </td>
                </tr>
              </tbody>

            </table>	     
        </div>
        
        <div align="right">
            <a href="BuyServlet?command=buy&pageno=${pageno}" class="btn btn-primary">목록</a>
            
            <c:if test="${buy.id == loginUser.id}">
            	<a href="BuyServlet?command=buy-update-form&buy_no=${buy.buy_no}" class="btn btn-primary">수정</a>
            	<a href="BuyServlet?command=buy-delete&buy_no=${buy.buy_no}" class="btn btn-primary" onclick="return confirm('정말 삭제하시겠습니까?');">삭제</a>
            </c:if>
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
		                  	${replyList.br_content}
		                  </b>
		                  	${replyList.br_date} / ${replyList.id}
		                  	<c:if test="${replyList.id == loginUser.id}">
			                	<div align="right"><a href="BuyServlet?command=buy-reply-delete&br_no=${replyList.br_no}&buy_no=${replyList.buy_no}" class="btn btn-danger" style="margin-top: -22px;" type="button" onclick="return confirm('정말 삭제하시겠습니까?')">삭제</a></div>           	
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

              <form name="frm" action="BuyServlet?command=buy-reply-write" method="post">

                <!-- Modal Header -->
                <div class="modal-header">
                  <h4 class="modal-title">댓글 입력</h4>
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                  <label for="comment">댓글:</label>
                  <textarea class="form-control" rows="5" name="br_content" id="comment"></textarea>
                  <input type="hidden" name="buy_no" value="${buy.buy_no}">
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
   
        
        

      </div>

      
    </section>

  </main><!-- End #main -->

<%@ include file="footer.jsp" %>