<template>
  <div class="more-wrapper">
    <div class="row-recommendations">
      <div class="recommendation" @click="goRecommend">관심사 추천</div>
      <div class="recommendation" @click="goRecommend">장소 추천</div>
    </div>
    <button type="button" class="leave" @click="leaveChatRoom">
      대화 종료
    </button>

    <v-snackbar
      v-model="alert"
      top
      flat
      color="#f1f3f5"
      rounded="pill"
      :timeout="1500"
      class="snack-bar"
    >
      <span class="snack-text">
        {{ message }}
      </span>
    </v-snackbar>
  </div>
</template>

<script>
import { rejectChat } from "../../../worker/user"
import { useAppStore } from "@/store/userState";
import { loadMatchObject } from "../../../worker/user";
 
export default {
  setup() {
    const store = useAppStore();
    return { store };
  },
  data() {
    return {
      name: "ChatRoomMoreContent",
      message: "",
      alert: false,
    }
  },  
  methods: {
    leaveChatRoom() {

      // call reject
      this.store.match.activeFlag = 2
      rejectChat()

      this.$router.push('/');
    },
    goRecommend() {
      console.log("goRecommend")
      this.message = "준비중입니다.";
      this.alert = true;
    }
  },
  async created() {
    // fetch match object
      console.log(localStorage.getItem("userId"))
      await loadMatchObject(localStorage.getItem("userId"))
  }
};
</script>

<style lang="scss" scoped>
.more-wrapper {
  position: absolute;
  width: 100%;
  height: 200px;
  bottom: 0;
  padding: 15px 0;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-content: center;
  background-color: colors.$GRAY2;
  animation: growUp 150ms;

  .row-recommendations {
    width: 100%;
    height: 100px;
    display: flex;
    justify-content: center;
    align-content: center;

    .recommendation {
      display: flex;
      justify-content: center;
      align-items: center;
      width: 100px;
      height: 100px;
      margin: 0 5px;
      border: 1px solid colors.$GRAY9;
      border-radius: 10px;
      transition: background-color 100ms;
      cursor: pointer;

      &:hover {
        background-color: rgba(colors.$WHITE, 45%);
      }
    }
  }
  button.leave {
    width: 210px;
    height: 40px;
    margin: 0 auto;
    margin-top: 10px;
    border-radius: 10px;
    background-color: colors.$CAUTION;
    color: colors.$GRAY2;
    transition: background-color 100ms;
    cursor: pointer;

    &:hover {
      background-color: rgba(colors.$CAUTION, 85%);
    }
  }
}

@keyframes growUp {
  from {
    height: 0;
  }

  to {
    height: 200px;
  }
}
</style>
