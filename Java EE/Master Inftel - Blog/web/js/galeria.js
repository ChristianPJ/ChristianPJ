$(function () {
    
    var resizeTimeOut;
    
    var resizeCarouselImages = function () {
        var $carousel = $('.carousel').first();
        var carouselWidth = $carousel.width();
        var carouselHeight = $carousel.height();

        $carousel.find('div img').each(function () {
            var $image = $(this);
            var imgWidth = $image.width();
            var imgHeight = $image.height();

            var widthRatio = imgWidth / carouselWidth;
            var heightRatio = imgHeight / carouselHeight;

            var maxRatio = Math.max(widthRatio, heightRatio);

            var newWidth;
            var newHeight;

            if (widthRatio === maxRatio) {
                newWidth = carouselWidth;
                newHeight = parseInt(imgHeight / widthRatio);
            } else {
                newWidth = parseInt(imgWidth / heightRatio);
                newHeight = carouselHeight;
            }

            $image.css('width', newWidth);
            $image.css('height', newHeight);
        });
    };
    
    // Redimensionamos las imagenes del carousel al cargar la pagina.
    resizeCarouselImages();
    
    // Redimensionamos las imagenes del carousel al terminar de redimensionar la pagina.
    $(window).bind('resizeEnd', function() {
        resizeCarouselImages();
    });
    
    $(window).resize(function() {
        if(resizeTimeOut) {
            clearTimeout(resizeTimeOut);
        }
        resizeTimeOut = setTimeout(function() {
            $(this).trigger('resizeEnd');
        }, 500);
    });
    
    
    var $navs = $('.carousel nav');
    
    // La libreria del carousel agrega 2 menus de navegacion. Eliminamos uno.
    $navs.last().remove();
    
    // Y al otro menu le eliminamos el texto de los enlaces.
    $navs.first().find('a').each(function () {
        $(this).text('');
    });
    
    // Corrige un bug de la libreria que hace que se cuenten los
    // menus de navegacion como items del carousel.
    $navs.removeClass('carousel-item');
    $navs.removeClass('carousel-item-prev');
    $navs.removeClass('carousel-item-next');
    $navs.removeClass('carousel-active');
    
});
    