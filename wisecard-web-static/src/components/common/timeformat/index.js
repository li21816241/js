const timeformat={
    install:function(Vue){
        Vue.component('timeformat',{
          // 声明 props
          props: ['message','date'],
          // 就像 data 一样，prop 可以用在模板内
          // 同样也可以在 vm 实例中像 “this.message” 这样使用
          //template: '<span >{{ getLocalTime(message) }}{{getLocalDate(type)}}</span>',
          template: "<span v-if=\"message !=''&&message != null\">{{ getLocalTime(message) }}</span><span v-else>{{getLocalDate(date)}}</span>",
          methods: {
    		  getLocalTime(nS) {
    			  if(nS==''||nS==null) return;
    			  return new Date(parseInt(nS) *
    	    			 1000).toLocaleString('en-US',{hour12:false})
    	      }, getLocalDate(nS) {
    	    	  if(nS==''||nS==null) return;
    	    	  return new Date(parseInt(nS) *
     	    			 1000).toLocaleDateString()
     	      }
    	  }
        })
    }
};

export default timeformat;