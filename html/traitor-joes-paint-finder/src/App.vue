<template>
  <div id="app">
    <search-page/>
  </div>
</template>

<script>
import SearchPage from './components/SearchPage.vue'

export default {
  name: 'App',
  components: {

    SearchPage
  }
}
</script>

<style>
body {
  margin: 0;
}

#app {
  padding:0;
  margin:0;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
}
</style>
