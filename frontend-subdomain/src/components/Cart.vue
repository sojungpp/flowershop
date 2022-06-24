<template>
  <v-data-table
    :headers="headers"
    :items="cartItems"
    :items-per-page="5"
    class="elevation-1"
  ></v-data-table>
</template>

<script>
//axios변수 이용해 데이터 주고받음
const axios = require('axios').default;

export default {   
  name: 'App',

  components: {

  },
//카트에 담을 데이터 정의
  data: () => ({
      headers: [
        {  text: '이름', value: 'flowerDetail.name' },
        {  text: '색깔', value: 'flowerDetail.color' },
        {  text: '신선도', value: 'flowerDetail.freshness' },
        {  text: '가격', value: 'flowerDetail.price' },
        {  text: '결재방법', value: 'payment.method' },
        {  text: '결재상태', value: 'payment.status' }
      ],
      cartItems: [],
//처음에는 cart보이지 않도록
      showCart: false
  }),

  created(){
    this.init();
  },
  methods:{
//실행시, cart보이도록
    showCart(){
      this.showCart = true;
    },
//await = url에 존재하는 데이터를 받아온다
    async init(){
      const response = await axios.get("/cartItems");
//받아온 데이터 지정
      this.cartItems = response.data._embedded.cartItems;
      this.cartItems.forEach(async cartItem => {
        const response = await axios.get(new URL(cartItem._links.flower.href).pathname);
        cartItem.flowerDetail = response.data;
      })
    },

  }
};
</script>
