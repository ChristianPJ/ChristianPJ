function entries(){
    
    var html ='';

    html+="<section class='entries'>                                                                                                               ";
    html+="    <div class='entry'>                                                                                                                 ";
    html+="        <h3>Últimos Trabajos</h3>                                                                                                       ";
    html+="        <div class='entry-inner'>                                                                                                       ";
    html+="            <div class='date'>                                                                                                          ";
    html+="                <strong>01</strong>                                                                                                     ";
    html+="                <span>2016</span>                                                                                                       ";
    html+="                <em>jun</em>                                                                                                            ";
    html+="            </div>                                                                                                                      ";
    html+="            <div class='cnt'>                                                                                                           ";
    html+="                <p><a href='#'><b>Inauguración Página Web</b></a></p>                                                                   ";
    html+="                <p class='meta' style='margin-left : 6.5em;'><b>Christian Pareja Jensen</b></p>                                         ";
    html+="            </div>                                                                                                                      ";
    html+="        </div>                                                                                                                          ";
    html+="        <div class='entry-inner'>                                                                                                       ";
    html+="            <div class='date'>                                                                                                          ";
    html+="                <strong>31</strong>                                                                                                     ";
    html+="                <span>2015</span>                                                                                                       ";
    html+="                <em>may</em>                                                                                                            ";
    html+="            </div>                                                                                                                      ";
    html+="            <div class='cnt'>                                                                                                           ";
    html+="                <p><a href='servicios.html'><b>Master Inftel</b></a></p>                                                                ";
    html+="                <p class='meta' style='margin-left : 6.5em;'><b>Christian Pareja Jensen / </br> Universidad de Málaga</b></p>           ";
    html+="            </div>                                                                                                                      ";
    html+="        </div>                                                                                                                          ";
    html+="        <div class='entry-inner'>                                                                                                       ";
    html+="            <div class='date'>                                                                                                          ";
    html+="                <strong>04</strong>                                                                                                     ";
    html+="                <span>2013</span>                                                                                                       ";
    html+="                <em>feb</em>                                                                                                            ";
    html+="            </div>                                                                                                                      ";
    html+="            <div class='cnt'>                                                                                                           ";
    html+="                <p><a href='proyecto.html'><b>'Desarrollo de una aplicación de Contabilidad para una empresa de alimentación</b></a></p>";
    html+="                <p class='meta' style='margin-left : 6.5em;'><b>Christian Pareja Jensen / </br> Universidad de Málaga</b></p>           ";
    html+="            </div>                                                                                                                      ";
    html+="        </div>                                                                                                                          ";
    html+="    </div>                                                                                                                              ";
    html+="    <div class='entry'>                                                                                                                 ";
    html+="        <h3>Información Personal</h3>                                                                                                   ";
    html+="        <h2>Christian Pareja Jensen </h2>                                                                                               ";
    html+="        <h4><em>Desarrollador de Software</em></h4>                                                                                     ";
    html+="        <br/>                                                                                                                           ";
    html+="        <p><b>Teléfono:</b> 667 34 97 45</p>                                                                                            ";
    html+="        <p><b>Email:</b> parejajensen@gmail.com</p>                                                                                     ";
    html+="    </div>                                                                                                                              ";
    html+="                                                                                                                                        ";
    html+="    <div class='entry'>                                                                                                                 ";
    html+="        <h3>Citas</h3>                                                                                                                  ";
    html+="                                                                                                                                        ";
    html+="        <div class='testimonials'>					                                                                   ";
    html+="            <!-- Carga con Javascript -->                                                                                               ";
    html+="        </div>                                                                                                                          ";
    html+="    </div>                                                                                                                              ";
    html+="    <div class='cl'>&nbsp;</div>                                                                                                        ";
    html+="</section>                                                                                                                              ";    
    
    $('.entries').html(html);
     
}

function testimonials(){
    
    var html ='';
    
    switch (Math.floor((Math.random() * 3) + 1)) {
        case 1:
                html+= "<p><strong>“</strong>Una máquina puede hacer el trabajo de 50 hombres corrientes.";
                html+= "    Pero no existe ninguna máquina que pueda hacer el trabajo de un hombre extraordinario.</p>";
                html+= "<p class='author'>Elbert Hubbard</p>";
            break;
        
        case 2:
                html+= "<p><strong>“</strong>Controlar la complejidad es la esencia de la programación.";
                html+= "<p class='author'>Brian Kernigan</p>";
            break;
        
        case 3:
                html+= "<p><strong>“</strong>Los mejores programadores no son sólo marginalmente mejores que los buenos.<br/><br/>";
                html+= "Se trata de un orden de magnitud mayor, medida por cualquier estándar: creatividad conceptual, velocidad, ";
                html+= "ingenio o habilidad para solucionar problemas.";
                html+= "<p class='author'>Randall E. Stross</p>";
            break;
    }

$('.testimonials').html(html);
}
