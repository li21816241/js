import transpage from './transpage.vue'
const transwrap = {
    install: function(Vue) {
        Vue.component("transwrap", transpage)
    }
};
export default transwrap;