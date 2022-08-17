<template>
  <div>
    <v-navigation-drawer
      v-if="!$vuetify.breakpoint.smAndUp"
      v-model="drawer"
      :clipped="$vuetify.breakpoint.lgAndUp"
      app
      dark
      style="background-color: #f1f3f5"
    >
      <div style="padding-top: 50px">
        <v-col>
          <p id="top">연결고리</p>
          <v-btn text id="under" style="margin-top: 5px" @click="goHome()"
            >연결고리 홈</v-btn
          >
        </v-col>
        <hr />
        <v-col>
          <p id="top">내 정보</p>
          <v-btn
            text
            id="under"
            style="margin-top: 5px; margin-bottom: 5px"
            @click="goInfo()"
            >정보 재등록</v-btn
          >
          <v-btn text id="under" style="margin-bottom: 5px" @click="goPrefer()"
            >성향 재파악</v-btn
          >
          <v-btn text id="under" @click="goRequestList()">매칭 요청목록</v-btn>
        </v-col>
        <hr />
        <v-col>
          <p id="top">매칭서비스</p>
          <v-btn
            text
            id="under"
            style="margin-top: 5px; margin-bottom: 5px"
            @click="goFace()"
            >외모로 연결</v-btn
          >
          <v-btn text id="under" @click="goMind()">마음으로 연결</v-btn>
        </v-col>
      </div>
    </v-navigation-drawer>

    <v-app-bar
      v-if="this.store.user"
      :clipped-left="$vuetify.breakpoint.lgAndUp"
      app
      color="#845ef7"
      elevate-on-scroll
      flat
      style="padding-top: 10px; height: 73px !important"
    >
      <v-container :class="{ 'px-0': !$vuetify.breakpoint.smAndUp }">
        <v-row
          :no-gutters="!$vuetify.breakpoint.smAndUp"
          align="center"
          justify="space-between"
        >
          <!-- Header Title -->
          <div
            v-if="page == 'Main'"
            style="margin-left: 5px; display: flex; align-items: center"
          >
            <img
              style="
                width: 40px;
                height: 40px;
                border-radius: 100%;
                margin-right: 10px;
              "
              :src="getImg(this.store.user.profileFilename)"
            />
            <div style="color: white; font-size: 18px">
              {{ this.store.user.nickname }} 님
            </div>
          </div>

          <div
            v-if="page == 'MyDataAgree'"
            style="margin-left: 5px; display: flex; align-items: center"
          >
            <div style="color: white; font-size: 18px; margin-left: 10px">
              약관 동의
            </div>
          </div>

          <div
            v-if="page == 'BasicInfoList'"
            style="margin-left: 5px; display: flex; align-items: center"
          >
            <div style="color: white; font-size: 18px; margin-left: 10px">
              기본정보 등록
            </div>
          </div>

          <div
            v-if="page == 'PreferenceQuestion'"
            style="margin-left: 5px; display: flex; align-items: center"
          >
            <div style="color: white; font-size: 18px; margin-left: 10px">
              성향 파악
            </div>
          </div>

          <div
            v-if="page == 'RequestList'"
            style="margin-left: 5px; display: flex; align-items: center"
          >
            <v-icon dark large @click="goHome()">mdi-home</v-icon>
            <div style="color: white; font-size: 18px; margin-left: 10px">
              매칭 요청목록
            </div>
          </div>

          <div
            v-if="page == 'FaceSelect'"
            style="margin-left: 5px; display: flex; align-items: center"
          >
            <v-icon dark large @click="goHome()">mdi-home</v-icon>
            <div style="color: white; font-size: 18px; margin-left: 10px">
              외모로 연결
            </div>
          </div>

          <div
            v-if="page == 'MindQuestion'"
            style="margin-left: 5px; display: flex; align-items: center"
          >
            <v-icon dark large @click="goHome()">mdi-home</v-icon>
            <div style="color: white; font-size: 18px; margin-left: 10px">
              마음으로 연결
            </div>
          </div>

          <div
            v-if="page == 'MatchDetail'"
            style="margin-left: 5px; display: flex; align-items: center"
          >
            <v-icon dark large @click="goBack()">mdi-chevron-left</v-icon>
            <div style="color: white; font-size: 18px; margin-left: 10px">
              상세 정보
            </div>
          </div>
          <div
            v-if="page == 'ChatRoom'"
            style="margin-left: 5px; display: flex; align-items: center"
          >
            <v-icon dark large @click="goBack()">mdi-chevron-left</v-icon>
            <div style="color: white; font-size: 18px; margin-left: 10px">
              채팅하기
            </div>
          </div>

          <!-- List, Menu -->
          <v-col
            v-if="
              page == 'Main' ||
              page == 'RequestList' ||
              page == 'FaceSelect' ||
              page == 'MindQuestion'
            "
            class="d-flex align-center"
            style="justify-content: flex-end"
          >
            <v-icon
              style="color: white; margin-right: 5px"
              @click="goRequestList"
              >mdi-bell</v-icon
            >
            <v-app-bar-nav-icon
              v-if="!$vuetify.breakpoint.mdAndUp"
              @click.stop="drawer = !drawer"
              style="color: white"
            />
            <v-toolbar-title
              class="font-weight-bold text-h5 primary--text"
              style="cursor: pointer"
              @click="$router.push('/')"
            >
            </v-toolbar-title>
          </v-col>

          <v-col v-if="$vuetify.breakpoint.mdAndUp" cols="6">
            <v-btn
              v-for="(item, i) in barItems"
              :key="`k3-${i}`"
              :to="item.to"
              class="text-capitalize"
              exact
              exact-active-class="accent--text"
              text
              >{{ item.title }}
            </v-btn>
          </v-col>

          <v-col v-if="$vuetify.breakpoint.mdAndUp" class="text-right">
            <v-btn
              v-for="(item, i) in btnItems"
              :key="`k4-${i}`"
              :color="item.color"
              :href="item.href"
              :outlined="item.outlined"
              :target="item.target"
              :to="item.to"
              class="ml-3 text-capitalize"
            >
              <v-icon left>{{ item.icon }}</v-icon>
              {{ item.text }}
            </v-btn>
          </v-col>
        </v-row>
      </v-container>
    </v-app-bar>
  </div>
