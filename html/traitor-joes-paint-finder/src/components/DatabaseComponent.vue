<template>
  <div class="database-component">
    <div class="grid-container">
      <div v-for="paint in paints" :key="paint.id" class="box-container">
        <div class="box" :style="{ backgroundColor: paint.hexCode }"></div>
        <div class="paint-info">
          <p class="paint-name">{{ paint.paintName }}</p>
          <p class="paint-brand">{{ paint.brandName }}</p>
          <p class="hex-code">{{ paint.hexColorCode }}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "DatabaseComponent",
  props: {
    searchQuery: {
      type: String,
      required: true,
    },
  },
  data() {
    return {
      paints: [],
      // Add your data properties here
    };
  },
  mounted() {
    this.fetchData();
  },
  methods: {
    // Add your methods for interacting with the Java application and PostgreSQL here
    // Include the search query in the request
    // Update the 'paints' data property with the received results
    fetchData() {
      let url = "";
      if (this.searchQuery) {
        // Perform search by name
        url = `http://localhost:8080/paint/paints?search-name=${encodeURIComponent(
          this.searchQuery
        )}`;
      } else {
        // Fetch all paints
        url = "http://localhost:8080/paint/all";
      }

      // Make the API request
      axios
        .get(url)
        .then((response) => {
          this.paints = response.data.map((paint) => ({

            paintName: paint.paintName,
            brandName: paint.brandName,
            hexColorCode: paint.hexColorCode,
          }));
        })
        .catch((error) => {
          console.error(error);
        });
    },
  },
};
</script>

<style scoped>
.database-component {
  /* Add your styles for the component here */
}
.grid-container {
  display: grid;
  grid-template-columns: repeat(
    3,
    1fr
  ); /* Adjust the number of columns as needed */
  grid-gap: 10px; /* Adjust the gap between boxes as needed */
}

.box-container {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.box {
  width: 100px;
  height: 100px;
  border: 1px solid #000;
}

.paint-info {
  text-align: center;
}

.paint-name {
  font-weight: bold;
  color:white
}

.paint-brand {
  color: white;
}

.hex-code {
  font-size: 12px;
  color: white;
}
</style>
