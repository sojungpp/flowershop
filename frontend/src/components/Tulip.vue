<template>

  <Flower v-model="value"></Flower>
 
</template>

<script>
//Flower components import
  import Flower from './Flower'

  export default {
    name: 'Tulip',

    components:{
      Flower
    },

    mixins: [Flower],


    methods:{

    }
  }
</script>
