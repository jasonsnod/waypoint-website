<template>
  <div class="home">
    <global-header />
    <search-landmarks />
    <view-landmark />
    <h1>City Tours</h1>
    <p>You must be authenticated to see this</p>
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
