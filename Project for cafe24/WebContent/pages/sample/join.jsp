<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>JoinComicssion</title>
  
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
              <h3 class="card-title text-left mb-3">JOIN</h3>
              
              
              
              <form action="join.do" method="post" name="frm">
                <div class="form-group">
                  <label>ID</label>
                  <input type="text" name="id" class="form-control p_input">
                  <input type="hidden" name="reid" size="20">
                </div>
                <div class="form-group">
                  <input type="button" value="중복체크" onclick="idCheck()" class="btn btn-primary btn-block enter-btn">
                </div>

                <div class="form-group">
                  <label>Password</label>
                  <input type="password" name="pw" class="form-control p_input">
                </div>
                <div class="form-group">
                    <label>Password Check</label>
                    <input type="password" name="pw_check" class="form-control p_input">
                </div>

                <div class="form-group">
                  <label>이름</label>
                  <input type="text" name="name" class="form-control p_input">
                </div>

                <div class="form-group">
                  <label>연락처</label>
                  <input type="text" name="tel" class="form-control p_input" placeholder="-없이 입력">
                </div>

                <div class="form-group">
                  <label>메일</label>
                  <input type="text" name="email" class="form-control p_input">
                </div>

                <div class="form-group">
                    <label>생년</label>
                    <div class="row">
						<div class="col">
							<input type="number" name="birth" min="1900" max="2021" maxlength="4" class="form-control p_input" placeholder="탄생한 년도(4자)">
						</div>
                    </div>
                </div>
                
                <div class="form-group">

                </div>

                <div class="text-center">
                  <button type="submit" class="btn btn-primary btn-block enter-btn" onclick="return joinCheck()">가입하기</button>
                </div>
                <p class="sign-up text-center">이미 계정을 갖고계신가요?<a href="login.do"><br> 로그인 화면으로</a></p>
                
                <br>
                <p style="text-align:center; color:red;">${message}</p>
              </form>
       
              
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