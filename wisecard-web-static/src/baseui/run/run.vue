<template><section>
  <section>
    <div>
      <div>
        <div id="ad"></div>
        <div id="buttons">
          <div v-for="item in this.showtrans">
            <enterbutton :caption="item.name" v-on:click="click"></enterbutton>
          </div>
        </div>
      </div>
      <div id="infotip"></div>
    </div>
  </section>
</template>
<script>
export default{
  created(){
    console.log("转入正常运行状态");
    for( let i in this.config.trans ){
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
    this.timer = setInterval( this.transcheck, 10000);
    
  },
  destroyed(){
    clearInterval( this.timer );
  },
  data(){
    return {
      notify:{},
      showtrans:{},
      testtrans:[],
      timer:0,
      transcount:0
    };
  },
  computed:{
  },
  methods:{
    click(name){
      this.onselecttrans( name )
    },
    devevent( dev, type, cmd, data ){

    },
    onselecttrans( button ){
      this.$emit( "pagechange", "transpage", "trans", {witch:button} );
    },
    oncardin(){
      this.$emit( "pagechange", "transpage", "cardreader", {witch:'cardreader'} );
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
