$(document).ready(function(){
    var loginForm = $('#login_form');
    loginForm.on('submit', function(event){
        var now = new Date();
        if(now.getHours() >= 23 && now.getHours() <= 24){
            alert('23:00 ~ 24:00 사이 시스템 점검으로 로그인이 제한됩니다.');
            event.preventDefault();
            return false;
        }
        if($('#user_id').val() == '' || $('#user_pw').val() == ''){
            alert('아이디와 비밀번호를 모두 입력하세요.');
            event.preventDefault();
            return false;
        }
    });
    $('#user_id').on('keyup', function(event){
        var idCheck = $('#id2');
        if($(this).val().length < 6) {
            alert('아이디는 6글자 이상입니다');
            event.preventDefault();
            return false;
        }

    });
});