</template>

<script>
import { useAppStore } from "../../store/userState";
import { loadUser } from "@/worker/user";

export default {
  name: "MenuBar",
  setup() {
    const store = useAppStore();
    return { store };
  },
  props: {
    page: String,
  },
  data: () => ({
    drawer: null,
    btnItems: [
      {
        text: "연결고리",
        target: "_black",
        color: "primary",
        icon: "mdi-download",
      },
    ],
    barItems: [
      {
        title: "홈",
        to: "/",
      },
      {
        title: "외모로 연결",
        to: "/faceSelect",
      },
      {
        title: "마음으로 연결",
        to: "/mindQuestion",
      },
      {
        title: "요청 목록",
        to: "/requestList",
      },
    ],
  }),
  methods: {
    getImg(filename) {
      return require("@/assets/" + filename);
    },
    goRequestList() {
      this.$router.push("/requestList").catch(() => {});
    },
    goHome() {
      this.$router.push("/").catch(() => {});
    },
    goBack() {
      this.$router.go(-1);
    },
    goInfo() {
      this.$router.push({ name: "BasicInfoList", params: { prev: "main" } });
    },
    goPrefer() {
      this.$router.push("/preferenceQuestion").catch(() => {});
    },
    goFace() {
      this.$router.push("/faceSelect").catch(() => {});
    },
    goMind() {
      this.$router.push("/mindQuestion").catch(() => {});
    },
  },
  created() {
    loadUser(localStorage.getItem("userId"));
  },
};
</script>

<style>
.v-toolbar__content {
  padding: 0px;
}

#under {
  font-size: 23px;
  padding-left: 0px;
  color: black;
}

#top {
  font-size: 27px;
  color: #5f3dc4;
  font-weight: bold;
}

hr {
  margin: 10px;
}
</style>
