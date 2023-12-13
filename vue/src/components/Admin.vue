<template>
 
  <h1 class="ml-3">Add a Landmark</h1>
      <form class="login-form" v-on:submit.prevent="submitForm"> 
          <div class="form-group">
              <label for="landmarkName">Landmark Name: </label>
              <input type="text" class="form-control" v-model="landmark.landmarkName" id="landmarkName" placeholder="Enter landmark name">
              <label for="landmarkAddress" class="mt-2">Landmark Address: </label>
              <div ref="autocomplete" class="autocomplete-container autocomplete-input"></div>
  
              <label for="landmarkDetails" class="mt-2">Landmark Details: </label>
              <input type="textarea" class="form-control" v-model="landmark.landmarkDetails" id="landmarkDetails" placeholder="Enter landmark details">
  
              <button type="submit" class="btn btn-primary mr-3 mt-3">Submit</button>
              <button type="reset" class="btn btn-secondary mt-3">Reset</button>
  
  
          
          </div>
      </form>
  </template>
  
  
  
  <script>
  
  import { GeocoderAutocomplete } from "@geoapify/geocoder-autocomplete";
  import LandmarkService from "../services/LandmarkService";
  
  
  export default {
  
      data() {
          return {
              landmark: {}
          }
      },
  
      methods: {
          submitForm() {
              console.log(this.landmark)
              LandmarkService.addLandmark(this.landmark)
          }
      },
  
      mounted: function () {
      const autocomplete = new GeocoderAutocomplete(
        this.$refs.autocomplete,
        import.meta.env.VITE_GEOAPIFY_API_KEY,
        {
          country: 'US'
        }
      );
  
      autocomplete.on("select", (location) => {
        // check selected location here
        
        this.landmark.landmarkAddress = location.properties.formatted;
        this.landmark.landmarkLatitude = location.properties.lat;
        this.landmark.landmarkLongitude = location.properties.lon;
      });
  
      autocomplete.on("suggestions", (suggestions) => {
        // process suggestions here
      });
    },
  };
  </script>
  
  
  
  <style scoped>
  .login-form {
    display: flex;
    flex-direction: column;
    /* align-items: center; */
    /* margin: auto; */
    width: 520px;
    /* border-radius: 10px; */
    /* margin-top: 60px;
    margin-bottom: 90px; */
    padding: 20px;
  }
  .form-group {
    color: white;
  }
  </style>