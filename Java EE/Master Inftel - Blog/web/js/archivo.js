$(function () {
    
    var monthsByNumber = [];
    monthsByNumber['1'] = $.archivoMessages().enero;
    monthsByNumber['2'] = $.archivoMessages().febrero;
    monthsByNumber['3'] = $.archivoMessages().marzo;
    monthsByNumber['4'] = $.archivoMessages().abril;
    monthsByNumber['5'] = $.archivoMessages().mayo;
    monthsByNumber['6'] = $.archivoMessages().junio;
    monthsByNumber['7'] = $.archivoMessages().julio;
    monthsByNumber['8'] = $.archivoMessages().agosto;
    monthsByNumber['9'] = $.archivoMessages().septiembre;
    monthsByNumber['10'] = $.archivoMessages().octubre;
    monthsByNumber['11'] = $.archivoMessages().noviembre;
    monthsByNumber['12'] = $.archivoMessages().diciembre;
    
    $('.archive-month-entry p').each(function () {
        var $p = $(this);
        $p.text(monthsByNumber[$p.text()]);
    });
    
    $('#archivo .archive-year-entry > p').click(function () {
        $(this).parent().find('.archive-months').toggleClass('hide');
    });
    
    $('#archivo .archive-month-entry > p').click(function () {
        $(this).parent().find('.archive-months-posts').toggleClass('hide');
    });
    
    $('#archivo .archive-year-entry > p:first-of-type').parent().find('.archive-months').first().removeClass('hide');
    $('#archivo .archive-month-entry > p:first-of-type').parent().find('.archive-months-posts').first().toggleClass('hide');
});