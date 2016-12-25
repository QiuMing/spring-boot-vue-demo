import Vue from 'vue';
import Vuex from 'vuex';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-default/index.css';
import App from './menu';
import router from './router';

Vue.use(ElementUI)
Vue.use(Vuex);


new Vue({
  el: '#app',
  router,
  render: h => h(App),
});
