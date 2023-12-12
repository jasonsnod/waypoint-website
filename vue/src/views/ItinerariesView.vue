<template>
    <global-header />
    <h1>Your itineraries</h1>
    <div class="itineraries-list" v-for="itinerary in this.$store.state.itineraries" v-bind:key="itinerary.itineraryId">
        <itinerary-card v-bind:itinerary="itinerary"/>
    </div>
    <button class="new-itinerary-button" v-if="!showForm" v-on:click="flipForm">Create New Itinerary</button>
    <form v-if="showForm" v-on:submit.prevent="createItinerary">
        <p>Itinerary Name</p>
        <input v-model="itinerary.itineraryName"/>
        <p>Starting Address</p>
        <input v-model="itinerary.startingAddress"/>
        <ul class="landmarks-list" v-for="landmark in this.$store.state.landmarks" v-bind:key="landmark.landmarkId">
            <input type="checkbox" v-bind="landmark.landmarkId" v-on:click="updateIds">{{ landmark.landmarkName }}
        </ul>
        
        <button type="submit" v-on:click="flipForm">Ahhh</button>

    </form>
    <global-footer />
</template>

<script>
import GlobalFooter from '../components/GlobalFooter.vue';
import GlobalHeader from '../components/GlobalHeader.vue';
import ItineraryCard from '../components/ItineraryCard.vue';
import itineraryService from '../services/ItineraryService.js';

export default {
    components: {
    GlobalFooter,
    GlobalHeader,
    ItineraryCard
},
    data() {
        return {
            showForm: false,
            landmarkIds: [],
            itinerary: {
                userId: this.$store.state.user.userId,
                itineraryName: "",
                startingAddress: ""
            }
        }
    },
    methods: {
        flipForm() {
            this.showForm = !this.showForm
        },
        updateIds() {
            if (this.landmarkIds.includes(this.landmarkId)) {
                this.landmarkIds.splice(this.landmarkIds.findIndex(this.landmarkId), 1)
            } else {
                this.landmarkIds.push(this.landmarkId)
            }
        },
        getItineraries() {
            itineraryService.getAllItineraries(this.$store.state.user.id)
            .then(response => {
                this.$store.commit('SET_USER_ITINERARIES', response.data);
            })
            .catch(error => {
                this.handleErrorResponse();
            });
        },
        createItinerary() {
            itineraryService.createBaseItinerary(this.itinerary)
            itineraryService.createLandmarksForItinerary(this.landmarkIds)
        },
        handleErrorResponse() {
            console.log('Error: Network Error');
        }
    },
    created() {
        this.getItineraries();
    }
}

</script>

<style scoped>

</style>
