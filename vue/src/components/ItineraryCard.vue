<template>
    <global-header />
    <h1>Your Itinerary</h1>
    <router-link v-bind="{ name: 'landmark-details', params: {landmarkId: landmark.landmarkId } }">Link to a LandmarkDetailsView</router-link>
    <global-footer />
</template>

<script>
import GlobalFooter from '../components/GlobalFooter.vue';
import GlobalHeader from '../components/GlobalHeader.vue';

export default {
    data() {
        return {

        }
    },
    components: {
        GlobalFooter,
        GlobalHeader
    }
}

</script>

<style scoped>

</style>
