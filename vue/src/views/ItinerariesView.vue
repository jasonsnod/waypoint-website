<template>
    <global-header />
    <h1>Your itineraries</h1>
    <div class="itineraries-list" v-for="itinerary in this.$store.state.itineraries" v-bind:key="itinerary.itineraryId">
        <itinerary-card v-bind:itinerary="itinerary"/>
    </div>
    <button class="new-itinerary-button" v-if="!showForm" v-on:click="flipForm">Create New Itinerary</button>
    <form v-if="showForm" v-on:submit.prevent="createItinerary">
        <p>Itinerary Name</p>
        <input v-model="itinerary.itineraryName" id="itinerary-name-input"/>
        <p>Starting Address</p>
        <input v-model="itinerary.startingAddress" id="starting-address-input"/>
        <ul class="landmarks-list" >
            <li v-for="landmark in this.$store.state.landmarks" v-bind:key="landmark.landmarkId">
                <input type="checkbox" v-on:click="updateIds(landmark.landmarkId)" class="landmark-checkbox" />{{ landmark.landmarkName }}
            </li>
        </ul>
        
        <button type="submit" v-on:click="flipForm">Submit</button>

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
        updateIds(landmarkId) {
            console.log(landmarkId)
            if (this.landmarkIds.includes(landmarkId) === true) {
                //this.landmarkIds.splice(this.landmarkIds.indexOf(landmarkId), 1)
                this.landmarkIds = this.landmarkIds.filter(id => id != landmarkId)
                console.log(this.landmarkIds)
            } else {
                this.landmarkIds.push(landmarkId)
                console.log(this.landmarkIds)
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
            .then(response => {
                this.$store.state.itineraries.add(response)
            })
            .catch(error => {
                console.log(error)
            })
            // itineraryService.createLandmarksForItinerary(this.landmarkIds)
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
