$('#btn-python').click(function(){             
    var html='';
    
    document.getElementById("btn-android").style.backgroundPosition = '';
    document.getElementById("btn-bbdd").style.backgroundPosition = '';
    document.getElementById("btn-ios").style.backgroundPosition = '';
    document.getElementById("btn-java").style.backgroundPosition = '';
    document.getElementById("btn-python").style.backgroundPosition = 'center';
    document.getElementById("btn-vbnet").style.backgroundPosition = '';
    //document.getElementById("btn-web").style.backgroundPosition = '';
    
    html+= "<div id='python'>";
    html+= "<h2 style='color:#DBA901;'>Python</h2>";
    html+= "</br>";
    html+= "<div class='highlight'>";
    html+= "<div><img src='css/images/icons/application-x-python.png' width='64' height='64' align='left' style='margin-right:10px'/>";  
    html+= "<p>Conocimientos básicos del lenguaje de programación Python.\n\</p><br/>";
    html+= "<p>Creación de pequeños módulos que sirvan de complemento a otros proyectos de mayor envergadura.</p><br/>";
    
    // Proyecto RSS
    html+= "<div class='proyecto-yellow'>";
    html+= "<div class='proyecto-texto'>";
    html+= "<h3 style='color:#DBA901;'>Proyecto: Noticias en RSS</h3>";
    html+= "<br/>";                                        
    html+= "<ul>";
    html+= "<li>Listado de webs RSS</li>";
    html+= "<li>Filtrado de Información</li>";
    html+= "<li>Tratamiento de fechas</li>";
    html+= "</ul>";                                        
    html+= "<br/>";
    html+= "<center>";  
    html+= "<br/>";
    html+= "<p><strong>Ver código fuente en repositorio: ";
    html+= "<a href='https://github.com/ChristianPJ/ChristianPJ/tree/master/Python/Master%20Inftel%20-%20Noticias%20en%20RSS'>";
    html+= "<img src='css/images/icons/GitHub-Logo.png' width='55' height='15' />";
    html+= "</a></strong></p></center></div>";
    html+= "</div>";  

    $('#info').html(html);  
});