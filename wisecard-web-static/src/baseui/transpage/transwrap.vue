<template><section>
  <section>
    <div>
      <component ref="trans" :is="showpage" id="mianview" v-on:pagechange="pagechange" ></component>
    </div>
  </section>
</template>
<script>
export default{
  props:['transindex', 'pageparam'],
  created(){
    console.log(this.param);
    this.log.d( "transpage","created", "param" + JSON.stringify(this.param) );
    if( this.param.witch == "cardreader" ){
      this.showpage = '';
    }else{
      
    }
  },
  mounted(){
    alert( "ok" );
    console.log( "进入流程" );
    this.log.i( "transpage", "mounted", "trans begin" );
    debugger;
    
  },
  destroyed(){
    console.log( "退出流程" );
    this.log.i( "transpage", "destroyed", "trans end" );
  },
  data(){
    return{
      curflow:'',
      param:this.pageparam,
      showpage:''
    }
  },
  computed:{
  },
  methods:{
    //reason : success,cancel,interrupt,fault
    pagechange( nextpage, reason ){
      this.log.i( "transpage", "pagechagen", "change page to:" + showpage);
      switch( reason ){
        case "cancel":
          this.$emit("runpage", reason, 0 );
          break;
        case "interrupt":
          this.$emit("runpage", reason, 0 );
          break;
        case "fault":
          this.$emit( "pausepage", reason, 0 );
          break;
        default:
          this.showpage = nextpage;
          break;
      }
    }
  }
}
</script>
