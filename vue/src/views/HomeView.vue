<template>
  <div class="home">
    <global-header />
    <h1 class="homeview-header">City Tours</h1>
    <img
      class="homeview-image"
      src="https://i.icanvas.com/WDA757?d=2&sh=h&p=1&bg=g"
    />
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
    ViewLandmarks,
    GlobalFooter,
  },
};
</script>
<style scoped>
/* Add component-specific styles heres  */
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
</style>

<!-- 
Color Pallete I was working with if anyone cares:

https://www.w3schools.com/w3css/w3css_color_generator.asp -->
