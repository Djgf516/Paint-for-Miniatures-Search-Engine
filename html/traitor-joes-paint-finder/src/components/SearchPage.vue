<template>
  <div class="container">
    <div class="background-image"></div>
    <div class="logo">
      <!-- logo here-->
      <img src="../assets/Banner2.png" alt="Logo" />
    </div>
    <div class="search-bar">
      <input type="text" v-model="searchQuery" placeholder="Search" />
      <button @click="search">Search</button>
    </div>
    <database-component
      v-if="showDatabaseComponent"
      ref="databaseComponent"
      :searchQuery="searchQuery"
    ></database-component>
  </div>
</template>

<script>
import DatabaseComponent from "./DatabaseComponent.vue";

export default {
  name: "SearchPage",
  data() {
    return {
      searchQuery: "",
      showDatabaseComponent: false, // Initially set to false
      searchResults: [], // Array to store search results
    };
  },
  methods: {
    search() {
      // Implement your search logic here
      console.log("Search query:", this.searchQuery);

      // Perform your search operation based on the search query
      // For example, you can filter the data from your database component based on the search query
      // Wait for the next tick to ensure the component is mounted
      this.showDatabaseComponent = true;
    },
  },
  components: {
    DatabaseComponent,
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
  pointer-events: none; /* Add this property */
}

.search-bar {
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  position: relative; /* Add position relative */
  z-index: 1; /* Set a higher z-index value */
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