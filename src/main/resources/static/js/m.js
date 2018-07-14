var M = {};

M.init = function () {
    console.log('Init call');
};

M.login = function () {
    var data = {
        login:$('#inputLogin').val(),
        password:$('#inputPassword').val(),
    };

    $.ajax('/doLogin',{
        method:'POST',
        data:JSON.stringify(data),
        contentType: "application/json",
    });

};

M.register = function () {

};