<template>
  <div class="wrapper">
    <div style="margin: 15px">
      <h3 style="margin-top: 30px; margin-bottom: 10px; font-size: 16px">
        마이데이터 수집·이용 동의
      </h3>
      <v-divider></v-divider>
      <h2 style="margin-top: 30px; font-size: 20px">
        마이데이터 수집·이용 동의하고<br />연결고리 서비스를 시작해 보세요.
      </h2>
      <div id="box-agree">
        <div class="text-center">
          <v-dialog v-model="dialog" width="500">
            <template v-slot:activator="{ on, attrs }">
              <v-btn
                v-if="isAgreed"
                id="agreeBtn"
                color="#7048e8"
                v-on:click="selectAgree"
                fab
                x-small
                ><v-icon color="white"> mdi-check </v-icon></v-btn
              >
              <v-btn
                v-else
                id="agreeBtn"
                color="#AEAEAE"
                fab
                x-small
                v-bind="attrs"
                v-on:click="selectAgree"
                v-on="on"
                ><v-icon color="white"> mdi-check </v-icon></v-btn
              >
            </template>

            <v-card>
              <v-card-title class="text-h5 grey lighten-2"
                >Privacy Policy</v-card-title
              >
              <v-card-text>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
                eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
                enim ad minim veniam, quis nostrud exercitation ullamco laboris
                nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor
                in reprehenderit in voluptate velit esse cillum dolore eu fugiat
                nulla pariatur. Excepteur sint occaecat cupidatat non proident,
                sunt in culpa qui officia deserunt mollit anim id est laborum.
              </v-card-text>
              <v-divider></v-divider>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn
                  color="primary"
                  text
                  @click="
                    dialog = false;
                    isAgreed = true;
                  "
                >
                  I accept
                </v-btn>
              </v-card-actions>
            </v-card>
          </v-dialog>
        </div>
        <h3 style="font-size: 16px; margin-left: 20px">전체 동의</h3>
      </div>

      <v-divider></v-divider>

      <div id="box-agreeText">
        <v-btn
          v-if="isAgreed"
          color="#000000"
          plain
          fab
          text
          x-small
          v-on:click="selectAgree"
          ><v-icon>mdi-check</v-icon></v-btn
        >
        <v-btn
          v-else
          color="#AEAEAE"
          plain
          fab
          text
          x-small
          v-on:click="selectAgree"
          ><v-icon>mdi-check</v-icon></v-btn
        >
        <h3
          id="agreeText"
          v-on:click="displayAgreeText"
          style="font-size: 16px; margin-left: 20px"
        >
          마이데이터 수집·이용 동의(필수) >
        </h3>
      </div>
    </div>

    <div id="bottomBtn">
      <v-btn
        class="white--text"
        block
        color="#7048e8"
        v-on:click="goNextPage"
        style="height: 60px; font-size: 18px"
        >동의하고 시작</v-btn
      >
    </div>
  </div>
</template>

<script>

import { useAppStore } from '../../store/userState'

export default {
  setup() {
        const store = useAppStore()
        return { store }
  },
  data() {
    return {
      dialog: false,
      user: null,
      isAgreed: 0,
    };
  },
  methods: {
    selectAgree() {
      this.isAgreed = !this.isAgreed
    },
    displayAgreeText() {
      this.dialog = !this.dialog
    },
    goNextPage() {
      this.store.user.agreeFlag = "Y"
      // this.$router.push("/basicInfoList").catch(() => {});
      this.$router.push("/preferenceQuestion").catch(() => {}); // TODO: change path into "/basicInfoList"
    }
  }
};
</script>

<style scoped>
.wrapper {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  height: 100vh;
}

#box-agree {
  margin-top: 50px;
  display: flex;
  flex-direction: row;
  align-items: center;
  margin-bottom: 20px;
}

#box-agreeText {
  display: flex;
  flex-direction: row;
  align-items: center;
  margin-top: 16px;
}

#bottomBtn {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  transform: translateY(-100%); /*  FIXME: it should be modified after remove MenuBar  */
}
</style>