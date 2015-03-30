$(function () {
    
    $('.botonBorrarComentario').click(function() {
        var boton = $(this);
        var comentario = boton.parent();
        var contenedorComentarios = comentario.parent();
        comentario.remove();

        if (contenedorComentarios.children().length === 0) {
            contenedorComentarios.parent().remove();
        }
    });
});