<template>
    <global-header />
    <h1>Your itineraries</h1>
    <div class="itineraries-list" v-for="itinerary in this.$store.state.itineraries" v-bind:key="itinerary.itineraryId">
        <itinerary-card v-bind:itinerary="itinerary"/>
    </div>
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
            itineraryService.getAllItineraries(this.$store.state.user.userId)
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
    }
}

</script>

<style scoped>

</style>
