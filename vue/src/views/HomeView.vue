<template>
  <div class="home">
    <global-header />
    <!-- <h1 class="homeview-header">
      <div class="word-group">
        <span>Welcome</span> <span>to </span>
        <span> Waypoint </span>
        <span>where </span>
        <span>to </span>
        <span>next?</span>
      </div>
    </h1> -->
    <img
      class="homeview-image fade-in"
      src="img\logo-large.png"
      @load="handleImageload"
    />
    <!-- <hr class="line-under-image" /> -->
    <h1 class="homeview-header">
      <div class="word-group">
        <span>Welcome</span> <span>to </span>
        <span> Waypoint </span>
        <span>where </span>
        <span>to </span>
        <span>next?</span>
      </div>
    </h1>
    <div class="gif-container">
      <img src="../assets/cincyPhotos/cincyBridge.gif" />
    </div>

    <div class="image-with-paragraphs">
      <div class="image-container mx-auto mb-4">
        <router-link v-bind:to="{ name: 'itineraries' }">
          <img
            src="img\itinerary-logo.png"
            alt="Image 1"
            class="rounded mr-3"
            id="itinerary-photo"
          />
        </router-link>
        <router-link v-bind:to="{ name: 'landmarks' }"
          data-aos="fade-down-left"
          data-aos-duration="1000"
        >
          <img
            src="img\landmarks-logo.png"
            alt="Image 2"
            class="rounded mr-3"
            id="landmarks-photo"
          />
        </router-link>

        <p data-aos="zoom-in" data-aos-duration="1000">
          Explore Cincinnati's hidden gems with Waypoint! Create your
          personalized itinerary effortlessly and share it with friends.
          Discover the must-see landmarks and make the most of your Cincinnati
          visit!
        </p>
      </div>
    </div>
    <global-footer />
  </div>
</template>

<script>
import GlobalHeader from "../components/GlobalHeader.vue";
import GlobalFooter from "../components/GlobalFooter.vue";
import landmarkService from "../services/LandmarkService";
export default {
  components: {
    GlobalHeader,
    GlobalFooter,
  },
  data() {
        return {
            landmarkCart: []
        }
    },
  methods: {
    handleImageload() {
      const image = document.querySelector(".homeview-image");
      image.classList.add("loaded");
    },
    getLandmarks() {
      landmarkService.getAllLandmarks()
        .then((response) => {
          this.$store.commit('SET_LANDMARKS', response.data);
        })
        .catch(error => {
          console.log(error)
        });
    },
    setLandmarkCart() {
      this.$store.commit('SET_LANDMARK_CART', this.landmarkCart)
    }
  },
  mounted() {
    window.initAOS();
  },
  created() {
    this.getLandmarks();
  }
};
</script>

<style scoped>
.homeview-header {
  text-align: center;
  margin-top: 50px;
  font-family: "Roboto", sans-serif;
  font-size: 50px;
  color: #e2ecf7;
  text-shadow: 3px 2px 4px rgba(0, 0, 0, 0.9);
  letter-spacing: 2px;
}

.homeview-image {
  display: block;
  margin: 30px auto;
  margin-top: 30px;
  border-radius: 30px;
}

.fade-in {
  opacity: 0;
  transition: opacity 2.5s ease-in-out;
}

.fade-in.loaded {
  opacity: 1;
}

.line-under-image {
  width: 40%;
  margin: 20px auto;
  border-bottom: 2px solid #234d80;
}

/* Styles for itinerary and graphic */

.image-with-paragraphs {
  display: flex;
  justify-content: space-between;
  margin-top: 40px;
}

.image-container {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 20px;
}

img {
  max-width: 100%;
  height: auto;
}

#itinerary-photo {
  border: 1px solid antiquewhite;
}

#landmarks-photo {
  width: 100%;
  width: 250px;
  border: 1px solid antiquewhite;
}

.gif-container {
  display: flex;
  justify-content: center;
  margin-top: 100px;
  height: 70vh;
  border-radius: 10px;
}

.gif-container img {
  max-width: 100%;
  height: auto;
  border: 2px solid rgb(232, 228, 229);
  border-radius: 10px;
}

p {
  font-size: 1.2rem;
  max-width: 300px;
  color: white;
  margin: 0 auto;
  line-height: 1.6;
  font-family: "Roboto", sans-serif;
}

@keyframes scale {
  100% {
    transform: scale(1);
  }
}

.word-group span {
  margin-right: 5px;
}

span {
  display: inline-block;
  opacity: 0;
  filter: blur(4px);
}

span:nth-child(1) {
  animation: fade-in 0.8s 0.1s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

span:nth-child(2) {
  animation: fade-in 0.8s 0.2s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

span:nth-child(3) {
  animation: fade-in 0.8s 0.3s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

span:nth-child(4) {
  animation: fade-in 0.8s 0.4s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

span:nth-child(5) {
  animation: fade-in 0.8s 0.5s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

span:nth-child(6) {
  animation: fade-in 0.8s 0.6s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

span:nth-child(7) {
  animation: fade-in 0.8s 0.7s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

span:nth-child(8) {
  animation: fade-in 0.8s 0.8s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

span:nth-child(9) {
  animation: fade-in 0.8s 0.9s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

span:nth-child(10) {
  animation: fade-in 0.8s 1s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

span:nth-child(11) {
  animation: fade-in 0.8s 1.1s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

span:nth-child(12) {
  animation: fade-in 0.8s 1.2s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

span:nth-child(13) {
  animation: fade-in 0.8s 1.3s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

span:nth-child(14) {
  animation: fade-in 0.8s 1.4s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

span:nth-child(15) {
  animation: fade-in 0.8s 1.5s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

span:nth-child(16) {
  animation: fade-in 0.8s 1.6s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

span:nth-child(17) {
  animation: fade-in 0.8s 1.7s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

span:nth-child(18) {
  animation: fade-in 0.8s 1.8s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

@keyframes fade-in {
  100% {
    opacity: 1;
    filter: blur(0);
  }
}

/* Media Queries for Mobile */
@media only screen and (max-width: 600px) {
  .homeview-header {
    font-size: 24px;
  }

  .homeview-image {
    width: 100%;
    margin-top: 20px;
  }

  .line-under-image {
    width: 60%;
  }

  .image-with-paragraphs {
    flex-direction: column;
    align-items: center;
    margin-top: 20px;
  }

  .image-container {
    flex-direction: column;
    align-items: center;
    padding: 10px;
  }

  #itinerary-photo {
    margin-bottom: 40px;
  }

  p {
    max-width: 80%;
    text-align: center;
    margin-top: 20px;
  }
  .gif-container {
    height: 50vh;
    margin-left: 30px;
    margin-right: 30px;
  }
}

/* Media Queries for Larger Screens */
@media only screen and (min-width: 601px) {
  #landmarks-photo {
    max-width: none;
  }
}
</style>
