function addBook() {
    var date = Date.parse($('[name=releaseDate]').val())/1000;
    var book = {
        name: $('[name=name]').val(),
        author: $('[name=author]').val(),
        releaseDate: date
    };
    var catalogName = $("#catalog_name").val();
    var catalog = {
        id: catalogName
    };
    var obj = {
        book: book,
        catalog: catalog
    };
    $.ajax({
        url: "/ui/catalog/book/add/",
        cache: false,
        method: "POST",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(obj),
        success: function (data) {
            window.setTimeout(function(){
                // Move to a new location or you can do something else
                window.location.href = "/ui/list_book.html?id="+catalogName ;
            }, 1000);
        },
        error: function(e) {
            alert("Приносим свои извенения. В данный момент мы не можем добавить книгу.");
        }
    });
    return false;
}
function removeBook(name,author,releaseDate, catalogId, bookId) {
    var book = {
        id: bookId,
        name: name,
        author: author,
        releaseDate: releaseDate
    };
    var catalog = {
        id: catalogId
    };
    var obj = {
        book: book,
        catalog: catalog
    };
    $.ajax({
        url: "/ui/catalog/book/remove/",
        cache: false,
        method: "POST",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(obj),
        success: function (data) {
            setTimeout(function() {window.location.reload();}, 1000);
        },
        error: function(e) {
            alert("Приносим свои извенения. В данный момент нельзя удалить книгу.");
        }
    });
}
function updateBook() {
    var catalogId = getParameterByName("catalogId");
    var id = getParameterByName("bookId")
    var date = Date.parse($('[name=releaseDate]').val())/1000;
    var book = {
        id: id,
        name: $('[name=name]').val(),
        author: $('[name=author]').val(),
        releaseDate: date
    };
    var catalog = {
        id: catalogId
    };
    var obj = {
        book: book,
        catalog: catalog
    };
    $.ajax({
        url: "/ui/catalog/book/update/",
        cache: false,
        method: "POST",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(obj),
        success: function (data) {
            window.setTimeout(function(){
                // Move to a new location or you can do something else
                window.location.href = "/ui/list_book.html?id="+catalogId;
            }, 1000);
        },
        error: function(e) {
            alert("Приносим свои извенения. В данный момент нельзя изменить книгу.");
        }
    });
}
function getParameterByName(name) {
    var match = RegExp('[?&]' + name + '=([^&]*)').exec(window.location.search);
    return match && decodeURIComponent(match[1].replace(/\+/g, ' '));
}