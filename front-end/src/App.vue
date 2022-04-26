<template>
  <div id="root">
    <NavBar />
    <div class="container">
      <router-view />
      <!-- It's basically the view where the components are rendered.  -->
    </div>
  </div>
</template>


<script>
import NavBar from "./components/NavBar";
export default {
  name: "App",
  components: { NavBar },
};
</script>

