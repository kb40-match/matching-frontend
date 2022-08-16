<template>
<v-container v-if="users.length">
<MenuBar page="FaceSelect" />
<div style="text-align:center;">
    <div id = "title">
        <h1 v-if="stage==2">결승</h1>
        <h1 v-else>{{stage}} 강전</h1>
        <span style="font-size:22px;">마음이 가는 사용자를 선택해주세요!</span>
    </div>
    <div id = "face-img">
    
        <img :src="getProfile(this.save[this.round])" @click="selectT" :class="{'selected':isTop, 'no-selected':!isTop}" />
        <p style="font-size:30px;font-weight:bold">VS</p>
        <img :src="getProfile(this.save[this.round+1])" @click="selectB" :class="{'selected':isBottom, 'no-selected':!isBottom}"/>
    </div> 
    <v-btn id="nextBtn" rounded text large dark @click="goNext" :disabled=check()>{{this.btnText}}</v-btn>
    <!-- <v-snackbar v-model="alert" Bottom flat color="black" rounded="pill" :timeout="1500">
      <span class="snackText">
        한명을 선택해주세요
      </span>
    </v-snackbar> -->
</div>
</v-container>
</template>

<script>
import { useAppStore } from '../../store/userState'
import MenuBar from "../MenuBar.vue";

export default {
    components:{
        MenuBar
    },
    setup(){
        const store = useAppStore()
        return {store}
    },
    data(){
        return{
            myDataFlag : false,
            // alert: false,
            btnText : "다음",
            stage : 8,
            round : 0,
            isTop : false,
            isBottom : false,
            users : [],
            save : [0,1,2,3,4,5,6,7]
        }
    },
    
    methods: {
        selectT() {
            this.isTop = true;
            this.isBottom = false;
        },
        check(){
            if(!this.isTop && !this.isBottom) return true
            return false
        },
        selectB() {
            this.isTop = false;
            this.isBottom = true;
        },
        goNext() {
            if(!this.isTop && !this.isBottom){
                // this.alert = true;
                return;
            }
            
            if(this.isTop){ // 위에 선택하면
                this.save.push(this.save[this.round])
            }else{ // 아래 선택하면
                this.save.push(this.save[this.round+1])
            }

            this.round += 2
            
            if(this.round >=this.stage){
                this.round = 0
                this.save = this.save.slice(this.stage)
                this.stage = this.stage / 2
            }

            if(this.round+2 >= this.stage){
                this.btnText = "다음 라운드"
            }else{
                this.btnText = "다음"
            }

            this.isTop = false
            this.isBottom = false

            if(this.stage == 2){
                this.btnText = "결과보기"
            }

            if(this.stage == 1){ // 상세 페이지로 화면 이동
                let finalUser = this.users[this.save[0]]
                this.$router.push({name: 'FaceFinal', params: {user: finalUser}})
            }
        },
        getProfile(i){
            return require("@/assets/" + this.users[i].profileFilename)
        },
        setIdx(){
            this.users = this.users.map((user, idx) => ({
                ...user, 
                idx,
            }))
        },
        async getRandom(){
            const response = await this.$axios.get(`/user/findRandom/${this.store.myData.gender}`) // ${this.store.myData.gender}!!!!!
            this.users = response.data
            this.setIdx()
        }
    },
    created(){
        this.getRandom()
    }
}
</script>


<style scoped>
h1{
    font-size:50px;
}
#title{
    text-align:center;
    margin-top:10px;
}

#face-img{
    text-align:center;
    margin : 30px;
}

#nextBtn{
    background-color:#8452f7;
    width:70%;
    font-size:24px;
}

img {
    width:200px;
    height:200px;
    border: 5px solid #f3f0ff;
    border-radius: 50%;
     /* filter: brightness(50%); */
     /* opacity:0.2; */
}

.selected{
border: 5px solid #8452f7;
}

.no-selected{
border: 5px solid #f3f0ff;
}
</style>
