<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="header.jsp" %>


  <main id="main">
  
  <link rel="stylesheet" property="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

    <!-- ======= Breadcrumbs Section ======= -->
    <section class="breadcrumbs">
      <div class="container">

        <div class="d-flex justify-content-between align-items-center">
          <h2>Search</h2>
          <ol>
            <li><a href="index.do">Home</a></li>
            <li>search</li>
          </ol>
        </div>

      </div>
    </section><!-- End Breadcrumbs Section -->


    <section class="inner-page">
      <div class="container">
  
        <h3>검색</h3>
        <hr style="margin-bottom: 2%;">

        <div class="container" style="padding: 0;">

		<c:if test="${!empty loginUser}">
			<div class="float-right" style="margin-bottom: 2%; margin-right: 3%;">
        		<a href="BuyServlet?command=buy-write-form" class="btn btn-primary">글쓰기</a>
          	</div>
		</c:if>       

        </div>

        <table class="table table-bordered table-striped">

          <thead>
            <tr>
              <th>글번호</th>
              <th>제목</th>
              <th>작성자</th>
              <th>작성일</th>
              <th>완료기한</th>
            </tr>
          </thead>

          <tbody>
          
          	<c:forEach var="buy" items="${buy}">
	            <tr>
	              <td>${buy.buy_no}</td>
	              <td><a href="BuyServlet?command=buy-detail&buy_no=${buy.buy_no}">${buy.buy_title}</a></td>
	              <td>${buy.id}</td>
	              <td>${buy.buy_date}</td>
	              <td>${buy.buy_deadline}</td>
	            </tr>
			</c:forEach>
			
          </tbody>

        </table>

        <hr/>

		<form action="BuyServlet?command=buy-search" name="frm" method="post">
			<div class="text-center">
	          <select id="option" name="search_keyword">
	            <option value="buy_title">제목</option>
	            <option value="buy_content">내용</option>
	            <option value="id">작성자</option>
	          </select>
	          <input type="text" name="search_text">
	          <input type="submit" class="btn btn-primary" value="검색">
	        </div>
		</form>

        <div class="text-center">          
          <ul class="pagination">
          
          	<c:if test="${startpage > 1}">
          		<li><a href="BuyServlet?command=buy-search&search_keyword=${search_keyword}&search_text=${search_text}&pageno=1">처음으로</a></li>
          	</c:if>
          	
          	<c:if test="${pageno > 1}">
          		<li><a href="BuyServlet?command=buy-search&search_keyword=${search_keyword}&search_text=${search_text}&pageno=${pageno-1}">이전</a></li>
          	</c:if>
			
			<c:forEach var="i" begin="${startpage}" end="${endpage}">
				<li><a href="BuyServlet?command=buy-search&search_keyword=${search_keyword}&search_text=${search_text}&pageno=${i}">${i}</a></li>
			</c:forEach>
  	
  			<c:if test="${pageno < totalpage}">
  			   <li><a href="BuyServlet?command=buy-search&search_keyword=${search_keyword}&search_text=${search_text}&pageno=${pageno+1}">다음</a></li>
  			</c:if>
  	
  			<c:if test="${endpage < totalpage}">
  				<li><a href="BuyServlet?command=buy-search&search_keyword=${search_keyword}&search_text=${search_text}&pageno=${totalpage}">끝으로</a></li>
  			</c:if>
  	
          </ul>
        </div>

      </div>
    </section>

  </main><!-- End #main -->

<%@ include file="footer.jsp" %>