<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="language" value="${not empty sessionScope.locale ? sessionScope.locale : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="es.uma.inftel.blog.i18n.messages" />
<html lang="${language}">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <title><fmt:message key="titulo-pagina" /></title>
        <link href='http://fonts.googleapis.com/css?family=Archivo+Narrow:400,700|Open+Sans:400,300' rel='stylesheet' type='text/css' />
        <link href="css/style.css" rel="stylesheet" type="text/css" media="screen" />
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
                            <li><a class="button button-nav" href="login"><fmt:message key="btn-identificarse" /></a></li>
                            <li><a class="button button-nav current-page-item" href="#"><fmt:message key="btn-registrarse" /></a></li>
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
                        <h2 class="title"><fmt:message key="registrarse" /></h2>
                        <div class="entry">
                            <form id="form-registro" action="registro" method="post" enctype="multipart/form-data">
                                <label for="username" class="form-item"><fmt:message key="usuario" /></label>
                                <input type="text" name="username" id="username" class="form-item" />
                                <label for="password" class="form-item"><fmt:message key="contraseña" /></label>
                                <input type="password" name="password" id="password" class="form-item" />
                                <label for="password2" class="form-item"><fmt:message key="repetir-contraseña" /></label>
                                <input type="password" name="password2" id="password2" class="form-item" />
                                <label for="email" class="form-item"><fmt:message key="email" /></label>
                                <input type="text" name="email" id="email" class="form-item" />
                                <label for="avatar" class="form-item"><fmt:message key="avatar" /></label>
                                <input type="file" name="avatar" id="avatar" class="form-item" />
                                <input type="submit" class="button form-item form-submit-button" name="registrarse" value="<fmt:message key="btn-registrarse" />" />
                            </form>
                            <c:if test="${registroView.errorRegistro == true}">
                                <p id="error-user-exists" class="error-message"><fmt:message key="usuario-registrado" /></p>
                            </c:if>
                        </div>
                    </div>
                </div>
                
                <div id="sidebar">
                    <div id="sidebar-content">
                        <ul>                              
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
                                    <c:forEach var="yearEntry" items="${registroView.postsArchive}">
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
        <script src="js/lib/jquery-validation/plugin/jquery.validate.min.js" type="text/javascript"></script>
        <script src="js/lib/jquery-validation/plugin/additional-methods.min.js" type="text/javascript"></script>
        <c:if test="${language == 'es_ES'}">
            <script src="js/lib/jquery-validation/plugin/localization/messages_es.min.js" type="text/javascript"></script>
            <script src="js/additional-methods_messages_es.js" type="text/javascript"></script>
        </c:if>
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
        <script src="js/registro.js" type="text/javascript"></script>
    </body>
</html>
