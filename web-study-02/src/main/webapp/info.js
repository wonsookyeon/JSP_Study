function check(){

    if(document.frm.name.value === ""){
    //이름에 값이 "" 없을 때
        alert("이름을 입력해주세요.");
        document.frm.name.focus();
        //커서가 다시 입력하라고 돌아가줌, 안쓰면 클릭해서 화면에 클릭해서 입력값 넣으면 됨
        return false;
    }else if (document.frm.addr.value === ""){
    //주소에 값이 "" 없을 때
        alert("주소를 입력해주세요.");
        document.frm.addr.focus();
        return false;
    }else{
        return true;
    }

}

function check2(){

    if(document.frm2.name.value === ""){
    //이름에 값이 "" 없을 때
        alert("이름을 입력해주세요.");
        document.frm2.name.focus();
        //커서가 다시 입력하라고 돌아가줌, 안쓰면 클릭해서 화면에 클릭해서 입력값 넣으면 됨
        return false;
    }else if (document.frm2.addr.value === ""){
    //주소에 값이 "" 없을 때
        alert("주소를 입력해주세요.");
        document.frm2.addr.focus();
        return false;
    }else{
        return true;
    }

}