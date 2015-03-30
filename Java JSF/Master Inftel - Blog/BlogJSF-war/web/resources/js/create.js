$(function(){
    var eliminar = function(){
        $(this).parent().remove();
    }
    var botonMas = function(){
        var fieldsets = $("#fotos").children();
        var numero=0;
        if(fieldsets.length>0){
            var name = $("#fotos").children().last().find("input[type=file]").attr("name");   
            var indice = name.indexOf("-");
            numero = parseInt(name.substring(indice+1))+1;
        }
        var fieldset = $("<fieldset>").appendTo($("#fotos"));
        $("<input>")
                .attr("type","file")
                .attr("name","foto-"+(numero))
                .addClass("form-item")
                .addClass("foto")
                .appendTo(fieldset);
        $("<input>")
                .attr("type","button")
                .attr("value","Eliminar")
                .appendTo(fieldset)
                .addClass("button-eliminar")
                .click(eliminar);
        $("#numFotos").val(numero);

        };
        $("#botonAgregar").click(botonMas);
        $(".button-eliminar").click(eliminar);
        $('[id*=botonBuscar]').click(codeAddress);
});