<template>
  <div class="home">
    <global-header />
    <h1 class="homeview-header">Welcome to Waypoint, where to next?</h1>
    <img
      class="homeview-image"
      src="img\logo-large.png"
    />
    <hr class="line-under-image" />

    <div class="image-with-paragraphs ">
      <div class="image-container mx-auto mb-4">
        <img src="img\itinerary-logo.png" alt="Image 1" class="rounded mr-3">
        <router-link v-bind:to="{ name: 'landmarks'}">
          <img src="img\landmarks-logo.png" alt="Image 2" class="rounded mr-3">
        </router-link>
        <p>
          Your paragraph text goes here. This is an example paragraph.
        </p>
        
      </div>
      
    </div>

  

    <global-footer />
  </div>
</template>

<script>
import GlobalHeader from "../components/GlobalHeader.vue";
import GlobalFooter from "../components/GlobalFooter.vue";
export default {
  components: {
    GlobalHeader,
    GlobalFooter,
  },
};
</script>
<style scoped>
.homeview-header {
  text-align: center;
  margin-top: 50px;
  font-family: "Roboto", sans-serif;
  font-size: 30px;
  color: #e2ecf7;
}

.homeview-image {

  display: block;
  margin-left: auto;
  margin-right: auto;
  margin-top: 30px;
  width: 60%;
  border-radius: 30px;
}

.line-under-image {
  width: 40%;
  margin: 20px auto;
  border-bottom: 2px solid #234d80;
}

/* Styles for itinerary and graphic */

.image-with-paragraphs {
  display: flex;
  justify-content: space-between;
  margin-top: 40px;
}


.image-container {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 20px; /* Adjust the padding as needed */
}

img {
  max-width: 100%; /* Make sure images don't exceed their container */
  height: auto;
}

p {
  max-width: 300px;
  color: white; /* Adjust the width of the paragraph */
}

</style>

<!-- 
Color Pallete I was working with if anyone cares:

https://www.w3schools.com/w3css/w3css_color_generator.asp -->
