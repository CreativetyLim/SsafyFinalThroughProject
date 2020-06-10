<template>
  <div id="app">
    <!--<HelloWorld msg="Welcome to Your Vue.js App"/>-->
    <Header/>
    <router-view id="contain"/>
  </div>
</template>

<script>
//import HelloWorld from './components/HelloWorld.vue'
import Header from       './components/Header.vue'

export default {
  name: 'App',
  components: {
    Header,
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
#contain{
  width: 94%;
  margin-left: auto;
  margin-right: auto;
}
</style>
