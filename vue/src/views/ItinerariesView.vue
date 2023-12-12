<template>
    
    <global-header />
    <div class="itinerary-container">
        <h1>Your Itineraries</h1>
        <div class="itineraries-list">
            <div class="itinerary-item" v-for="itinerary in $store.state.itineraries" :key="itinerary.itineraryId">
            <itinerary-card :itinerary="itinerary" />
            </div>
        </div>
        <button class="new-itinerary-button" v-if="!showForm" @click="flipForm">Create New Itinerary</button>
        <form class="itinerary-form" v-if="showForm" @submit.prevent="createItinerary">
            <div class="form-field">
                <label for="itinerary-name-input">Itinerary Name</label>
                <input v-model="itinerary.itineraryName" id="itinerary-name-input" type="text" placeholder="Enter itinerary name" />
            </div>
            <div class="form-field">
                <label for="starting-address-input">Starting Address</label>
                <input v-model="itinerary.startingAddress" id="starting-address-input" type="text" placeholder="Enter starting address" />
            </div>
            <ul class="landmarks-list">
                <li v-for="landmark in $store.state.landmarks" :key="landmark.landmarkId">
                    <label>
                        <input type="checkbox" @click="updateIds(landmark.landmarkId)" class="landmark-checkbox" />
                        {{ landmark.landmarkName }}
                    </label>
                </li>
            </ul>
            <div class="form-buttons">
                <div class="button-wrapper">
                    <button type="submit" class="submit-button">Submit</button>
                </div>
                <div class="button-wrapper">
                    <button type="button" class="cancel-button" @click="flipForm">Cancel</button>
                </div>
            </div>
        </form>
    </div>
    <global-footer />
    
  </template>
  

<script>
import GlobalFooter from '../components/GlobalFooter.vue';
import GlobalHeader from '../components/GlobalHeader.vue';
import ItineraryCard from '../components/ItineraryCard.vue';
import itineraryService from '../services/ItineraryService.js';

export default {
    components: {
    GlobalFooter,
    GlobalHeader,
    ItineraryCard
},
    data() {
        return {
            showForm: false,
            landmarkIds: [],
            itinerary: {
                userId: this.$store.state.user.id,
                itineraryName: "",
                startingAddress: ""
            },
            newItineraryId: 0
        }
    },
    methods: {
        flipForm() {
            this.showForm = !this.showForm
        },
        updateIds(landmarkId) {
            console.log(landmarkId)
            if (this.landmarkIds.includes(landmarkId) === true) {
                this.landmarkIds = this.landmarkIds.filter(id => id != landmarkId)
                
            } else {
                this.landmarkIds.push(landmarkId)
                
            }
        },
        getItineraries() {
            itineraryService.getAllItineraries(this.$store.state.user.id)
            .then(response => {
                this.$store.commit('SET_USER_ITINERARIES', response.data);
            })
            .catch(error => {
                this.handleErrorResponse();
            });
        },
        createItinerary() {
            itineraryService.createBaseItinerary(this.itinerary)
            .then(response => {
                this.newItineraryId = response.data.itineraryId
                console.log(this.landmarkIds)
                itineraryService.createLandmarksForItinerary(this.newItineraryId, this.landmarkIds)

                this.landmarkIds = [];
                 this.itinerary = {
                userId: this.$store.state.user.userId,
                itineraryName: "",
                startingAddress: ""
                 };
            this.showForm = false;
            })
            .catch(error => {
                console.log(error)
            });
            
            
        },
        handleErrorResponse() {
            console.log('Error: Network Error');
        }
    },
    created() {
        this.getItineraries();
    }
}

</script>

<style scoped>
    .itinerary-container {
        max-width: 600px;
        margin: 0 auto;
        padding: 20px;
        font-family: 'Arial', sans-serif;
    }

    .itineraries-list{
        display: flex;
        flex-wrap: wrap;
        gap: 20px;
    }

    .new-itinerary-button {
        background-color: #3498db;
        color: white;
        border: none;
        border-radius: 4px;
        padding: 8px 16px;
        cursor: pointer;
        display: block;
        margin: 0 auto;
        margin-top: 30px;
    }

    h1 {
        font-size: 24px;
        margin-bottom: 20px;
       }

    .itineraries-list {
        display: flex;
        flex-wrap: wrap;
        gap: 20px;
    }

    .new-itinerary-button {
        background-color: #3498db;
        color: white;
        border: none;
        border-radius: 4px;
        padding: 10px 20px;
        cursor: pointer;
        margin-bottom: 20px;
    }

    .itinerary-form {
        background-color: rgb(59, 108, 172);
        padding: 20px;
        border-radius: 8px;
    }

    .form-field {
        margin-bottom: 15px;
    }

    label {
        font-weight: bold;
        margin-bottom: 5px;
        display: block;
    }

    input[type="text"] {
        width: calc(100% - 20px);
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    .landmarks-list {
        list-style: none;
        padding: 0;
        margin: 0;
    }

    .landmark-checkbox {
        margin-right: 5px;
    }

    .form-buttons {
        display: flex;
        justify-content: center;
        margin-top: 20px;
    }

    .button-wrapper{
        margin: 0 10px;
    }

    .submit-button {
        background-color: #4caf50;
        color: white;
        border: none;
        border-radius: 4px;
        padding: 10px 20px;
        cursor: pointer;
    }

    .submit-button:hover{
        background-color: #45a049;
    }

    .cancel-button {
        background-color: #3498db;
        color: white;
        border: none;
        border-radius: 4px;
        padding: 10px 20px;
        cursor: pointer;
    }

    .cancel-button:hover{
        background-color: #BB2D38;
    }
</style>