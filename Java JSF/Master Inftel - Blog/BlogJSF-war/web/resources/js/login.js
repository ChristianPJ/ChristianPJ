$(function () {
    
    var validationRules = {};
    
    validationRules['form-login:username'] = {
        required: true,
        alphanumeric: true,
        maxlength: 15
    };
    
    validationRules['form-login:password'] = {
        required: true,
        minlength: 4,
        maxlength: 15
    };
    
    $('#form-login').validate({
        rules: validationRules,
        submitHandler: function(form) {
            form.submit();
        }
    });
});