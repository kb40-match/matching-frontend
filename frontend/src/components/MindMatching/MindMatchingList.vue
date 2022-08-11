<template>
    <div>
        <div style="text-align: center;"> 
                <v-btn block id="retryBtn" @click="retry" color="#FEBC0E" rounded style="margin-top: 50px">다시하기(500원)</v-btn>
        </div>

        <v-container fluid>
            <v-row dense id="main">
            <v-col v-for="(person, index) in people.slice(0,1)" :key="index" cols="12" xs="12">
                <v-card id="mainCard" class="pa-3" outlined v-on:click="goDetailPage" style="border:5px solid #FEBC0E;" color="#C4C4C4">
                <div rounded style="background-color: #FEBC0E; border-radius: 0px;" >100% match</div>
                <img id="personImage" src="../../assets/logo.png"/>
                <v-spacer></v-spacer>
                {{person.name}}, {{person.age}}세
                </v-card>
            </v-col>
            </v-row>
           
            <v-row dense id="sub">
            <v-col v-for="(person, index) in people.slice(1)" :key="index" cols="6" xs="6">
                <v-card id="subCard" class="pa-3" outlined v-on:click="goDetailPage" style=" border:5px solid #FEBC0E; " color="#C4C4C4">
                <div rounded style="background-color: #FEBC0E; border-radius: 0px;">100% match</div>
                <img id="personImage" src="../../assets/logo.png"/>
                <v-spacer></v-spacer>
                {{person.name}}, {{person.age}}세
                </v-card>
            </v-col>
            </v-row>
        </v-container>

    </div>
    
</template>

<script>
export default {
    data() {
        return {
            a: 0,
            b: 1,
            people: [
                {
                    name: "김국은1",
                    age: "20"
                },
                {
                    name: "김국은2",
                    age: "21"
                },
                {
                    name: "김국은3",
                    age: "22"
                },
                {
                    name: "김국은4",
                    age: "23"
                },
                {
                    name: "김국은5",
                    age: "24"
                },
                {
                    name: "김국은6",
                    age: "25"
                },
                {
                    name: "김국은7",
                    age: "26"
                },
                {
                    name: "김국은8",
                    age: "27"
                },
                {
                    name: "김국은9",
                    age: "28"
                }
            ]
        }
    },
    methods: {
        retry() {
            // TODO: implement decrease point
            this.$router.push("/mindQuestion").catch(() => {});
        },
        goDetailPage() {
            // TODO: implement decrease point
            this.$router.push("/mindQuestion").catch(() => {}); //FIXME: change path
        }
    }
}
</script>


<style scoped>

#main{
  margin : 10px;
  display : flex;
  align-items:center;
}
#sub{
  margin : 10px;
  display : flex;
  align-items:center;
}

#mainCard {
    display:flex;
    justify-content:center;
    align-items: center;
    flex-direction: column;
    color: white;
    height: 200px;
    border-radius: 20px;
}

#subCard {
    display:flex;
    justify-content:center;
    align-items: center;
    flex-direction: column;
    color: white;
    height: 250px;
    border-radius: 20px;
}

#retryBtn {
    display : flex;
    align-items:center;
}

#box-user {
    background-color: #C4C4C4;
}

</style>