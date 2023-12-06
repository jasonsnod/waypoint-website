import axios from "axios";
//import.meta.env.VITE_REMOTE_API;


const http = axios.create({
    baseURL: import.meta.env.VITE_REMOTE_API
    
})

export default{
    getAllLandmarks(){
        return http.get("/landmark")
    }
}