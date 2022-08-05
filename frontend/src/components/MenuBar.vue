<template>
  <div>
    <v-navigation-drawer
        v-if="!$vuetify.breakpoint.smAndUp"
        v-model="drawer"
        :clipped="$vuetify.breakpoint.lgAndUp"
        app
        color="primary"
        dark
    >
      <v-list color="primary" nav>
        <v-list-item
            v-for="(item, i) in btnItems"
            :key="`k1-${i}`"
            :href="item.href"
            :target="item.target"
            :to="item.to"
            link
        >
          <v-list-item-content>
            <v-list-item-title>{{ item.text }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-list-item
            v-for="(item, i) in barItems"
            :key="`k2-${i}`"
            :href="item.href"
            :target="item.target"
            :to="item.to"
            link
        >
          <v-list-item-content>
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-app-bar
        :clipped-left="$vuetify.breakpoint.lgAndUp"
        app
        color="white"
        elevate-on-scroll
        flat
        style="padding-top:10px;"
    >
      <v-container :class="{ 'px-0': !$vuetify.breakpoint.smAndUp }">
        <v-row
            :no-gutters="!$vuetify.breakpoint.smAndUp"
            align="center"
            justify="space-between"
        >
        <!-- <v-icon style="color:black;margin:10px;">mdi-keyboard-backspace</v-icon> -->
        <div style="margin-left:15px;display: flex; align-items: center;">
        <img style="width:40px;height:40px;border-radius:100%;border:1px solid; margin-right:10px;" src="../assets/logo.png"/>
        <div>이재인 님</div>
        </div>
          <v-col class="d-flex align-center" style="justify-content: flex-end;">
          <v-icon style="color:black">mdi-bell</v-icon>
            <v-app-bar-nav-icon
                v-if="!$vuetify.breakpoint.mdAndUp"
                @click.stop="drawer = !drawer"
                style="color:black"
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
            </v-btn
            >
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
export default {
  name: 'MenuBar',
  data: () => ({
    drawer: null,
    btnItems: [
      {
        text: "연애조작단",
        href: "https://github.com/kb40-match",
        target: "_black",
        color: "primary",
        icon: "mdi-download",
      },
    ],
    barItems: [
      {
        title: "이니",
        to: "/",
      },
      {
        title: "우니",
        to: "/category",
      },
      {
        title: "워니",
        to: "/detail",
      },
      {
        title: "영이",
        to: "/authors",
      },
      {
        title: "혀니",
        to: "/login",
      },
    ],
  }),
};
</script>