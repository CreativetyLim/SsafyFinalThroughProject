import axios from "axios";

const config = {
    baseUrl: 'http://localhost:9999/happyhouse/api/user'
}
function requestJoinMember(User) {
    return axios.post(`${config.baseUrl}/register`, User);
}

function requestLogin(User) {
    let form = new FormData();

    form.append('uId', User.uId);
    form.append('uPw', User.uPw);

    const requestData = {
        url: `${config.baseUrl}/oauth/token`,
        method: "POST",
        auth: {
            username: process.env.VUE_APP_CLIENTID,
            password: process.env.VUE_APP_CLIENTSECRET,
        },
        data: form
    };
    return axios(requestData);
}

function queryMember() {
    return axios.get(`${config.baseUrl}/api/members`);
}

export {
    requestLogin,
    requestJoinMember,
    queryMember
}