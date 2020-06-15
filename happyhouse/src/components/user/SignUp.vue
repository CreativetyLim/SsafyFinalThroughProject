<template>
    <v-row align="center" class="fill-height" justify="center">
        <div class="register elevation-14 w-50">
            <h3 class="mt-3 font-weight-bold text-center py-3 black--text">
                회 원 가 입
            </h3>
            <v-form class="pa-5 text-center" ref="form">
                <v-text-field :rules="nameRules" cla
                ss="pl-3 pr-3" label="Name" prepend-icon="mdi-account"
                            required type="text" v-model="User.uName">
                        </v-text-field>
                <v-text-field :rules="idRules" cla
                ss="pl-3 pr-3" label="Id" prepend-icon="mdi-lock"
                            required type="text" v-model="User.uId">
                        </v-text-field>
                <v-text-field :rules="pwRules" cla
                ss="pl-3 pr-3" label="Password" prepend-icon="mdi-lock"
                            required type="password" v-model="User.uPw">
                        </v-text-field>
                <v-text-field :rules="repwRules" cla
                ss="pl-3 pr-3" label="Confirm Password" prepend-icon="mdi-lock"
                            required type="password" v-model="User.reuPw">
                        </v-text-field>
                <v-radio-group v-model="User.uGender" prepend-icon="mdi-account-multiple" row>
                    <v-icon left medium></v-icon>
                    <v-label prepend-icon="mdi-account-multiple">Gender</v-label>
                    <v-radio label="남성" value="m" class="text-center"></v-radio>
                    <v-radio label="여성" value="w" class="text-center"></v-radio>
                </v-radio-group>
                <v-text-field :rules="telRules" cla
                ss="pl-3 pr-3" label="Tel" prepend-icon="mdi-phone"
                            required type="text" v-model="User.uTel" placeholder="01012341234">
                        </v-text-field>
                <v-btn :loading="loadingState" @click="userRegister" class="mt-3" color="indigo" outlined>
                            REGISTER
                        </v-btn>
            </v-form>
        </div>
    </v-row>
</template>

<script>
//import {router} from "../../router/index";
//import axios from 'axios';
export default {
    name: 'SignUp',
    data() {
        return{
            dialog: false,
            User: {
                uId: '',
                uPw: '',
                reuPw: '',
                uName: '',
                uGender: '',
                uTel: '',
                uAddr: ''
            }
        }
    },
}
</script>