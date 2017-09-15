import button from './button.vue'
const mybutton = {
    install: function(Vue) {
        Vue.component("xbutton", mybutton);
    }
};
export default mybutton;