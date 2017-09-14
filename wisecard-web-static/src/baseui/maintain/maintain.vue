<template><section>
  <section>
    <component v-if="this.$route.params" :is="selectui" ></component>
  </section>
</template>
<script>
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
  }
}
</script>
