<template>
  <div style="margin-left: 20px; margin-right: 20px">
    <h1 id="guideText">유저 ID를 입력해주세요!</h1>

    <div id="box-main">
      <input
        id="text-field-userid"
        v-model="userId"
        @keydown.enter="onSubmitForm"
        placeholder="ID를 입력하세요."
      />
      <h5 id="textFieldGuide">
        user1~200 사이의 형태로 입력해주세요. ex) user23
      </h5>
      <v-btn
        text
        rounded
        large
        id="loginBtn"
        @click="onSubmitForm"
        style="background-color: #845ef7"
        >로그인</v-btn
      >
    </div>

    <v-snackbar
      v-model="alert"
      top
      flat
      color="#f1f3f5"
      rounded="pill"
      :timeout="1500"
      style="margin-top: 70px; font-size: 20px"
    >
      <span id="alertMessage">
        {{ this.message }}
      </span>
    </v-snackbar>
  </div>
</template>

<script>
import { useAppStore } from "../../store/userState";
import { loadUser, loadMydata } from "../../worker/user";

export default {
  setup() {
    const store = useAppStore();
    return { store };
  },
  data() {
    return {
      userId: "",
      alert: false,
      message: "user1~200 사이의 형태로 입력해주세요.",
    };
  },
  methods: {
    async onSubmitForm() {
      if (this.check()) {
        this.userId =this.userId.substring(0, 4) + parseInt(this.userId.substring(4, this.userId.length));
        localStorage.setItem("userId", this.userId);
        await loadUser(localStorage.getItem("userId"));
        await loadMydata(localStorage.getItem("userId"));
        this.$router.push("/myDataAgree").catch(() => {});
      } else {
        this.alert = true;
      }
    },
    check() {
      if (
        this.userId.substring(0, 4) === "user" &&
        parseInt(this.userId.substring(4, this.userId.length)) <= 200
      ) {
        console.log(parseInt(this.userId.substring(4, this.userId.length)));
        return true;
      } else {
        return false;
      }
    },
  },
};
</script>

<style scoped>
#guideText {
  text-align: center;
  font-weight: normal;
  font-size: 24px;
  margin-top: 150px;
  margin-bottom: 30px;
}

#box-main {
  display: flex;
  flex-direction: column;
  margin-top: 100px;
}

#text-field-userid {
  height: 50px;
  display: flex;
  justify-content: center;
  align-items: center;
  background: #dee2e6;
  border-radius: 5px;
  padding-left: 15px;
  padding-right: 15px;
}

#textFieldGuide {
  font-size: 12px;
  color: #495057;
}

#loginBtn {
  margin-top: 50px;
  color: white;
  font-size: 20px;
}
</style>
