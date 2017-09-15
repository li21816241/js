<template><section>
  <section>
    
  </section>
</template>
<script>
export default{
  created(){
    console.log("转入正常运行状态");
    for( var i = 0; i < this.config.trans.length; i++ ){
      if( this.config.trans[ i ].type & 1 ){
        this.showtrans[ this.config.trans[ i ].name ] = this.config.trans[ i ];
      }
      if( ( this.config.trans[ i ].type & 4 ) == 0 ){
        var checkinfo = {};
        checkinfo.name = this.config.trans[ i ].name;
        checkinfo.cando = this.config.trans[ i ].cando;
        checkinfo.tip = '';
        if( this.config.trans[ i ].type & 8 )
          checkinfo.notify = true;
        else
          checkinfo.notify = false;
        this.testtrans.push( checkinfo );
      }
    }
  },
  mounted(){
    let me = this;
    this.timer = setInterval( this.transcheck, 10000);
  },
  destroyed(){
    clearInterval( timer );
  },
  data(){
    return {
      notify:{},
      showtrans:{},
      testtrans:[],
      timer:0
    };
  },
  computed:{
  },
  methods:{
    devevent( dev, type, cmd, data ){

    },
    onselecttrans( button ){
      this.$emit( "pagechagne", "transpage", "trans", button );
    },
    oncardin(){
      this.$emit( "pagechange", "transpage", "card", 0 );
    },
    transcheck(){
      for( var i = 0; i < this.testtrans.length; i++ ){
        var result = this.testtrans[ i ].cando();
        if( this.testtrans[ i ] & 8 ){
          this.testtrans[ i ].tip = result.tip;
        }
      }
    }
  }
}
</script>
