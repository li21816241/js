import transwrap from './transwrap.vue'
const transpage = {
    install: function(Vue) {
        Vue.component("transpage", transwrap)
    }
};
export default transpage;