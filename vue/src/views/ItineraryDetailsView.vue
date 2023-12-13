<template>
    <global-header />
    <h1>{{ itinerary.itineraryId }}</h1>
    <p>{{ itinerary.userId }}</p>
    <p>{{ itinerary.itineraryName }}</p>
    <p>{{  itinerary.startingAddress }}</p>

    <div class="list-of-landmarks" v-for="landmark in landmarks" v-bind:key="landmark.landmarkId">
        <router-link :to="{ name: 'landmark-details', params: {landmarkId: landmark.landmarkId} }">
            <p>{{ landmark.landmarkName }}</p>
        </router-link>
    </div>

    <div ref="routeDirections" id="route-directions"></div>
    <div class="map-container" ref="myMap"></div>

    <global-footer />
</template>

<script>
import GlobalFooter from '../components/GlobalFooter.vue';
import GlobalHeader from '../components/GlobalHeader.vue';
import itineraryService from '../services/ItineraryService';
import { RouteDirections } from '@geoapify/route-directions';
import maplibre from 'maplibre-gl';

export default {
    data() {
        return {
            itinerary: {},
            landmarks: []
        }
    },
    components: {
        GlobalFooter,
        GlobalHeader
    }, 
    methods: {
        getItinerary() {
            this.itinerary = this.$store.state.itineraries.find(itinerary => itinerary.itineraryId == this.$route.params.itineraryId)
        },
        getLandmarks() {
            itineraryService.getLandmarksByItinerary(this.itinerary.itineraryId)
            .then(response => {
                this.landmarks = response.data;
            })
            .catch(error => {
                console.log(error);
            });
        }
    },
    created() {
        this.getItinerary();
        this.getLandmarks();
    },
    mounted() {

        const waypointsToMap = {waypoints: []};
        for(let landmark of this.landmarks) {
            waypointsToMap.waypoints.push({address: landmark.landmarkAddress});
        }
        const routeDirections = new RouteDirections(
            this.$refs.routeDirections, 
            import.meta.env.VITE_GEOAPIFY_API_KEY,
            waypointsToMap.waypoints
        );

        // routeDirections.on('waypointChanged', (waypoint, reason) => {
        //     updateMarkers();
        // });

        // routeDirections.on('routeCalculated', (geojson) => {
        //     visualizeRoute(geojson);
        //     generateInstructions(geojson);
        // });

        const mapStyle = 'https://maps.geoapify.com/v1/styles/osm-carto/style.json';

        const initialState = {
            lng: 11,
            lat: 49,
            zoom: 4
        };

        const map = new maplibre.Map({
            container: this.$refs.myMap,
            style: `${mapStyle}?apiKey=${import.meta.env.VITE_GEOAPIFY_API_KEY}`,
            center: [initialState.lng, initialState.lat],
            zoom: initialState.zoom
        });

        const markerPopup = new maplibre.Popup().setText('Some marker');
        new maplibre.Marker().setLngLat([initialState.lng, initialState.lat]).setPopup(markerPopup).addTo(map);
    }
}

</script>

<style scoped>
@import '../../node_modules/@geoapify/route-directions/styles/styles.css';
@import '../../node_modules/maplibre-gl/dist/maplibre-gl.css';

.map-container {
  height: 400px;
  width: 600px;
}

</style>

