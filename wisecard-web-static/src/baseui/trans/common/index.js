import tippage from './tip.vue'
import supplespage from './tip.vue'
import inputpin from './inputpin.vue'
import selects from './selects.vue'
const commontrans = {
    install: function(Vue) {
        Vue.component("tip", tippage)
        Vue.component("supplies", supplespage)
        Vue.component("inputpin", inputpin)
        Vue.component("selects", selects)
    },
    getflow: function() {
        return ['tip', 'supplies', 'inputpin', 'selects'];
    }
};

export default commontrans;