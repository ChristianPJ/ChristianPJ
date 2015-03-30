/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(window).load(function () {
    $('img.bgfade').hide();
    var dg_H = $(window).height();
    var dg_W = $(window).width();
    $('#wrap').css({'height': dg_H, 'width': dg_W});
    function anim() {
        $("#wrap img.bgfade").first().appendTo('#wrap').fadeOut(1500);
        $("#wrap img").first().fadeIn(3000);
        setTimeout(anim, 5000);
    }
    anim();
});

$(window).bind('resize', function () {
    window.location.href = window.location.href;
});

function signInCallback(authResult) {
    if (authResult['access_token']) {
        console.log(authResult);
        $('#signinButton').attr('style', 'display: none');
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/SN-web/TokenServlet',
            contentType: 'application/octet-stream; charset=utf-8',
            success: function (response) {
                retrieveData(authResult['access_token']);
            },
            processData: false,
            data: JSON.stringify(authResult['access_token'])
        });
    }
}

function retrieveData(token) {
    console.log(token);
    $.ajax({
        type: 'POST',
        url: 'https://www.googleapis.com/oauth2/v1/userinfo?access_token=' + token,
        success: function (result) {
            if (!result['error']) {
                sendDataToServer(result);
            }
        },
        data: null,
        dataType: "jsonp"
    });
}
function sendDataToServer(user) {
    console.log(user);
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/SN-web/LoginServlet',
        contentType: 'application/octet-stream; charset=utf-8',
        success: function (result) {
            if (!result['error']) {
                window.location.replace('index.xhtml');
            }
        },
        processData: false,
        data: JSON.stringify(user)
    });
}
