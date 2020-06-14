
import Vue from 'vue';
import Vuex from 'vuex';

import {
    requestRegisterUser,
} from '../api/index.js'

Vue.use(Vuex);

export default new vuex.Store({
    async REQUEST_JOIN(context, User){
        try {
            const res = await requestRegisterUser(User);
            context.commit('OPEN_MODAL', setModalTexts(true));
            return res;
        } catch (error) {
            context.commit('OPEN_MODAL', setModalTexts(false));
        }
    }
})
