function loginCheck(){
	if(document.frm.id.value.length == 0){
		alert("아이디를 입력해주세요");
		frm.id.focus();
		return false;
	}
	
	if(document.frm.pw.value == ""){
		alert("비밀번호를 입력해주세요");
		frm.pw.focus();
		return false;
	}
	return true;
}






function idCheck(){
	if(document.frm.id.value == ""){
		alert('아이디를 입력해주세요');
		document.frm.userid.focus();
		return;
	}
	
	var url = "idCheck.do?id=" + document.frm.id.value;
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
	
}





function idok(){
	opener.frm.id.value = document.frm.id.value;
	opener.frm.reid.value = document.frm.id.value;
	self.close();
	window.close();
}





function joinCheck(){
	if(document.frm.id.value.length == 0){
		alert("아이디를 입력해주세요");
		frm.id.focus();
		return false;
	}
	
	if(document.frm.id.value.length < 3){
		alert("아이디는 3글자 이상이어야 합니다");
		frm.id.focus();
		return false;
	}
	
	if(document.frm.pw.value == ""){
		alert("비밀번호를 입력해주세요");
		frm.pw.focus();
		return false;
	}
	
	if(document.frm.pw.value != document.frm.pw_check.value){
		alert("비밀번호가 일치하지 않습니다");
		frm.pw.focus();
		return false;
	}
	
	if(document.frm.name.value.length == 0){
		alert("이름 입력해주세요");
		frm.name.focus();
		return false;
	}
	
	if(document.frm.tel.value.length == 0){
		alert("연락처를 입력해주세요");
		frm.tel.focus();
		return false;
	}
	
	if(document.frm.email.value.length == 0){
		alert("메일주소를 입력해주세요");
		frm.email.focus();
		return false;
	}
	
	if(document.frm.birth.value.length == 0){
		alert("연령을 입력해주세요");
		frm.birth.focus();
		return false;
	}
	
	if(document.frm.reid.value != document.frm.id.value){
		alert("중복체크를 하지 않았습니다.");
		frm.id.focus();
		return false;
	}
	
	return true;
}


function updateCheck(){
	
	if(document.frm.pw.value == ""){
		alert("비밀번호를 입력해주세요");
		frm.pw.focus();
		return false;
	}
	
	if(document.frm.pw.value != document.frm.pw_check.value){
		alert("비밀번호가 일치하지 않습니다");
		frm.pw.focus();
		return false;
	}
	
	if(document.frm.name.value.length == 0){
		alert("이름 입력해주세요");
		frm.name.focus();
		return false;
	}
	
	if(document.frm.tel.value.length == 0){
		alert("연락처를 입력해주세요");
		frm.tel.focus();
		return false;
	}
	
	if(document.frm.email.value.length == 0){
		alert("메일주소를 입력해주세요");
		frm.email.focus();
		return false;
	}
	
	if(document.frm.birth.value.length == 0){
		alert("연령을 입력해주세요");
		frm.birth.focus();
		return false;
	}
	
	if(confirm("정말 수정하시겠습니까??") == true) {
		alert("수정완료. 다시 로그인 해주세요.");
		return true;
	}else{
		return false;
	}

}



function deleteCheck() {

	if(document.frm.pw.value == ""){
		alert("비밀번호를 입력해주세요.");
		frm.pw.focus();
		return false;
	}
	
	if(confirm("정말 탈퇴하시겠습니까? 지금까지 작성하신 글이 모두 삭제됩니다.")){
		return true;
	}else{
		return false;
	}

}
