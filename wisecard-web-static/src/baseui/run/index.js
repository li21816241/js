import Vue from 'vue'
import enterbutton from '../../components/common/button2'
import transpage from '../../baseui/transpage'
Vue.use( transpage );
import runview from './run.vue'
Vue.use(enterbutton);
const runpage = {
    install: function(Vue) {
        Vue.component("runpage", runview);
    }
};
export default runpage;