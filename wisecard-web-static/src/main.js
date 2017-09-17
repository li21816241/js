import 'babel-polyfill'
import Vue from 'vue'
import VueI18N from 'vue-i18n'
import VueRouter from 'vue-router'
import axios from 'axios'
Vue.prototype.$http = axios

import SimpleValidation from 'simple-vue-validator'
Vue.use(SimpleValidation)
import webbase from './components/common/web'
Vue.use(webbase)
import App from './app.vue'

import mybutton from './components/common/button'
Vue.use(mybutton)
import mytext from './components/common/text'
Vue.use(mytext)

import wait from './baseui/common/wait-trans.vue'


import issuecard from './baseui/trans/card'
Vue.use(issuecard);
import querytrans from './baseui/trans/query'
Vue.use(querytrans);

import devmonitor from './baseui/devmonitor'
Vue.use(devmonitor);

import startpage from './baseui/start'
Vue.use(startpage);
import runpage from './baseui/run'
Vue.use(runpage);
import maintainpage from './baseui/maintain'
Vue.use(maintainpage);
import pausepage from './baseui/pause'
Vue.use(pausepage);

import exitpage from './baseui/exit'
Vue.use(exitpage);

import transwrap from './baseui/transpage'
Vue.use(transwrap);


const router = new VueRouter({
    routes: [{
        path: '/',
        component: pausepage
    }, {
        path: '/pause',
        component: pausepage
    }, {
        path: '/run',
        component: runpage
    }, {
        path: '/maintain',
        component: maintainpage
    }, {
        path: '/start',
        component: startpage
    }]
});

window.app = new Vue({
    router,
    render: h => h(App)
}).$mount('#app');