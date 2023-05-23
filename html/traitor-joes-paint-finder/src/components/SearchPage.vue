<template>
  <div class="container">
    <div class="background-image"></div>
    <div class="logo">
      <!-- logo here-->
      <img src="../assets/Banner2.png" alt="Logo" />
    </div>
    <div class="search-bar">
      <div class="brand-filter">
        <select id="brand-select" v-model="selectedBrand" @change="search">
          <option value="">All Brands</option>
          <option v-for="brand in brands" :key="brand" :value="brand">
            {{ brand }}
          </option>
        </select>
      </div>
      <span class="separator">|</span>
      <input type="text" v-model="searchQuery" placeholder="e.g. AbbadonBlack" />
    </div>
    <button @click="search">Search</button>
    <database-component
      v-if="showDatabaseComponent"
      ref="databaseComponent"
      :searchQuery="searchQuery"
      :brandFilter="selectedBrand"
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
      selectedBrand: "", // Initially set to empty for All Brands
      showDatabaseComponent: false, // Initially set to false
      searchResults: [], // Array to store search results
      brands: ["Citadel", "Vallejo Game", "Vallejo Model", "Army Painter", "P3 Formula"], // Add your list of brands here
    };
  },
  methods: {
    search() {
      this.showDatabaseComponent = false; // Hide the database component

      // Clear the search results from the previous search
      this.searchResults = [];

      // Implement your search logic here
      console.log("Search query:", this.searchQuery);
      console.log("Brand filter:", this.selectedBrand);

      // Perform your search operation based on the search query
      // For example, you can filter the data from your database component based on the search query
      // Wait for a second to all results to load
      setTimeout(() => {
        this.showDatabaseComponent = true;
      }, 500);
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
  min-height: 100vh;
  background-color: black;
}

.logo {
  margin-bottom: 20px;
}
.logo img {
  width: auto; /* Adjust the width as needed */
  height: 200%; /* Adjust the height as needed */
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
  pointer-events: none; /* Making sure that the image cannot be interacted with */
}

.search-bar {
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: row;
  position: relative; /* Add position relative */
  z-index: 1; /* Set a higher z-index value */
}

.brand-filter {
  display: flex;
  align-items: center;
}
#brand-select {
  font-size: 100%;
  color: #333;
 
  padding: 8px;
  border-radius: 10px; /* Adjust the value to change the level of rounding */
}

.separator {
  font-size: 3vh;
  display: flex;
  margin: 0 10px;
  color: white;
  font-weight: bold;
}

input[type="text"] {
  padding: 8px;
  font-size: 1.75vh;
  border-radius: 10px;
}

button {
  margin-top: 10px;
  padding: 10px 20px;
  font-size: 1.75vh;
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 10px;
}
</style>