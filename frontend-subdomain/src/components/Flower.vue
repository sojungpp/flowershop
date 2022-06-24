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
        <v-list-item-title class="text-h5 mb-1">
          {{value.name}}
        </v-list-item-title>
        <v-list-item-subtitle >색깔은 {{value.color}}, 신선도는 {{value.freshness}}, 가격은 {{value.price}}입니다.</v-list-item-subtitle>
      </v-list-item-content>
    </v-list-item>

    <v-card-actions>

      <v-chip v-if="inTheCart">카트에 담겼습니다</v-chip>

      <v-btn
        v-else
        outlined
        rounded
        text

        @click="addToCart"
      >
        카트담기
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
    data: function() {
      return {
        inTheCart: false
      }
    },


    methods:{

      async addToCart(){

        var cartItem = {
          //주소 가져옴
          flower: this.value._links.self.href,
          customer: "http://localhost:8088/customers/help@uengine.org",
          payment: {
            method: "신용카드",
            status : "결재완료"
          }
        }
//POST메소드 통해 JSON타입으로 데이터 보냄
        await axios.request({ 
          method: 'POST', 
          url: "/cartItems", 
          headers: {'Content-Type': 'application/json'},
          data: cartItem
        });

        this.inTheCart = true;
      }
    }
  }
</script>
