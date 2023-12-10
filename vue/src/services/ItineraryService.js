import axios from 'axios';

export default {
    getAllItineraries(userId) {
        return axios.get(`/itinerary/${userId}`);
    }
}