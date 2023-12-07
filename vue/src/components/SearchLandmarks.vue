<template>
  <link rel="stylesheet" type="text/css" href="https://unpkg.com/@geoapify/geocoder-autocomplete@^1/styles/minimal.css">
  <div class="search-landmarks">
    <h1 id="search-landmarks-header">Search Landmarks</h1>
    <form @submit.prevent="searchLandmarks">
      <div ref="autocomplete" class="autocomplete-container"></div>

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
import { GeocoderAutocomplete } from '@geoapify/geocoder-autocomplete';

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
    }
  },
  mounted: function() {
    const GEOAPIFY_API_KEY = 'f4ec423be4f84260bdd3b93a488dd3b0';

    const autocomplete = new GeocoderAutocomplete(
                          this.$refs.autocomplete, 
                          GEOAPIFY_API_KEY, 
                          { /* Geocoder options */ }
    );

    autocomplete.on('select', (location) => {
        // check selected location here 
    });

    autocomplete.on('suggestions', (suggestions) => {
        // process suggestions here
    });
  }
};
</script>

<style scoped>
/* Add component specific styles here */
.autocomplete-container {
    position: relative;
}
</style>
