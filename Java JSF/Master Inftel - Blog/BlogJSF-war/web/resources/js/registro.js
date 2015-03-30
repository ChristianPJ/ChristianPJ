$(function () {
    
    var validationRules = {};
    
    validationRules['form-registro:username'] = {
        required: true,
        alphanumeric: true,
        maxlength: 15
    };
    
    validationRules['form-registro:password'] = {
        required: true,
        minlength: 4,
        maxlength: 15
    };
    
    validationRules['form-registro:password2'] = {
        required: true,
        minlength: 4,
        maxlength: 15,
        equalTo : "[id$=password]"
    };
    
    validationRules['form-registro:email'] = {
        required: true,
        email: true
    };
    
    validationRules['form-registro:avatar'] = {
        required: true
    };
    
    $('#form-registro').validate({
        rules: validationRules,
        submitHandler: function(form) {
            form.submit();
        }
    });
});