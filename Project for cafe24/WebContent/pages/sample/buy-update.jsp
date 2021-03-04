<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="header.jsp" %>    
    


  <main id="main">
  
  <style>
    form div + div{
      margin-top: 1em;
    }

    textarea{
      font: 1em sans-serif;
      width: 70%;
      box-sizing: border-box;
      border: 1px solid #999;
      vertical-align: top;
      height: 400px;
      resize: vertical;
    }

    input:focus, textarea:focus{
      border-color: #000;
    }
  </style>
  
  
    <!-- 날짜가 null일 경우 -->
  	<script type="text/javascript">
  		function updateBuy() {
  			if(document.frm.buy_deadline.value == ""){
  				alert("날짜를 입력해주세요");
  				frm.buy_deadline.focus();
  				return false;
  			}
  			return true;
  		}
  	</script>

    <!-- ======= Breadcrumbs Section ======= -->
    <section class="breadcrumbs">
      <div class="container">

        <div class="d-flex justify-content-between align-items-center">
          <h2>글 수정하기</h2>
          <ol>
            <li><a href="index.html">HOME</a></li>
            <li><a href="BuyServlet?command=buy">의뢰 게시판</a></li>
            <li>글 수정하기</li>
          </ol>
        </div>

      </div>
    </section><!-- End Breadcrumbs Section -->

    <section class="inner-page">


      <div class="container">

        <form name="frm" action="BuyServlet?command=buy-update" method="post" enctype="multipart/form-data">
		  <input type="hidden" name="buy_no" value="${buy.buy_no}">
		  
          <div class="row">

            <table class="table table-borderless" style="text-align: center; border: 1px solid #f7f7f7">
              
              <thead>
                <tr>
                  <th colspan="3" style="background-color: #f7f7f7; text-align: center;">글 수정 </th>
                </tr>
              </thead>

              <tbody>
                <tr>
                  <td style="width: 20%;"> 글 제목 </td>
                  <td colspan="2" align="left"><div style="margin-left:40px"><input type="text" id="buy_title" name="buy_title" value="${buy.buy_title}" style="width: 300px"/></div></td>
                </tr>

                <tr>
                  <td>작성자</td>	
                  <td colspan="2" align="left"><div style="margin-left:40px"><input type="text" name="id" value="${buy.id}" readonly style="width: 300px"></div></td>
                </tr>

                <tr>
                  <td>완료기한</td>
                  <td colspan="2" align="left"><div style="margin-left:40px"><input id="datepicker" type="date" name="buy_deadline" value="${buy.buy_deadline}" style="width: 300px"></div></td>
                </tr>

                <tr>
                  <td>첨부파일</td>	
                  <td colspan="2" align="left"><div style="margin-left:40px"><input type="file" id="buy_image" name="buy_image" accept="image/png, image/jpeg" value="${buy.buy_image}" style="width: 300px"></div></td>
                </tr>

                <tr>
                  <td>내용</td>	
                  <td colspan="2" style="min-height: 200px; text-align: left;" align="left"><div style="margin-left:40px"><textarea id="buy_content" name="buy_content" placeholder="이 곳에 주의사항을 입력해주세요.">${buy.buy_content}</textarea></div></td>
                </tr>
              </tbody>

            </table>	

          </div>

            <div align="right">
              <button type="submit" class="btn btn-primary" onclick="return updateBuy()">완료</button>
            </div>
            

        </form>

      </div>
      
    </section>

  </main><!-- End #main -->


<%@ include file="footer.jsp" %>