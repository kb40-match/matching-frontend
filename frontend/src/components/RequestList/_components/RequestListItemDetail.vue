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
      <v-btn text rounded small dark style="background-color:#8452f7" class="mr-5" @click="beforeAccept()">수락</v-btn>
      <v-btn text rounded small dark style="background-color:#8452f7" @click="beforeReject()">거절</v-btn>
    </v-row>


    <v-row justify="center">
    <v-dialog
      v-model="this.dialog"
      persistent
      max-width="290"
    >
      <v-card>
        <v-card-title >
          요청을 {{cardType}}하시겠습니까?
        </v-card-title>
        <v-card-text></v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn
            v-if="cardType=='수락'"
            color="#5f3dc4"
            text
            @click="accept()"
          >
            예
          </v-btn>
          <v-btn
           v-if="cardType=='거절'"
            color="#5f3dc4"
            text
            @click="reject()"
          >
            예
          </v-btn>
          <v-btn
            color="#5f3dc4"
            text
            @click="dialog = false"
          >
            아니오
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-row>
  </dl>
  
</template>

<script>
import dayjs from "dayjs";
import { useAppStore } from '../../../store/userState'

export default {
  name: "RequestListItemDetail",
  setup(){
        const store = useAppStore()
        return {store}
    },
  data(){
    return{
      dialog:false,
      cardType:"수락",
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
    beforeAccept(){
      this.cardType="수락"
      this.dialog = true
    },
    accept(){
      this.match = {activeFlag : "1", createdDate : dayjs().format("YYYYMMDDHHmmss"), sender: this.contents.userId, receiver: this.store.user.userId  }
      this.$axios.put(`/matching/accept`,this.match)
      .then((response)=>{
          // this.$router.go();  // 새로고침
          this.getUser()
      }).catch((err)=>{
        console.log(err.response)
      })
    },
    getUser(){
      this.$axios.get(`/user/${this.contents.userId}`)
      .then((response)=>{
        let senderUser = response.data
        senderUser.matchCount = senderUser.matchCount+1
        this.setCount(senderUser)
      })

      this.$axios.get(`/user/${this.store.user.userId }`)
      .then((response)=>{
        let receiverUser = response.data
        receiverUser.matchCount = receiverUser.matchCount+1
        this.setCount(receiverUser)
      })
      
    },
    setCount(user){
      this.$axios.put(`/user`, user)
      .then((response)=>{
      })
    },
    beforeReject(){
      this.cardType="거절"
      this.dialog = true
    },
    reject(){
      this.match = {activeFlag : "2", createdDate : dayjs().format("YYYYMMDDHHmmss"), sender: this.contents.userId, receiver: this.store.user.userId }
      this.$axios.put(`/matching/reject`,this.match)
      .then((response)=>{
        // this.$router.go(); // 새로고침
      }).catch((err)=>{
        console.log(err.response)
      })
    }
  },
  mounted(){
    this.$axios.get(`/user/mydata/${this.contents.userId}`)
    .then((response)=>{
      this.myData = response.data
      this.items = {
        createdDate : this.makeDate(this.contents.createdDate),
        age : this.myData.age + "세",
        job : this.contents.job,
        address : this.myData.address
      }
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
