import Vue from 'vue'
import axios from 'axios'

import vuetify from './plugins/vuetify'
import App from './App.vue'
import router from './router'

import { createPinia, PiniaVuePlugin } from 'pinia'

document.title = '연결고리';

const pinia = createPinia()
Vue.use(PiniaVuePlugin)
Vue.config.productionTip = false
Vue.prototype.$axios = axios
// localStorage.setItem("userId", "user131");

new Vue({
  vuetify,
  pinia,
  router,
  render: h => h(App)
}).$mount('#app')
