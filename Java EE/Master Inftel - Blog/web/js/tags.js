$(document).ready(function() {
    $.get('EtiquetaTrendingServlet', {

    }, function(responseText) {
         var trend = $('#trend_etiquetas');
         $('#trend_etiquetas').empty();
         $.each(responseText.etiquetas,function(i,etiqueta){
            var etiquetaNombre = etiqueta.nombre;
            $('<a>')
                    .attr('href', 'busqueda?etiqueta=' + etiquetaNombre)
                    .text(etiquetaNombre).appendTo(trend);
            if(i !== 9){
                $('<span>').text(", ").appendTo(trend);
            }
        });
    });
});