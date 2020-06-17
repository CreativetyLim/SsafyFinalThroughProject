<template>
    <v-footer app class="theme--dark" fixed><span class="mx-auto">Copyright © {{new Date() | moment('YYYY')}} SSAFY 광주 200조.</span>
    </v-footer>
</template>

<script>
    export default {
        name: "Footer"
    }
</script>

<style scoped>
</style>