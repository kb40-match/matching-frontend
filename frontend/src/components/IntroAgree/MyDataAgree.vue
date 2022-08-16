<template>
  <div class="wrapper">
    <MenuBar page="MyDataAgree" />
    <div style="margin-left: 15px; margin-right: 15px">
      <h3 style="margin-top: 30px; margin-bottom: 10px; font-size: 16px">
        마이데이터 수집·이용 동의
      </h3>
      <v-divider></v-divider>
      <h2 style="margin-top: 30px; font-size: 20px"> 마이데이터 수집·이용 동의하고<br />연결고리 서비스를 시작해 보세요.</h2>
      <div id="box-agree">
        <div class="text-center">

          <!-- first dialog box -->
          <v-dialog v-model="dialog" width="500">
            <template v-slot:activator="{ on, attrs }">
              <v-btn
                v-if="isAgreed === true && isPurchaseAgreed === true"
                id="agreeBtn"
                color="#7048e8"
                v-on:click="selectTotalAgree"
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
                v-on:click="selectTotalAgree"
                v-on="on"
                ><v-icon color="white"> mdi-check </v-icon></v-btn
              >
            </template>

            <v-card>
              <v-card-title class="grey lighten-2"
                >"연결고리" 서비스 이용약관</v-card-title
              >
              <v-card-text>
                              제 1 조 (목적)
              이 약관은 주식회사 국민은행(이하 “은행”이라 합니다)과 “은행”이 제공하는 “연결고리서비
              스”(이하 “서비스”라 합니다)를 이용하는 고객(이하 ”이용자” 라 합니다) 사이의 권리, 의무 및 책
              임사항, “서비스” 제공에 관한 제반 사항을 규정함을 목적으로 합니다.제 2 조 (용어의 정의)
              ① 이 약관에서 사용하는 용어의 의미는 다음과 같습니다.
              1. “서비스”라 함은 “이용자”의 “개인신용정보” 전송요구에 따라 은행, 카드, 보험, 증권, 통신
              업권 또는 공공기관 등에 분산된 이용자의 금융정보 등의 “개인신용정보”를 통합하여 제
              공하는 통합조회 서비스, 자산관리 서비스, 지출관리 서비스, 기타 “은행”이 제공하는 서비
              스를 의미합니다.
              2. “이용자”는 이 약관에 따라 “은행”과 이용 계약을 체결하고 “은행”으로부터 “서비스” 이용
              자격을 부여 받은 고객을 의미합니다.
              3. “개인신용정보”란 금융거래 등 상거래에서 개인인 신용정보주체의 신용, 거래내용, 거래능
              력 등을 판단할 수 있는 정보를 말합니다.
              4. “정보제공자”란 『신용정보의 이용 및 보호에 관한 법률』 제33조의2 조에 따라 신용정보를
              전송할 의무가 있으며, 이러한 의무에 따라 “이용자”의 “개인신용정보”를 전송하는 자를
              말합니다.
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

          <!-- second dialog box -->
          <v-dialog v-model="dialog2" width="500">
            <v-card>
              <v-card-title class="grey lighten-2"
                >"연결고리" 인 앱 결제 이용약관</v-card-title
              >
              <v-card-text>
                              제 7 조 (서비스 이용 통지)
                ① “은행”이 “이용자”에 대한 통지를 하는 경우 이 약관에 별도 규정이 없는 한 “이용자”의 이메
                일, 문자 등의 방법으로 통지합니다.
                ② “은행”은 전체 “이용자”에 대하여 통지가 필요한 경우 홈페이지, 모바일 어플리케이션 등에
                게시함으로써 제1항의 통지에 갈음할 수 있습니다. 다만, “이용자”에게 중대한 영향을 미치는
                사항에 대하여는 이메일, 문자 등의 방법으로 개별 통지합니다.

                제 8 조 (이용 수수료)
                ① “은행”은 사용자의 “서비스” 이용에 따른 수수료를 부과할 수 있습니다.
                ② “은행”은 수수료에 관한 사항을 홈페이지 등에 게시합니다.
                ③ “은행”은 수수료를 변경하고자 하는 경우 이 약관 제16조를 준용합니다.
              </v-card-text>
              <v-divider></v-divider>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn
                  color="primary"
                  text
                  @click="
                    dialog2 = false;
                    isPurchaseAgreed = true;
                  "
                >
                  I accept
                </v-btn>
              </v-card-actions>
            </v-card>
          </v-dialog>

        </div>

        <!-- total agree box -->
        <h3 style="font-size: 16px; margin-left: 20px">전체 동의</h3>
      </div>

      <v-divider></v-divider>

      <!-- first agree box -->
      <div id="box-agreeText">
        <v-btn
          v-if="isAgreed"
          color="#000000"
          plain
          fab
          text
          x-small
          v-on:click="selectFirstAgree"
          ><v-icon>mdi-check</v-icon></v-btn
        >
        <v-btn
          v-else
          color="#ced4da"
          plain
          fab
          text
          x-small
          v-on:click="selectFirstAgree"
          ><v-icon>mdi-check</v-icon></v-btn
        >
        <h3
          id="agreeText"
          v-on:click="displayMyDataAgreeText"
          style="font-size: 16px; margin-left: 20px">
          마이데이터 수집·이용 동의 (필수) >
        </h3>
      </div>

        <!-- second agree box -->
       <div id="box-agreeText"> 
        <v-btn
          v-if="isPurchaseAgreed"
          color="#000000"
          plain
          fab
          text
          x-small
          v-on:click="selectSecondAgree"
          ><v-icon>mdi-check</v-icon></v-btn
        >
        <v-btn
          v-else
          color="#ced4da"
          plain
          fab
          text
          x-small
          v-on:click="selectSecondAgree"
          ><v-icon>mdi-check</v-icon></v-btn
        >
        <h3
          id="agreeText"
          v-on:click="displayInAppPurchaseText"
          style="font-size: 16px; margin-left: 20px">
          인 앱 결제 동의 (필수) >
        </h3>
      </div>
    </div>
    <v-spacer></v-spacer>
    <div id="bottomBtn">
      <v-btn
        class="white--text"
        block
        text
        v-on:click="goNextPage"
        style="height: 60px; font-size: 18px; width:100%; background-color:#845ef7 ;"
        :disabled="check()"
        >시작</v-btn
      >
      <!-- <v-snackbar v-model="alert" Bottom flat color="red" rounded="pill" :timeout="1500">
                <span class="snackText"> 동의 후 진행해주세요</span>
      </v-snackbar> -->
    </div>
  </div>
