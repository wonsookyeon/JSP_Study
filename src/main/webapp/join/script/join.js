function joinCheck(){

    if(document.frm.name.value.length == 0){
        alert("이름을 써주세요.");
        frm.name.focus();
        return false;
    }

    if(document.frm.id.value == ""){
        alert("아이디를 입력해주세요.");
        frm.id.focus();
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

    
    if(document.frm.email.value == ""){
        alert("이메일을 입력해주세요.");
        frm.email.focus();
        return false;
    }
    if(document.frm.phone.value == ""){
        alert("전화번호를 입력해주세요.");
        frm.phone.focus();
        return false;
    }
    
    
    

}

function idCheck(){

    if(document.frm.id.value == ""){
    	alert("아이디를 입력해주세요.")
        document.frm.id.focus();
        return false;
    }

    var url = "main?command=id_check&id=" + document.frm.id.value;
    window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");

}

function idok(){
    opener.frm.id.value = document.frm.id.value; // 중복체크했을때 아이디 사용 누르면 회원가입 아이디입력창에 들어가게 하는 코드
    opener.frm.reid.value = document.frm.id.value;
    self.close();

}