<template>
  <global-header />
  <div>
    <search-landmarks @retrieveCoordinates="filterLandmarks($event)"/>
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
  <global-footer />
</template>

<script>
import GlobalHeader from "../components/GlobalHeader.vue";
import GlobalFooter from "../components/GlobalFooter.vue";
import SearchLandmarks from "../components/SearchLandmarks.vue";
import MapOfLandmarks from "../components/MapOfLandmarks.vue";
import LandmarkCard from "../components/LandmarkCard.vue";
import landmarkService from "../services/LandmarkService.js";

export default {
  components: {
    GlobalHeader,
    GlobalFooter,
    MapOfLandmarks,
    SearchLandmarks,
    LandmarkCard,
  },
  data() {
    return {
      landmarks: [],
      displayedLandmarks: []
    };
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
    handleErrorResponse() {
      console.log('Error: Network Error');
    },
    filterLandmarks(startingLocationCoordinates) {
      this.displayedLandmarks.filter()
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
