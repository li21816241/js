import maintainview from './maintain.vue'
const maintainpage = {
    install: function(Vue) {
        Vue.component("maintainpage", maintainview)
    }
};
export default maintainpage;