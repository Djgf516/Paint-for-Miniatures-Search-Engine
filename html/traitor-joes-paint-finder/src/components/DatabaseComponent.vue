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
import paintService from "../paintService";
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
    // Call the paintService to fetch data
    fetchData() {
      paintService
        .getPaints(this.searchQuery)
        .then((paints) => {
          this.paints = paints;
        })
        .catch((error) => {
          console.error(error);
        throw error;
          // Handle the error
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
  background-color: #000;
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
  font-size: 1.75vh;
  color: white;
}

.hex-code {
  font-size: 12px;
  color: white;
}
</style>
