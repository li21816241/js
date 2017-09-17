import cardtip from './card-tip.vue'
import cardid from './card-id.vue'
import cardphoto from './card-photo.vue'
import cardfigure from './card-figure.vue'
import cardinfo from './card-info.vue'
import cardconfirm from './card-confirm.vue'
import cardissue from './card-issue.vue'
const issuecard = {
    install: function(Vue) {
        Vue.component("cardtip", cardtip)
        Vue.component("cardid", cardid)
        Vue.component("cardphoto", cardphoto)
        Vue.component("cardfigure", cardfigure)
        Vue.component("cardinfo", cardinfo)
        Vue.component("cardconfirm", cardconfirm)
        Vue.component("cardissue", cardissue)
    },
    getflow: function() {
        return ['cardtip', 'cardid', 'cardphoto', 'cardfigure', 'cardinfo', 'cardconfirm', 'cardissue' ];
    },
    cando:function(){
        return {tip:'',status:"ok"};
    }
};
export default issuecard;