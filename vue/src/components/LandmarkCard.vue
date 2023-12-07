<template>
    <div v-bind:id="landmark.landmarkId" class="landmark-card">
        <h1>{{landmark.landmarkName}}</h1>
        <p>{{landmark.landmarkAddress}}</p>
        <p>{{ landmark.landmarkDetails }}</p>

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
</style>