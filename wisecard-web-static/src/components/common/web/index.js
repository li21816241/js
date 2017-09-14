import Vue from 'vue'
import VueI18N from 'vue-i18n'
import axios from 'axios';
Vue.use(VueI18N)

function getCookie(c_name) {
    var c_start = -1,
        c_end = -1;
    if (document.cookie.length > 0) {
        c_start = document.cookie.indexOf(c_name + "=");
        if (c_start != -1) {
            c_start = c_start + c_name.length + 1;
            c_end = document.cookie.indexOf(";", c_start);
            if (c_end == -1) c_end = document.cookie.length;
            return unescape(document.cookie.substring(c_start, c_end));
        }
    }
    return "";
}
setInterval((obj) => {
    var sid = getCookie('sid');
    axios.get('/rest/session')
        .then(function(res) {
            console.log(res);
        })
        .catch(function(err) {
            console.log(err);
        })
}, 30000);

const webbase = {
    install: function(Vue) {}
};

export default webbase;