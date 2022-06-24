<template>

    <Flower v-model="value">

      <template v-slot:buttons>
        <v-btn  outlined
        rounded
        text @click="abundant">풍성도</v-btn>
        <v-btn  outlined
        rounded
        text @click="color">COLOR</v-btn>
      </template>

    </Flower>

</template>

<script>
//Flower components import
   const axios = require('axios').default;
   import Flower from './Flower'

  export default {
    name: 'Gypsophila',

    mixins: [Flower],

    components:{
      Flower
    },

    
    methods:{
//color는 gypsophila가 특별하게 가지고 있기 때문에 해당 파일에서 데이터보냄
//PUT메소드, URL에 데이터 담아서 전송
      async color(){
        await axios.request({ 
          method: 'PUT', 
          url: new URL(this.value._links.color.href).pathname, 
          headers: {'Content-Type': 'application/json'}
        });
        this.refresh();
      },
//abundant는 gypsophila가 특별하게 가지고 있기 때문에 해당 파일에서 데이터보냄
//PUT메소드, URL에 데이터 담아서 전송
      async abundant(){
        await axios.request({ 
          method: 'PUT', 
          url: new URL(this.value._links.abundant.href).pathname, 
          headers: {'Content-Type': 'application/json'}
        });
        this.refresh();
      }
    }
  }
</script>
