<style>
</style>
<template>
  <div class="full" id="level1">
    <component ref="mainview" :is="showpage" id="mianview" :devs="devs" v-on:pagechange="pagechange" ></component>
    <component ref="devwrap" :is="devmonitor" id="devtest" style="display:none" v-on:devevent="devevent" v-on:success="success" ></component>
  </div>
</template>
<script>
  import Vue from 'vue'
  export default {
    created(){
      Vue.prototype.log={};
      if( false && $("#logctl")!=null && $("#logctl")!=undefined ){
        Vue.prototype.log.logger=$("#log");
        Vue.prototype.log.i=function( module, func, data ){
          Vue.prototype.log.debug( Date().toLocaleString() + "\t" + module + "::" + func + "->" + data );
        };
        Vue.prototype.log.d=function( module, func, data ){
            Vue.prototype.log.debug( Date().toLocaleString() + "\t" + module + "::" + func + "->" + data );
        };
        Vue.prototype.log.e=function( module, func, data ){
            Vue.prototype.log.error( Date().toLocaleString() + "\t" + module + "::" + func + "->" + data );
        };
      }else{
        Vue.prototype.log.i = function( module, func, data){
            console.log( "info\t" + Date().toLocaleString() + "\t" + module + "::" + func + "->" + data );
          };
          Vue.prototype.log.e=function( module, func, data){
            console.log( "error\t" + Date().toLocaleString() + "\t" + module + "::" + func + "->" + data );
          };
          Vue.prototype.log.d =function( module, func, data){
            console.log( "debug\t" + Date().toLocaleString() + "\t" + module + "::" + func + "->" + data );
          };
      }
      this.log.i( "app", "created", "start app" );
      var me=this;
      Vue.prototype.config={
          modules:[{
              name:'cardreader',
              id:'',
              type:''
            },{
              name:'pinpad',
              id:'',
              type:''
            }
          ],
          trans:{
            devid:'0123456789',
            bankid:'chinabank',
            service:'127.0.0.1/cmt/'
          },
          cfg:{
            rpt:30000,
            maxcount:1,
            monitor:'127.0.0.1/cmt',
          },
          setconfig:function(data){
            if( data ==null || data == undefined ){
              me.log.e( "app", "setconfig", "config data is empty" );
              return -1;
            }
            me.config = JSON.parse(str);
            if( data.modules != null && data.modules != undefined){
              me.rpttimer = setInterval( function(){
                me.rpt();
              }, me.config.cfg.rpt );
              me.$ref.devwrap.devcreate();
              return 0;
            }
            return -1;
          }
        };
      document.onkeydown=this.keydown;
    },
    mounted(){
      this.$refs.devwrap.devcreate();
    },
    data(){
      return {
        neterrcount:0,
        devs:'',
        showpage:'startpage',
        devmonitor:'devmonitor',
        status:{
          //exiting,running,idle,starting,pause,maintain
          status:'starting',
          exit:false,
          control:'pause',
          pause:''
        },
        rpttimer:0
      }
    },
    methods:{
      devevent( dev, type, cmd, data ){
        console.log("分发设备事件");
        this.log.d( "app", "devevent", "dispalte message" );
        this.$refs.mainview.devevent( dev, type, cmd, data );
      },
      pagechange( nextpage, reason, data ){
        if( this.status.exit == true ){
          console.log( "停止作业，退出系统" );
          this.log.i( "app", "pagechange", "ready exit app" );
          closewindow();
        }else if( this.status.control=="pause" ){
          console.log("转入受控停用");
          this.log.i("app", "pagechange", "conver to pause by control command" );
          nextpage="pausepage";      
        }else if( this.status.control == "restart" ){
          console.log("转入受控重启");
          this.log.i("app", "pagechange", "conver to restart by control command" );
          this.status.exit=true;
          closewindow();
        }else{
          this.log.i( "app", "pagechange", "change page" + nextpage + ",reason" + reason + " data:" + data );
          if( nextpage == "runpage" ){
            if( -1 != this.rpttimer ){
              this.rpttimer = setInterval( function(){
                this.rpt();
              }, this.config.cfg.rpt );
            }
            this.status.status = "idle";
          }else if( nextpage == "pausepage" ){
            if( -1 != this.rpttimer ){
              this.rpttimer = setInterval( function(){
                this.rpt();
              }, this.config.cfg.rpt );
            }
            this.status.status = "pause";
          }else if( nextpage == "maintain" ){
            if( -1 != this.rpttimer ){
              this.rpttimer = setInterval( function(){
                this.rpt();
              }, this.config.cfg.rpt );
            }
            this.status.status = "maintain";
          }else if( nextpage=="transpage" ){
            window.clearInterval( this.rpttimer );
            this.rpttimer = -1;
            this.status.status = "running";
          }else{
            this.log.e( "app", "pagechange", "unknown page" );
          }
          console.log("跳转到("+nextpage+")页面");
          this.log.i("app", "pagechange", "goto " + nextpage + " page");
          this.showpage = nextpage;
        }
      },
      keydown( event ){
        console.log(event);
        if( event.key=="F9" && event.ctrlKey==true){
          this.log.i( "app", "pagechange", "receive CTRL + F9" );
            this.status.exit = true;
        }
        if( this.status.status != "running" && this.status.status != "exiting" ){
          this.log.i( "app", "pagechange", "exit app now" );
          this.closewindow();
        }
      },
      closewindow(){
        this.status.status = "exiting";
        this.$refs.devwrap.exit();
        this.showpage = "exitpage";
        setTimeout(function() {
          console.log( "达到指定时间系统依然没有退出,强行重启" );
          this.log.i( "app", "timeout", "exit app failed" );
        }, 5 * 60 * 1000);
      },
      success( cmd, status ){
        console.log("设备监控层完成退出" );
        this.log.i( "app", "success", "ready exit app" );
        widnow.close();
      },
      rpt(){
        var me = this;
        this.$http.get( '/rest/session' ).then(function(res){
          if( neterrcount > 0 ){
            neterrcount = neterrcount - 1;
          }
          var cmd = JSON.parse(res);
          if( cmd.control != null && cmd.control != undefined ){
            if( cmd.control == 'pause' ){
              console.log( "受控停用");
              me.log.i( "app", "rpt", "receive pause command" );
              me.status.control = 'pause';
            }else if( cmd.control == "restart" ){
              console.log( "受控重启");
              me.log.i( "app", "rpt", "receive restart command" );
              me.status.control="restart";
            }else if( cmd.control == "run" ){
              console.log( "受控恢复");
              me.log.i( "app", "rpt", "receive run command" );
              me.status.control = "run";
            }
          }
        }).catch(function(err){
          console.log( "网络故障" );
          me.log.err( "app", "rpt::catch", "net error" );
          neterrcount = neterrcount + 1;
          if( neterrcount >= me.config.cfg.maxcount ){
            if( me.status.status == "idle" ){
                me.pauseservice();
            }
          }
        });
      },
      pauseservice(){
        this.status.status="pause";
        this.pagechange( "pausepage", 1, "" );
      }
    }
  }
</script>
