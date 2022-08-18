<template>
  <div v-if="this.store.user">
    <MenuBar page="Main" :transparent="false" />
    <div
      id="box-main"
      style="
        height: 200px;
        /* background-color: #845ef7; */
        padding: 5px 15px 15px 15px;
      "
    >
      <div style="height: 70%; padding: 5px; text-align: center">
        <p style="font-size: 30px; font-weight: bold; color: white">
          {{ addComma(this.store.user.userPoint) }} P
        </p>
        <p style="font-size: 25px; color: white">
          총 {{ this.store.user.matchCount }}회 매칭되었어요 !
        </p>
      </div>
      <div style="display: flex; justify-content: center">
        <v-btn id="main-btn" class="mr-5" @click="reInfo()">정보 재등록</v-btn>
        <v-btn id="main-btn" @click="rePrefernce()">성향 재파악</v-btn>
      </div>
    </div>
    <v-col style="cursor: pointer">
      <v-row id="match" @click="goFaceMatching">
        <!-- <div style="width: 35%; display:flex;align-items: center; justify-content:center;"><img src="../assets/purpleheart.png" /></div> -->
        <div
          style="
            width: 100%;
            text-align: center;
            font-size: 40px;
            font-weight: bold;
          "
        >
          외모로 연결
        </div>
      </v-row>

      <v-row id="match" @click="goMindMatching" style="cursor: pointer">
        <div
          style="
            width: 100%;
            text-align: center;
            font-size: 40px;
            font-weight: bold;
          "
        >
          마음으로 연결
        </div>
        <!-- <div style="width: 35%; display:flex;align-items: center; justify-content:center;"><img src="../assets/purpleheart.png" /></div> -->
      </v-row>

      <v-row id="sub">
        <v-col id="chat" @click="goChat()">
          <div class="d-flex mb-2" style="justify-content: center">
            <!-- <div style="width: 25px; height: 25px"></div> -->
            <img id="img2" src="../assets/icons/chat2.png" />
            <!-- <div id="chat-count">5</div> -->
          </div>
          <div style="font-size: 25px; font-weight: bold; cursor: pointer">
            대화하기
          </div>
        </v-col>
        <v-col id="service" @click="goService()">
          <div class="d-flex mb-2" style="justify-content: center">
            <img id="img2" src="../assets/icons/service2.png" />
          </div>
          <div style="font-size: 25px; font-weight: bold; cursor: pointer">
            사후서비스
          </div>
        </v-col>
      </v-row>
    </v-col>
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
    <!-- <div class="bottom_menu">
      <div>
        <v-icon large>mdi-home-variant</v-icon>
      </div>
      <div>
        <v-icon large>mdi-chat</v-icon>
      </div>
      <div>
        <v-icon large>mdi-list-box</v-icon>
      </div>
      <div>
        <v-icon large>mdi-account</v-icon>
      </div>
    </div> -->
  </div>
</template>

<script>
import MenuBar from "./_common/MenuBar";
import { useAppStore } from "@/store/userState";
import { loadUser } from "@/worker/user";

export default {
  name: "Main",
  components: {
    MenuBar,
  },
  setup() {
    const store = useAppStore();
    return { store };
  },
  data: () => ({
    matchId: "",
    alert: false,
    message: "",
  }),
  methods: {
    goFaceMatching() {
      console.log(this.matchId);
      if (this.matchId) {
        this.message = "이미 대화중인 상대가 있어요!";
        this.alert = true;
      } else this.$router.push("/faceSelect").catch(() => {});
    },
    goMindMatching() {
      if (this.matchId) {
        this.message = "이미 대화중인 상대가 있어요!";
        this.alert = true;
      } else this.$router.push("/mindQuestion").catch(() => {});
    },
    addComma(price) {
      price = price + "";
      var regexp = /\B(?=(\d{3})+(?!\d))/g;
      return price.toString().replace(regexp, ",");
    },
    reInfo() {
      this.$router.push({ name: "BasicInfoList", params: { prev: "main" } });
    },
    rePrefernce() {
      this.$router.push("/preferenceQuestion").catch(() => {});
    },
    getMatchId() {
      this.$axios
        .get(
          `http://matching.169.56.100.104.nip.io/match/matching/matchId/${this.store.user.userId}`,
        )
        .then((response) => {
          this.matchId = response.data;
        });
    },
    goChat() {
      if (this.matchId !== "false") {
        this.$router.push("/chat").catch(() => {});
      } else {
        this.message = "매칭된 상대가 없습니다 :(";
        this.alert = true;
      }
    },
    goService() {
      this.message = "준비중입니다.";
      this.alert = true;
    },
  },
  created() {
    loadUser(localStorage.getItem("userId"));
    this.getMatchId();
  },
};
</script>

<style>
#match {
  border-radius: 10px;
  height: 150px;
  padding: 13px;
  margin: 20px;
  display: flex;
  align-items: center;
  box-shadow: 0 0 15px 0 rgba(0, 0, 0, 0.2);
  background-color: white;
  /* background:linear-gradient(to right bottom, #7950f2, #b197fc); */
  /* background-image: linear-gradient(-225deg, #5271C4 0%, #B19FFF 48%, #ECA1FE 100%); */
}
#sub {
  margin: 20px;
  display: flex;
  align-items: center;
  margin-top: 20px;
}

#chat {
  border-radius: 10px;
  margin-right: 10px;
  text-align: center;
  padding-top: 20px;
  padding-bottom: 20px;
  box-shadow: 0 0 15px 0 rgba(0, 0, 0, 0.2);
  margin-right: 30px;
  background-color: white;
}
#service {
  border-radius: 10px;
  text-align: center;
  padding-top: 20px;
  padding-bottom: 20px;
  box-shadow: 0 0 15px 0 rgba(0, 0, 0, 0.2);
  background-color: white;
}

img {
  width: 90px;
  height: 90px;
}

#img2 {
  width: 70px;
  height: 70px;
}
#chat-count {
  font-weight: bold;
  display: flex;
  align-items: center;
  justify-content: center;
  border: 1px solid;
  border-radius: 100%;
  width: 25px;
  height: 25px;
}

#box-main {
  background: linear-gradient(-270deg, #5271c4 0%, #b19fff 48%, #eca1fe 100%);
}

.bottom_menu {
  position: fixed;
  bottom: 0px;
  left: 0px;
  width: 100%;
  height: 80px;
  z-index: 100;
  border-top: 1px solid gray;
  background-color: white;
}
.bottom_menu > div {
  float: left;
  width: 25%;
  height: 100%;
  display: flex;
  text-align: center;
  justify-content: center;
}

#main-btn {
  width: 42%;
  font-size: 20px;
  height: 50px;
  border-radius: 15px;
  background-color: #f3f0ff;
  cursor: pointer;
}

p {
  margin: 0px !important;
}

.snack-bar {
  align-items: center;
  margin-top: 70px;
  font-size: 20px;
  text-align: center;
}

.snack-text {
  text-align: center;
  display: flex;
  justify-content: center;
}
</style>
