<template>
<v-container>
<div>
    <div id="user">
        <div id="user-img"><img src="../../assets/logo.png"/></div>
        <div id="user-info">
            <div style="display:flex; align-items:center;">
                <div style="width:180px;">
                <div style="font-size:20px;">이재인, 20세</div>
                <div style="font-size:15px;"><v-icon small style="color:pink;">mdi-map-marker</v-icon>서울시 여의도</div>
                </div>
                <div id="chat" @click="goChat">
                        <v-icon large style="color:black">mdi-chat</v-icon>
                </div>
            </div>
        </div>
    </div>
    <div style="text-align:center">
        <v-btn rounded text large @click="displayDetail" style="font-size:15px;">상세 정보 보기</v-btn>
        <v-btn rounded text large @click="reMatching" style="font-size:15px;">다시하기(500원)</v-btn>
    </div>
</div>
</v-container>

</template>

<script>
export default {
    methods: {
        displayDetail() {
            console.log("displayDetail")
        },
        reMatching() {
            this.$router.push("/faceSelect").catch(() => {});
        },
        goChat(){
            console.log("goChat")
        }
    }
}
</script>


<style scoped>
button {
    background:rgb(248, 212, 89);
    width:40%;
    margin-right: 10px;
    margin-left: 10px;
    font-size:15px;
}

#user{
    border : 1px solid;
    border-radius: 30px;
    margin : 20px;
    height : 450px;
}
#user-img{
    height:310px; 
    display:flex;
    justify-content: center;
    align-items: center;
}
#user-info{
    border : 1px solid;
    border-radius: 30px;
    height:100px;
    margin:20px;
    padding:20px;
    align-items: center;
    display:flex;
}
#chat{
    width:45px; 
    height:45px; 
    display:flex; 
    align-items:center; 
    justify-content:center; 
    border:1px solid; 
    border-radius:100%;
}
</style>
