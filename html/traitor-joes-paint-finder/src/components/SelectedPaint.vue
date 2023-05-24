<template>
  <div class="paint-info-selected">
    <h1>Selected Paint</h1>
    <div class="hex-code">
      <div class="color-box" :style="{ backgroundColor: selectedPaint.hexColorCode }"></div>
    </div>
    <p class="paint-code">{{ selectedPaint.hexColorCode }}</p>
    <p class="paint-name">{{ selectedPaint.paintName }}</p>
    <p class="paint-brand">{{ selectedPaint.brandName }}</p>

    <label>
      <input
        type="checkbox"
        v-model="displayMatches"
        @change="fetchMatches(selectedPaint)"
      />
      Display matches
    </label>
  </div>
</template>

<script>
import paintService from "../paintService";
export default {
  name: "SelectedPaint",
  props: {
    selectedPaint: {
      type: Object,
      required: true,
    },
  },
  data() {
    return {
      displayMatches: false,
    };
  },
  methods: {
    fetchMatches(selectedPaint) {
      if (this.displayMatches)  {
        paintService
          .getMatches(selectedPaint.id) // Replace with the appropriate method and parameters for fetching matches
          .then((matches) => {
            matches;
            // Handle the fetched matches
          })
          .catch((error) => {
            console.error(error);
            throw error;
          });
      }
    },
  },
};
</script>

<style scoped>
.paint-info-selected {
  position: fixed;
  top: 20px;
  left: 20px;
  width: 200px;
  background-color: #000;
  border: 2px solid white;
  padding: 10px;
}

.paint-info-selected h1 {
  color: white;
  margin: 5px 0;
}

.paint-info-selected p {
  color: white;
  margin: 5px 0;
}

.paint-info-selected label {
  color: white;
  display: block;
  margin-top: 10px;
}



</style>
