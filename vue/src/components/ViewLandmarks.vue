<template>
  <div class="view-landmark">
    <h1 id="landmark-details-header">Landmark Details</h1>
  </div>
  <div v-for="id in imageIds" v-bind:key="id">
    <img v-bind:src="imageUrl" + id />
  </div>
</template>

<script>
import ImageService from "../services/ImageService";

export default {
  data() {
    return {
      imageUrl: "http:localhost:9000/images",
      imageIds: [],
    };
  },
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
      this.getTopics();
    },
  },
};
</script>

<style scoped>
/* Add specific styles for this component here */
</style>
