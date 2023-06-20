function validateForm() {
    var id = document.getElementsByName("id")[0].value;
    var pw = document.getElementsByName("pw")[0].value;
    var name = document.getElementsByName("name")[0].value;
    var birth = document.getElementsByName("birth")[0].value;
    var age = document.getElementsByName("age")[0].value;
    var email = document.getElementsByName("email")[0].value;
    var addr = document.getElementsByName("addr")[0].value;

    if (id === "" || pw === "" || name === "" || birth === "" || age === "" || email === "" || addr === "") {
        alert("모든 정보를 기입해야 합니다.");
        return false;
    } else {
        alert("가입이 완료되었습니다.");
        return true;
    }
}