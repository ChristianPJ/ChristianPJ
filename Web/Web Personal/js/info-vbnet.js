$('#btn-vbnet').click(function(){             
    var html='';
    
    document.getElementById("btn-android").style.backgroundPosition = '';
    document.getElementById("btn-bbdd").style.backgroundPosition = '';
    document.getElementById("btn-ios").style.backgroundPosition = '';
    document.getElementById("btn-java").style.backgroundPosition = '';
    document.getElementById("btn-python").style.backgroundPosition = '';
    document.getElementById("btn-vbnet").style.backgroundPosition = 'center';
    //document.getElementById("btn-web").style.backgroundPosition = '';
    
    html+= "<div id='vbnet'>";
    html+= "<h2 style='color:#00ACEF;'>Visual Basic .Net</h2>";
    html+= "</br>";
    html+= "<p class='bigtext'>Desarrollo de <strong>aplicaciónes nativas</strong> en Android Studio o Eclipse</p><br/>";
    html+= "<div class='highlight'>";
    html+= "<img src='css/images/icons/network-workgroup.png' width='64' height='64' align='left'/>";
    html+= "<p>Empleo de recogida de datos optima, mediante asíncronia… restful, tanto sql como mongodb</p><br/>";                             
    html+= "<p>xxxXxxx xxxxXxXX</p><br/>";
    html+= "<br/>";  

    // Proyecto VB .Net
    html+= "<div class='proyecto'>";
    html+= "<div class='proyecto-texto'>";
    html+= "<h3 style='color:#00ACEF;'>Proyecto: Desarrollo de una Aplicación de Contabilidad para una Empresa de Alimentación</h3>";
    html+= "<br/>";                                       
    html+= "<ul>";
    html+= "<li>Servicios RESTful</li>";
    html+= "<li>Framework: Spring</li>";
    html+= "<li>Base de Datos NoSQL: MongoDB</li>";
    html+= "<li>API Dropbox para tratamiento de las imágenes</li>";
    html+= "<li>Login con QR</li>";
    html+= "<li>Login con Google API</li>";
    html+= "<li>Navigation Drawer / Expandable List</li>";
    html+= "<li>Teclado Accesible</li>";
    html+= "</ul>";                                        
    html+= "<br/>";
    html+= "<center>";                                             
    html+= "<p>";
    html+= "<strong>Ver código fuente en repositorio: "; 
    html+= "<a href='https://github.com/ChristianPJ/ChristianPJ/tree/master/VB'>";
    html+= "<img src='css/images/icons/GitHub-Logo.png' width='55' height='15' />";
    html+= "<br/>";
    html+= "</a></strong></p></center></div></div></div></div>";
    html+= "<br/>";
    html+= "<div class='featured'>";
    html+= "<center><h4>Más información</h4></center>";
    html+= "<a href='http://localhost:8383/WebPersonal/proyecto.html' class='blue-btn'>Proyecto</a>";
    html+= "</div>";

    $('#info').html(html);  
});