$('#btn-bbdd').click(function(){             
    var html='';
    
    document.getElementById("btn-android").style.backgroundPosition = '';
    document.getElementById("btn-bbdd").style.backgroundPosition = 'center';
    document.getElementById("btn-ios").style.backgroundPosition = '';
    document.getElementById("btn-java").style.backgroundPosition = '';
    document.getElementById("btn-python").style.backgroundPosition = '';
    document.getElementById("btn-vbnet").style.backgroundPosition = '';
    //document.getElementById("btn-web").style.backgroundPosition = '';
    
    html+= "<div id='bbdd'>";
    html+= "<h2 style='color:#A4A4A4;'>Bases de Datos</h2>";
    html+= "</br>";
    html+= "<div class='highlight'>";
    html+= "<img src='css/images/icons/database.png' width='64' height='64' align='left'/>";
    html+= "<p class='bigtext'>Administración de datos bajo sistema de gestión de bases de datos relacional <strong>Oracle, Microsoft SQL Server y/o MySQL</strong>. Diseño de diagramas E/R para generar script de creación de objetos en la BBDD con DataModeler. Alto nivel de conocimientos en <strong>querys SQL</strong>.</p><br/>";
    
    html+= "<div class='quote'>";
    html+= "<div class='quote-texto'>";
    html+= "<p>' <b>Teradata</b> es un gestor de base de datos relacional específicamente diseñado para soportar paralelismo. Su arquitectura patentada permite descomponer las preguntas complejas entre múltiples unidades de trabajo paralelas en el software de la base de datos, cada una denominada AMP (Access Module Processors). '</p>";
    html+= "</div></div><br/>";
    
    html+= "<div class='quote'>";
    html+= "<div class='quote-texto'>";
    html+= "<p>' <b>Hadoop</b> es un sistema de código abierto que se utiliza para almacenar, procesar y analizar grandes volúmenes de datos; cientos de terabytes, petabytes o incluso más..</p><br/>";    
    html+= "<p>En el entorno tecnológico que actualmente se mueven todas las organizaciones, donde los sistemas no sólo son capaces de generar e ingestar los datos rápidamente sobre formatos estructurados (SQL), también, cada vez más, se generan datos que no son estructurados (NoSQL)..</p><br/>";
    html+= "<p>Hadoop es capaz de almacenar toda clase de datos: estructurados, no estructurados, semiestructurados; archivos de registro, imágenes, video, audio, comunicación, etc. '</p>";
    html+= "</div></div><br/>";
    
    html+= "<img src='css/images/icons/storage_4.png' width='64' height='64' align='right' />"; 
    html+= "<p>Manejo de Bases de Datos NoSQL (MongoDB o Cassandra). Creación de estructuras, así como consultas básicas de información. Conectividad de este tipo de BBDD con Java, mediante servicios con arquitectura REST.</p><br/>";

    html+= "<p>Creación de Informes dinámicos JasperRepots usando la herramienta iReports.</p><br/>";
    
    html+= "<div class='quote'>";
    html+= "<div class='quote-texto'>";
    html+= "<p>' <b>JasperReports</b> es una librería de creación de informes que tiene la habilidad de entregar contenido enriquecido al monitor, a la impresora o a ficheros PDF, HTML, XLS, CSV y XML. '</p>";
    html+= "</div></div><br/>";
    
    html+= "<br/>";  
    
    // Proyecto Social Network
    html+= "<div class='proyecto-grey'>";
    html+= "<div class='proyecto-texto'>";
    html+= "<h3 style='color:#A4A4A4;'>Proyecto: Indexador</h3>";
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