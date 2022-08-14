<template>
  <div class="profile-wrapper">
    <div class="profile-photo-dummy"></div>
    <div class="profile-text">
      <h1>{{ this.user.nickname }}</h1>
      <p>{{ this.user.address }}</p>
    </div>
  </div>
</template>

<script>
import { fetchUser } from "@/worker/user";

export default {
  name: "ChatRoomMyProfile",
  props: {
    // user: {
    //   type: Object,
    //   required: true,
    // },
    userId: {
      type: String,
      required: true,
    }
  },
  async created() {
    this.user = await fetchUser(this.userId);
  },
};
</script>

<style lang="scss" scoped>
.profile-wrapper {
  width: calc(100% - 30px);
  height: 58px;
  margin: 10px auto;
  display: flex;
  align-items: center;
  border-bottom: 1px solid colors.$GRAY3;
}

.profile-photo-dummy {
  width: 40px;
  height: 40px;
  background-color: colors.$GRAY6;
  border-radius: 50%;
  margin-right: 18px;
}

.profile-text {
  h1 {
    margin-bottom: 7px;
    font-weight: 700;
    font-size: 17px;
  }

  p {
    font-weight: 300;
    font-size: 12px;
  }
}
</style>
