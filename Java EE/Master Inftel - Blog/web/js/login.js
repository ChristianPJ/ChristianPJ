$(function () {
    $('#form-login').validate({
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
            }
        },
        submitHandler: function(form) {
            form.submit();
        }
    });
});