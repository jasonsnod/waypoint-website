<template>
  <div class="landmarks-view">
  <global-header />
  <div>
    <search-landmarks @retrieveCoordinates="filterLandmarks($event)"/>
    <input type="button" value="Reset Form" v-on:click="resetListOfLandmarks" class="reset-button">
  </div>
  <div>
    <map-of-landmarks />
  </div>
  <div
    class="landmark-card-list"
    v-for="landmark in displayedLandmarks"
    v-bind:key="landmark.landmarkId"
  >
    <landmark-card v-bind:landmark="landmark" />
    

  </div>

  <hr class="line-under-image" />

  <admin v-if="isAdmin" />
  <global-footer />
  </div>
</template>

<script>
import GlobalHeader from "../components/GlobalHeader.vue";
import GlobalFooter from "../components/GlobalFooter.vue";
import SearchLandmarks from "../components/SearchLandmarks.vue";
import MapOfLandmarks from "../components/MapOfLandmarks.vue";
import LandmarkCard from "../components/LandmarkCard.vue";
import landmarkService from "../services/LandmarkService.js";
import geoApifyService from "../services/GeoApifyService.js";
import Admin from "../components/Admin.vue";
import axios from 'axios';

export default {
  components: {
    GlobalHeader,
    GlobalFooter,
    MapOfLandmarks,
    SearchLandmarks,
    LandmarkCard,
    Admin,
  },
  data() {
    return {
      landmarks: [],
      displayedLandmarks: []
    };
  },

  computed: {
    isAdmin() {
      if (this.$store.state.user.authorities) {
        return this.$store.state.user.authorities[0].name === 'ROLE_ADMIN';
      } else {
        return false;
      }
    },
  },
  methods: {
    getLandmarks() {
      landmarkService.getAllLandmarks()
        .then((response) => {
          this.landmarks = response.data;
          this.displayedLandmarks = response.data;
        })
        .catch(error => {
          this.handleErrorResponse();
        });
    },
    filterLandmarks(startingLocationParameters) {

      geoApifyService.getRoutes(startingLocationParameters, this.landmarks)
      .then(
        axios.spread((...data) => {

          this. displayedLandmarks = this.displayedLandmarks.filter((landmark, index) => {

            console.log(data[index].data.features[0].properties.distance);
            console.log(startingLocationParameters.searchRadius);

            return data[index].data.features[0].properties.distance <= startingLocationParameters.searchRadius;
          })
      }))
      .catch(error => {
        this.handleErrorResponse();
      });
      
    },
    handleErrorResponse() {
      console.log('Error: Network Error');
    },
    resetListOfLandmarks() {
      this.displayedLandmarks = this.landmarks;
    }
  },
  created() {
    this.getLandmarks();
  }
}
</script>

<style scoped>


.reset-button{
  display: block;
  margin: 0 auto;
  padding: 10px 30px;
  margin-bottom: 60px;
  background-color: #3498db;
  color: #fff;
  border: none;
  border-radius: 5px;
  font-weight: bold;
  cursor: pointer;
}

.reset-button:hover{
  background-color: #DC3545;
}

.landmark-card-list {
  display: flex;
  flex-direction: row;
}

.line-under-image {
  width: 40%;
  margin: 20px auto;
  border-bottom: 2px solid #234d80;
}
</style>
