import Vue from 'vue';
import Vuex from 'vuex';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-default/index.css';
import App from './Table';
import mytable from './MyTable';
import router from './router';

Vue.use(ElementUI)
Vue.use(Vuex);

// new Vue({
//   el: '#app',
//   render: h => h(App),
//    router,
// });

new Vue({
  el: '#mytable',
  router,
  render: h => h(mytable),
});
