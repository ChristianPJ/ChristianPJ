$(function () {
    
    $.extend({
        redirectGET: function(location, args){
            var form = '';
            $.each( args, function( key, value ) {
                form += '<input type="hidden" name="'+key+'" value="'+value+'">';
            });
            $('<form action="'+location+'" method="GET">'+form+'</form>').appendTo('body').submit();
        }
    });
});