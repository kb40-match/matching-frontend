import Vue from 'vue'
import VueRouter from 'vue-router'
import Main from '../components/Main'
import FaceSelect from '../components/face-matching/FaceSelect'
import FaceFinal from '../components/face-matching/FaceFinal'

Vue.use(VueRouter);

export default new VueRouter({
    mode: "history",
    routes: [
        {
            path: "/",
            component: Main
        },
        {
            path: "/faceSelect", 
            name: "FaceSelect",
            component: FaceSelect
        },
        {
            path: "/faceFinal",
            name: "FaceFinal", 
            component: FaceFinal
        }
    ]
})