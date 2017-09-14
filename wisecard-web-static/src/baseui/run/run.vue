<template><section>
  <section>
    
  </section>
</template>
<script>
export default{
  created(){
    console.log("转入正常运行状态");
  },
  mounted(){
  },
  data(){
    return { a:'' }
  },
  computed:{
  },
  methods:{
    pauseSerivce( reason, data ){
      this.$emit("pagechange", "pausepage", reason, data );
    }
  }
}
</script>
