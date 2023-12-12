<template>

    <div class="landmark-details">
        <global-header />
        <div class="details-container">
            <p>{{landmark.landmarkId}}</p>

            <p class="detail-name">{{landmark.landmarkName}}</p>
            <p class="detail-value">{{landmark.landmarkAddress}}</p>
            <p class="detail-value">{{landmark.landmarkDetails}}</p>
            <img class="landmark-image" src="https://www.visittheusa.com/sites/default/files/styles/hero_l/public/images/hero_media_image/2023-04/cd6d5f6d-0b19-47cf-93f1-dd16cca640a8.jpeg?h=2935a1aa&itok=mlV8oEZW">
            <!-- <p>{{landmark.landmarkLatitude}}</p>
            <p>{{landmark.landmarkLongitude}}</p> -->
        </div>
    </div>
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
    .details-container{
        padding: 20px;
        background-color: #f9f9f9;
        border-radius: 10px;
        margin: 20px;
        color: #333;
        border: 2px solid rgb(236, 173, 231);
        border-radius: 8px;
        padding: 10px;
        margin-bottom: 20px;
        margin-top: 10px;
        margin-left: 500px;
        margin-right: 500px;
        background-color: rgb(59, 108, 172);
    }

    .landmark-image{
        max-width: 80%;
        border-radius: 8px;
        display: block;
        margin: 0 auto;
        margin-bottom: 50px;
        border: 1px solid antiquewhite;
    }

    .detail-name{
        font-weight: bold;
        font-size: 18px;
    }

    /* Mobile Styles   */
   @media screen and (max-width: 600){
    .details-container{
        display: flex;
        flex-direction: column;
    }
   }
</style>
