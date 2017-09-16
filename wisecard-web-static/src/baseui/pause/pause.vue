<template><section>
  <section>
    <div>
      <input type="text" disabled="disabled">设备暂停</input>
    </div>
  </section>
</template>
<script>
export default{
  created(){
    console.log("设备暂停页面");
    this.check();
    this.timer = setInterval( this.check, 10000 );
  },
  destroyed(){
    clearInterval( this.timer );
  },
  mounted(){
    alert( "Pause" );
    this.runService( 0, '恢复' );
  },
  data(){
    return{
      timer:0
    }
  },
  computed:{
  },
  methods:{
    runService( reason, data ){
      this.$emit("pagechange", "runpage", reason, data );
    },
    devcheck(){
      return {who:'none', status:0,data:{}};
    },
    netcheck(){
      return {who:'net', status:0, data:{} };
    },
    controlcheck(){
      return {who:'control', status:0, data:{} };
    },
    check(){
      let r = devcheck();
      if( r.status == 0 ){
        r = netcheck();
        if( r.status == 0 ){
          r = controlcheck();
          if( r.status == 0 ){
            runService( 0, "" );
          }
        }
      }
    }
  }
}
</script>
