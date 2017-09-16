import './devcommon.js'
var pinpadevent = function(vue) {
    function pinpad::onstatuschange() {
        vue.triggerEvent("pinpad", 0, 0, 0);
    }

    //data{ o:...,n:...}
    function pinpad::onstatuschange(data) {
        vue.triggerEvent("pinpad", "pinpad", "status", data);
    }

    //data{ c:??(*/0-9),end:"entry"/"cancel"/"timeout"}
    function pinpad::oninput(data) {
        vue.triggerEvent("pinpad", "pinpad", "status", data);
    }

    //cmd:"init"/"open"/"close"/"getpinblock"/"getmac"/"crypt"/"reset"
    function pinpad::oncomplete(cmd, result) {
        vue.triggerEvent("pinpad", "pinpad", cmd, result);
    }
    setTimeout(function() {
        debugger;
        vue.triggerEvent("pinpad", "pinpad", "open", {id:0,result:0,data:{}});
    }, 5000);
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