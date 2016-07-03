$('#btn-ios').click(function(){             
    var html='';
    
    document.getElementById("btn-android").style.backgroundPosition = '';
    document.getElementById("btn-bbdd").style.backgroundPosition = '';
    document.getElementById("btn-ios").style.backgroundPosition = 'center';
    document.getElementById("btn-java").style.backgroundPosition = '';
    document.getElementById("btn-python").style.backgroundPosition = '';
    document.getElementById("btn-vbnet").style.backgroundPosition = '';
    //document.getElementById("btn-web").style.backgroundPosition = '';
    
    html+= "<div id='ios'>";
    html+= "<h2 style='color:#00ACEF;'>Objective-C</h2>";
    html+= "</br>";
    html+= "<div class='highlight'>";
    html+= "<img src='css/images/icons/xcode.png' width='64' height='64' align='left' style='margin-right:10px'/>";
    html+= "<p class='bigtext'>Desarrollo de aplicaciones nativas básicas con <strong>Xcode</strong>, con conectividad a Base de Datos, mediante servicios de arquitectura REST.</p><br/>";
	
    html+= "<p>Diseño y maquetación de Storyboards dinamicos para crear interfaces personalizados.</p><br/>";
	
    // Proyecto iRecipe
    html+= "<div class='proyecto-grey'>";
    html+= "<div class='proyecto-texto'>";
    html+= "<h3 style='color:#909090;'>Proyecto: iRecipe</h3>";
    html+= "<br/>";                                        
    html+= "<ul>";
    html+= "<li>Servicios RESTful</li>";
    html+= "</ul>";                                        
    html+= "<br/>";
    html+= "<center>";
    html+= "<iframe src='https://www.youtube.com/embed/_Sb9XHUHqd4' frameborder='0' allowfullscreen></iframe><br/>";
    html+= "<br/>";
    html+= "<p><strong>Ver código fuente en repositorio: ";
    html+= "<a href='https://github.com/ChristianPJ/ChristianPJ/tree/master/Objective-C/Master%20Inftel%20-%20iRecipe'>";
    html+= "<img src='css/images/icons/GitHub-Logo.png' width='55' height='15' />";
    html+= "</a></strong></p></center></div>";
    html+= "</div></div></div>";          

    $('#info').html(html);  
});