var cardreaderevent = function(vue) {
    function cardreader::onstatuschange( oldstatus, newstatus ) {
        vue.triggerEvent("cardreader", "cardreader", "statuschange", {old:oldstatus,now:newstatus});
    }
    function cardreader::oncomplete(cmd, result) {
        vue.triggerEvent("pinpad", "pinpad", cmd, result);
    }
    function cardreader::oninsert(){
        vue.triggerEvent( "pinpad", "pinpad", "cardinsert", null );
    }
    function cardreader::ontaken(){
        vue.triggerEvent( "pinpad", "pinpad", "cardtaken", null );
    }
    function cardreader::oncardboxthreshold( witch, status ){
        vue.triggerEvent( "pinpad", "pinpad", "cardbox", {witch:witch,status:status} );
    }
}

var cardreaderfunc=function( vue ){
    cardreader.open=function( param ){
        setTimeout(function() {
            vue.triggerEvent("pinpad", "pinpad", "open", {id:0,result:0,data:{}});
        }, 3000);
        return {result:0,reason:''};
    };
    cardreader.reset=function(param){
        setTimeout(function() {
            vue.triggerEvent("pinpad", "pinpad", "reset", {id:0,result:0,data:{}});
        }, 3000);
        return {result:0,reason:''};
    };
    cardreader.close=function(){
        vue.triggerEvent("pinpad", "pinpad", "close", {id:0,result:0,data:{}});
        return {result:0,reason:''};
    };
    cardreader.cancel=function(cmdid){
        return {result:0,reason:''};
    };
    cardreader.getstatus=function(){
        return {status:'ok'};
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
    cardreaderfunc( vue );
};