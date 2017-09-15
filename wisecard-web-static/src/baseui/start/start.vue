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
        showpage:''
    }
  },
  computed:{
  },
  methods:{
    loadtrans(){
      {
        let trans = require( "../trans/" + "common" + "/index.js" );
        Vue.use(trans.default);
        if( trans.default.getflow != null ){
          this.config.trans[i].pagelist = trans.default.getflow();
        }
      }
      for(let i = 0, j = 0; i < this.config.trans.length; i++ ){
        let trans = require( "../trans/" + this.config.trans[ i ].module + "/index.js" );
        Vue.use(trans.default);
        if( trans.default.getflow != null ){
          this.config.trans[i].pagelist = trans.default.getflow();
        }else{
          this.log.e( "start", "loadtrans", "trans(" + this.config.trans[i].name + ") not define listpage" );
          continue;
        }
        if( trans.default.cando != null ){
          this.config.trans[i].cando = trans.default.cando;   
        }else{
          this.config.trans[i].cando=function(){ return {tip:'',status:"ok"}}; };
        }
      }
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
    getconfig(){
      var me = this;
      this.$http.get( "/rest/getconfig" ).then( function( res ){
        console.log( "ok" );
        if( 0 == me.setconfig( res  ) ){
          this.loadtrans();
        }else{
          setTimeout(function() {
            me.getconfig();
          }, 30000 );
          me.log.e( "start", "getconfig", "getconfig error->" + res );
        }
      }).catch(function(err){
        console.log("网络错误");
        setTimeout(function() {
            me.getconfig();
          }, 30000 );
        me.log.e( "start","getconfig", "getconfig error->" + err );
      });
    },
    startsuccess(){
      if( this.key.masterkey.status == true && this.key.pinkey.status == true && this.key.mackey.status == true &&
       1 ){
         
         success( "runpage", 0, 0 );
       }
    },
    getMasterKey(force){
      var me = this;
      if( force == true || this.key.MasterKey.status == false ){
        this.$http.get( "/rest/key/master" ).then( function( res ){
        if( true ){
          this.log.i( "start", "getMasterKey", "DownLoad MasterKey success" );
          me.key.master.status = true;
          console.log("下载工作秘钥");
          me.getWorkKey(true);
        }else{
          this.log.i( "start", "getMasterKey", "DownLoad MasterKey failed, retry" );
          setTimeout(function() {
            me.getMasterKey(true);
          }, 30000);
          me.key.master.status = false;
        }
      }).catch( function(err){
        console.log( "下载主秘钥失败");
        me.log.e( "start","getMasterKey", "DownLoad MasterKey failed->" + err );
      });
    }
    },
    getWorkKey( force ){
      var me = this;
      if( ( force != null && force == true ) || this.key.pinkey.status == false ){
        this.$http.get( "/rest/key/work/pin" ).then( function( res ){
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
        me.log.e( "start","getMasterKey", "DownLoad PinKey failed->" + err );
       });
      }
      
      if( force == true || this.key.mackey.status == false ){
        this.$http.get( "/rest/key/work/mac" ).then( function( res ){
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
        me.log.e( "start","getMasterKey", "DownLoad mackey failed->" + err );
      });
     }
    }
  }
}
</script>
