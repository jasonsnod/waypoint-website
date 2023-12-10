<template>
    <global-header />
    <h1>Itineraries List</h1>
    <div class="itineraries-list">
        <itinerary-card />
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
    data() {
        return {
            itineraries: []
        }
    },
    methods: {
        getItineraries() {
            itineraryService.getAllItineraries(this.$store.state.user.userId)
                .then(response => {
                    this.itineraries = response.data;
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
