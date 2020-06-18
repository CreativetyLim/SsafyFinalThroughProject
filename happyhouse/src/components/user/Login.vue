<template>
    <v-row align="center" class="fill-height mt-5" justify="center">
        <div class="register elevation-14 w-50">
            <h3 class="mt-3 font-weight-bold text-center py-3 black--text">
                로 그 인
            </h3>
            <v-form class="pa-5 text-center" ref="form" @submit.prevent="onSubmit(uId, uPw)">
                <v-text-field cla
                ss="pl-3 pr-3" label="Id" prepend-icon="mdi-lock"
                            required type="text" v-model="uId">
                        </v-text-field>
                <v-text-field cla
                ss="pl-3 pr-3" label="Password" prepend-icon="mdi-lock"
                            required type="password" v-model="uPw">
                        </v-text-field>
                <v-btn type="submit" class="mt-3" color="indigo" outlined>
                            Login
                        </v-btn>
            </v-form>
        </div>
        <b-alert variant="danger" :show="showAlert">{{ errMsg }}</b-alert>
    </v-row>
</template>

<script>
export default {
    name: 'Login',
    data() {  
        return { 
            User: {
                uId: '',
                uPw: '',
            },
            msg: '',
            showAlert: false,
            errMsg: ''
        } 
    },
    // methods: {
    //     onSubmit(){
    //         this.$store.dispatch('LOGIN', {User})
    //             .then(() => this.redirect())
    //             .catch(({message}) => this.msg = message)
    //         },
    //         redirect(){
    //             const {search} = window.location
    //             const tokens = search.replace(/^\?/, '').split('&')
    //             const {returnPath} = tokens.reduce((qs, tkn) => {
    //             const pair = tkn.split('=')
    //             qs[pair[0]] = decodeURIComponent(pair[1])
    //             return qs
    //         }, {})

    //         this.$router.push(returnPath)
    //     }
    // },
}
</script>