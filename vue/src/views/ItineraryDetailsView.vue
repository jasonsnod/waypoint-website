<template>
<body>
    <global-header />
    <h1>{{ itinerary.itineraryId }}</h1>
    <p>{{ itinerary.userId }}</p>
    <p>{{ itinerary.itineraryName }}</p>
    <p>{{  itinerary.startingAddress }}</p>

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
import ItineraryService from '../services/ItineraryService';

export default {
    data() {
        return {
            showUpdateForm: false,
            showDeleteNotification: false,
            itinerary: {},
            itineraryLandmarks: []

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
        getItineraryLandmarks() {
            this.itineraryLandmarks = ItineraryService.getLandmarksByItinerary(this.itinerary.itineraryId)
        },
        flipDeleteAlert() {
            this.showDeleteNotification = !this.showDeleteNotification
        },
        deleteItinerary() {
            ItineraryService.deleteItinerary(this.itinerary.itineraryId)
            this.$router.push('/itineraries')
        }
    },
    created() {
        this.getItinerary();
        this.getItineraryLandmarks();
    }
}

</script>

<style scoped>

</style>

