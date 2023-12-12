<template>
    <global-header />
    <h1>Your itineraries</h1>
    <div class="itineraries-list" v-for="itinerary in this.$store.state.itineraries" v-bind:key="itinerary.itineraryId">
        <itinerary-card v-bind:itinerary="itinerary"/>
    </div>
    <button class="new-itinerary-button" v-if="!showForm" v-on:click="flipForm">Create New Itinerary</button>
    <form v-if="showForm">
        <p>Itinerary Name</p>
        <input/>
        <p>Starting Address</p>
        <input/>
        <ul class="landmarks-list" v-for="landmark in this.$store.state.landmarks" v-bind:key="landmark.landmarkId">
            <input type="checkbox">{{ landmark.landmarkName }}<input/>
        </ul>
        
        <button type="" v-on:click="flipForm">Ahhh</button>

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
            showForm: false
        }
    },
    methods: {
        flipForm() {
            this.showForm = !this.showForm
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
