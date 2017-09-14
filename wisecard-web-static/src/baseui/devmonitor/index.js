import devmonitors from './devmonitor.vue'
const devmonitor = {
    install: function(Vue) {
        Vue.component("devmonitor", devmonitors)
    }
};
export default devmonitor;