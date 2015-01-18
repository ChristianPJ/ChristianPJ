/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


// crear funcion mostrar hoteles
                     function showhotels(){
                         
                         
                         function  hotel(nombre, descripcion, fotoext, fotomext, fotoint1, fotomint1, fotoint2, fotomint2) {
                    this.nombre = nombre;
                            this.descripcion = descripcion;
                            this.fotoext = fotoext;
                            this.fotomext = fotomext;
                             this.fotoint1 = fotoint1;
                             this.fotomint1 = fotomint1;
                             this.fotoint2 = fotoint2;
                             this.fotomint2 = fotomint2;
                             this.enlace = enlace;
                                    }
                        
                         
                         
                                        
                            var indice = 0;
                            var hoteles = new Array();
                       
                       
                       
                       
                $.ajax({ 
                url: "json/londres/hoteleslondres.json", 
                async: false, dataType: 'json', 
                success: function(data) { 
                hoteles = data.hoteles; } 
                }); // Fin de lectura del Json
                           
                                    
                                 

                            //variable contenedora

                            var contenedor = '';
                            for (indice in hoteles){

                            contenedor += "<header>";
                            contenedor += "<h2>" + hoteles[indice].nombre + "</h2>";
                            contenedor += "<p>" + hoteles[indice].descripcion + "</p>";
                            contenedor +="</header>";
                            
                            contenedor += '<div class="container small gallery">';
                            contenedor += '<div class="row flush images">';
               
        
                             //cuadro izquierdo
               
                             contenedor += '<div class="4u">';
                             contenedor +="<a href="+hoteles[indice].fotoext+" class=\"image fit from-left\">";  
    
                             contenedor +="<img src="+hoteles[indice].fotomext+" width=\"440\" height= \"276\" title=\"foto exterior\" alt=\"descripcion\" />";
                             
                             contenedor += "</a></div>" ;
                                 
    
                           
                             //cuadro centrado
                              contenedor += '<div class="4u">';
                              contenedor +="<a href="+hoteles[indice].fotoint1+" class=\"image fit from-\">";
                              contenedor +="<img src="+hoteles[indice].fotomint1+" width=\"440\" height= \"276\" title=\"foto interior\" alt=\"descripcion\" />";
                              contenedor += "</a></div>" ;
                              
                              
                              
                              //cuadro derecho
                              contenedor += '<div class="4u">';
                              contenedor +="<a href="+hoteles[indice].fotoint2+" class=\"image fit from-right\">";
                              contenedor +="<img src="+hoteles[indice].fotomint2+" width=\"440\" height= \"276\" title=\"foto interior\" alt=\"descripcion\" />";
                              contenedor += "</a></div>" ;
                              
                              
                              
               
                
                              contenedor += "</div></div>";
                              contenedor+="<br><br>";
                              
                              contenedor +="<a href="+hoteles[indice].enlace+" target = \"blank\">" +hoteles[indice].nombre+"</a>";
                              contenedor+="<br><br><br>";
                            }   
               
                     

                       $('#galeria').html(contenedor);
          //        });   
             }