import Vue from 'vue'
import App from './App.vue'
import Vuex from 'vuex'
//
import router from "./router";
import store from "./store/store";

/* For BootStrap */
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import vuetify from './plugins/vuetify';

Vue.use(Vuex)
Vue.use(BootstrapVue)
//이후에 사용할 것이다.
Vue.config.productionTip = false

new Vue({
  // 라우터 객체 전달
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
