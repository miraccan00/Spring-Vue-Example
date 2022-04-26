<template>
  <div class="form">
    <h1>Update Page</h1>
    <form v-on:submit.prevent="updateForm">
      <div class="form-group">
        <label for="city_name">City Name</label>
        <input
          type="text"
          class="form-control"
          id="city_name"
          placeholder="City name"
          v-model="form.cityName"
        />
      </div>
      <div class="form-group">
        <label for="district_name">District Name</label>
        <input
          type="text"
          class="form-control"
          id="district_name"
          placeholder="District Name"
          v-model="form.districtName"
        />
      </div>
      <div class="form-group">
        <label for="city_code">City Code</label>
        <input
          type="text"
          class="form-control"
          id="city_code"
          placeholder="City Code"
          v-model="form.cityCode"
        />
      </div>

      <div class="form-group">
        <button class="btn btn-primary mt-2">Submit</button>
      </div>
    </form>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "UpdateCity",

  data() {
    return {
      cities: [],
      uniqid: this.$route.params.id,
      form: {
        cityName: "",
        districtName: "",
        cityCode: "",
      },
    };
  },
  methods: {
    async updateForm() {
      await axios
        .post(
          "http://localhost:8080/api/adresses/v1/update-adress/" + this.uniqid,
          this.form
        )
        .then((res) => {
          this.$router.push("/listitem");
          console.log(res);
        })
        .catch((error) => {
          // error.response.status Check status code
          console.log(error);
        });
    },
  },
};
</script>

<style>
</style>