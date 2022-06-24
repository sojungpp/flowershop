<template>
   <v-app id="inspire">
    <v-app-bar
      app
      color="#EBC354"
      flat
    >
      <v-container class="py-0 fill-height">
        <v-avatar
          class="mr-10"
          color="#D48155"
          size="32"
        ></v-avatar>

        <v-btn
          v-for="link in links"
          :key="link.href"
          :href="link.href"
          text
        >
          {{ link.title }}
        </v-btn>

        <v-spacer></v-spacer>
        

        <v-responsive max-width="260">
          <v-text-field
            dense
            flat
            hide-details
            rounded
            solo-inverted
          ></v-text-field>
        </v-responsive>
      </v-container>
    </v-app-bar>

    <v-main class="grey lighten-3">
      <v-container>
        <v-row>
          <v-col cols="2">
            <v-sheet rounded="lg">
              <v-list color="transparent">
                <v-list-item @click="showCart = true">
                  <v-list-item-content>
                    <v-list-item-title>
                      카트보기
                    </v-list-item-title>
                  </v-list-item-content>
                </v-list-item>

                <v-divider class="my-2"></v-divider>

                <v-list-item
                  link
                  color="grey lighten-4"
                >
                  <v-list-item-content>
                    <v-list-item-title>
                      Refresh
                    </v-list-item-title>
                  </v-list-item-content>
                </v-list-item>
              </v-list>
            </v-sheet>
          </v-col>

          <v-col>
            <v-sheet
              min-height="80vh"
              rounded="lg"
            >
              <Cart v-if="showCart"></Cart>

              <Flower v-model="flowers[index]" v-for="(flower, index) in flowers" :key="index"></Flower>
                          
              
            </v-sheet>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
//Flower과 Cart import
import Flower from './components/Flower'  
import Cart from './components/Cart'
//axios변수 이용해 데이터 주고받음
const axios = require('axios').default;

export default {    // public class App{
  name: 'App',

  components: {
    Flower, Cart
  },

  data: () => ({
//title과 url지정
      links: [
        {title: 'Flower List', href:"/"}
      ],
      items: [
        '튤립',
        '장미',
        '안개꽃'
      ],
      flowers: [
        
        
      ],
      showCart: false
  }),

  created(){
    this.init();
  },
//cart보이게 하는 메소드
  methods:{
    showCart(){
      this.showCart = true;
    },
    async init(){
      const response = await axios.get("/roses");

      this.flowers = response.data._embedded.roses;
    },

  }
};
</script>
