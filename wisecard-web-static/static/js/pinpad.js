var pinpadevent = function(vue) {
    function pinpad::onstatuschange(oldstatus, newstatus) {
        vue.triggerEvent("pinpad", "pinpad", "statuschange", {old:oldstatus,now:newstatus});
    }

    //data{ c:??(*/0-9),end:"entry"/"cancel"/"timeout"}
    function pinpad::ongetchar(data) {
        vue.triggerEvent("pinpad", "pinpad", "getchar", data);
    }

    //cmd:"init"/"open"/"close"/"getpinblock"/"getmac"/"crypt"/"reset"
    function pinpad::oncomplete(cmd, result) {
        vue.triggerEvent("pinpad", "pinpad", cmd, result);
    }
};
var pinpadfunc=function( vue ){
    pinpad.open=function( param ){
        setTimeout(function() {
            vue.triggerEvent("pinpad", "pinpad", "open", {id:0,result:0,data:{}});
        }, 3000);
        return {result:0,reason:''};
    };
    pinpad.reset=function(param){
        setTimeout(function() {
            vue.triggerEvent("pinpad", "pinpad", "reset", {id:0,result:0,data:{}});
        }, 3000);
        return {result:0,reason:''};
    };
    pinpad.close =function(){
        vue.triggerEvent("pinpad", "pinpad", "close", {id:0,result:0,data:{}});
        return {result:0,reason:''};
    };
    pinpad.cancel=function(cmdid){
        return {result:0,reason:''};
    };
    pinpad.getstatus=function(){
        return {status:'ok'};
    }
}

window.$pinpad = function(vue) {
    console.log("init pinpad");
    var myElement = document.createElement('object');
    myElement.classid = "";
    myElement.id = "pinpad";
    myElement.class = "devclass";
    document.getElementById('devactivexs').appendChild(myElement);
    pinpadevent(vue);
    pinpadfunc( vue );
};