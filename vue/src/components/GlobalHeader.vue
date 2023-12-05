<template>
  <div id="nav">
    <div class="home">
        <router-link v-bind:to="{ name: 'home' }">Home</router-link>
        <router-link v-if="!isLoggedIn" :to="{ name: 'login' }">Login</router-link>
        <router-link v-if="isLoggedIn" :to="{ name: 'logout' }">Logout</router-link>
    </div>
  </div>
</template>

<script>
export default {
  computed: {
    isLoggedIn() {
      return !!this.$store.state.token;
    }
  },
  methods: {
    login() {
      this.$store.commit('SET_AUTH_TOKEN', 'token');
      this.$store.commit('SET_USER', { username: 'user' });
    },
    logout() {
      this.$store.commit('LOGOUT');
    }
  }
}
</script>

<style scoped>


.home {
  display:flex;
  flex-direction: row;
  justify-content: space-between;
  margin-right: 100;
}
</style>