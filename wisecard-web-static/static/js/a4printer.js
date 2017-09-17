var a4event = function(vue) {
    function a4printer::onstatuschange(oldstatus, newstatus) {
        vue.triggerEvent("a4printer", "a4printer", "statuschange", {old:oldstatus,now:newstatus});
    }

    //cmd:"init"/"open"/"close"/"getpinblock"/"getmac"/"crypt"/"reset"
    function a4printer::oncomplete(cmd, result) {
        vue.triggerEvent("a4printer", "a4printer", cmd, result);
    }
};
var a4func=function( vue ){
    a4printer.open=function( param ){
        setTimeout(function() {
            vue.triggerEvent("a4printer", "a4printer", "open", {id:0,result:0,data:{}});
        }, 3000);
        return {result:0,reason:''};
    };
    a4printer.reset=function(param){
        setTimeout(function() {
            vue.triggerEvent("a4printer", "a4printer", "reset", {id:0,result:0,data:{}});
        }, 3000);
        return {result:0,reason:''};
    };
    a4printer.close =function(){
        vue.triggerEvent("a4printer", "a4printer", "close", {id:0,result:0,data:{}});
        return {result:0,reason:''};
    };
    a4printer.cancel=function(cmdid){
        return {result:0,reason:''};
    };
    a4printer.getstatus=function(){
        return {status:'ok'};
    }
}

window.$a4printer = function(vue) {
    console.log("init a4printer");
    var myElement = document.createElement('object');
    myElement.classid = "";
    myElement.id = "a4printer";
    myElement.class = "devclass";
    document.getElementById('devactivexs').appendChild(myElement);
    a4event(vue);
    a4func( vue );
};