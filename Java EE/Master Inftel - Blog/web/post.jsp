<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="language" value="${not empty sessionScope.locale ? sessionScope.locale : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="es.uma.inftel.blog.i18n.messages" />
<html lang="${language}">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <title><fmt:message key="titulo-pagina" /></title>
        <link href='http://fonts.googleapis.com/css?family=Archivo+Narrow:400,700|Open+Sans:400,300' rel='stylesheet' type='text/css' />
        <link href="css/style.css" rel="stylesheet" type="text/css" media="screen" />
        <link href="css/maps.css" rel="stylesheet">
        <link href="css/galeria.css" rel="stylesheet" type="text/css" media="screen" />
        <link href="js/lib/responsive-carousel/responsive-carousel.css" rel="stylesheet">
        <link href="js/lib/responsive-carousel/responsive-carousel.slide.css "rel="stylesheet">
        <link href="css/post.css" rel="stylesheet" type="text/css"/>
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
                    <div class="post">
                        <h2 class="title"><a href="#">${postView.post.titulo}</a></h2>
                        <div class="meta">
                            <span class="date"><fmt:formatDate type="both" dateStyle="short" timeStyle="short"  value="${postView.post.fechaCreacion}" /></span>
                            <span class="posted"><fmt:message key="escrito-por" />
                                <a href="<c:url value="busqueda?usuario=${postView.post.usuarioId.username}"/>">${postView.post.usuarioId.username}</a>
                            </span>
                        </div>
                        <div class="entry">
                            <c:if test="${not empty postView.imagenes}">
                            <div class="carousel" <c:if test="${fn:length(postView.imagenes) > 1}">data-transition="slide" data-autoplay data-loop="true"</c:if>>
                                    <c:forEach var="f" items="${postView.imagenes}">
                                        <div><img src="FotosServlet?id=${f.id}"></div>
                                    </c:forEach>
                                </div>
                            </c:if>
                            <c:forEach var="p" items="${postView.parrafosPost}">
                                <p>${p}</p>
                            </c:forEach>
                            <div id="mapitas">
                                <c:if test="${not empty postView.mapa}">
                                    <input type="text" value="${postView.mapa.latitud}" id="latitud" hidden="false" name="lat" />
                                    <input type="text" value="${postView.mapa.longitud}" id="longitud" hidden="false" name="lng" />
                                    <div id="map-canvas"></div>
                                </c:if>
                            </div>
                            <div class="etiquetas">
                                <c:if test="${not empty postView.post.etiquetaCollection}">
                                    <fmt:message key="etiquetas" />:
                                    <c:forEach var="e" items="${postView.post.etiquetaCollection}">
                                        <a class="etiq" href="<c:url value="busqueda?etiqueta=${e.nombre}" />">${e.nombre}</a>,
                                    </c:forEach>
                                </c:if>
                            </div>
                                <c:if test="${postView.post.fechaCreacion != postView.post.fechaModificacion}">
                                    <div class="meta">
                                        <span class="date mod-date"><fmt:message key="ultima-modificacion" /> <fmt:formatDate type="both" dateStyle="short" timeStyle="short"  value="${postView.post.fechaModificacion}" /></span>
                                    </div>
                                </c:if>
                            <div class="botones-post">
                                <c:if test="${not empty sessionScope.usuario and sessionScope.usuario.tipo == 0}">
                                    <a class="button botonBorrarPost" href="BorrarPostServlet?post=${postView.post.id}">
                                        <fmt:message key="borrar" />
                                    </a>
                                </c:if>
                                <c:if test="${not empty sessionScope.usuario and sessionScope.usuario.tipo == 1 and sessionScope.usuario.id == postView.post.usuarioId.id}">
                                    <div class="botonEditarPost" id="post-${postView.post.id}">
                                        <a class="button botonBorrarPost" href="editar-post?id=${postView.post.id}"><fmt:message key="editar" /></a>
                                    </div>
                               </c:if>
                            </div>
                        </div>
                    </div>
                    <c:if test="${not empty sessionScope.usuario and sessionScope.usuario.tipo < 3}">
                        <div class="post">
                            <div class="entry">
                                <form action="ComentarServlet?idpost=${postView.post.id}" method="post">
                                    <label><fmt:message key="comentario" /></label>
                                    <textarea id="commentBody" name="texto" style="width: 99%; height: 94px;" placeholder=<fmt:message key="introduce-comentario" />></textarea><br />
                                    <input type="submit" class="button form-item form-submit-button" name="GuardarComentario" value=<fmt:message key="btn-guardar" /> />
                                </form>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${not empty sessionScope.usuario}">
                        <c:if test="${fn:length(postView.post.comentarioCollection) > 0}">
                            <div class="post">
                                <div class="entry" name="comentarios">
                                    <c:forEach var="comentario" items="${postView.post.comentarioCollection}">
                                        <li id="commentBody">
                                            <c:if test="${sessionScope.usuario.tipo == 0}">
                                                <div class="botonBorrarComentario" id="comentario-${comentario.id}">
                                                    <button class="button"><fmt:message key="borrar" /></button>
                                                </div>
                                            </c:if>
                                            <div class="useravatar">
                                                <div id="avatar-comentario"><img src="AvatarUsuarioServlet?usuarioId=${comentario.usuarioId.id}" /></div>
                                                <div class="metadata-comentario">
                                                    <h3 class="title2" ><a href="#">${comentario.usuarioId.username}</a></h3>
                                                    <div class="fechaComentario"><fmt:formatDate type="both" dateStyle="short" timeStyle="short"  value="${comentario.fechaCreacion}" /></div>
                                                </div>
                                            </div>
                                            <div class="mostrarcomentario" >${comentario.texto}</div>
                                            <hr />
                                        </li>
                                    </c:forEach>
                                </div>
                            </div>
                        </c:if>
                    </c:if>

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
            <p>María Expósito, Alfredo Gallego, Christian Pareja y Miguel Vicente</p>
        </div>
        <script src="js/lib/jquery-1.10.2.js" type="text/javascript"></script>
        <script>
            $(function () {
                pintarMapa();
            });
        </script>
        <script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>    
        <script src="js/maps.js"></script>
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
        <script src="js/delete.js" type="text/javascript"></script>
        <script src="js/tags.js" type="text/javascript"></script>
        <script src="js/lib/responsive-carousel/responsive-carousel.js"></script>
        <script src="js/lib/responsive-carousel/responsive-carousel.loop.min.js" type="text/javascript"></script>
        <script src="js/lib/responsive-carousel/responsive-carousel.autoinit.js"></script>
        <script src="js/lib/responsive-carousel/responsive-carousel.autoplay.js"></script>
        <script src="js/galeria.js" type="text/javascript"></script>
    </body>
</html>
