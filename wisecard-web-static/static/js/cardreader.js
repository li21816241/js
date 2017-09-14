var cardreaderevent = function(vue) {
    function cardreader::onin() {
        console.log(vue);
        var name = '[method]';
        vue[name].triggerEvent("cardreader", 0, 0, 0);
    }

}
window.$cardreader = function(vue) {
    console.log("init cardreader");
    var myElement = document.createElement('object');
    myElement.classid = "";
    myElement.id = "cardreader";
    myElement.class = "devclass";
    document.getElementById('devactivexs').appendChild(myElement);
    cardreaderevent(vue);
};