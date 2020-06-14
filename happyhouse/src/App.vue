<template>
  <div>
    <v-app>
      <v-content>
        <Header/>
        <v-container fluid>
          
          <router-view/>

        </v-container>
      </v-content>
    </v-app>
  </div>
</template>

<script>
import Header from '@/components/Header';

export default {
  name: 'App',

  components: {
    Header,
  },

  data: () => ({
    //
  }),
};
</script>