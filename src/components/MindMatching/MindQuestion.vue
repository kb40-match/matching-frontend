<template>
  <div>
    <MenuBar page="MindQuestion" />
    <v-dialog v-model="loading" fullscreen>
      <v-container
        fluid
        fill-height
        style="background-color: rgba(255, 255, 255, 0.5)"
      >
        <v-layout justify-center align-center>
          <v-progress-circular indeterminate color="primary">
          </v-progress-circular>
        </v-layout>
      </v-container>
    </v-dialog>

    <div
      class="quiz-main"
      v-for="(element, index) in questionList.slice(a, b)"
      :key="index"
      style="margin: 20px"
    >
      <div id="steps">
        <v-avatar v-if="a >= 1" color="#845ef7" style="margin-right: 10px">
          <v-icon dark> mdi-check </v-icon></v-avatar
        >
        <v-avatar v-else id="step1" color="#DDDDDD" style="margin-right: 10px"
          >1</v-avatar
        >

        <v-avatar v-if="a >= 2" color="#845ef7" style="margin-right: 10px">
          <v-icon dark> mdi-check </v-icon></v-avatar
        >
        <v-avatar v-else id="step2" color="#DDDDDD" style="margin-right: 10px"
          >2</v-avatar
        >

        <v-avatar v-if="a >= 3" color="#845ef7" style="margin-right: 10px">
          <v-icon dark> mdi-check </v-icon></v-avatar
        >
        <v-avatar v-else id="step3" color="#DDDDDD" style="margin-right: 10px"
          >3</v-avatar
        >
      </div>

      <h2 id="guideText">매칭 전 몇 가지만 확인할게요!</h2>

      <div style="height: 200px">
        <h1 id="questionText">{{ element.questionContent }}</h1>
      </div>
      <div id="box-answers" style="padding-bottom: 50px">
        <div
          id="box-answer"
          @click="selectLeftAnswer"
          :class="{ selected: clickedLeft, 'no-selected': !clickedLeft }"
        >
          {{ element.answerContent1 }}
        </div>
        <div
          id="box-answer"
          @click="selectRightAnswer"
          :class="{ selected: clickedRight, 'no-selected': !clickedRight }"
        >
          {{ element.answerContent2 }}
        </div>
      </div>
      <div style="text-align: center">
        <v-btn
          v-if="a > 0"
          text
          @click="goPrevQuestion"
          rounded
          dark
          style="
            height: 50px;
            font-size: 24px;
            width: 120px;
            background-color: #845ef7;
            margin-right: 5px;
          "
          >이전</v-btn
        >
        <v-btn
          text
          @click="goNextQuestion"
          rounded
          :disabled=check()
          dark
          style="
            height: 50px;
            font-size: 24px;
            width: 120px;
            background-color: #845ef7;
            margin-left: 5px;
          "
          >다음</v-btn
        >
      </div>
    </div>
  </div>
</template>

<script>
import { useAppStore } from "@/store/userState";
import { loadResultFromAI } from "@/worker/user";
import MenuBar from "../_common/MenuBar.vue";
import { API_URL_BASE } from "@/worker/user";

export default {
  setup() {
    const store = useAppStore();
    return { store };
  },
  components: {
    MenuBar,
  },
  data() {
    return {
      a: 0,
      b: 1,
      loading: false,
      clickedLeft: false,
      clickedRight: false,
      questionList: [],
      choices: [],
    };
  },
  methods: {
    selectLeftAnswer() {
      this.clickedLeft = !this.clickedLeft;
      if (this.clickedRight) {
        this.clickedRight = !this.clickedRight;
      }
    },
    selectRightAnswer() {
      this.clickedRight = !this.clickedRight;
      if (this.clickedLeft) {
        this.clickedLeft = !this.clickedLeft;
      }
    },
    goPrevQuestion() {
      this.a--;
      this.b--;
    },
    goNextQuestion() {
      this.clickedLeft = false;
      this.clickedRight = false;
      if (this.b >= 3) {
        loadResultFromAI(localStorage.getItem("userId")); // get 5 user and myData objects
        this.loading = true;

        setTimeout(() => {
          this.loading = false;
          this.$router.push("/mindMatchingList").catch(() => {});
        }, 3000);
      } else {
        this.a++;
        this.b++;
      }
    },
    check(){
            if(!this.clickedLeft && !this.clickedRight){
                return true
            }else
                return false
    }
  },
  beforeMount() {
    this.$axios
      .get(`${API_URL_BASE}/match/question/findAll`)
      .then((response) => {
        this.questionList = response.data;
      })
      .catch((err) => {
        console.log(err.response);
      });
  },
};
</script>

<style lang="scss" scoped>
#steps {
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 0 10px;
  margin-top: 80px;
  margin-bottom: 40px;
  font-size: 16px;
  color: white;
}

#step1 {
  color: white;
}

#step2 {
  color: white;
}

#step3 {
  color: white;
}

#guideText {
  text-align: center;
  font-weight: normal;
  font-size: 18px;
  padding-bottom: 30px;
  color: colors.$GRAY7;
}

#questionText {
  text-align: center;
  font-size: 24px;
  font-weight: 600;
}

#box-answers {
  text-align: center;
  margin-bottom: 30px;
  display: flex;
  justify-content: center;
}

#box-answer {
  width: 170px;
  height: 170px;
  margin: 0 5px;
  border: 1px solid;
  word-break: break-all;
  font-size: 20px;
  padding: 2px;
  display: flex;
  align-items: center;
  justify-content: center;
  transition: background-color 100ms;
  cursor: pointer;
  border-radius: 5px;
}

#nextBtn {
  color: white;
  font-size: 24px;
}

.selected {
  background-color: colors.$GRAY5;

  &:hover {
    background-color: colors.$GRAY5;
  }
}

.no-selected {
  background-color: colors.$GRAY2;

  &:hover {
    background-color: rgba(colors.$GRAY1, 80%);
  }
}
</style>
