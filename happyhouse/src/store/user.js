import {queryMember, requestJoinMember, requestLogin} from "../api/user";
import {deleteTokenInLocalStorage, setTokenInLocalStorage} from "../util/oauth";
import {deleteAccessTokenInHeader, setSnackBarInfo} from "../api/common";
import {router} from "../router/index";

const state = {
    accessToken: localStorage.getItem('access_token'),
};

const getters = {
    isAuthenticated(state) {
        return !!state.accessToken;
    },
};

function resetToken(state) {
    deleteTokenInLocalStorage();
    deleteAccessTokenInHeader();
    state.accessToken = null;
}

const mutations = {
    LOGIN(state) {
        state.accessToken = localStorage.getItem('access_token');
        router.push('/');
    },
    LOGOUT(state) {
        resetToken(state);
        this.commit('SET_SNACKBAR', setSnackBarInfo('로그아웃 완료', 'success', 'top'));

    },
    LOGOUT_WITH_TOKEN_INVALIDE(state) {
        resetToken(state);
        if (router.currentRoute.name !== 'boards') {
            router.push('/');
        }
    }
};

const actions = {
    async REQUEST_JOIN(context, User) {
        try {
            context.commit('START_LOADING');
            const response = await requestJoinMember(User);
            context.commit('SET_SNACKBAR', setSnackBarInfo('회원가입이 완료되었습니다!', 'info', 'top'));
            context.commit('END_LOADING');
            router.push('/login');
            return response;
        } catch (e) {
            context.commit('END_LOADING');
            context.commit('OPEN_MODAL', {title: '회원가입에 실패', content: e.response.data.message, option1: '닫기',});
        }
    },
    async REQUEST_LOGIN(context, User) {
        try {
            context.commit('START_LOADING');
            const response = await requestLogin(User);
            setTokenInLocalStorage(response.data);

            const getMember = await queryMember();
            context.commit('LOGIN', response.data);
            greetingMember(context, getMember.data);
            context.commit('END_LOADING', response.data);

            return response;
        } catch (e) {
            context.commit('OPEN_MODAL', {title: '로그인 실패', content: '아이디 혹은 비밀번호를 확인해주세요.', option1: '닫기',}
            )
        }
    },
};

const greetingMember = (context, data) => {
    let text = '';
    if (data.role === 'USER') {
        text = `안녕하세요 ${data.name} 님!`;
    } else if (data.role === 'ADMIN') {
        text = `안녕하세요 마스터 님!`;
    }
    context.commit('SET_SNACKBAR', setSnackBarInfo(text, 'info', 'top'));
};


export default {mutations, state, actions, getters};