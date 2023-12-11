<template>
    <global-header />
    <h1>Itineraries List</h1>
    <global-footer />
</template>

<script>
import GlobalFooter from '../components/GlobalFooter.vue';
import GlobalHeader from '../components/GlobalHeader.vue';

export default {
    data() {
        return {
            itinerary: this
        }
    },
    components: {
        GlobalFooter,
        GlobalHeader
    }, 
    methods: {
        getItinerary() {
            console.log(this.$route);
            //this.itinerary = this.$store.state.itineraries.find(itinerary => itinerary.id === this.$route.itineraryId)
        }
    },
    created() {
        this.getItinerary();
    }
}

</script>

<style scoped>

</style>
