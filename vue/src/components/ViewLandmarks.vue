
<template>
  <div class="view-landmark">
    <h1 id="landmark-details-header">Landmark Details</h1>
  </div>
  <!-- <div v-for="id in imageIds" v-bind:key="id">
    <img v-bind:src="imageUrl" + id />
  </div> -->

  <!-- <div v-for="landmark in landmarks" :key="landmark.id">
      <landmark-card v-bind:landmark="landmark" />
  </div> -->

  <div class="locations">
    <div class="landmark-card">
        <h1>'Cathedral Basilica of the Assumption'</h1>
      <img src="https://img1.10bestmedia.com/Images/Photos/70596/p-st-marys-church-service_55_660x440_201404182126.jpg">
    </div>
  
  <div>
    <div class="landmark-card">
        <h1>'The Spaceship House'</h1>
      <img src="https://upload.wikimedia.org/wikipedia/commons/e/e5/Futuro_WeeGee_Espoo.jpg">
    </div>
  </div>
  <div>
    <div class="landmark-card">
        <h1>'Cincinnati Museum Center at Union Terminal'</h1>
      <img src="https://www.cincymuseum.org/wp-content/uploads/2018/11/UT-2000x700.jpg">
    </div>
  </div>
</div>

</template>

<script>
import ImageService from "../services/ImageService";
import LandmarkService from "../services/LandmarkService";
import LandmarkCard from "./LandmarkCard.vue";

export default {
  data() {
    return {
      imageUrl: "http:localhost:9000/images",
      imageIds: [],
      landmarks: []
    };
  },
  // components: {
  //   LandmarkCard
  // },
  methods: {
    getTopics() {
      ImageService.getImageIds()
        .then((response) => {
          this.imageIds = response.data;
        })
        .catch((error) => {
          console.log(error);
        });
    },
    handleErrorResponse() {
      this.$store.commit(
        "SET_NOTIFACTION",
        `Could not get topic data from server.`
      );
    },
    created() {
      this.getLandmarks();
    },
  },
  getLandmarks(){
    LandmarkService.getAllLandmarks()
      .then((response) => {
        this.landmarks = response.data;
      })
      .catch((error) => {
        console.log("Error fetching the landmark", error)
      })

  }
};
</script>

<style scoped>
/* Add specific styles for this component here */
img {
  width: 300px;
  height: 200px;
  border-radius: 50px;
}

.locations{
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}

/* Add a no repeat */
</style>
