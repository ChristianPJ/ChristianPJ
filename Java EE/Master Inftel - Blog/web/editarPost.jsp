<%-- 
    Document   : crearPost
    Created on : Dec 13, 2014, 12:07:59 PM
    Author     : maramec
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
    </head>
    <body>
        <div id="wrapper">
            <div id="header-wrapper">
                <div id="header">
                    <div id="logo">
                        <h1><a href="#"><fmt:message key="titulo-pagina" /></a></h1>
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
                        <h2><fmt:message key="editar-post" /></h2>
                        <div class="entry">
                            <form id="form-editarEntrada" action="editar-post" method="post" enctype="multipart/form-data">
                                <label for="titulo" class="form-item"><fmt:message key="titulo" /></label>
                                <input type="text" name="id" value="${postView.post.id}"  hidden="true" />
                                <input type="text" name="tituloPost" id="titulo" value="${postView.post.titulo}" class="form-item"/>
                                <label for="entrada" id="label-entrada" class="form-item"><fmt:message key="entrada" /> </label>
                                <textarea name="textoPost" rows="20" cols="30" id="entrada" class="form-item">${postView.post.texto}</textarea>
                                <label><fmt:message key="etiquetas" /></label>
                                <c:choose>
                                    <c:when test="${postView.etiquetas != null && not empty postView.etiquetas}">
                                       <input type="text" name="etiqueta" size="60" maxlength="60" value="${postView.etiquetas}"/>
                                    </c:when>
                                    <c:otherwise>
                                        <input type="text" name="etiqueta" size="60" maxlength="60"/>
                                    </c:otherwise>   
                                </c:choose>
                                <input type="submit" class="button form-item form-submit-button" name="EditarPost" value=<fmt:message key="btn-editar-post" /> />
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
                                 <form id="form-login" action="busqueda" method="post">
                                    <input type="text" name="cadena" id="buscador" class="form-item no-float" />
                                    <input type="submit" class="button form-item form-submit-button no-float" id="boton-buscar" name="buscar" value=<fmt:message key="btn-buscar" /> />
                                </form>
                            </li>                                
                            <li>
                                <h2><fmt:message key="etiquetas" /></h2>
                                <div class="etiquetas" id="trend_etiquetas"></div>
                            </li>                           
                            <li>
                                <h2><fmt:message key="archivo" /></h2>
                                <ul id="archivo">
                                    <c:forEach var="yearEntry" items="${postView.postsArchive}">
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
            <p>&copy; Untitled. All rights reserved. Design by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>. Photos by <a href="http://fotogrph.com/">Fotogrph</a>.</p>
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
    </body>
</html>
