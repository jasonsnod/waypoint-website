<template>
  <div class="home">
    <global-header />
    <h1 class="homeview-header">City Tours</h1>
    <search-landmarks />
    <view-landmarks />
    <global-footer />
  </div>

  <!-- Testing an image -->
  <!-- <div>
    <img
      src="https://www.shutterstock.com/image-vector/cincinnati-city-ohio-skyline-silhouette-600nw-1807651513.jpg"
    />
  </div> -->
</template>

<script>
import GlobalHeader from "../components/GlobalHeader.vue";
import SearchLandmarks from "../components/SearchLandmarks.vue";
import ViewLandmarks from "../components/ViewLandmarks.vue";
import GlobalFooter from "../components/GlobalFooter.vue";
export default {
  components: {
    GlobalHeader,
    SearchLandmarks,
    ViewLandmarks,
    GlobalFooter,
  },
};
</script>
<style scoped>
/* Add component-specific styles heres  */
.homeview-header {
  border: 2px solid pink;
  text-align: center;
  margin-top: 30px;
  font-family: "Roboto", sans-serif;
}
</style>
