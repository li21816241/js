import Vue from 'vue'
import enterbutton from '../../components/common/button2'
import runview from './run.vue'
Vue.use(enterbutton);
const runpage = {
    install: function(Vue) {
        Vue.component("runpage", runview);
    }
};
export default runpage;