<template>
<div>
    <h1>8강전 1라운드</h1>
    <h2>마음이 가는 사용자를 선택해주세요</h2>
    <img class = "userA" src="../../assets/logo.png" v-on:click="selectUser" />
    <h1>VS</h1>
    <img class = "userB" src="../../assets/logo.png" v-on:click="selectUser" />
    <p></p>
    <button type="button" @click="goNextPage">다음</button>
</div>

</template>

<script>
export default {
    methods: {
        selectUser() {
            console.log("haha")
        },
        goNextPage() {
            this.$router.push("/faceFinal").catch(() => {});
        }
    }
}
</script>


<style scoped>
img {
    border: 5px solid #F8BB41;
}

.userA {
    border-radius: 50%;
}
.userB {
    border-radius: 50%;
}


</style>
