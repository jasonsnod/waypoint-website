<template>
    <global-header />
    <h1>Your itineraries</h1>
    <div class="itineraries-list" v-for="itinerary in this.$store.state.itineraries" v-bind:key="itinerary.itineraryId">
        <itinerary-card v-bind:itinerary="itinerary"/>
    </div>
    <button class="new-itinerary-button">Create New Itinerary</button>
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
    methods: {
        getItineraries() {
            console.log(this.$store.state.user);
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
