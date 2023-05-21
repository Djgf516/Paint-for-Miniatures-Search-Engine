<template>
  <div class="container">
    <div class="background-image"></div>
    <div class="logo">
       <!-- Add your logo here-->
      <img src="../assets/Banner2.png" alt="Logo" />
    </div>
    <div class="search-bar">
      <input type="text" v-model="searchQuery" placeholder="Search" />
      <button @click="search">Search</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "SearchPage",
  data() {
    return {
      searchQuery: "",
    };
  },
  methods: {
    search() {
      // Implement your search logic here
      console.log("Search query:", this.searchQuery);
    },
  },
};
</script>

<style>
.container {
  position: relative;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
  background-color: black;
}

.logo {
  margin-bottom: 20px;
}

.background-image {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-image: url("../assets/Background.jpg");
  background-size: cover;
  background-position: center;
  opacity: 0.2;
}

.search-bar {
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
}

input[type="text"] {
  padding: 8px;
  font-size: 16px;
  margin-bottom: 10px;
}

button {
  padding: 10px 20px;
  font-size: 16px;
}

</style>