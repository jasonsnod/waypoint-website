<template>
    <div v-bind:id="landmark.landmarkId" class="landmark-card">
        <h1 class="landmark-name">{{landmark.landmarkName}}</h1>
        <p class="landmark-address">{{landmark.landmarkAddress}}</p>
        <p class="landmark-details">{{ landmark.landmarkDetails }}</p>
        <img :src="landmark.imageSrc" alt="Landmark Image" class="landmark-image" />
        <img src="https://themotzgroup.com/wp-content/uploads/2018/06/Bengals.jpg&nocache=1">
    </div>
</template>

<script>
    export default{
        props: {
            landmark: Object
        }
    }
</script>

<style scoped>
.landmark-card{
    border: 1px solid pink;
}

.landmark-name{
    font-size: 24px;
}
</style>