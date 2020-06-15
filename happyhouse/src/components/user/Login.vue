<template>
    <v-row align="center" class="fill-height" justify="center">
        <div class="register elevation-14 w-50">
            <h3 class="mt-3 font-weight-bold text-center py-3 black--text">
                로 그 인
            </h3>
            <v-form class="pa-5 text-center" ref="form">
                <v-text-field :rules="idRules" cla
                ss="pl-3 pr-3" label="Id" prepend-icon="mdi-lock"
                            required type="text" v-model="User.uId">
                        </v-text-field>
                <v-text-field :rules="pwRules" cla
                ss="pl-3 pr-3" label="Password" prepend-icon="mdi-lock"
                            required type="password" v-model="User.uPw">
                        </v-text-field>
                <v-btn :loading="loadingState" @click="userLogin" class="mt-3" color="indigo" outlined>
                            Login
                        </v-btn>
            </v-form>
        </div>
    </v-row>
</template>

<script>
//import {router} from "../../router/index";
//import axios from 'axios';
export default {
    name: 'Login',
    data() {
        return{
            dialog: false,
            User: {
                uId: '',
                uPw: '',
            }
        }
    },
}
</script>