import axios from "axios";

const config = {
    baseUrl: 'http://localhost:9999/happyhouse/api/user'
}
function requestJoinMember(User) {
    // User.uId = User.uId;
    // User.uPw = User.uPw;
    // User.uName = User.uName;
    // User.uTel = User.uTel;
    // User.uAddr = User.uAddr;
    // User.uGender = User.uGender;
    console.dir(User);

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
    return axios.get(`${config.baseUrl}/api/users`);
}

export {
    requestLogin,
    requestJoinMember,
    queryMember
}