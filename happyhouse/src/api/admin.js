import axios from "axios";

const config = {
    baseUrl: 'http:localhost:9999/api/user'
}

function validateAdmin() {
    return axios.head(`${config.baseUrl}/validate`);
}

function queryMembers() {
    return axios.get(`${config.baseUrl}/users`);
}


export {
    validateAdmin,
    queryMembers
}