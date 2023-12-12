<template>
 
  <h1 class="ml-3">Add a Landmark</h1>
      <form class="login-form" v-on:submit.prevent="submitForm"> 
          <div class="form-group">
              <label for="landmarkName">Landmark Name: </label>
              <input type="text" class="form-control" v-model="landmark.landmarkName" id="landmarkName" placeholder="Enter landmark name">
              <label for="landmarkAddress" class="mt-2">Landmark Address: </label>
              <div ref="autocomplete" class="autocomplete-container autocomplete-input"></div>
  
              <label for="landmarkDetails" class="mt-2">Landmark Details: </label>
              <textarea class="form-control" v-model="landmark.landmarkDetails" id="landmarkDetails" placeholder="Enter landmark details" rows="2"></textarea>
              <file-upload class="mt-3"/>

              <image-viewer class="mb-3"/>
              <button type="submit" class="btn btn-primary mr-3 mt-3">Submit</button>
              <button type="reset" class="btn btn-secondary mt-3">Reset</button>
  
 
          
          </div>
      </form>
  </template>
  
  
  
  <script>
  
import { GeocoderAutocomplete } from "@geoapify/geocoder-autocomplete";
import LandmarkService from "../services/LandmarkService";
import FileUpload from '../components/FileUpload.vue';
import ImageViewer from '../components/ImageViewer.vue';
import imageService from "../services/ImageService";
  
export default {
  
  data() {
      return {
          landmark: {}
      }
  },

  components: {
    FileUpload,
    ImageViewer,
  },

  methods: {
     
      submitForm() {
        this.jasonsDestiny();
        FileUpload.methods.saveImage.call(this);
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

  .autocomplete-container {
    color:black;
  }

  .form-group {
    color: white;
  }

  .imagePreviewWrapper {
    display: flex;
    flex-direction: column;
  }
  .imagePreviewWrapper img {
    height: 20em;
    width: 20em;
  }
  </style>