import axios from 'axios';

export default {
    getAllItineraries(userId) {
        return axios.get(`/itinerary/${userId}`);
    },
    editLandmarksForItinerary(itineraryId, landmarkIdArray) {
        // let landmarkIdString = landmarkIdArray.join(',')
        //?landmarkIds=${landmarkIdString}
        return axios.put(`/itinerary/${itineraryId}/landmark`, landmarkIdArray)
    },
    createLandmarksForItinerary(itineraryId, landmarkIdArray) {
        // let landmarkIdString = landmarkIdArray.join(',')
        //?landmarkIds=${landmarkIdString}
        return axios.post(`/itinerary/${itineraryId}/landmark`, landmarkIdArray)
    },
    deleteItinerary(itineraryId) {
        return axios.delete(`/itinerary/${itineraryId}`)
    },
    createBaseItinerary(itinerary) {
        return axios.post('/itinerary', itinerary)
    },
    updateItineraryDetails(itineraryId, itinerary) {
        return axios.put(`/itinerary/${itineraryId}`, itinerary)
    },
    getLandmarksByItinerary(itineraryId) {
        return axios.get(`/itinerary/${itineraryId}/landmark`)
    }

}