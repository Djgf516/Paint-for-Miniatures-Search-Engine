<template>
  <div class="paint-info-selected">
    <h1>Selected Paint</h1>
    <div class="hex-code">
      <div
        class="color-box"
        :style="{ backgroundColor: selectedPaint.hexColorCode }"
      ></div>
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
      if (this.displayMatches) {
        let cleanName = selectedPaint.paintName.replace(/\s/g, "");
        paintService
          .getMatches(cleanName) // Pass the paint name as the search query
          .then((matches) => {
            // Handle the fetched matches
            console.log(matches); // log the matches to the console
          })
          .catch((error) => {
            if (error.response) {
              // error.response exists
              // Request was made, but response has error status (4xx or 5xx)
            } if(error.response.status > 500){
                throw new Error("Response Paint name not found in database");
            }
            
            else if (error.request) {
              // There is no error.response, but error.request exists
              // Request was made, but no response was received
            } else {
              // Neither error.response and error.request exist
              // Request was *not* made
            }
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
