import { createStore as _createStore } from 'vuex';
import axios from 'axios';
import AuthService from '../services/AuthService';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
        user: currentUser || {},
      landmarks: [],
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
      SET_LANDMARKS(state, arrayOfLandmarks) {
        state.landmarks = arrayOfLandmarks;
      },
      SET_LANDMARK_CART(state, emptyArrayOfLandmarks) {
        state.landmarkCart = emptyArrayOfLandmarks
      }
    },
  });
  return store;
}
