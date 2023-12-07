<template>
  <div class="home">
    <global-header />
    <h1 class="homeview-header">City Tours</h1>
    <img
      class="homeview-image"
      src="https://i.icanvas.com/WDA757?d=2&sh=h&p=1&bg=g"
    />
    <hr class="line-under-image" />

    <!-- YOU ARE WORKING HERE -->

    <div class="image-with-paragraphs">
      <div class="image-with-text">
        <img
          src="../assets/locationGraphics/itinerary-logo.png"
          alt="Itinerary Graphic"
          class=""
        />
        <p class="paragraph-text">
          Waypoint allows you to plan your trip using our website, then share
          your customized itinerary with friends in just a few clicks.
        </p>
      </div>
      <div class="image-with-text">
        <img
          src="../assets/locationGraphics/landmarks-logo.png"
          alt="Landmark Graphic"
          class=""
        />
        <p class="paragraph-text">
          Explore Cincinnati's iconic landmarks with Waypoint.
        </p>
      </div>
    </div>

    <search-landmarks />
    <router-link v-bind:to="{ name: 'landmarks' }">View Landmarks</router-link>
    <!-- <router-link :to="{ name: 'itinerary' }">View Itinerary</router-link> -->
    <!-- <global-footer /> -->
  </div>
</template>

<script>
import GlobalHeader from "../components/GlobalHeader.vue";
import SearchLandmarks from "../components/SearchLandmarks.vue";
import ViewLandmarks from "../components/ViewLandmarks.vue";
import GlobalFooter from "../components/GlobalFooter.vue";
export default {
  components: {
    GlobalHeader,
    SearchLandmarks,
    // ViewLandmarks,
    GlobalFooter,
  },
};
</script>
<style scoped>
.homeview-header {
  text-align: center;
  margin-top: 50px;
  font-family: "Roboto", sans-serif;
  font-size: 60px;
  color: #e2ecf7;
}

.homeview-image {
  border: 2px solid #234d80;
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
  margin-top: 80px;
}

.image-with-text {
  text-align: center;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  max-width: 420px;
  margin: 0 auto;
}

.image-with-text img {
  width: 100%;
  max-width: 300px;
  height: auto;
  border-radius: 10px;
  margin-bottom: 10px;
  border: 2px solid #234d80;
}
.paragraph-text {
  font-size: 20px;
  color: #f3f4f5;
  font-family: "Roboto", sans-serif;
}

/* Reducing margin between images on larger screens */

@media (min-width: 14px) {
  .image-with-text {
    width: calc(100% - 10px);
  }
}

/* Media Queries for Mobile */
@media (max-width: 768px) {
  .image-with-paragraphs {
    flex-direction: column;
    margin: 0 20px;
  }

  .image-with-text {
    width: 100%;
    margin-bottom: 20px;
  }
}
</style>

<!-- 
Color Pallete I was working with if anyone cares:

https://www.w3schools.com/w3css/w3css_color_generator.asp -->
