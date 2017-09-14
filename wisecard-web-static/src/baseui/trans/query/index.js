import querytip from './query-tip.vue'
import queryshow from './query-show.vue'
const querytrans = {
    install: function(Vue) {
        Vue.component("querytip", querytip)
        Vue.component("queryshow", queryshow)
    }
};
export default querytrans;