</template>

<script>

import { useAppStore } from '../../store/userState'
import MenuBar from "../MenuBar.vue";

export default {
  components:{
    MenuBar
  }, 
  setup() {
        const store = useAppStore()
        return { store }
  },
  data() {
    return {
      dialog: false,
      dialog2: false,
      user: null,
      // alert: false,
      isAgreed: 0,
      isPurchaseAgreed: 0,
    };
  },
  methods: {
    selectFirstAgree() {
      this.isAgreed = !this.isAgreed
    },
    selectSecondAgree() {
      this.isPurchaseAgreed = !this.isPurchaseAgreed
    },
    selectTotalAgree() {
      if(this.isAgreed && this.isPurchaseAgreed) {
        this.isAgreed = false
        this.isPurchaseAgreed = false
      } else {
        this.isAgreed = true
        this.isPurchaseAgreed = true
      }
    },
    displayMyDataAgreeText() {
      this.dialog = !this.dialog
    },
    displayInAppPurchaseText() {
      this.dialog2 = !this.dialog2
    },
    goNextPage() {
      if(!this.isAgreed) {
        // this.alert = true;
        return;
      }
      else {
        this.store.user.agreeFlag = "Y"
        this.$router.push("/basicInfoList").catch(() => {});
      }
    },
    check(){
      if(!this.isAgreed) return true
      return false
    }
  }
};
</script>

<style scoped>
.wrapper {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  height: 100%;
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
}
</style>