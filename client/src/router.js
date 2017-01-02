import Vue from 'vue'
import VueRouter from 'vue-router'
import Users from './containers/Users'
import Settings from './containers/Settings'
import Cookbook from './containers/Cookbook'
Vue.use(VueRouter);

const Router = new VueRouter({
    routes: [
        {path: '/', redirect: '/cookbook'},
        {path: '/userManager', component: Users},
        {path: '/settings', component: Settings},
        {path: '/cookbook', component: Cookbook},
    ]
});
export default Router;

