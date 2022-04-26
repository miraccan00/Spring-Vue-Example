<template>
  <div>
    <div v-if="showSuccess">İşlem Başarılı</div>
    <div>
      <alert show dismissible variant="danger" v-if="errors.length > 0">
        <span v-for="error in errors" :key="error"> {{ error }} , </span>
      </alert>
    </div>
    <div class="form">
      <form v-on:submit.prevent="submitForm">
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
          <label for="city_code">City Area</label>
          <input
            type="text"
            class="form-control"
            id="city_code"
            placeholder="City Code"
            v-model="form.areaName"
          />
        </div>
        <div class="form-group">
          <button class="btn btn-primary mt-2">Submit</button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "AddCity",
  data() {
    return {
      cities: [],
      errors: [],
      showSuccess: false,
      form: {
        cityName: "",
        districtName: "",
        cityCode: "",
        areaName: "",
      },
    };
  },
  methods: {
    submitForm() {
      this.errors = [];
      if (!this.form.cityName) {
        this.errors.push("City Name required");
      }
      if (!this.form.districtName) {
        this.errors.push("District Name required");
      }
      if (!this.form.cityCode) {
        this.errors.push("City Code required");
      }
      // form validation

      axios
        .post("http://localhost:8080/api/adresses/v1/add-adress", this.form)
        .catch((error) => {
          // error.response.status Check status code
          this.errors.push(error);
          alert(error);
        })
        .then(() => {
          this.form.cityName = "";
          this.form.districtName = "";
          this.form.cityCode = "";
        });
    },
  },
};
</script>

<style>
</style>