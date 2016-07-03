$('#btn-android').click(function(){             
    var html='';

    document.getElementById("btn-android").style.backgroundPosition = 'center';
    document.getElementById("btn-bbdd").style.backgroundPosition = '';
    document.getElementById("btn-ios").style.backgroundPosition = '';
    document.getElementById("btn-java").style.backgroundPosition = '';
    document.getElementById("btn-python").style.backgroundPosition = '';
    document.getElementById("btn-vbnet").style.backgroundPosition = '';
    //document.getElementById("btn-web").style.backgroundPosition = '';
    
    html+= "<div id='android'>";
    html+= "<h2 style='color:#5FB404;'>Android</h2>";
    html+= "</br>";
    html+= "<p class='bigtext'>Desarrollo de <strong>aplicaciónes nativas</strong> en Android Studio o Eclipse</p><br/>";
    html+= "<div class='highlight'>";
    html+= "<img src='css/images/icons/android_platform.png' width='64' height='64' align='left'/>";
    html+= "<p>Empleo de recogida de datos optima, mediante asíncronia… restful, tanto sql como mongodb</p><br/>";
    html+= "<img src='css/images/icons/google_buzz.png' width='64' height='64' align='right' />";                                    
    html+= "<p>Conocimientos en el aprovechamiento de diversas APIs externas como Google +, Google Maps, Dropbox o</p><br/>";
    html+= "<p>Uso de Material Design para dotar a las aplicaciones de un diseño moderno y llamativo</p><br/>";
    html+= "<br/>";  

    // Proyecto Museo
    html+= "<div class='proyecto-green'>";
    html+= "<div class='proyecto-texto'>";
    html+= "<h3 style='color:#5FB404;'>Proyecto: Museo Inftel</h3>";
    html+= "<br/>";                                        
    html+= "<ul>";
    html+= "<li>Servicios RESTful</li>";
    html+= "<li>API Dropbox para tratamiento de las imágenes</li>";
    html+= "<li>Lector QR</li>";
    html+= "<li>Audioguía</li>";
    html+= "<li>Google Maps</li>";
    html+= "</ul>";                                        
    html+= "<br/>";
    html+= "<center>";
    html+= "<iframe src='https://www.youtube.com/embed/TMdhTkfGYFE' frameborder='0' allowfullscreen></iframe><br/>";
    html+= "<br/>";
    html+= "<p><strong>Ver código fuente en repositorio: ";
    html+= "<a href='https://github.com/ChristianPJ/ChristianPJ/tree/master/Android/Master%20Inftel%20-%20Museo'>";
    html+= "<img src='css/images/icons/GitHub-Logo.png' width='55' height='15' />";
    html+= "</a></strong></p></center></div>";
    html+= "</div>";
    html+= "<br />";

    // Proyecto Social Network
    html+= "<div class='proyecto-green'>";
    html+= "<div class='proyecto-texto'>";
    html+= "<h3 style='color:#5FB404;'>Proyecto: Social Network</h3>";
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
    html+= "<a href='https://github.com/ChristianPJ/ChristianPJ/tree/master/Android/Master%20Inftel%20-%20Social%20Network'>";
    html+= "<img src='css/images/icons/GitHub-Logo.png' width='55' height='15' />";
    html+= "</a></strong></p></center></div></div></div></div>";
    $('#info').html(html);  
}); 
