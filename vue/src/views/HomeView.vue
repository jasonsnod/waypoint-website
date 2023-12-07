<template>
  <div class="home">
    <global-header />
    <h1 class="homeview-header">City Tours</h1>
    <img
      class="homeview-image"
      src="https://i.icanvas.com/WDA757?d=2&sh=h&p=1&bg=g"
    />
    <hr class="line-under-image" />

    <div class="image-with-paragraphs">
      <div class="image-with-text">
        <img
          src="https://oyster.ignimgs.com/mediawiki/apis.ign.com/pokemon-blue-version/8/89/Pikachu.jpg?width=325"
          alt="Itinerary Graphic"
        />
        <p>Use our website to build an itinerary and share with friends.</p>
      </div>
      <div class="image-with-text">
        <img
          src="https://oyster.ignimgs.com/mediawiki/apis.ign.com/pokemon-blue-version/8/89/Pikachu.jpg?width=325"
          alt="Landmark Graphic"
        />
        <p>Check out the landmarks in Cincinnati</p>
      </div>
    </div>

    <search-landmarks />
    <view-landmarks />
    <global-footer />
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
    // GlobalFooter,
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

/* Placeholder images for now */
img {
  width: 200px;
  border-radius: 50px;
}

/* Styles for itinerary and graphic */

.image-with-paragraphs {
  display: flex;
}
</style>

<!-- 
Color Pallete I was working with if anyone cares:

https://www.w3schools.com/w3css/w3css_color_generator.asp -->
