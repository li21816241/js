import Vue from 'vue'
import startview from './start.vue'
import text from '../../components/common/text'
Vue.use(text);
const startpage = {
    install: function(Vue) {
        Vue.use(text);
        Vue.component("startpage", startview)
    }
};
export default startpage;