function loginCheck(){
    if(document.frm.userid.value.length == 0){
        alert("아이디를 써주세요.");
        frm.userid.focus();
        return false;
    }
    if(document.frm.pwd.value == ""){
        alert("비밀번호를 입력해주세요.");
        frm.pwd.focus();
        return false;
    }
    
    return true;
}

function joinCheck(){

    if(document.frm.name.value.length == 0){
        alert("이름을 써주세요.");
        frm.name.focus();
        return false;
    }

    if(document.frm.pwd.value == ""){
        alert("비밀번호를 입력해주세요.");
        frm.pwd.focus();
        return false;
    }

    if(document.frm.pwd.value != document.frm.pwd_check.value){
        alert("암호가 일치하지 않습니다.");
        frm.pwd.focus();
        return false;
    }
}

function idCheck(){
    if(document.frm.userid.value == ""){
        alert("아이디를 입력해주세요.")
        document.frm.userid.focus();
        return false;
    }

    var url = "idCheck.do?userid=" + document.frm.userid.value;
    window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");

}

function idok(){
    opener.frm.userid.value = document.frm.userid.value; // 중복체크했을때 아이디 사용 누르면 회원가입 아이디입력창에 들어가게 하는 코드
    opener.frm.reid.value = document.frm.userid.value;
    self.close();

}
