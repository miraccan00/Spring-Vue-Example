<template>
  <div class="hello">
    <div class="row m-5">
      <table class="table">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">City Name</th>
            <th scope="col">District Name</th>
            <th scope="col">City Code</th>
            <th scope="col">City Area</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(item, i) in cities" :key="item.id">
            <th>{{ i }}</th>
            <th>{{ item.cityName }}</th>
            <th>{{ item.districtName }}</th>
            <th>{{ item.cityCode }}</th>
            <th>{{ item.areaName }}</th>
            <th>
              <router-link
                :to="{ name: 'UpdateCity', params: { id: item.id } }"
              >
                Update
              </router-link>
            </th>
            <th>
              <button
                type="submit"
                class="bg-danger"
                @click="deleteTutorial(item.id)"
              >
                Delete
              </button>
            </th>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "HomePage",
  data() {
    return {
      cities: [],
      form: {
        cityName: "",
        districtName: "",
        cityCode: "",
        areaName: "",
      },
    };
  },
  mounted() {
    axios
      .get("http://localhost:8080/api/adresses/v1/get-adresses")
      .then(
        (response) => ((this.cities = response.data), console.log(this.cities))
      );
  },
  methods: {
    deleteTutorial(id) {
      axios
        .post("http://localhost:8080/api/adresses/v1/delete-adress/" + id)
        .then((res) => {
          console.log(res);
        })
        .catch((error) => {
          // error.response.status Check status code
          console.log(error);
        })
        .finally(() => {
          axios
            .get("http://localhost:8080/api/adresses/v1/get-adresses")
            .then(
              (response) => (
                (this.cities = response.data), console.log(this.cities)
              )
            );
        });
    },
  },
};
</script>


