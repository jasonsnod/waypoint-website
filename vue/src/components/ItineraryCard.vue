<template>
    <router-link :to="{ name: 'itinerary-details', params: {itineraryId: itinerary.itineraryId}}">
        <h1>{{ itinerary.itineraryName }}</h1>
    </router-link>
    <p>{{ itinerary.itineraryId}}</p>
    <p>{{ itinerary.userId }}</p>
    <p>{{ itinerary.startingAddress }}</p>
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
