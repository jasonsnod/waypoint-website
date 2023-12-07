<template>
  <footer class="bg-white fixed-bottom py-3">
    <div class="container">
      <div class="row">
        <div class="col-md-4">
          <div class="footer-column">
            <ul>
              <h6>Explore</h6>
              <li><router-link :to="{ name: 'home' }">Home</router-link></li>
              <li><a href="#">About</a></li>
              <li><a href="#">FAQ</a></li>
              <li><a href="#">Contact</a></li>
            </ul>
          </div>
        </div>
        <div class="col-md-4">
          <div class="footer-column">
            <ul>
              <h6>More</h6>
              <li><a href="#">Create/View Itineraries</a></li>
              <li><a href="#">View Landmarks</a></li>
              <li v-show="isAdmin"><a href="#">View Landmarks</a></li>
            </ul>
          </div>
        </div>
        <div class="col-md-4">
          <div class="footer-column">
            <ul>
              <h6>Contact</h6>
              <span>Phone Number: 855-867-5309</span>
              <li>
                <span
                  >Email:
                  <a href="mailto:your@email.com"
                    >youshould@notemailus.com</a
                  ></span
                >
              </li>
              <span>Mailing Address: </span>
              <li>
                <p>
                  <span class="address-line">Waypoint, 123 Main Street</span
                  ><br />
                  <span class="address-line">Cityville, State, USA 12345</span
                  ><br />
                </p>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <span id="waypoint" class="text-black">&copy; 2023 Waypoint</span>
  </footer>
</template>

<script>
export default {
  data() {
    return {
      user: {
        authenticated: true, // Add actual properties to match authentication and admin rights
        isAdmin: true,
      },
    };
  },
  computed: {
    isAdminUser() {
      // Add actual properties to match authentication and admin rights
      return this.user.authenticated && this.user.isAdmin;
    },
  },
};
</script>

<style scoped>
#waypoint {
  display: flexbox;
  padding: 5%;
  justify-content: space-around;
}

a {
  text-decoration: none;
  color: #1d366f;
  transition: color 0.3s ease;
}

a:hover {
  text-decoration: underline;
  color: #08c076;
}

ul {
  list-style-type: none;
}

footer {
  margin-top: auto;
  padding: 20;
  border-top: 1px solid #1d366f;
}
</style>
