<!DOCTYPE html>
<!--
    Original Design by TEMPLATED
    http://templated.co
    Released for free under the Creative Commons Attribution License

    Name       : Murky Stairwell
    Description: A two-column, fixed-width design with dark color scheme.
    Version    : 1.0
    Released   : 20130405

-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="language" value="${not empty sessionScope.locale ? sessionScope.locale : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="es.uma.inftel.blog.i18n.messages" />
<html>
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
                            <c:choose>
                                <c:when test="${empty sessionScope.usuario}">
                                    <li><a class="button button-nav" href="login"><fmt:message key="btn-identificarse" /></a></li>
                                    <li><a class="button button-nav" href="registro"><fmt:message key="btn-registrarse" /></a></li>
                                </c:when>
                                <c:otherwise>
                                    <c:choose>
                                        <c:when test="${sessionScope.usuario.tipo == 0}">
                                            <li><a class="button button-nav" href="admin"><fmt:message key="btn-admin" /></a></li>
                                        </c:when>
                                        <c:when test="${sessionScope.usuario.tipo == 1}">
                                            <li><a class="button button-nav" href="crear-post"><fmt:message key="btn-crear-entrada" /></a></li>
                                        </c:when>
                                    </c:choose>
                                    <c:if test="${sessionScope.usuario.tipo != 3}">
                                        <li><a class="button button-nav" href="perfil"><fmt:message key="btn-editar-perfil" /></a></li>
                                    </c:if>
                                    <li><a class="button button-nav" href="logout"><fmt:message key="btn-desconectarse" /></a></li>
                                </c:otherwise>
                            </c:choose>
                        </ul>
                    </div>
                </div>
                <div id="banner">
                    <div class="content"><img src="images/img02.jpg" alt="" /></div>
                </div>
            </div>

            <div id="page">
                <div id="content">
                    <c:forEach var="postSummary" items="${busquedaView.resultadosBusqueda}">
                        <div class="post">
                            <h2 class="title"><a href="post?id=${postSummary.id}">${postSummary.titulo}</a></h2>
                            <div class="meta">
                                <span class="date"><fmt:formatDate type="both" dateStyle="short" timeStyle="short"  value="${postSummary.fechaCreacion}" /></span>
                                <span class="posted"><fmt:message key="escrito-por" /> 
                                    <a href="<c:url value="busqueda?usuario=${postSummary.username}"/>">${postSummary.username}</a>
                                </span>
                            </div>
                            <div class="entry">
                                <c:forEach var="p" items="${postSummary.parrafos}">
                                    <p>${p}</p>
                                </c:forEach>
                                <div class="links">
                                    <a href="post?id=${postSummary.id}" class="button more"><fmt:message key="leer-mas" /></a>
                                </div>
                                <div class="etiquetas">
                                    <c:if test="${not empty postSummary.listEtiqueta}">
                                        <fmt:message key="etiquetas" />:
                                        <c:forEach var="e" items="${postSummary.listEtiqueta}">
                                            <a class="etiq" href="<c:url value="busqueda?etiqueta=${e.nombre}" />">${e.nombre}</a>,
                                        </c:forEach>
                                    </c:if>
                                </div>  
                            </div>
                        </div>
                    </c:forEach>
                    <div class="pagination-container">
                        <div class="pagination">
                            <a href="#" class="pagination-button first" data-action="first">&laquo;</a>
                            <a href="#" class="pagination-button previous" data-action="previous">&lsaquo;</a>
                            <input type="text" readonly="readonly" data-current-page="${busquedaView.currentPage}" data-max-page="${busquedaView.lastPage}" />
                            <a href="#" class="pagination-button next" data-action="next">&rsaquo;</a>
                            <a href="#" class="pagination-button last" data-action="last">&raquo;</a>
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
                                    <c:forEach var="yearEntry" items="${busquedaView.postsArchive}">
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
                <div id="tipo-busqueda" class="hide">${busquedaView.tipoBusqueda.id}</div>
                <div id="valor-busqueda" class="hide">${busquedaView.valor}</div>
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
        <script src="js/lib/beneverard-jqPagination/js/jquery.jqpagination.js"></script>
        <script src="js/redirect-get.js" type="text/javascript"></script>
        <script src="js/pagination-search.js" type="text/javascript"></script>                
        <script src="js/tags.js" type="text/javascript"></script>        
    </body>
</html>
