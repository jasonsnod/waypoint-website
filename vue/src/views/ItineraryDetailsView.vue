<template>
<body>
    <global-header />
    <h1>{{ itinerary.itineraryId }}</h1>
    <p>{{ itinerary.userId }}</p>
    <p>{{ itinerary.itineraryName }}</p>
    <p>{{  itinerary.startingAddress }}</p>
    <div class="list-of-landmarks" v-for="landmark in itineraryLandmarks" v-bind:key="landmark.landmarkId">
        <router-link :to="{ name: 'landmark-details', params: {landmarkId: landmark.landmarkId} }">
            <p>{{ landmark.landmarkName }}</p>
        </router-link>
    </div>
 
    <div class="map-container" ref="myMap"></div>

    <button class="update-button" v-if="!showUpdateForm" @click="flipUpdateForm">Update</button>
    <form class="itinerary-form" v-if="showUpdateForm" @submit.prevent="updateItinerary">
            <div class="form-field">
                <label for="itinerary-name-input" id="itinerary-name">Itinerary Name:</label>
                <input v-model="itinerary.itineraryName" id="itinerary-name-input" type="text" placeholder="Enter itinerary name" />
            </div>
            <div class="form-field">
                <label for="starting-address-input" id="itinerary-address">Starting Address:</label>
                <div class="bottom-input">
                    <input v-model="itinerary.startingAddress" id="starting-address-input" type="text" placeholder="Enter starting address" />
                </div>
            </div>
            <ul class="landmarks-list">
                <li v-for="landmark in $store.state.landmarks" :key="landmark.landmarkId">
                    <label>
                        <input type="checkbox" @click="updateIds(landmark.landmarkId)" class="landmark-checkbox"/>
                        {{ landmark.landmarkName }}
                    </label>
                </li>
            </ul>
            <div class="form-buttons">
                <div class="button-wrapper">
                    <button type="submit" class="submit-button" @click="flipUpdateForm">Submit</button>
                </div>
                <div class="button-wrapper">
                    <button type="button" class="cancel-button" @click="flipUpdateForm">Cancel</button>
                </div>
            </div>
        </form>

    <button class="delete-button" v-if="!showDeleteNotification" @click="flipDeleteAlert">Delete</button>
    <container class="delete-box" v-if="showDeleteNotification">
        <h6>Are you sure you want to delete this itinerary?</h6>
        <button class="delete-confirmation" @click="deleteItinerary">Yes!</button>
        <button class="delete-rejection" @click="flipDeleteAlert">No!</button>
    </container>

    <global-footer />
</body>
</template>

<script>
import GlobalFooter from '../components/GlobalFooter.vue';
import GlobalHeader from '../components/GlobalHeader.vue';
import itineraryService from '../services/ItineraryService';
import geoApifyService from '../services/GeoApifyService';
import maplibre from 'maplibre-gl';

export default {
    data() {
        return {
            itinerary: {},
            itineraryStartingCoordinates: {},
            landmarkIdsToAdd: [],
            showUpdateForm: false,
            showDeleteNotification: false,
            itineraryLandmarks: [],
            itineraryRoute: {}
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
        flipUpdateForm() {
            this.showUpdateForm = !this.showUpdateForm
        },
        updateIds(landmarkId) {
            console.log(landmarkId)
            if (this.landmarkIdsToAdd.includes(landmarkId) === true) {
                this.landmarkIdsToAdd = this.landmarkIdsToAdd.filter(id => id != landmarkId)
                console.log(this.landmarkIdsToAdd)
            } else {
                this.landmarkIdsToAdd.push(landmarkId)
                console.log(this.landmarkIdsToAdd)
            }
        },
        updateItinerary() {
            itineraryService.updateItineraryDetails(this.itinerary.itineraryId, this.itinerary)
            let idsToSend = this.landmarkIdsToAdd
            for(let landmark of this.itineraryLandmarks) {
                if(!idsToSend.includes(landmark.landmarkId)) {
                    idsToSend.push(landmark.landmarkId)
                }
            }
            itineraryService.editLandmarksForItinerary(this.itinerary.itineraryId, idsToSend)
            .then(response => {
                this.landmarkIdsToAdd = [];
            })
            .catch(error => {
                console.log(error);
            })
        },
        getItineraryLandmarks() {
            itineraryService.getLandmarksByItinerary(this.itinerary.itineraryId)
            .then(response => {
                this.itineraryLandmarks = response.data;
            })
            .catch(error => {
                console.log(error);
            });
        },
        flipDeleteAlert() {
            this.showDeleteNotification = !this.showDeleteNotification
        },
        deleteItinerary() {
            itineraryService.deleteItinerary(this.itinerary.itineraryId)
            this.$router.push('/itineraries')
        },
        getStartingAddressCoordinates() {
           geoApifyService.getCoordinatesForAddress(this.itinerary.startingAddress)
           .then(response => {
            this.itineraryStartingCoordinates.lat = response.data.results[0].lat;
            this.itineraryStartingCoordinates.lon = response.data.results[0].lon;

            this.getItineraryRoute();
           })
           .catch(error => {
            console.log([error, 'Could not retrieve route.']);
           });
        },
        getItineraryRoute() {
            let waypointsCoordinatesArray = [];

            waypointsCoordinatesArray.push({latitude: this.itineraryStartingCoordinates.lat , longitude: this.itineraryStartingCoordinates.lon});

            for (let landmark of this.itineraryLandmarks) {
                waypointsCoordinatesArray.push({latitude: landmark.landmarkLatitude , longitude: landmark.landmarkLongitude})
            }

            geoApifyService.getItineraryRoute(waypointsCoordinatesArray)
            .then(response => {
                this.itineraryRoute = response.data;

                this.createItineraryMap();
            })
            .catch(error => {
                console.log(error);
            });
        },
        createItineraryMap() {
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

            function visualizeRoute(routeGeojson) {

                console.log(routeGeojson)
                map.addSource('my-route', {
                    type:"geojson",
                    data: routeGeojson // <= add data here!
                });

                map.addLayer({
                    id: 'my-route-layer',
                    source: 'my-route',
                    type: 'line',
                });
            }
            map.on('load', visualizeRoute(this.itineraryRoute));
        }
    },
    created() {
        this.getItinerary();
        this.getStartingAddressCoordinates();
        this.getItineraryLandmarks();
    },
}

</script>

<style scoped>
@import '../../node_modules/maplibre-gl/dist/maplibre-gl.css'; 

.map-container {
  height: 400px;
  width: 600px;
}

</style>

