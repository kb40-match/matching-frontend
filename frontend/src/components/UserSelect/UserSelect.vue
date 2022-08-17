<template>
    <div style="margin-left: 20px; margin-right: 20px;">
        <h1 id="guideText">유저 ID를 입력해주세요!</h1>

        <div id="box-main">
            <input id="text-field-userid" v-model="userId" placeholder="ID를 입력하세요." >
            <v-btn text rounded large id="loginBtn" @click="onSubmitForm" style="background-color: #845ef7;">로그인</v-btn>
        </div>
    </div>
</template>

<script>
export default {
    data () {
        return {
            userId: ""
        }
    },
    methods:{
        onSubmitForm() {
            console.log(this.userId)

            // TODO: go to next page
            
        }
    }
}
</script>

<style scoped>



#guideText{
    text-align: center;
    font-weight: normal;
    font-size: 24px;
    margin-top: 30px;
    margin-bottom:30px;
}

#box-main {
    display: flex;
    flex-direction: column;
    margin-top: 50px;
}

#loginBtn {
    margin-top: 50px;
    color: white;
}


</style>
