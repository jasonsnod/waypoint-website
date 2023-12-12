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
        
        <button type="submit">Submit</button>
        <button type="cancel" v-on:click="flipForm">Cancel</button>


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
                userId: this.$store.state.user.id,
                itineraryName: "",
                startingAddress: ""
            },
            newItineraryId: 0
        }
    },
    methods: {
        flipForm() {
            this.showForm = !this.showForm
        },
        updateIds(landmarkId) {
            console.log(landmarkId)
            if (this.landmarkIds.includes(landmarkId) === true) {
                this.landmarkIds = this.landmarkIds.filter(id => id != landmarkId)
                
            } else {
                this.landmarkIds.push(landmarkId)
                
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
                this.newItineraryId = response.data.itineraryId
                console.log(this.landmarkIds)
                itineraryService.createLandmarksForItinerary(this.newItineraryId, this.landmarkIds)

                this.landmarkIds = [];
                 this.itinerary = {
                userId: this.$store.state.user.userId,
                itineraryName: "",
                startingAddress: ""
                 };
            this.showForm = false;
            })
            .catch(error => {
                console.log(error)
            });
            
            
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
