function addCatalog() {
    var nameCatalog = $('[name=name]').val();
    $.ajax({
        url: "/ui/catalog/add/"+nameCatalog,
        cache: false,
        method: "POST",
        contentType: "application/json",
        dataType: "json",
        success: function (data) {
            window.setTimeout(function(){
                // Move to a new location or you can do something else
                window.location.href = "/ui/";
            }, 1000);
        },
        error: function(e) {
            alert("Приносим свои извенения. В данный момент мы не можем создать каталог.");
        }
    });
    return false;
}
function removeCatalog(name) {
    var obj = {
        name: name
    };
    var jsonStr = JSON.stringify(obj);
    $.ajax({
        url: "/ui/catalog/remove/",
        cache: false,
        method: "POST",
        contentType: "application/json",
        dataType: "json",
        data: jsonStr,
        success: function (data) {
            setTimeout(function() {window.location.reload();}, 1000);
        },
        error: function(e) {
            alert(JSON.stringify(e));
        }
    });
}