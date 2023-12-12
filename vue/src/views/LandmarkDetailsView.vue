<template>
    <div class="landmark-details">
        <global-header />
        <div class="details-container">
            <p class="landmark-id">{{landmark.landmarkId}}</p>
            <p class="detail-name">{{landmark.landmarkName}}</p>
            <p class="detail-value">{{landmark.landmarkAddress}}</p>
            <p class="detail-value">{{landmark.landmarkDetails}}</p>
            <img class="landmark-image" src="https://www.visittheusa.com/sites/default/files/styles/hero_l/public/images/hero_media_image/2023-04/cd6d5f6d-0b19-47cf-93f1-dd16cca640a8.jpeg?h=2935a1aa&itok=mlV8oEZW">
            <!-- <p>{{landmark.landmarkLatitude}}</p>
            <p>{{landmark.landmarkLongitude}}</p> -->
            <router-link v-bind:to="{ name: 'landmarks' }">
                <button>Landmark List</button>
            </router-link>
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
        margin: 20px auto;
        color: #333;
        border: 2px solid rgb(236, 173, 231);
        max-width: 600px;
        width: 100%;
        background-color: rgb(59, 108, 172);
        text-align: center;
    }

    .landmark-image{
        max-width: 100%;
        border-radius: 8px;
        display: block;
        margin: 0 auto;
        margin-top: 40px;
        margin-bottom: 50px;
        border: 1px solid antiquewhite;
    }

    .detail-name{
        font-weight: bold;
        font-size: 18px;
    }

    .landmark-id{
        display: none;
    }

    button{
        padding: 12px 24px;
        background-color: #4caf50;
        color: white;
        font-weight: bold;
        border: none;
        border-radius: 20px;
        display: inline block;
        cursor: pointer;
        transition: background-color 0.3s ease;
        margin-bottom: 30px;
    }

    button:hover{
        background-color: #45a049;
    }

    /* Mobile Styles   */
   @media screen and (max-width: 600){
    .details-container{
        padding: 3000px;
        margin-left: 70px;
    }
   }
</style>
