<template>
  <hr class="line-under-image" />
  <footer class="bg-#1d366f fixed-bottom py-2 mt-4">
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
    


    <span id="waypoint" class="text-white py-2 mt-4">&copy; 2023 Waypoint</span>
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
    isAdmin() {
      return this.$store.getters.isAdmin;
    },
  },
};
</script>

<style scoped>
#waypoint {
  display: flexbox;
  
  justify-content: space-around;
}

a {
  text-decoration: none;
  color: white;
  transition: color 0.3s ease;
}

a:hover {
  text-decoration: underline;
  color: #08c076;
}

ul {
  list-style-type: none;
  padding: 0;
  margin: 0;
}

footer {
  margin-top: auto;

  position: relative;
}

h6 {
  color: #08c076
}

span {
  color: white
}

.line-under-image {
  width: 40%;
  margin: 20px auto;
  border-bottom: 2px solid #234d80;
}
</style>