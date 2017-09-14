<template>
  <section>
    
  </section>
</template>
<script>
export default{
  props:['devs'],
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
    devevent(dev, type, cmd, data){
      console.log("接收到分发的设备事件");
      this.success( "runpage", 0, '' );
    },
    success( nextpage, reason, data ){
      this.$emit("pagechange", nextpage, reason, data );
    }
  }
}
</script>
