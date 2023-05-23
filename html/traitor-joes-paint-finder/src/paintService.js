// paintService.js
import axios from "axios";

// Methods for interacting with the Java application and PostgreSQL here
// Include the search query in the request
const paintService = {
    // Update the 'paints' data property with the received results
  getPaints(searchQuery) {
    let url = "";
    if (searchQuery) {
        // Perform search by name
      url = `http://localhost:8080/paint/paints?search-name=${encodeURIComponent(
        searchQuery
      )}`;
    } else {
    // Fetch all paints
      url = "http://localhost:8080/paint/all";
    }

    // Make the API request
    return axios
      .get(url)
      .then((response) => {
        return response.data.map((paint) => ({
          paintName: paint.paintName.split(/(?=[A-Z])/).join(" "), // Add space between words,
          brandName: paint.brandName,
          hexColorCode: paint.hexColorCode,
        }));
      })
      .catch((error) => {
        console.error(error);
        throw error; // Rethrow the error to handle it in the component or other error handling mechanism
      });
  },
};

export default paintService;
