<template>
<v-container>
<div style="text-align:center;">
    <div id = "title">
        <h1 v-if="stage==2">결승</h1>
        <h1 v-else>{{stage}} 강전</h1>
        <h3>마음이 가는 사용자를 선택해주세요</h3>
    </div>
    <div id = "face-img">
    <img :src="getProfile(this.save[this.round])" @click="selectT" :class="{'selected':isTop, 'no-selected':!isTop}" />
    <h2>VS</h2>
    <img :src="getProfile(this.save[this.round+1])" @click="selectB" :class="{'selected':isBottom, 'no-selected':!isBottom}"/>
    </div>
    <v-btn id="nextBtn" rounded text large dark @click="goNext">{{this.btnText}}</v-btn>
    <v-snackbar v-model="alert" Bottom flat color="black" rounded="pill" :timeout="1500">
      <span class="snackText">
        한명을 선택해주세요
      </span>
    </v-snackbar>
</div>
</v-container>
</template>

<script>
export default {
    data(){
        return{
            alert: false,
            btnText : "다음",
            stage : 8,
            round : 0,
            isTop : false,
            isBottom : false,
            users : [
                {userId:"id0", profile : "jaein1.png", idx : 0},
                {userId:"id1", profile : "jaein2.png", idx : 1},
                {userId:"id2", profile : "jaein3.png", idx : 2},
                {userId:"id3", profile : "jaein4.png", idx : 3},
                {userId:"id4", profile : "jaein5.png", idx : 4},
                {userId:"id5", profile : "jaein6.png", idx : 5},
                {userId:"id6", profile : "jaein7.png", idx : 6},
                {userId:"id7", profile : "jaein8.png", idx : 7}
            ],
            save : [0,1,2,3,4,5,6,7]
        }
    },
    
    methods: {
        selectT() {
            this.isTop = true;
            this.isBottom = false;
        },
        selectB() {
            this.isTop = false;
            this.isBottom = true;
        },
        goNext() {
            if(!this.isTop && !this.isBottom){
                this.alert = true;
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

            if(this.stage == 1){ // 상세 페이지로
                let userId = this.users[this.save[0]].userId
                console.log(userId)
                this.$router.push(`/faceFinal/${userId}`);
            }
            
        },
        getProfile(i){
            return require("@/assets/" + this.users[i].profile)
        }
    }
}
</script>


<style scoped>
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
}

img {
    width:160px;
    height:160px;
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
