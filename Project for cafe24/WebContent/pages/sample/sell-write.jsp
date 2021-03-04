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

    input{
      font: 1em sans-serif;
      width: 300px;
      box-sizing: border-box;
      border: 1px solid #999;
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
  
  <script type="text/javascript">
		function updateSell() {
			
			if(document.frm.sell_image1.value == ""){
				alert("이미지1 입력 필수");
				frm.sell_image1.focus();
				return false;
			}
			
			return true;
		}
  </script>	


    <!-- ======= Breadcrumbs Section ======= -->
    <section class="breadcrumbs">
      <div class="container">

        <div class="d-flex justify-content-between align-items-center">
          <h2>sell-write</h2>
          <ol>
            <li><a href="index.do">Home</a></li>
            <li><a href="SellServlet?command=sell">sell</a></li>
            <li>sell-write</li>
          </ol>
        </div>

      </div>
    </section><!-- End Breadcrumbs Section -->

    <section class="inner-page">


      <div class="container">

        <form name="frm" action="SellServlet?command=sell-write" method="post" enctype="multipart/form-data">

          <div class="row">

            <table class="table table-borderless" style="text-align: center; border: 1px solid #f7f7f7">
              
              <thead>
                <tr>
                  <th colspan="3" style="background-color: #f7f7f7; text-align: center;">작품 등록</th>
                </tr>
              </thead>

              <tbody>
              
              <tr>
              <td style="width: 20%;"> 글 제목 </td>
                  <td colspan="2" align="left"><div style="margin-left:40px"><input type="text" id="sell_title" name="sell_title" style="width: 300px"/></div></td> 
              </tr>
                <tr>
             <td>장르</td>	
                    <td colspan="2" align="left">
                    <div style="margin-left:40px">
                        <select name="sell_genre" id="sell_genre">
                            <option value="일러스트">일러스트</option>
                            <option value="도트">도트</option>
                            <option value="만화">만화</option>
                            <option value="기타">기타</option>
                        </select>
                    </div>
                   
                </tr>

                <tr>
                  <td>작성자</td>	
                  <td colspan="2" align="left">
                  	<div style="margin-left:40px">
                  		<input type="text" name="id" value="${loginUser.id}" readonly style="width: 300px">
                  		<input type="hidden" name="tel" value="${loginUser.tel}">
                  		<input type="hidden" name="email" value="${loginUser.email}">            
                  	</div>
                  </td>
                </tr>
                
                <tr>
                   
                </tr>

                <tr>
                  <td>이미지1 *</td>	
                  <td colspan="2" align="left"><div style="margin-left:40px"><input type="file" id="sell_image1" name="sell_image1" accept="image/png, image/jpeg"></div></td>
                </tr>

                <tr>
                  <td>이미지2</td>	
                  <td colspan="2" align="left"><div style="margin-left:40px"><input type="file" id="sell_image2" name="sell_image2" accept="image/png, image/jpeg"></div></td>
                </tr>

                <tr>
                  <td>이미지3</td>	
                  <td colspan="2" align="left"><div style="margin-left:40px"><input type="file" id="sell_image3" name="sell_image3" accept="image/png, image/jpeg"></div></td>
                </tr>

                <tr>
                  <td>내용</td>	
                  <td colspan="2" style="min-height: 200px; text-align: left; align="left"><div style="margin-left:40px"><textarea id="sell_content" name="sell_content" placeholder="판매페이지임"></textarea></div></td>
                </tr>
              </tbody>

            </table>	

          </div>
          
          <div align="right">
              <input type="submit" class="btn btn-primary" value="완료" onclick="return updateSell()">
            </div>

        </form>

      </div>
      
    </section>

  </main><!-- End #main -->

<%@ include file="footer.jsp" %>