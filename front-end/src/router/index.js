import { createWebHistory, createRouter } from "vue-router";
import HomePage from "@/views/HomePage";
import AddCity from "@/views/AddCity";
import UpdateCity from "@/views/UpdateCity";
import ListCity from "@/views/ListCity";

const routes = [
    {
        path: "/",
        name: "HomePage",
        component: HomePage,
    },
    {
        path: "/additem",
        name: "AddCity",
        component: AddCity,
    },
    {
        path: "/listitem",
        name: "ListCity",
        component: ListCity,
    },
    {
        path: '/:id',
        name: "UpdateCity",
        component: UpdateCity
    },


];

const router = createRouter({
    mode: history,
    history: createWebHistory(),
    routes,
});

export default router;