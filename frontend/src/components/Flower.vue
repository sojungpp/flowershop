<template>

  <v-card
    class="mx-auto"
    max-width="400"
    outlined
  >
  <v-img
      class="white--text align-end"
      height="200px"
      src="https://cdn.pixabay.com/photo/2012/03/04/00/40/arrangement-22013_960_720.jpg"
    >
    </v-img>
    <v-list-item three-line>
      <v-list-item-content>
        <div class="text-overline mb-4">
          {{value.type}}
        </div>
        <v-list-item-title class="text-h5 mb-1" v-if="editMode">
          <v-text-field v-model="value.name"></v-text-field>
        </v-list-item-title>
        <v-list-item-title class="text-h5 mb-1" @click="toggleEditMode" v-else>
          {{value.name}}
        </v-list-item-title>
        <v-list-item-subtitle @click="toggleEditMode">색깔은 {{value.color}}, 신선도는 {{value.freshness}}, 가격은 {{value.price}}입니다.</v-list-item-subtitle>
      </v-list-item-content>

    </v-list-item>

    <v-card-actions>
      <v-btn
        outlined
        rounded
        text

        @click="water"
      >
        물주기
      </v-btn>
      <v-btn
        outlined
        rounded
        text

        @click="nutrition"
      >
        영양제주기
      </v-btn>

      <slot name="buttons"></slot>
      
    </v-card-actions>
  </v-card>


</template>

<script>
//axios변수 이용해 데이터 주고받음
  const axios = require('axios').default;

  export default {
    name: 'Flower',
//객체 인수 받음
    props: {
      value: Object,
      editMode: Boolean
    },
//기능은 backend에서 구현
    methods:{
//업데이트된 정보 받아오기 위해 await사용
      async water(){
//PUT메소드 통해 JSON타입으로 url에 데이터를 보냄
        await axios.request({ 
          method: 'PUT', 
          url: new URL(this.value._links.water.href).pathname, 
          headers: {'Content-Type': 'application/json'}
        });
        //데이터 보낸 후, refresh
        this.refresh();
      },

      async nutrition(){
//PUT메소드 통해 JSON타입으로 url에 데이터를 보냄
        await axios.request({ 
          method: 'PUT', 
          url: new URL(this.value._links.nutrition.href).pathname, 
          headers: {'Content-Type': 'application/json'}
        });
        this.refresh();
      },
      //refresh 실행
      async refresh(){
        var response = await axios.get(new URL(this.value._links.self.href).pathname);
//input 이벤트 실행
        if(response){
          this.value = response.data;
          this.$emit("input", this.value);
        }
      },
//change 이벤트 실행
      toggleEditMode(){
        this.editMode = !this.editMode;
        this.$emit("change", this.value);
      }


    }
  }
</script>
