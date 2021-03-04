<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
$(document).ready(function(){
	/* location.href=history.go(-1) */
	var referrer = document.referrer;
	var count=null;
	console.log('referrer -> ' + referrer);

	location.replace('BuyServlet?command=buy');
});
</script>
</head>
<body>


</body>
</html>