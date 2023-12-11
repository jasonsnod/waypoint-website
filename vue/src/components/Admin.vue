<template>
    <hr class="line-under-image" />
    <h1>Add a Landmark</h1>
        <form class="login-form" v-on:submit.prevent="jasonsDestiny"> 
            <div>
                <label for="landmarkName">Landmark Name: </label>
                <input type="text" v-model="landmark.landmarkName" id="landmarkName">
    
                <div ref="autocomplete" class="autocomplete-container autocomplete-input"></div>
    
                <label for="landmarkDetails">Landmark Details: </label>
                <input type="textarea" v-model="landmark.landmarkDetails" id="landmarkDetails">
    
                <button type="submit">Submit</button>
    
    
            
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
            jasonsDestiny() {
                console.log(this.landmark)
                LandmarkService.addLandmark(this.landmark)
            }
        },
    
        mounted: function () {
        const autocomplete = new GeocoderAutocomplete(
          this.$refs.autocomplete,
          import.meta.env.VITE_GEOAPIFY_API_KEY,
          {
            /* Geocoder options */
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
      border: 3px solid #e9e7e7;
      display: flex;
      flex-direction: column;
      align-items: center;
      /* height: 80vh; */
      margin: auto;
      width: 320px;
      border-radius: 10px;
      margin-top: 60px;
      margin-bottom: 90px;
      background-color: #f9f9f9;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
      padding: 20px;
    }
    </style>