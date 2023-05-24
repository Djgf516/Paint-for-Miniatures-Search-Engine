<template>
  <div class="database-component">
    <div class="grid-container">
      <div
        v-for="paint in paints"
        :key="paint.id"
        class="box-container"
        @click="selectPaint(paint)"
      >
        <div class="box" :style="{ backgroundColor: paint.hexCode }"></div>
        <div class="paint-info">
          <div class="hex-code">
            <div
              class="color-box"
              :style="{ backgroundColor: paint.hexColorCode }"
            ></div>
          </div>
          <p class="paint-code">{{ paint.hexColorCode }}</p>
          <p class="paint-name">{{ paint.paintName }}</p>
          <p class="paint-brand">{{ paint.brandName }}</p>
        </div>
      </div>
    </div>
    <SelectedPaint v-if="selectedPaint" :selectedPaint="selectedPaint" />
  </div>
</template>

<script>
import paintService from "../paintService";
import SelectedPaint from "./SelectedPaint.vue";

export default {
  name: "DatabaseComponent",
  components: {
    SelectedPaint,
  },
  props: {
    searchQuery: {
      type: String,
      required: true,
    },
  },
  data() {
    return {
      paints: [],
      selectedPaint: null,
      displayMatches: false,
      // Add your data properties here
    };
  },
  mounted() {
    this.fetchData();
  },
  methods: {
    // Call the paintService to fetch data
    fetchData() {
      //Remove any spaces from the query
      const cleanedQuery = this.searchQuery.replace(/\s/g, "");
      paintService
        .getPaints(cleanedQuery)
        .then((response) => {
          this.paints = response;
        })
        .catch((error) => {
          console.error(error);
          throw error;
          // Handle the error
        });
    },
    selectPaint(paint) {
      this.selectedPaint = paint;
    },
  },
};
</script>

<style>
.database-component {
  /* Add your styles for the component here */
}
.grid-container {
  display: grid;
  grid-template-columns: repeat(
    5,
    1fr
  ); /* Adjust the number of columns as needed */
  grid-gap: 10px; /* Adjust the gap between boxes as needed */
}

.box-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: #000;
  /* border: 1px solid white;(for testing purposes)*/
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
  font-size: 2vh;
  font-weight: bold;
  color: white;
}

.paint-brand {
  font-size: 1.75vh;
  color: white;
}
.paint-code {
  font-size: 1.75vh;
  color: white;
}

.hex-code {
  font-size: 1.5vh;
  color: white;
  margin-top: 5px;
  position: relative;
  display: flex;
  align-items: center;
  justify-content: center;
}

.color-box {
  width: 10vh;
  height: 10vh;
  background-color: white;
  box-shadow: 0 0 0 3px white, 0 0 0 1px #000;
  z-index: 1;
}

.code {
  font-size: 1.5vh;
}
</style>
