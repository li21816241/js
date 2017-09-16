<template>
  <section>
    <div id="devactivexs" style="display:none"> 
    </div>
  </section>
</template>
<script>
import Vue from 'vue'
export default{
  created(){
    
  },
  mounted(){
  },
  data(){
    return{
    }
  },
  computed:{
  },
  methods:{
    devcreate(){
      this.i("devcreate", "create devices begin" );
      Vue.prototype.$devs = new Array(0);
      var me = this;
      for( var i = 0; i < this.config.modules.length; i++ ){
        this.$devs.push({
                name:module.name,
                obj:'',
                loaded:false
              });
        ( function( module, index ){
          var dom= document.getElementById("devactivexs");
          var script= document.createElement('script'); 
          script.type= 'text/javascript'; 
          script.onload = script.onreadystatechange = function() {
            if (!this.readyState || this.readyState === "loaded" || this.readyState === "complete" ) {
                var name = '$'+module.name;
                window[name](me);
                me.$devs[index].obj=document.getElementById(module.name );
                me.$devs[index].loaded=true;
                me.log.i( "devmonitor", "script::onload", "(" +module.name + ") load finash" );
              }
              script.onload = script.onreadystatechange = null; 
            }
          script.src= "../../../static/js/" + module.name + ".js"; 
          dom.appendChild(script);
          })( this.config.modules[ i ], i);     
      }
      this.i("devcreate", "create devices end" );
      this.triggerEvent( "pinpad", "pinpad", "open", {id:0,result:0,data:{}} );
    },
    triggerEvent( witch, type, cmd, data ){
      this.d("triggerEvent", witch + "," + type + "," + cmd + "," + data );
      this.$emit("devevent", witch, type, cmd, data );
    },
    exit(){
      this.i("exit", "close all devices" );
    },
    i( func, data){
      this.log.i( "devmonitor", func, data );
    },
    e(func,data){
      this.log.e( "devmonitor", func, data );
    },
    d(func,data){
      this.log.d( "devmonitor", func, data );
    }
  }
}
</script>