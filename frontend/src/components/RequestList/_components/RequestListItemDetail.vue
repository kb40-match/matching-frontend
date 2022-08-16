<template>
  <dl style="border-top:1px solid gray; margin-bottom:10px;">
    <div
      class="pair"
      v-for="(item, key, index) in items"
      :key="index"
    > 
    <div class="ml-5"><span style="font-weight:bold">{{title[index]}}</span> {{item}}</div>
    </div>
    <v-row class="pair" style="display:flex; justify-content: center;" v-if="this.contents.activeFlag=='0' && tab == false">
      <v-btn text rounded small dark style="background-color:#8452f7" class="mr-5" @click="accept">수락</v-btn>
      <v-btn text rounded small dark style="background-color:#8452f7" @click="reject">거절</v-btn>
      
    </v-row>
  </dl>
</template>

<script>
import dayjs from "dayjs";

export default {
  name: "RequestListItemDetail",
  data(){
    return{
      items:[],
      myData: [],
      title:[this.getType(this.contents.activeFlag), "나이", "직업", "주소"],
      match:[]
    }
  },
  props: {
    contents: Object,
    tab: Boolean
  },
  methods:{
    getType(flag){
      if(flag=="0"){
        return "요청 시간"
      }else if(flag=="1"){
        return "매칭 시간"
      }else{
        return "종료 시간"
      }
    },
    makeDate(date){
      return date.slice(0,4)+"/"+date.slice(4,6)+"/"+date.slice(6,8)+" "+date.slice(8,10)+":"+date.slice(10,12)+":"+date.slice(12,14)
    },
    accept(){
      this.match = {activeFlag : "1", createdDate : dayjs().format("YYYYMMDDHHmmss"), sender: this.store.user.userId, receiver: this.contents.userId }
      this.$axios.put(`/matching/accept`,this.match)
      .then((response)=>{
        console.log("수락하였습니다.")
      }).catch((err)=>{
        console.log(err.response)
      })
    },
    reject(){
      this.match = {activeFlag : "2", createdDate : dayjs().format("YYYYMMDDHHmmss"), sender: this.store.user.userId, receiver: this.contents.userId }
      this.$axios.put(`/matching/reject`,this.match)
      .then((response)=>{
        console.log("거절하였습니다.")
      }).catch((err)=>{
        console.log(err.response)
      })
    }
  },
  mounted(){
    console.log(this.contents.userId)
    this.$axios.get(`/user/mydata/${this.contents.userId}`)
    .then((response)=>{
      this.myData = response.data

      this.items = {
        createdDate : this.makeDate(this.contents.createdDate),
        age : this.myData.age + "세",
        job : this.contents.job,
        address : this.myData.address
      }
      console.log("mydata : "+this.items)
    }).catch((err)=>{
      console.log(err.response)
    })
  }
};
</script>

<style scoped>
dl {
  height: 160px;
  width: 100%;
  border-top: 1px solid #dcdfe3;
  margin: 10px 0;
  animation: 100ms grow;
}

.pair {
  display: flex;
  justify-content: space-between;
  align-content: center;
  width: 100%;
  /* height: 18px; */
  margin: 5px 0;
}

dt {
  color: #808080;
  font-size: 14px;
}

dd {
  color: #000;
  font-size: 14px;
  font-weight: 700;
}

@keyframes grow {
  0% {
    height: 0;
  }

  100% {
    height: 180px;
  }
}
</style>
