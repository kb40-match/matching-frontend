<template>
  <div class="wrapper" :style="cssVariables">
    <div class="chat-input-wrapper">
      <AddSVG class="chat-add-icon" @click="toggleMore" />
      <input
        type="textarea"
        placeholder="메세지를 입력하세요."
        @input="updateText($event)"
        @keyup.enter="confirmText($event)"
        ref="textInput"
      />
      <SendSVG class="chat-send-icon" @click="confirmText" />
    </div>
    <ChatRoomMoreContent v-if="showMore" />
  </div>
</template>

<script>
import AddSVG from "@/assets/icons/add.svg";
import SendSVG from "@/assets/icons/send.svg";
import ChatRoomMoreContent from "./ChatRoomMoreContent.vue";

export default {
  name: "ChatRoomMessageInput",
  data() {
    return {
      text: "",
      showMore: false,
    };
  },
  computed: {
    cssVariables() {
      return {
        height: this.showMore ? "250px" : "40px",
      };
    },
  },
  methods: {
    toggleMore() {
      this.showMore = !this.showMore;
    },
    updateText(event) {
      this.text = event.target.value;
    },
    confirmText() {
      this.$emit("sentMessageContent", this.text);
      this.text = "";
      this.$refs.textInput.value = "";
    },
  },
  components: {
    AddSVG,
    SendSVG,
    ChatRoomMoreContent,
  },
  mounted() {
    this.$refs.textInput.focus();
  },
};
</script>

<style lang="scss" scoped>
.wrapper {
  position: absolute;
  bottom: 0;
  height: var(height);
  transition: height 150ms;
}
.chat-input-wrapper {
  width: 100%;
  height: 60px;
  display: flex;
  justify-content: center;
  background-color: colors.$GRAY2;
  z-index: 51;
}

svg {
  transform: scale(-50%);
  border-radius: 50%;
  transition: background-color 100ms;
  cursor: pointer;

  &:hover {
    background-color: colors.$GRAY3;
  }
}

button {
  width: 40px;
  height: 40px;
  margin: 10px 0;
  all: unset;
  cursor: pointer;
  transition: background-color 100ms;

  &:hover {
    background-color: #fefefe;
    border-radius: 50%;
  }
}

input[type="textarea"] {
  border: none;
  height: 28px;
  width: calc(100% - 70px);
  margin-bottom: 0;
  margin-top: 10px;
  margin-right: 12px;
  padding-left: 10px;
  border-radius: 10px;
  background-color: colors.$GRAY3;
  font-size: 14px;

  &:focus {
    outline: none;
  }
}
</style>
