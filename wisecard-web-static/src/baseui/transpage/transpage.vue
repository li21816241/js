<template><section>
  <section>
    <div>
      <component ref="trans" :is="showpage" id="mianview" :devs="devs" v-on:pagechange="pagechange" ></component>
    </div>
  </section>
</template>
<script>
export default{
  props:['transindex'],
  created(){
    this.curflow = this.config.trans;
    this.showpage = this.curflow[ i ].pagelist[ 0 ];
    this.log.i("transpage", "created", "trans begin by " + this.config.trans[transindex].name );
  },
  mounted(){
    console.log( "进入流程" );
    this.log.i( "transpage", "mounted", "trans begin" );
    debugger;
    if( this.$devs.getdevs().cardreader != null ){
      alert( 'ok' );
    }
  },
  destroyed(){
    console.log( "退出流程" );
    this.log.i( "transpage", "destroyed", "trans end" );
  },
  data(){
    return{
      curflow:'',
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
