<template>
    <h1>{{ itinerary.itineraryName }}</h1>
    <p>{{ itinerary.itineraryId}}</p>
    <p>{{ itinerary.userId }}</p>
    <p>{{ itinerary.startingAddress }}</p>
    <!-- <router-link v-bind="{ name: 'landmark-details', params: {landmarkId: landmark.landmarkId } }">Link to a LandmarkDetailsView</router-link> -->
</template>

<script>

export default {
    props: {
        itinerary: Object
    },
    components: {

    }
}

</script>

<style scoped>

</style>
