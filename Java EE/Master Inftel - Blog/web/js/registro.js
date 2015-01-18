$(function () {
    $('#form-registro').validate({
        rules: {
            username: {
                required: true,
                alphanumeric: true,
                maxlength: 15
            },
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
                required: true
            }
        },
        submitHandler: function(form) {
            form.submit();
        }
    });
});