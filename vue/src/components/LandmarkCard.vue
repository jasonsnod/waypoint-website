<template>
    <div class="scrollable-container">
        <div v-bind:id="landmark.landmarkId" class="landmark-card">
            <div class="landmark-content">
                <div class="landmark-info">
                    <h1 class="landmark-name">{{landmark.landmarkName}}</h1>
                    <p class="landmark-address">{{landmark.landmarkAddress}}</p>
                    <!-- <p class="landmark-details">{{ landmark.landmarkDetails }}</p> -->
                </div>
                    <!-- <img :src="landmark.imageSrc" alt="Landmark Image" class="landmark-image" /> -->
                    <img class="landmark-image" src="https://www.visittheusa.com/sites/default/files/styles/hero_l/public/images/hero_media_image/2023-04/cd6d5f6d-0b19-47cf-93f1-dd16cca640a8.jpeg?h=2935a1aa&itok=mlV8oEZW">
            </div>
        </div>
    </div>
</template>

<script>
    export default{
        props: {
            landmark: Object
        },
    components: {

    }
    }
</script>

<style scoped>
/* .landmark-card{
    border: 2px solid rgb(236, 173, 231);
    border-radius: 8px;
    padding: 20px;
    margin-bottom: 50px;
    margin-top: 20px;
    margin-left: 150px;
    margin-right: 150px;
    background-color: rgb(59, 108, 172);
} */

.scrollable-container{
    overflow: auto;
}

.landmark-card{
    border: 2px solid rgb(236, 173, 231);
    border-radius: 8px;
    padding: 10px;
    margin-bottom: 20px;
    margin-top: 10px;
    margin-left: 500px;
    margin-right: 500px;
    background-color: rgb(59, 108, 172);

}

.landmark-content{
    display: flex;
    flex-direction: column;
}

.landmark-info{
    padding: 20px;
}

.landmark-name{
    font-size: 20px;
    font-weight: bold;
    margin-bottom: 10px;
}

.landmark-address{
    font-size: 18px;
}

.landmark-image{
    max-width: 80%;
    border-radius: 8px;
    display: block;
    margin: 0 auto;
    margin-bottom: 50px;
    border: 1px solid antiquewhite;
}

/* Media Queries for Smaller Screens */
@media screen and (max-width: 768px){
    .landmark-card{
        border: 2px solid rgb(236, 173, 231);
        border-radius: 8px;
        padding: 10px;
        margin: 10px auto;
        max-width: 90%;
    }
}

</style>