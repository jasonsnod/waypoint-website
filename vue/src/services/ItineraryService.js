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
    createBaseItinerary(itinerary) {
        return axios.post('/itinerary', itinerary)
    },
    updateItineraryDetails(itineraryId, itinerary) {
        return axios.put(`/itinerary/${itineraryId}`, itinerary)
    }

}