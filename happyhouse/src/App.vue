<template>
  <div>
    <v-app>
      <Header/>
      <v-content>
        <v-container fluid>
          
          <router-view/>
        </v-container>
      </v-content>
      <Footer/>
      <Modal/>
    </v-app>
  </div>
</template>

<script>
import Header from '@/components/Header';
import Modal from '@/components/Modal';
import Footer from '@/components/Footer';
export default {
  name: 'App',

  components: {
    Header,
    Modal,
    Footer,
  },

  data: () => ({
    //
  }),
};
</script>