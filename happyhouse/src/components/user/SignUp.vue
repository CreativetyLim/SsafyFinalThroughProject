<template>
    <v-container fluid>
        <v-text-field class="pl-3 pr-3" :rules="nameRules" required v-model="User.uName"
                    label="Name" type="text" prepend-icon="mdi-Name">   
        </v-text-field>
        <v-text-field class="pl-3 pr-3" :rules="nameRules" required v-model="User.uName"
                    label="성별" type="text" prepend-icon="mdi-email">   
        </v-text-field>
        <v-text-field class="pl-3 pr-3" :rules="nameRules" required v-model="User.uName"
                    label="Name" type="text" prepend-icon="mdi-email">   
        </v-text-field>
        <v-text-field class="pl-3 pr-3" :rules="nameRules" required v-model="User.uName"
                    label="Name" type="text" prepend-icon="mdi-email">   
        </v-text-field>
        <v-text-field class="pl-3 pr-3" :rules="nameRules" required v-model="User.uName"
                    label="Name" type="text" prepend-icon="mdi-email">   
        </v-text-field>
        <v-text-field class="pl-3 pr-3" :rules="nameRules" required v-model="User.uName"
                    label="Name" type="text" prepend-icon="mdi-email">   
        </v-text-field>
        <v-text-field class="pl-3 pr-3" :rules="nameRules" required v-model="User.uName"
                    label="Name" type="text" prepend-icon="mdi-email">   
        </v-text-field>
    </v-container fluid>
</template>

<script>
import axios from 'axios';
export default {
    name: 'SignUp',
    data() {
        return{
            user {
                uId : '',
                uPw : '',
                reuPw : '',
                uName : '',
                uGender : '',
                uTel : '',
                uAddr : ''
            }
        }
    },
    methods: {
        testBtn(){
            axios.get('http://localhost:9999/happyhouse/api/qna/selectAll')
            .then(res => {
                this.qnaDatas = res.data;
            }).catch(e => {
                console.error(e)
            })
        }
    }
}
</script>