$(function () {
    
    $('.pagination').jqPagination({
        page_string : '{current_page} / {max_page}',
        paged: function (pageNumber) {
            var tipoBusqueda = parseInt($('#tipo-busqueda').text());
            var claveBusqueda = ((tipoBusqueda === 1) ? 'etiqueta' : (tipoBusqueda === 2) ? 'cadena' : 'usuario');
            var valorBusqueda = $('#valor-busqueda').text();
            
            var data = {};
            data['page'] = pageNumber;
            data[claveBusqueda] = valorBusqueda;
            
            $.redirectGET('busqueda', data);
        }
    });
    
});
