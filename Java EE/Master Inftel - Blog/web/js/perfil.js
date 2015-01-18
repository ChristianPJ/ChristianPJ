$(function () {
    $('#form-perfil').validate({
        rules: {
            password: {
                required: true,
                minlength: 4,
                maxlength: 15
            },
            password2: {
                required: true,
                minlength: 4,
                maxlength: 15,
                equalTo : "#password"
            },
            email: {
                required: true,
                email: true
            },
            avatar: {
                required: false
            }
        },
        submitHandler: function(form) {
            form.submit();
        }
    });
});