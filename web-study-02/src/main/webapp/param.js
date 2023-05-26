function check(){

    if(document.frm.id.value === ""){
    //id에 값이 "" 없을 때
        alert("아이디를 입력해주세요.");
        document.frm.id.focus();
        //커서가 다시 입력하라고 돌아가줌, 안쓰면 클릭해서 화면에 클릭해서 입력값 넣으면 됨
        return false;
    }else if (document.frm.age.value === ""){
    //age에 값이 "" 없을 때
        alert("나이를 입력해주세요.");
        document.frm.age.focus();
        return false;
    }else if (isNaN(document.frm.age.value)){
        alert("숫자만 입력해주세요.");
        document.frm.age.focus();
        return false;
    }else{
        return true;
    }

}