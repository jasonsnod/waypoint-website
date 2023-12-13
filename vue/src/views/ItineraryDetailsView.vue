<template>
<body>
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

 
    <div class="map-container" ref="myMap"></div>

    <button class="update-button" v-if="!showUpdateForm" >Update</button>
    <button class="delete-button" v-if="!showDeleteNotification" @click="flipDeleteAlert">Delete</button>
    <container class="delete-box" v-if="showDeleteNotification">
        <h6>Are you sure you want to delete this itinerary?</h6>
        <button class="delete-confirmation" @click="deleteItinerary">Yes!</button>
        <button class="delete-rejection">No!</button>
    </container>

    <global-footer />
</body>
</template>

<script>
import GlobalFooter from '../components/GlobalFooter.vue';
import GlobalHeader from '../components/GlobalHeader.vue';
import itineraryService from '../services/ItineraryService';
//import { RouteDirections } from '@geoapify/route-directions';
import maplibre from 'maplibre-gl';

export default {
    data() {
        return {
            itinerary: {},
            landmarks: [],
            showUpdateForm: false,
            showDeleteNotification: false,
            // this.itineraryLandmarks
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
        },
        // getItineraryLandmarks() {
        //     this.itineraryLandmarks = ItineraryService.getLandmarksByItinerary(this.itinerary.itineraryId)
        // },
        flipDeleteAlert() {
            this.showDeleteNotification = !this.showDeleteNotification
        },
        deleteItinerary() {
            itineraryService.deleteItinerary(this.itinerary.itineraryId)
            this.$router.push('/itineraries')
        }
    },
    created() {
        this.getItinerary();
        this.getLandmarks();
    },
    mounted: function(){
        const mapStyle = 'https://maps.geoapify.com/v1/styles/osm-carto/style.json';

        const initialState = {
            lng: -84.51233126586305,
            lat: 39.10162530373483,
            zoom: 12
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
@import '../../node_modules/maplibre-gl/dist/maplibre-gl.css'; 

.map-container {
  height: 400px;
  width: 600px;
}

</style>

