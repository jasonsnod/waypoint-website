<template>
  <div id="register">
    <global-header />
    <form v-on:submit.prevent="register" class="login-form">
      <h1 class="login-header">Create Account</h1>
      <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="form-input-group">
        <label for="username">Username:</label>
        <input
          type="text"
          id="username"
          v-model="user.username"
          required
          class="styled-input"
          autofocus
        />
      </div>
      <div class="form-input-group">
        <label for="password">Password:</label>
        <input
          type="password"
          id="password"
          class="styled-input"
          v-model="user.password"
          required
        />
      </div>
      <div class="form-input-group">
        <label for="confirmPassword" class="confirm-password"
          >Confirm Password:</label
        >
        <input
          type="password"
          id="confirmPassword"
          class="styled-input"
          v-model="user.confirmPassword"
          required
        />
      </div>
      <button type="submit" class="submit-button">Create Account</button>
      <p class="signup-link">
        <router-link v-bind:to="{ name: 'login' }"
          >Already have an account? Log in.</router-link
        >
      </p>
    </form>
    <global-footer />
  </div>
</template>

<script>
import authService from "../services/AuthService";
import GlobalHeader from "../components/GlobalHeader.vue";
import GlobalFooter from "../components/GlobalFooter.vue";
export default {
  components: {
    GlobalHeader,
    GlobalFooter,
  },
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "user",
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: "/login",
                query: { registration: "success" },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },
};
</script>

<style scoped>
.login-form {
  border: 3px solid rgb(233, 231, 231);
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 80vh;
  margin: auto;
  width: 300px;
  border-radius: 10px;
  margin-top: 60px;
  margin-bottom: 90px;
  background-color: #f9f9f9;
}

.login-header {
  margin-top: 20px;
  text-align: center;
  font-size: 2.5rem;
  margin-bottom: 30px;
  color: #1d366f;
  letter-spacing: 2px;
  font-weight: bold;
}

.submit-button {
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  background-color: #1d366f;
  color: white;
  cursor: pointer;
  transition: background-color 0.3s ease;
  margin-bottom: 20px;
}

.submit-button:hover {
  background-color: #77aae9;
}

.styled-input {
  border-radius: 5px;
  padding: 5px;
  border: 1px solid #ccc;
  width: calc(100% - 20px);
  margin-bottom: 15px;
}

.signup-link {
  text-align: center;
  margin-top: 20px;
}

.signup-link a {
  text-decoration: none;
  color: #1d366f;
  font-weight: bold;
  transition: color 0.3s ease;
}

.signup-link a:hover {
  color: #77aae9;
}

#confirmPassword {
  margin-left: 11px;
}

.confirm-password {
  margin-left: 11px;
}

.form-input-group {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;
}
</style>
