<template>
  <global-header />
  <div>
    <landmark-search />
  </div>
  <div>
    <map-of-landmarks />
  </div>
  <div
    class="landmark-card-list"
    v-for="landmark in landmarks"
    v-bind:key="landmark.landmarkId"
  >
    <landmark-card v-bind:landmark="landmark" />
  </div>
  <global-footer />
</template>

<script>
import GlobalHeader from "../components/GlobalHeader.vue";
import GlobalFooter from "../components/GlobalFooter.vue";
import LandmarkSearch from "../components/LandmarkSearch.vue";
import MapOfLandmarks from "../components/MapOfLandmarks.vue";
import LandmarkCard from "../components/LandmarkCard.vue";
import landmarkService from "../services/LandmarkService.js";

export default {
  components: {
    GlobalHeader,
    GlobalFooter,
    LandmarkSearch,
    MapOfLandmarks,
    LandmarkCard,
  },
  data() {
    return {
      landmarks: [],
    };
  },
  methods: {
    getLandmarks() {
      console.log("Am i being called?");
      landmarkService.getAllLandmarks()
        .then((response) => {
          this.landmarks = response.data;
        })
        .catch(error => {
          this.handleErrorResponse(error);
        });
    },
    handleErrorResponse(error) {
      if (error.response.status === 404) {
        alert(`${error.response.status}: No landmarks found`);
      }
      else {
        alert("An unknown error has occurred");
      }
    }

  },
  created() {
    this.getLandmarks();
  }
}
</script>

<style scoped>
.landmark-card-list {
  display: flex;
  flex-direction: row;
}
</style>
