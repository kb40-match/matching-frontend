<template>
<div>
    <div class = "position1">
        <img src="../../assets/logo.png" v-on:click="selectUser" />
    </div>
    <div>
        <button type="button" @click="displayDetail">상세 정보 보기</button>
        <button type="button" @click="reMatching">다시하기(500원)</button>
    </div>
</div>

</template>

<script>
export default {
    methods: {
        selectUser() {
            console.log("haha")
        },
        displayDetail() {
            console.log("haha")
        },
        reMatching() {
            this.$router.push("/faceSelect").catch(() => {});
            }
    }
}
</script>


<style scoped>
img {
    border: 5px solid rgb(215, 213, 71);
}
button {
    background:rgb(215, 213, 71);
    color: gray;
}
.position1{
  background:gray;
  position:static;
  left:100px;
  top:100px;
  z-index:10;
}
</style>
