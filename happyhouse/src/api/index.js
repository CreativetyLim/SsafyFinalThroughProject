import axios from 'axios'

const config= {
    baseUrl: 'http://localhost:9999/happyhouse/api/'
}

async function requestRegisterUser(User){
    return axios.post(`${config.baseUrl}/user/register`);
}
