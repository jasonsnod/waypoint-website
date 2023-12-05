<template>
  <div class="home">
    <global-header />
    <h1>City Tours</h1>
    <p>You must be authenticated to see this</p>
  </div>
</template>

<script>
import GlobalHeader from "../components/GlobalHeader.vue";
export default {
  components: {
    GlobalHeader,
  },
};
</script>
