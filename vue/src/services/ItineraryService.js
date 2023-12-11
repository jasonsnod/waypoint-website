import axios from 'axios';

export default {
    getAllItineraries(userId) {
        return axios.get(`/itinerary/${userId}`);
    },
    editLandmarksForItinerary(itineraryId, landmarkIdArray) {
        let landmarkIdString = landmarkIdArray.join(',')
        return axios.put(`/itinerary/${itineraryId}/landmark?landmarkIds=${landmarkIdString}`)
    },
    createLandmarksForItinerary(itineraryId, landmarkIdArray) {
        let landmarkIdString = landmarkIdArray.join(',')
        return axios.post(`/itinerary/${itineraryId}/landmark?landmarkIds=${landmarkIdString}`)
    },
    deleteItinerary(itineraryId) {
        return axios.delete(`/itinerary/${itineraryId}`)
    },
    createBaseItinerary() {
        return axios.post('/itinerary')
    },
    updateItineraryDetails(itineraryId) {
        return axios.put(`/itinerary/${itineraryId}`)
    }

}