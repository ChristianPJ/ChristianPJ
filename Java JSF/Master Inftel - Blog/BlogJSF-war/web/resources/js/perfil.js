$(function () {
    
    var validationRules = {};
    
    validationRules['form-perfil:password'] = {
        required: true,
        minlength: 4,
        maxlength: 15
    };
    
    validationRules['form-perfil:password2'] = {
        required: true,
        minlength: 4,
        maxlength: 15,
        equalTo : "[id$=password]"
    };
    
    validationRules['form-perfil:email'] = {
        required: true,
        email: true
    };
    
    validationRules['form-perfil:avatar'] = {
        required: false
    };
    
    $('#form-perfil').validate({
        rules: validationRules,
        submitHandler: function(form) {
            form.submit();
        }
    });
});