import my_text from './text.vue'
const mytext = {
    install: function(Vue) {
        Vue.component("mytext", my_text);
    }
};

export default mytext;