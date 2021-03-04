<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>LoginComicssion</title>
  
  <!-- inject:css -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
  
  <script src="<%=request.getContextPath()%>/pages/sample/js/member.js"></script>

</head>

<body>
  <div class="container-scroller">
    <div class="container-fluid page-body-wrapper">
      <div class="row">
        <div class="content-wrapper full-page-wrapper d-flex align-items-center">
          <div class="card col-lg-4 mx-auto">
            <div class="card-body px-5 py-5">
              <h3 class="card-title text-left mb-3">LOGIN</h3>
              
              
              <!--로그인 ----------------------------------------------->
              <form method="post" action="login.do" name="frm">
                <div class="form-group">
                  <label>MemberID *</label>
                  <input type="text" class="form-control p_input" name="id" id="id" value="${id}" />
                </div>
                <div class="form-group">
                  <label>Password *</label>
                  <input type="password" class="form-control p_input" name="pw" id="pw">
                </div>
                <div class="form-group d-flex align-items-center justify-content-between">

                </div>
                <div class="text-center">
                  <input type="submit" class="btn btn-primary btn-block enter-btn" id="login" value="로그인" onclick="return loginCheck()" />
                  <button type="button" class="btn btn-danger btn-block enter-btn" onclick="location.href='index.do'" id="logincancel">취소</button>
                </div>

                <p class="sign-up">계정이 없으신가요?<a href="join.do"> 회원가입</a></p>
                
                <br>
                <p style="text-align:center; color:red;">${message}</p>
                
               </form>
               <!--로그인-->
                            
            </div>
          </div>
        </div>
        <!-- content-wrapper ends -->
      </div>
      <!-- row ends -->
    </div>
    <!-- page-body-wrapper ends -->
  </div>



</body>

</html>
