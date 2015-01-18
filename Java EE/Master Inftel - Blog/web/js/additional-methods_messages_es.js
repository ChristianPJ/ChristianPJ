(function (factory) {
    if (typeof define === "function" && define.amd) {
        define(["jquery", "lib/jquery.validate"], factory);
    } else {
        factory(jQuery);
    }
}(function ($) {

    $.extend($.validator.messages, {
        alphanumeric: "Por favor, utiliza solo letras, números y barras bajas."
    });

}));