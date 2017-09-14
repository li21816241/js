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
  },
  mounted(){
    alert( "Pause" );
    this.runService( 0, '恢复' );
  },
  data(){
    return{
    }
  },
  computed:{
  },
  methods:{
    runService( reason, data ){
      this.$emit("pagechange", "runpage", reason, data );
    }
  }
}
</script>
