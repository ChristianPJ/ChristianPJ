/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function disconnectUser(event, access_token) {
    event.preventDefault();
    var revokeUrl = 'https://accounts.google.com/o/oauth2/revoke?token=' +
            access_token;

    console.log(revokeUrl);
    $.ajax({
        type: 'GET',
        url: revokeUrl,
        async: false,
        contentType: "application/json",
        dataType: 'jsonp',
        success: function (nullResponse) {
            invalidateSession();
        },
        error: function (e) {

        }
    });
}
function invalidateSession() {
    window.location.replace('login.xhtml');
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/SN-web/LogoutServlet',
        success: function (result) {
            if (!result['error']) {

            }
        },
        data: null,
        dataType: "jsonp"
    });
}
