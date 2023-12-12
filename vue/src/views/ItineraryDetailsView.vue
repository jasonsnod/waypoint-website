<template>
<body>
    <global-header />
    <h1>{{ itinerary.itineraryId }}</h1>
    <p>{{ itinerary.userId }}</p>
    <p>{{ itinerary.itineraryName }}</p>
    <p>{{  itinerary.startingAddress }}</p>

    <global-footer />
</body>
</template>

<script>
import GlobalFooter from '../components/GlobalFooter.vue';
import GlobalHeader from '../components/GlobalHeader.vue';

export default {
    data() {
        return {
            itinerary: {}
        }
    },
    components: {
        GlobalFooter,
        GlobalHeader
    }, 
    methods: {
        getItinerary() {
            this.itinerary = this.$store.state.itineraries.find(itinerary => itinerary.itineraryId == this.$route.params.itineraryId)
        }
    },
    created() {
        this.getItinerary();
    }
}

</script>

<style scoped>

</style>

