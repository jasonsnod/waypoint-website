import { createStore as _createStore } from 'vuex';
import axios from 'axios';
import AuthService from '../services/AuthService';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: {
        ...currentUser, 
        isAdmin: false,
      },
      itineraries: []
    },
    mutations: {
      SET_AUTH_TOKEN(state, token) {
        state.token = token;
        localStorage.setItem('token', token);
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
      },
      SET_USER(state, user) {
        state.user = user;
        localStorage.setItem('user', JSON.stringify(user));
      },
      LOGOUT(state) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        state.token = '';
        state.user = {};
        axios.defaults.headers.common = {};
      },
      SET_USER_ITINERARIES(state, arrayOfItineraries) {
        state.itineraries = arrayOfItineraries;
      },
      async fetchAndSetUserData({ commit }) {
        try {
          const userData = await UserService.fetchUserData();
          commit('SET_ADMIN_STATUS', userData.isAdmin);
        } catch (error) {
          console.error('Error fetching user data', error);
        }
      }
    },
  });
  return store;
}
