<template>
  <section>
    <span>dkfdkfdl</span>
    <text text="启动应用"></text>
    <component ref="mainview" :is="showpage" id="mianview"></component>
  </section>
</template>
<script>
import Vue from 'vue'
export default{
  props:['devs'],
  created(){
    this.getconfig();
  },
  mounted(){
  },
  data(){
    return{
        key:{
          masterkey:{
            status:false
          },
          pinkey:{
            status:false
          },
          mackey:{
            status:false
          }
        },
        curpagelist:[],
        showpage:'',
        loadtransstatus:false
    }
  },
  computed:{
  },
  methods:{
    loadtrans(){
      if( this.loadtransstatus == true )
        return;
      for(let i = 0, j = 1; i < this.config.trans.length; i++ ){
        console.log("加载业务")
        console.log( this.config.trans[i]);
        this.log.i( "start", "loadtrans", "load trans(" + this.config.trans[i].name + ")begin" );
        try{
          let trans = require( "../trans/" + this.config.trans[ i ].module + "/index.js" );
          Vue.use(trans.default);
          if( trans.default.getflow != null ){
            this.config.trans[i].pagelist = trans.default.getflow();
          }else{
            this.log.e( "start", "loadtrans", "trans(" + this.config.trans[i].name + ") not define listpage" );
            continue;
          }
          if( ( 0 == this.config.trans[i].type & 4 )  &&  ( trans.default.cando != null ) ) {
            this.config.trans[i].cando = trans.default.cando;
          }else{
            this.config.trans[i].cando=function(){ return {tip:'',status:"ok"}};
          }
          this.log.i( "start", "loadtrans", "load trans(" + this.config.trans[i].name + ")success" );
        }catch( e ){
          this.log.i( "start", "loadtrans", "load trans(" + this.config.trans[i].name + ") failed,reason" + e );
        }
        this.log.i( "start", "loadtrans", "load trans(" + this.config.trans[i].name + ")end" );
      }
      this.loadtransstatus = true;
    },
    devevent(dev, type, cmd, data){
      console.log("接收到分发的设备事件");
      if( dev == "pinpad" && cmd=="open" && data.result == 0 ){
        this.getMasterKey();
      }
      this.success( "runpage", 0, '' );
    },
    success( nextpage, reason, data ){
      this.$emit("pagechange", nextpage, reason, data );
    },
    setconfig(data){
      if( data.cfg == null || data == undefined ){
        this.log.e( "app", "setconfig", "config data is empty" );
        return -1;
      }
      this.config.getconfig().cfg =data.cfg;
      this.config.getconfig().modules = data.modules;
      this.config.getconfig().trans = data.trans;
      this.config.getconfig().application = data.application;
      this.config.onload();
      return 0;
    },
    getconfig(){
      var me = this;
      this.$http.get( "../../../static/data/config.json" ).then( function( res ){
        if( res.status== 200){
          if( 0 == me.setconfig( res.data  ) ){
            me.loadtrans();
          }
        }else{
          setTimeout(function() {
            me.getconfig();
          }, 30000 );
          me.log.e( "start", "getconfig", "getconfig error->" + JSON.tojson(res) );
        }
      }).catch(function(err){
        console.log("网络错误");
        setTimeout(function() {
            me.getconfig();
          }, 30000 );
        me.log.e( "start","getconfig", "getconfig exception->" + err );
      });
    },
    startsuccess(){
      if( this.key.masterkey.status == true && this.key.pinkey.status == true && this.key.mackey.status == true &&
       1 ){
         
         this.success( "runpage", 0, 0 );
       }
    },
    getMasterKey(force){
      console.log( "开始下载masterkey" );
      this.log.i( "start", "getmasterkey", "load masterkey begin")
      var me = this;
      if( force == true || this.key.masterkey.status == false ){
        this.$http.get( "../../../static/data/masterkey.json" ).then( function( res ){
        if( true ){
          me.log.i( "start", "getMasterKey", "DownLoad MasterKey success" );
          me.key.masterkey.status = true;
          console.log("下载工作秘钥");
          me.getWorkKey(true);
        }else{
          me.log.i( "start", "getMasterKey", "DownLoad MasterKey failed, retry" );
          setTimeout(function() {
            me.getMasterKey(true);
          }, 30000);
          me.key.masterkey.status = false;
        }
      }).catch( function(err){
        console.log( "下载主秘钥失败");
        me.log.e( "start","getMasterKey", "DownLoad MasterKey failed->" + err );
      });
      this.log.i( "start", "getmasterkey", "load masterkey end")
    }
    },
    getWorkKey( force ){
      var me = this;
      if( ( force != null && force == true ) || this.key.pinkey.status == false ){
        this.$http.get( "../../../static/data/pinkey.json" ).then( function( res ){
        console.log( "下载PIN秘钥成功");
        me.log.i( "start", "getWorkKey", "down pin Success" );
        if( true ){
          console.log( "下载PIN秘钥到键盘成功");
          me.log.i( "start", "getWorkKey", "DownLoad PinKey sucess" );
          me.key.pinkey.status = true;
        }else{
          console.log( "下载PIN秘钥到键盘失败");
          setTimeout(function() {
            me.getWorkKey();
          }, 30000);
          me.log.i( "start", "getWorkKey", "DownLoad PinKey failed, retry 30000 later" );
        }
        }).catch( function(err){
        console.log( "下载Pin秘钥失败");
        me.log.e( "start","getworkkey", "DownLoad PinKey failed->" + err );
       });
      }
      
      if( force == true || this.key.mackey.status == false ){
        this.$http.get( "../../../static/data/mackey.json" ).then( function( res ){
        console.log( "下载MAC秘钥成功");
        me.log.i( "start", "getWorkKey", "down mac Success" );
        if( true ){
          console.log( "下载MAC秘钥到键盘成功");
          me.log.i( "start", "getWorkKey", "DownLoad mackey sucess" );
          me.key.mackey.status = true;
          me.startsuccess();
        }else{
          console.log( "下载MAC秘钥到键盘失败");
          setTimeout(function() {
            me.getWorkKey();
          }, 30000);
          me.log.i( "start", "getWorkKey", "DownLoad mackey failed, retry 30000 later" );
        }
      }).catch( function(err){
        console.log( "下载MAC秘钥失败");
        me.log.e( "start","getworkkey", "DownLoad mackey failed->" + err );
      });
     }
    }
  }
}
</script>
