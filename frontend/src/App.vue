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
          href="/shop"
        >
          Flower Shop🌷
        </v-btn>

        <v-spacer></v-spacer>
      </v-container>
    </v-app-bar>

    <v-main class="grey lighten-3">
      <v-container>
        <v-row>
          <v-col cols="3">
            <v-sheet rounded="lg">
              <v-list color="transparent">
                <v-list-item
                  v-for="item in items"
                  :key="item"
                  link
                  @click="addFlower(item)"
                >
                  <v-list-item-content>
                    <v-list-item-title>
                      {{ item }}
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
                      문의하기
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

              <Flower @change="updateFlower(flower)" :is="flowers[index].type" v-model="flowers[index]" v-for="(flower, index) in flowers" :key="index"></Flower>
                          
              
            </v-sheet>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
//component Rose, Gypsophila, Tulip, Flower import
import Rose from './components/Rose'  
import Gypsophila from './components/Gypsophila'  
import Tulip from './components/Tulip'  
import Flower from './components/Flower'  
const axios = require('axios').default;

export default {   
  name: 'App',
//사용하는 components
  components: {
    Rose, Tulip,
    Flower, Gypsophila
  },

  data: () => ({
      items: [
        '튤립',
        '장미',
        '안개꽃'
      ],
      flowers: [
        
        
      ]
  }),

  created(){
    this.init();
  },

  methods:{
//URL에 있는 데이터 가져와서 response에 저장
    async init(){
      const response = await axios.get("/roses");
      this.flowers = response.data._embedded.roses;
    },

    addFlower(item){
//Flower추가 시, 튤립 기본 속성 정의
      if(item == "튤립"){
        this.flowers.push({
          type: 'Tulip',
          name: '튤립',
          freshness: 10, price: 1500

        });
      }else
//Flower추가 시, 장미 기본 속성 정의
      if(item == "장미"){
        this.flowers.push({
          type: 'Rose',
          name: '장미',
          freshness: 8, price: 2000

        });
      } else
//Flower추가 시, 안개꽃 기본 속성 정의
      if(item == "안개꽃"){
        this.flowers.push({
          type: 'Gypsophila',
          name: '안개꽃',
          freshness: 15, price: 2000

        });
      }
//POST메소드 통해 JSON타입으로 url에 데이터를 보냄
        axios.request({ 
          method: 'POST', 
          url: `/roses`, 
          headers: {'Content-Type': 'application/json'}, 
          data: this.flowers[this.flowers.length - 1]
        });
    },
    updateFlower(flower){
//PATCH메소드 통해 JSON타입으로 url에 데이터를 보냄
        axios.request({ 
          method: 'PATCH', 
          url: new URL(flower._links.self.href).pathname, 
          headers: {'Content-Type': 'application/json'}, 
          data: flower
        });
    }

  }
};
</script>
