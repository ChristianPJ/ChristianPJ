$(function () {
    
    $('.pagination').jqPagination({
        page_string : '{current_page} / {max_page}',
        paged: function (pageNumber) {
            $.redirectGET('index', {page: pageNumber});
        }
    });
    
});