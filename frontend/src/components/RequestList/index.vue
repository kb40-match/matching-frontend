<template>
  <div class="screen">
    <MenuBar page="RequestList" />
    <main>
      <!-- <p>지난 요청 목록을 모두 볼 수 있어요.</p> -->
      <RequestListItemToggle @selectedTab="setTab"/>
      <ul v-if="this.selectedTab" >
        <RequestListItem
          v-for="item in this.receiverItems"
          :key="item.userId"
          :item="item"
          :tab="selectedTab"
        />
      </ul>
      <ul v-if="!this.selectedTab">
        <RequestListItem
          v-for="item in this.senderItems"
          :key="item.userId"
          :item="item"
          :tab="selectedTab"
        />
      </ul>
    </main>
  </div>
</template>

<script>
import RequestListItem from "./_components/RequestListItem.vue";
import RequestListItemToggle from "./_components/RequestListItemToggle.vue";
import MenuBar from '../MenuBar.vue'
import { useAppStore } from '../../store/userState'

export default {
  name: "RequestList",
  setup(){
        const store = useAppStore()
        return {store}
  },
  data() {
    return {
      receiverItems: [],
      senderItems: [],
      selectedTab: true,
      selectedItem: -1,
    };
  },
  components: {
    RequestListItem,
    RequestListItemToggle,
    MenuBar
  },
  methods:{
    setTab(val){
      this.selectedTab = val
    }
  },
  async created() {
    await this.$axios.get(`/matching/receivers/${this.store.user.userId}`)
    .then((response)=>{
      this.receiverItems = response.data
    }).catch((err)=>{
      console.log(err.response)
    })

    await this.$axios.get(`/matching/senders/${this.store.user.userId}`)
    .then((response)=>{
      this.senderItems = response.data
    }).catch((err)=>{
      console.log(err.response)
    })
  },
};
</script>

<style lang="scss" scoped>
.screen {
  width: 100vw;
  height: 100vh;
}

h1 {
  margin: 7px 0;
}

p {
  font-weight: 300;
  font-size: 14px;
}

main {
  padding: 0 20px;
}

ul {
  all: unset;
  width: 90%;
  /* position: relative; */
  margin: 0 auto;
  // background-color: violet;
}
</style>
