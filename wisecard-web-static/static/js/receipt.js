var receiptevent = function(vue) {
    function receipt::onstatuschange(oldstatus, newstatus) {
        vue.triggerEvent("receipt", "receipt", "statuschange", {old:oldstatus,now:newstatus});
    }
    //cmd:"init"/"open"/"close"/"getpinblock"/"getmac"/"crypt"/"reset"
    function receipt::oncomplete(cmd, result) {
        vue.triggerEvent("receipt", "receipt", cmd, result);
    }
};
var receiptfunc=function( vue ){
    receipt.open=function( param ){
        setTimeout(function() {
            vue.triggerEvent("receipt", "receipt", "open", {id:0,result:0,data:{}});
        }, 3000);
        return {result:0,reason:''};
    };
    receipt.reset=function(param){
        setTimeout(function() {
            vue.triggerEvent("receipt", "receipt", "reset", {id:0,result:0,data:{}});
        }, 3000);
        return {result:0,reason:''};
    };
    receipt.close =function(){
        vue.triggerEvent("receipt", "receipt", "close", {id:0,result:0,data:{}});
        return {result:0,reason:''};
    };
    receipt.cancel=function(cmdid){
        return {result:0,reason:''};
    };
    receipt.getstatus=function(){
        return {status:'ok'};
    }
}

window.$receipt = function(vue) {
    console.log("init receipt");
    var myElement = document.createElement('object');
    myElement.classid = "";
    myElement.id = "receipt";
    myElement.class = "devclass";
    document.getElementById('devactivexs').appendChild(myElement);
    receiptevent(vue);
    receiptfunc( vue );
};