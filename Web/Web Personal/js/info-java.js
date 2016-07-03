$('#btn-java').click(function(){             
    var html='';

    document.getElementById("btn-android").style.backgroundPosition = '';
    document.getElementById("btn-bbdd").style.backgroundPosition = '';
    document.getElementById("btn-ios").style.backgroundPosition = '';
    document.getElementById("btn-java").style.backgroundPosition = 'center';
    document.getElementById("btn-python").style.backgroundPosition = '';
    document.getElementById("btn-vbnet").style.backgroundPosition = '';
    //document.getElementById("btn-web").style.backgroundPosition = '';
    
    html+= "<div id='java'>";
    html+= "<h2 style='color:#FE2E2E;'>Java</h2>";
    html+= "</br>";
    html+= "<div class='highlight'>";
    
    html+= "<p>Desarrollo de aplicaciones Web Java EE de gran envergadura mediante el uso de la tecnología JSP. Uso de la herramienta de software de proyectos Maven, asi como de frameworks como Spring MVC o Structs. Proyectos especificos implementados para el ámbito de las Teleoperadoras.</p>";
    html+= "<br/>"; 
    html+= "<p>Estas aplicaciones Web incluyen desarrollo tanto de la parte Front-End, como la parte Back-End.</p>";
    html+= "<br/>"; 
    html+= "<p>En la parte Front-End, se incluye todo tipo de elementos dinámicos y estéticos con uso de herramientas y lenguajes como pueden ser JSTL, JavaScripts, CSS, Ajax, jQuery...</p>";
    html+= "<p>Mientras que en la parte Back-End, además de un uso correcto de la filosofía Spring MVC, se incluye ****. Conocimientos en la implementacion de capas de persistencia ORM como iBatis, JPA o JDBC.</p>";
    html+= "<br/>"; 
    html+= "<div><center><img src='css/images/icons/logos-java2.png' width='400' height='200'/></center></div>";
    html+= "<br/>"; 
    html+= "<p>Esta conectividad se puede encontrar en los distintos proyectos con Bases de Datos. Por un lado, BBDD SQL Relacionales con entornos como los de Oracle o MYSQL, BBDD NoSQL, especialmente uso de MongoDB o para enormes cantidades de información, el uso de la filósofia BigData, empleando lenguajes tales como Teradata o Hadoop, o la unión de datos de ambas en una misma consulta. Más información en la seccion de Bases de Datos.</p>";
    html+= "<br/>"; 
    html+= "<p>Creacion de Informes a partir de ficheros XML como fuente de datos con el uso de la biblioteca JasperReports, mediante el front-end gráfico iReport.</p>";
    html+= "<br/>"; 
    html+= "<p>Implementación de código para dar soporte a librerias y configuración de Firma Digital en distintos formatos. Creacion de tareas programadas Quartz con expresiones Cron.</p>";
    html+= "<br/>"; 
    html+= "<div class='quote'>";
    html+= "<div class='quote-texto'>";
    html+= "<p>Quartz es un framework Java para la planificación de tareas, que destaca sobre todo por su potencia y sencillez,esta potencia le viene dada por sus amplias posibilidades de configuración.</p>";
    html+= "<p>Una expresión CRON es una cadena de texto compuesta por 6 o 7 campos separados por un espacio en blanco que se utiliza para representar instantes o periodos de tiempo.."
    html+= "</div></div><br/>";
    
    /*html+= "<p>Java EE, Java SE, JSP, JSF</p><br/>";
    html+= "<p>Desarrollo de proyectos con Maven, y uso de frameworks como Spring MVC o Structs.</p><br/>";
    html+= "<p>Dichos proyectos incluyen desarrollo tanto de la parte Front-End, como la parte Back-End. En la parte Front-End, se incluye todo tipo de elementos dinámicos y esteticos con uso de herramientos y lenguajes como pueden ser JavaScripts, Ajax, PrimeFaces, CSS...</p><br/>";
    html+= "<p>Mientras que en la parte Back-End, además de un uso correcto ... ****</p><br/>";
    html+= "<p>Reporting (XML / iReports Jasper)</p><br/>";
    html+= "<p>Esta conectividad se puede encontrar en los distintos proyectos con Bases de Datos. Por un lado, BBDD SQL Relacionales con entornos como los de Oracle o MYSQL, BBDD NoSQL, especialmente uso de MongoDB o para enormes cantidades de información, el uso de la filósofia BigData, empleando lenguajes tales como Teradata o Hadoop, o la unión de datos de ambas en una misma consulta. Más información en la seccion de Bases de Datos.</p><br/>";
    html+= "<p>Implementación de código para dar soporte a librerias y configuración de Firma Digital en distintos formatos. Creacion de tareas programadas Quartz con expresiones Cron.</p><br/>";
    html+= "<p>http://www.adictosaltrabajo.com/tutoriales/quartz/#quartz_web_app</p><br/>";
	
	html+= "<div class='quote'>";
    html+= "<div class='quote-texto'>";
    html+= "<p>Quartz es un framework Java para la planificación de tareas, que destaca sobre todo por su potencia y sencillez,esta potencia le viene dada por sus amplias posibilidades de configuración.</p>";	
	html+= "<p>Una expresión CRON es una cadena de texto compuesta por 6 o 7 campos separados por un espacio en blanco que se utiliza para representar instantes o periodos de tiempo..</p>";
	html+= "</div></div><br/>";
	
    html+= "<p>Prime faces</p><br/>";
    html+= "<br/>"; */
    
	// Proyecto CGI
    html+= "<div class='proyecto-red'>";
    html+= "<div class='proyecto-texto'>";
    html+= "<h3 style='color:#FE2E2E;'>Proyecto: CGI</h3>";
    html+= "<br/>";                                        
    html+= "<ul>";	
	html+= "<li>Desarrollo en lenguajes y tecnologías, tales como JSP, Javascript, CSS, Spring, Maven.</li>"; 
	html+= "<li>Análisis, diseño y desarrollo de Front-End.</li>"; 
	html+= "<li>Implementación de Back-End.</li>"; 
	html+= "<li>Creación de informes con JasperReports.</li>"; 
	html+= "<li>Firma electrónica Xades-XL.</li>"; 
	html+= "<li>BBDD Teradata y Hadoop.</li>"; 
	html+= "<li>Desarrollo de BTEQs y Sqoop.</li>";
    html+= "</ul>";                                        
    html+= "<br/>";
    html+= "<center>";
    html+= "<br/>";
    html+= "<p><strong>Ver código fuente en repositorio: No disponible";
    html+= "</a></strong></p></center></div>";
    html+= "</div>";
    html+= "<br />";
	
    // Proyecto Clinica
    html+= "<div class='proyecto-red'>";
    html+= "<div class='proyecto-texto'>";
    html+= "<h3 style='color:#FE2E2E;'>Proyecto: Clinica</h3>";
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
    html+= "<iframe width='450' height='300' src='https://www.youtube.com/embed/TMdhTkfGYFE' frameborder='0' allowfullscreen></iframe><br/>";
    html+= "<br/>";
    html+= "<p><strong>Ver código fuente en repositorio: ";
    html+= "<a href='https://github.com/ChristianPJ/ChristianPJ/tree/master/Android/Master%20Inftel%20-%20Museo'>";
    html+= "<img src='css/images/icons/GitHub-Logo.png' width='55' height='15' />";
    html+= "</a></strong></p></center></div>";
    html+= "</div>";
    html+= "<br />";
    
    // Proyecto Museo
    html+= "<div class='proyecto-red'>";
    html+= "<div class='proyecto-texto'>";
    html+= "<h3 style='color:#FE2E2E;'>Proyecto: Museo Inftel</h3>";
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
    html+= "<iframe width='450' height='300' src='https://www.youtube.com/embed/TMdhTkfGYFE' frameborder='0' allowfullscreen></iframe><br/>";
    html+= "<br/>";
    html+= "<p><strong>Ver código fuente en repositorio: ";
    html+= "<a href='https://github.com/ChristianPJ/ChristianPJ/tree/master/Android/Master%20Inftel%20-%20Museo'>";
    html+= "<img src='css/images/icons/GitHub-Logo.png' width='55' height='15' />";
    html+= "</a></strong></p></center></div>";
    html+= "</div>";
    html+= "<br />";
    
    // Proyecto RSS
    html+= "<div class='proyecto-red'>";
    html+= "<div class='proyecto-texto'>";
    html+= "<h3 style='color:#FE2E2E;'>Proyecto: Clinica</h3>";
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