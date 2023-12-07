<template>
<<<<<<< HEAD
    <global-header />
    <div>
        <landmark-search /> 
    </div>
    <div>
        <map-of-landmarks />
    </div>
    <div class="landmark-card-list" v-for="landmark in landmarks" v-bind:key="landmark.landmarkId">
        <landmark-card v-bind:landmark="landmark"/>
    </div>
    <global-footer />
=======
  <global-header />
  <landmark-search />
  <map-of-landmarks />
  <div
    class="landmark-card-list"
    v-for="landmark in landmarks"
    v-bind:key="landmark.landmarkId"
  >
    <landmark-card v-bind:landmark="landmark" />
  </div>
  <router-link to="/landmarks"> Explore Landmarks</router-link>
  <global-footer />
>>>>>>> 855cdf55eae7ee24daa35a09b91096f08dfa620b
</template>

<script>
import GlobalHeader from "../components/GlobalHeader.vue";
import GlobalFooter from "../components/GlobalFooter.vue";
import LandmarkSearch from "../components/LandmarkSearch.vue";
import MapOfLandmarks from "../components/MapOfLandmarks.vue";
import LandmarkCard from "../components/LandmarkCard.vue";
import landmarkService from "../services/LandmarkService";

export default {
  data() {
    return {
      landmarks: [],
    };
  },
  components: {
    GlobalHeader,
    GlobalFooter,
    LandmarkSearch,
    MapOfLandmarks,
    LandmarkCard,
  },
  method: {
    getLandmarks() {
      landmarkService
        .getAllLandmarks()
        .then((response) => {
          this.landmarks = response.data;
        })
        .catch((error) => {
          this.handleErrorResponse(error);
        });
    },
    handleErrorResponse(error) {
      if (error.response.status == 404) {
        alert(`${error.response.status} + No landmarks found`);
      } else {
        alert(`An unknown error occurred while searching for landmarks.`);
      }
    },
<<<<<<< HEAD
    method: {
        getLandmarks() {
            landmarkService.getAllLandmarks()
                .then(response => {
                    this.landmarks = response.data;
                })
                .catch(error => {
                    this.handleErrorResponse(error);
                })
        },
        handleErrorResponse(error) {
            if (error.response.status == 404) {
                alert(`${error.response.status}: No landmarks found`);
            }
            else {
                alert(`An unknown error occurred while searching for landmarks.`)
            }
        }
    },
    created() {
        this.getLandmarks();
    }
}

</script>

<style>
.landmark-card-list {
    display: flex;
    flex-direction: row;
}
</style>
=======
  },
  created() {
    this.getLandmarks();
  },
};
</script>

<style></style>
>>>>>>> 855cdf55eae7ee24daa35a09b91096f08dfa620b
