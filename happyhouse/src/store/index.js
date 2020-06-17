// store/index.js

import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

const resourceHost = 'http://localhost:9999'

export default new Veux.Store({
  state: {
    accessToken: null
  },
  getters: {

  },
  mutations: {
    LOGIN (state, {accessToken}) {
      state.accessToken = accessToken
    },
    LOGOUT (state) {
      state.accessToken = null
    }
  },
  actions: {
    LOGIN ({commit}, {uId, uPw}) {
      return axios.post(`${resourceHost}/happyhouse/api/user/login`, {uId, uPw})
        .then(({data}) => commit('LOGIN', data))
    },
    LOGOUT ({commit}) {
      commit('LOGOUT')
    },
  }
})