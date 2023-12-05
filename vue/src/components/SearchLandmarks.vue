<template>
  <div class="search-landmarks">
    <h1 id="search-landmarks-header">Search Landmarks</h1>
    <form @submit.prevent="searchLandmarks">
      <input type="text" v-model="searchTerm" placeholder="Enter Location" />

      <!-- 
        used this link for the idea, adding in case we need a reference later
        https://vuejs.org/guide/essentials/forms 
    -->

      <select v-model="searchRadius">
        <option disabled value="">Search Radius</option>
        <option value="5">5 miles</option>
        <option value="10">10 miles</option>
        <option value="20">20 miles</option>
      </select>
      <button>Search</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      searchTerm: "",
      searchRadius: "",
    };
  },
  methods: {
    searchLandmarks() {
      //Implement logic for searching landmarks
      //Assuming logic cannot be built out until API is up and running on backend
    },
  },
};
</script>

<style scoped>
/* Add component specific styles here */
</style>
