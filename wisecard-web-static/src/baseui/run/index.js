import Vue from 'vue'
import runview from './run.vue'
const runpage = {
    install: function(Vue) {
        Vue.component("runpage", runview)
    }
};
export default runpage;