<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IDCheck</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<script src="<%=request.getContextPath()%>/pages/sample/js/member.js"></script>

<style>
	body{
	    background-color: #fff;
	}
	#idcheckdiv{
		background: white;
		border:solid 1px #D9E5FF;
		width:500px;
		height:200px;
		margin:auto;
		border-radius:13px;
		margin-top:25px;
	}
    h3{
        margin : 30px;
    }
</style>

</head>
<body onresize="parent.resizeTo(420,300)" onload="parent.resizeTo(420,300)">

	<div id="idcheckdiv">
		<h3 style="text-align:center;">아이디 중복확인</h3>
		<form action="idCheck.do" method="get" name="frm">
			<p style="text-align:center;">ID <input type="text" name="id" value="${id}"> <input class="btn btn-primary" type="submit" value="중복체크"></p>
			
			<c:if test="${result == 1}">
				<script type="text/javascript">opener.document.frm.id.value="";</script>
				<p style="text-align:center;">${id}는 이미 사용 중인 아이디입니다.</p>
			</c:if>
			
			<c:if test="${result == -1}">
				<p style="text-align:center;">${id}는 사용 가능한 아이디입니다.
				<input class="btn btn-primary" type="button" value="사용" class="cancel" onclick="idok()"></p>
			</c:if>
			
		</form>
	</div>

</body>
</html>