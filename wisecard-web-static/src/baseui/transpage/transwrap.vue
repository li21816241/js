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
    this.transname = this.param.data.witch;
    this.log.d( "transpage","created", "param" + JSON.stringify(this.param) );
    if( this.param.witch == "cardreader" ){
      this.transname="pretrans";
      console.log( "执行进卡后步骤" )
      console.log(this.config.trans[ this.transname ] );
    }else if( this.param.witch == "trans" ){
      console.log( "执行直接业务" )
      console.log(this.config.trans[ this.transname ] );
    }else if( this.param.witch == "indirect " ){
      console.log( "执行间接调用" );
      //data:{ from,next}
      console.log(this.config.trans[ this.transname ] );
    }
    this.log.i( "transwrap", "created", "do " + JSON.stringify( this.config.trans[ this.transname ] ) );
    curflow = this.config.trans[ this.transname ].pagelist;
    pagechange( curflow[ 0 ] );
  },
  mounted(){
    console.log( "进入流程" );
    this.log.i( "transpage", "mounted", "trans begin" );
    
  },
  destroyed(){
    console.log( "退出流程" );
    this.log.i( "transpage", "destroyed", "trans end" );
  },
  data(){
    return{
      curflow:'',
      param:this.pageparam,
      showpage:'',
      transname:''
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
          this.$emit( "pagechange", "runpage", reason, 0 );
          break;
        case "interrupt":
          this.$emit( "pagechange", "runpage", reason, 0 );
          break;
        case "fault":
          this.$emit( "pagechange", "pausepage", reason, 0 );
          break;
        case "indirect":
          break;
        default:
          this.showpage = nextpage;
          break;
      }
    }
  }
}
</script>
