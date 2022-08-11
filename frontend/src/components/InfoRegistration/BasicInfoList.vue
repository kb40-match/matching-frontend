<template>
    <v-container>
        <div style="text-align:center;">
            <v-progress-linear
                v-model="percent"
                color="#8452f7"
                height="25"
                rounded
            >
                <template v-slot:default="{ value }">
                    <strong>{{ Math.ceil(value) }}%</strong>
                </template>
            </v-progress-linear>
            <div style="margin-bottom:20px;">
                <h1>나의 {{items[num]}} </h1>
            </div>
            <!-- <div style="display:flex;"> -->
                <div style="display:flex; justify-content: center; align-items: center;">
                    <input v-if="num==0" id="text-form" v-model="nickname" placeholder="닉네임을 입력하세요.">
                    <input v-if="num==1" id="text-form" v-model="job" placeholder="직업을 입력하세요.">
                    <div v-if="num==2" style="display:flex">
                        <v-col>
                        <v-row><span>1위</span> <div id="consume-form">{{user.consume_ptn1}}</div></v-row>
                        <v-row style="margin-top:30px;"><span>2위</span> <div id="consume-form">{{user.consume_ptn2}}</div></v-row>
                        <v-row style="margin-top:30px;"><span>3위</span> <div id="consume-form">{{user.consume_ptn3}}</div></v-row>
                        </v-col>
                    </div>
                    <div v-if="num==3" id="assets-form">{{user.assets}} </div> <span v-if="num==3">원</span>
                    <div v-if="num==4" id="assets-form">{{user.invest_prop}} </div>
                    <div style="width:250px;">
                    <v-select v-if="num==5" v-model="hobby" :items="hobbyItems" style="font-size:20px;">
                    </v-select>
                    </div>
                </div>
                <!-- <span><h1>입니다.</h1></span> -->
            <!-- </div> -->
            <div>
                <v-btn text rounded dark large style="background-color:#8452f7; width:60%; font-size:20px;">다음</v-btn>
            </div>
        </div>
    </v-container>
</template>

<script>
export default {
    data() {
        return{
            percent : 0,
            user:{
                consume_ptn1 : "식비", 
                consume_ptn2 : "월세", 
                consume_ptn3 : "의류비",
                assets : "2,000,000,000",
                invest_prop : "공격적"
            },
            hobbyItems : ["스포츠/피트니스", "어학", "재테크/투자", "요리/음료/맛집", "교양/전시회", "게임/코딩/프로그래밍", "음악/악기", "사진/영상제작", "패션/뷰티", "공에/DIY", "미술/캘리그라피", "연기/춤", "기타"],
            num : 5,
            items : ["닉네임은", "직업은", "소비패턴TOP3는", "총 자산은", "투자성향은", "취미는"],
            nickname : "",
            job : "",
            hobby:"",
        }
    },
    methods:{
        
    }
}
</script>

<style scoped>
#text-form{
    border:2px solid;
    border-radius: 20px;
    height:70px;
    text-align: center;
    font-size:30px;
}
#consume-form{
    border: 1px solid;
    border-radius: 20px;
    font-size:30px;
    font-weight:bold;
    width:200px;
    margin-left:10px;
}

span{
    font-size:30px;
    font-weight:bold
}

#assets-form{
    border: 1px solid;
    border-radius: 20px;
    font-size:30px;
    font-weight:bold;
    padding:10px;
    margin-right:10px;
    width:240px;
}

#hobby-form{
    font-size:30px;
}

</style>