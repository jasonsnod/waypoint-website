<template>
    <global-header />
    <p>{{landmark.landmarkId}}</p>
    <p>{{landmark.landmarkName}}</p>
    <p>{{landmark.landmarkAddress}}</p>

    <p>{{landmark.landmarkDetails}}</p>
    <p>{{landmark.landmarkLatitude}}</p>
    <p>{{landmark.landmarkLongitude}}</p>

    <global-footer />
</template>

<script>
import GlobalFooter from '../components/GlobalFooter.vue';
import GlobalHeader from '../components/GlobalHeader.vue';

export default {
    data() {
        return {
            landmark: {}
        }
    },
    components: {
        GlobalFooter,
        GlobalHeader
    },
    methods: {
        getLandmark(){
            this.landmark = this.$store.state.landmarks.find(landmark => {
                return this.$route.params.landmarkId == landmark.landmarkId;
            })
        }
    },
    created(){
        this.getLandmark();
    } 
    
}

</script>

<style scoped>

</style>
