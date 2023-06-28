function updateCheck(){

    if(document.frm.name.value.length == 0){
        alert("이름을 써주세요.");
        frm.name.focus();
        return false;
    }

    
    if(document.frm.pass.value == ""){
        alert("비밀번호를 입력해주세요.");
        frm.pass.focus();
        return false;
        }
        
	if(document.frm.pass_check.value == ""){
        alert("비밀번호를 한번 더 입력해주세요.");
        frm.pass_check.focus();
        return false;
	}

    if(document.frm.pass.value != document.frm.pass_check.value){
        alert("암호가 일치하지 않습니다.");
        frm.pass.focus();
        return false;
    }
}


function deleteCheck() {

	if(document.frm.pass.value != document.frm.pass_check.value){
        alert("암호가 일치하지 않습니다.");
        frm.pass.focus();
        return false;
    }else {
        alert("회원 탈퇴되었습니다.");
        frm.pass.focus();
        return true;
    }


}