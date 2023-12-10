<template>
  <h1 class="map-header">Map of Landmarks Test</h1>
  <!-- <img width="600" 
         height="400" 
         src="../../img/all-landmarks-static-map.jpg"
         alt="1725 Riverside Drive, Cincinnati, OH 45202, United States of America"
    /> -->
  <img
    width="600"
    height="400"
    src="https://maps.geoapify.com/v1/staticmap?style=osm-carto&width=600&height=400&center=lonlat:-84.482038,39.116247&zoom=11.4604&marker=lonlat:-84.5082596024472,39.07830587854244;color:%23ff0000;size:small|lonlat:-84.52642222209342,39.08815258064968;color:%23ff0000;size:small|lonlat:-84.42370410995925,39.1411755209522;color:%23ff0000;size:small&apiKey=f4ec423be4f84260bdd3b93a488dd3b0"
    alt="1725 Riverside Drive, Cincinnati, OH 45202, United States of America"
  />
</template>

<script>
export default {};
</script>

<style scoped>
.map-header {
  font-family: Arial, sans-serif;
  color: #fcf5f5;
  font-size: 36px;
  font-weight: bold;
  margin-bottom: 30px;
  text-transform: uppercase;
  letter-spacing: 1px;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2);
  text-align: center;
}

img {
  display: block;
  margin: 0 auto;
  border-radius: 5px;
  border: 2px solid #ccc;
}
</style>
