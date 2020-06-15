import Vue from 'vue'
import Vuex from 'vuex'

import user from './user'
import board from './board'

Vue.use(Vuex);

export const store = new Vuex.Store({
    modules: {
        user,
        board,
    }
});