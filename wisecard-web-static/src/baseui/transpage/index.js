import transwrap from './transpage.vue'
const transpage = {
    install: function(Vue) {
        Vue.component("transpage", transwrap)
    }
};
export default transpage;