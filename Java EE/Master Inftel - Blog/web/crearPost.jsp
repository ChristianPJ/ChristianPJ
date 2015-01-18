<%-- 
    Document   : crearPost
    Created on : Dec 13, 2014, 12:07:59 PM
    Author     : maramec
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="language" value="${not empty sessionScope.locale ? sessionScope.locale : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="es.uma.inftel.blog.i18n.messages" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="titulo-pagina" /></title>
        <link href='http://fonts.googleapis.com/css?family=Archivo+Narrow:400,700|Open+Sans:400,300' rel='stylesheet' type='text/css' />
        <link href="css/style.css" rel="stylesheet" type="text/css" media="screen" />
        <link href="css/maps.css" rel="stylesheet">
        <script src="js/lib/jquery-1.10.2.js" type="text/javascript"></script>
    </head>
    <body>
        <div id="wrapper">
            <div id="header-wrapper">
                <div id="header">
                    <div id="logo">
                        <h1><a href="index"><fmt:message key="titulo-pagina" /></a></h1>
                    </div>
                    <div id="menu">
                        <ul>
                            <li><a class="button button-nav" href="index"><fmt:message key="btn-inicio" /></a></li>
                            <li><a class="button button-nav current-page-item" href="crear-post"><fmt:message key="btn-crear-entrada" /></a></li>
                            <li><a class="button button-nav" href="perfil"><fmt:message key="btn-editar-perfil" /></a></li>
                            <li><a class="button button-nav" href="logout"><fmt:message key="btn-desconectarse" /></a></li>
                        </ul>
                    </div>
                </div>
                <div id="banner">
                    <div class="content"><img src="images/img02.jpg" alt="" /></div>
                </div>
            </div>

            <div id="page">
                <div id="content">
                    <div class="post">
                        <h2><fmt:message key="crear-post" /></h2>
                        <div class="entry">
                            <form id="form-nuevaEntrada" action="crear-post" method="post" enctype="multipart/form-data">
                                <label for="titulo" class="form-item"><fmt:message key="titulo" /></label>
                                <input type="text" name="tituloPost"id="titulo" class="form-item"/>
                                <label for="entrada" class="form-item"><fmt:message key="entrada" /> </label>
                                <textarea name="textoPost" rows="20" cols="30" id="entrada" class="form-item"></textarea>
                                <label><fmt:message key="etiquetas" /></label>
                                <input type="text" name="etiqueta" size="60" maxlength="60" /><br />
                                <input type="text" id="latitud" hidden="true" name="lat"/><br />
                                <input type="text" id="longitud" hidden="true" name="lng"/><br />
                                <input type="text" id="numFotos" value="0" hidden="true" name="numFotos"/><br />
                                <label for="fotos" class="form-item"><fmt:message key="foto" /></label>
                                <input type="button" value=<fmt:message key="btn-agregar" /> id="botonAgregar"/>
                                <fieldset id="fotos">
                                    <fieldset>
                                        <input type="file" name="foto-0" class="form-item foto"/>
                                        <input type="button" value=<fmt:message key="btn-eliminar" /> class="button-eliminar"/>
                                    </fieldset>
                                </fieldset>
                                <label for="localizacion" class="form-item"><fmt:message key="localizacion" /></label>
                                <fieldset id="panel">
                                    <input id="address" type="text" class="form-item" name="address"/>
                                    <input type="button" id="botonBuscar" value=<fmt:message key="btn-buscar" /> >
                                </fieldset>
                                <div id="map-canvas"></div>
                                <input type="submit" class="button form-item form-submit-button" name="CrearPost" value=<fmt:message key="btn-crear-post" /> />
                            </form>
                        </div>
                    </div>
                </div>
                <div id="sidebar">
                    <div id="sidebar-content">
                        <ul>
                            <c:if test="${not empty sessionScope.usuario}">
                                <li>
                                    <h2>${sessionScope.usuario.username}</h2>
                                    <div id="avatar-perfil"><img src="AvatarUsuarioServlet" /></div>
                                </li>
                            </c:if>                                
                            <li>
                                <h2><fmt:message key="buscador" /></h2>
                                 <form id="form-login" action="busqueda" method="get">
                                    <input type="text" name="cadena" id="buscador" class="form-item no-float" />
                                    <input type="submit" class="button form-item form-submit-button no-float" id="boton-buscar" value=<fmt:message key="btn-buscar" /> />
                                </form>
                            </li>                                
                            <li>
                                <h2><fmt:message key="etiquetas" /></h2>
                                <div class="etiquetas" id="trend_etiquetas"></div>
                            </li>                           
                            <li>
                                <h2><fmt:message key="archivo" /></h2>
                                <ul id="archivo">
                                    <c:forEach var="yearEntry" items="${crearPostView.postsArchive}">
                                        <li class="archive-year-entry">
                                            <p>${yearEntry.key}</p>
                                            <ul class="archive-months hide">
                                                <c:forEach var="monthEntry" items="${yearEntry.value}">
                                                    <li class="archive-month-entry">
                                                        <p>${monthEntry.key}</p>
                                                        <ul class="archive-months-posts hide">
                                                            <c:forEach var="post" items="${monthEntry.value}">
                                                                <li><a href="post?id=${post.id}" class="archive-title-entry">${post.titulo}</a></li>
                                                            </c:forEach>
                                                        </ul>
                                                    </li>
                                                </c:forEach>
                                            </ul>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="clear">&nbsp;</div>
            </div>
        </div>

        <div id="footer">
            <div id="barra-idiomas">
                <a class="button button-idioma" href="idioma?locale=es_ES">Español</a>
                <a class="button button-idioma" href="idioma?locale=en_UK">English</a>
            </div>
            <p>María Expósito, Alfredo Gallego, Christian Pareja y Miguel Vicente</p>
        </div>
        <script src="js/lib/jquery-1.10.2.js" type="text/javascript"></script>
        <c:choose>
            <c:when test="${language == 'es_ES'}">
                <script src="js/archivo_messages_es_ES.js" type="text/javascript"></script>
            </c:when>
            <c:otherwise>
                <script src="js/archivo_messages_en_UK.js" type="text/javascript"></script>
            </c:otherwise>
        </c:choose>
        <script src="js/archivo.js" type="text/javascript"></script>
        <script src="js/tags.js" type="text/javascript"></script> 
        <script src="js/create.js" type="text/javascript"></script> 
        <script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>    
        <script src="js/maps.js"></script>
    </body>
</html>
