import axios from "axios";

const inst = axios.create({
    baseURL: 'http://localhost:8080'
})

export const requestApi = {
    singIn(userData){
        return inst.post('/newUser', userData).then(response => response.data)
    }
}