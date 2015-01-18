$('.botonBorrarComentario').click(function() {
    var boton = $(this);
    var idBoton = boton.attr('id');
    var indice = idBoton.indexOf('-');
    var idComentario = idBoton.substring(indice + 1);

    $.get('BorrarComentarioServlet', {
        comentario : idComentario ,
    }, function(responseText) {
    });
    
    var comentario = boton.parent();
    var contenedorComentarios = comentario.parent();
    comentario.remove();
    
    if (contenedorComentarios.children().length === 0) {
        contenedorComentarios.parent().remove();
    }
});

$('.botonBorrarPost').click(function() {
    var boton = $(this);
    var idBoton = boton.attr('id');
    var indice = idBoton.indexOf('-');
    var idPost = idBoton.substring(indice + 1);
    $.get('BorrarPostServlet', {
        post : idPost ,
    }, function(responseText) {
    });

    boton.parent().remove();
});