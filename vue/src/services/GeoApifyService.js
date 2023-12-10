import axios from "axios";

// This URI is the base used for doing a geocode search using location addresses
const geoCoderUri = '/v1/geocode/search';

// This URI is the base used for finding the route between 2+ location coordinates
const routingUri = '/v1/routing?waypoints=';

// Example get request URL for getting route between two places: https://api.geoapify.com/v1/routing?waypoints=39.127973,-84.524567|39.1429225,-84.5090381&mode=drive&apiKey=YOUR_API_KEY


const geoapify = axios.create({
    baseURL: import.meta.env.VITE_GEOAPIFY_BASE_URL
});

export default {
    getRoutes(startingLocationCoordinates, landmarksArray) {

        return Promise.all(landmarksArray.map(landmark => {
            let requestUrl = (
                //import.meta.env.VITE_GEOAPIFY_BASE_URL + 
                routingUri +
                startingLocationCoordinates.startingLocationLat +
                ',' +
                startingLocationCoordinates.startingLocationLong +
                '|' + 
                landmark.landmarkLatitude +
                ',' +
                landmark.landmarkLongitude + 
                '&mode=drive' +
                '&units=imperial' +
                '&apiKey=' + import.meta.env.VITE_GEOAPIFY_API_KEY
            );
        
            //requestUrl = 'https://api.geoapify.com/v1/routing?waypoints=39.127973,-84.524567|39.1429225,-84.5090381&mode=drive&apiKey=a97e169c03ef43108e1e05b4a0cc2d4e';
            return geoapify.get(requestUrl);
        }));

    }, 
    getRoute() {
        return geoapify.get(
            'https://api.geoapify.com/v1/routing?waypoints=50.96209827745463%2C4.414458883409225%7C50.429137079078345%2C5.00088081232559&mode=drive&apiKey=' + import.meta.env.VITE_GEOAPIFY_API_KEY
        );
    }
}