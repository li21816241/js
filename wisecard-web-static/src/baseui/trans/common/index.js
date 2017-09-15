import tippage from './tip.vue'
import inputpin from './inputpin.vue'
import selects from './selects.vue'
const commontrans = {
    install: function(Vue) {
        Vue.component("tip", tippage)
        Vue.component("inputpin", inputpin)
        Vue.component("selects", selects)
    },
    getflow: function() {
        return ['tip', 'inputpin', 'selects'];
    },
    cando: function(vue) {

    }
};

export default commontrans;