import Vue from 'vue'
import App from './App.vue'
import router from "./router";

/* For BootStrap */
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.use(BootstrapVue)

//이후에 사용할 것이다.
Vue.config.productionTip = false

new Vue({
  router, // 라우터 객체 전달
  render: h => h(App),
}).$mount('#app')
