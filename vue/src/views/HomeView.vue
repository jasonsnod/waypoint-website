<template>
  <div class="home">
    <global-header />
    <search-landmarks />
    <view-landmark />
    <h1>City Tours</h1>
    <p>Welcome to the homepage</p>
  </div>
</template>

<script>
import GlobalHeader from "../components/GlobalHeader.vue";
import SearchLandmarks from "../components/SearchLandmarks.vue";
import ViewLandmarks from "../components/ViewLandmarks.vue";
export default {
  components: {
    GlobalHeader,
    SearchLandmarks,
    // ViewLandmarks,
  },
};
</script>
<style scoped>
/* Add component-specific styles heres  */
</style>
