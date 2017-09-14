var pinpadevent = function(vue) {
    function pinpad::onstatuschange() {
        var name = '[method]';
        vue[name].triggerEvent("pinpad", 0, 0, 0);
    }

    //data{ o:...,n:...}
    function pinpad::onstatuschange(data) {
        var name = '[method]';
        vue[name].triggerEvent("pinpad", "pinpad", "status", data);
    }

    //data{ c:??(*/0-9),end:"entry"/"cancel"/"timeout"}
    function pinpad::oninput(data) {
        var name = '[method]';
        vue[name].triggerEvent("pinpad", "pinpad", "status", data);
    }

    //cmd:"init"/"open"/"close"/"getpinblock"/"getmac"/"crypt"/"reset"
    function pinpad::oncomplete(cmd, result) {
        var name = '[method]';
        vue[name].triggerEvent("pinpad", "pinpad", cmd, result);
    }

};
window.$pinpad = function(vue) {
    console.log("init pinpad");
    var myElement = document.createElement('object');
    myElement.classid = "";
    myElement.id = "pinpad";
    myElement.class = "devclass";
    document.getElementById('devactivexs').appendChild(myElement);
    pinpadevent(vue);
};