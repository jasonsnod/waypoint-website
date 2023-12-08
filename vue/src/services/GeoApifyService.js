import axios from "axios";

// This URI is the base used for doing a geocode search using location addresses
const geoCoderUri = '/v1/geocode/search';

// Example get request URL for getting route between two places: https://api.geoapify.com/v1/routing?waypoints=39.127973,-84.524567|39.1429225,-84.5090381&mode=drive&apiKey=YOUR_API_KEY
const routingUri = 'v1/routing?waypoints='

const geoapify = axios.create({
    baseURL: import.meta.env.VITE_GEOAPIFY_BASE_URL
});

export default {

}