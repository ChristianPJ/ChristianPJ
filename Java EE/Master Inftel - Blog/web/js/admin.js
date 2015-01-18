$(function(){   
    $('#boton_buscar').click(function() {
        var name = $('#userName').val();
        $.get('admin', {
            username : name
        }, function(responseText) {
            var idusuario = $('#id_usuarios');
             $('#id_usuarios').empty();
             var tabla =$('<table>').appendTo(idusuario);
             var fila = $('<tr>').appendTo(tabla);
             $('<td>').text($.blogAdminMessages().indice).appendTo(fila);
             $('<td>').text($.blogAdminMessages().nombre).appendTo(fila);
             $('<td>').text($.blogAdminMessages().tipo).appendTo(fila);
             $('<td>').text($.blogAdminMessages().accion).appendTo(fila);
             $.each(responseText.usuarios,function(i,usuario){
                 var fila = $('<tr>').appendTo(tabla);
                 $('<td>').text(i+1).appendTo(fila);
                 $('<td>').addClass("nombre-usuario").text(usuario.nombre).appendTo(fila);

                 var desp =  $('<td>').appendTo(fila);
                 var despl =  $('<select>').addClass("tipo-usuario").appendTo(desp);
                 $('<option>').attr("value",0).text($.blogAdminMessages().usuarioAdmin).appendTo(despl);
                 $('<option>').attr("value",1).text($.blogAdminMessages().usuarioEscritor).appendTo(despl);
                 $('<option>').attr("value",2).text($.blogAdminMessages().usuarioNormal).appendTo(despl);
                 $('<option>').attr("value",3).text($.blogAdminMessages().usuarioNulo).appendTo(despl);

                 despl.find('option[value="'+ usuario.tipo +'"]').attr("selected",true);

                 var boton = $('<td>').appendTo(fila);
                 $('<button>').text($.blogAdminMessages().confirmar).appendTo(boton).click(function() {

                    var padre = $(this).parent().parent();
                    var nombreUsuario = padre.find(".nombre-usuario").first().text();
                    var tipoUsuario = padre.find(".tipo-usuario option:selected").first().index();

                     $.get('AdminActualizarServlet', {
                         username : nombreUsuario ,
                         usertype : tipoUsuario
                     }, function(responseText) {
                         $('#confirm').text($.blogAdminMessages().msgElUsuario + " " + nombreUsuario + " " + $.blogAdminMessages().msgHaSidoModificado);

                     });
                 });
            });
        });
    });
});