import axios from 'axios';

export default {

  login(user) {
    return axios.post('/login', user)
  },

  register(user) {
    return axios.post('/register', user)
  },

  async fetchUserData() {
    try {
      const response = await axios.get('/api/user');
      return response.data;
    } catch (error) {
      throw error;
    }
  }
};


