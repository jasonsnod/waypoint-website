<template>
  <link rel="stylesheet" type="text/css" href="https://unpkg.com/@geoapify/geocoder-autocomplete@^1/styles/minimal.css">
  <div class="search-landmarks">
    <h1 id="search-landmarks-header">Search Landmarks</h1>
    <form @submit.prevent="sendStartingLocationCoordinates">
      <div ref="autocomplete" class="autocomplete-container"></div>

      <!-- 
        used this link for the idea, adding in case we need a reference later
        https://vuejs.org/guide/essentials/forms 
    -->

      <select v-model.number="searchRadius">
        <option disabled value="0">Search Radius</option>
        <option value="5">5 miles</option>
        <option value="10">10 miles</option>
        <option value="20">20 miles</option>
      </select>
      <input type="submit" value="Search">
    </form>
  </div>
</template>

<script>
import { GeocoderAutocomplete } from '@geoapify/geocoder-autocomplete';

export default {
  data() {
    return {
      searchTerm: "",
      searchRadius: 0,
      results:{}
    };
  },
  methods: {
    sendStartingLocationCoordinates() {
      //Implement logic for searching landmarks
      //Assuming logic cannot be built out until API is up and running on backend
      let startingLocationParameters = {
        startingLocationLong: this.results.lon,
        startingLocationLat: this.results.lat,
        searchRadius: this.searchRadius
      }
      this.$emit('retrieveCoordinates', startingLocationParameters);
    },
  },
  mounted: function() {
    const autocomplete = new GeocoderAutocomplete(
                          this.$refs.autocomplete, 
                          import.meta.env.VITE_GEOAPIFY_API_KEY,
                          { /* Geocoder options */ }
    );

    autocomplete.on('select', (location) => {
        // check selected location here 
        this.results = location.properties;
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
