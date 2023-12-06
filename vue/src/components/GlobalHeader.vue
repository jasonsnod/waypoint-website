<template>
  <!-- Bootstrap navbar -->
  <nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
      <router-link class="navbar-brand" :to="{ name: 'home' }"
        >Welcome to the City Tours</router-link
      >
      <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarNavDropdown"
        aria-controls="navbarNavDropdown"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav me-auto">
          <li class="nav-item">
            <router-link
              class="nav-link"
              :to="{ name: 'home' }"
              aria-current="page"
              >Home</router-link
            >
          </li>
          <li class="nav-item">
            <router-link
              v-if="!isLoggedIn"
              class="nav-link"
              :to="{ name: 'login' }"
              >Login</router-link
            >
            <router-link
              v-if="isLoggedIn"
              class="nav-link"
              :to="{ name: 'logout' }"
              >Logout</router-link
            >
          </li>
        </ul>
      </div>
    </div>
  </nav>
</template>

<script>
export default {
  computed: {
    isLoggedIn() {
      return !!this.$store.state.token;
    },
  },
  methods: {
    login() {
      this.$store.commit("SET_AUTH_TOKEN", "token");
      this.$store.commit("SET_USER", { username: "user" });
    },
    logout() {
      this.$store.commit("LOGOUT");
    },
  },
};
</script>

<style scoped>
/* .home {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  margin-right: 100;
} */
</style>
