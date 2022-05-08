<template>

  <div id="app">
    <!-- 추가된 헤더 컴포넌트 사용 -->
    <Header/>

    <HelloWorld msg="Welcome to Your Vue.js App"/>

    <!-- 추가된 풋터 컴포넌트 사용 -->
    <Footer/>
  </div>
</template>

<script>/* eslint-disable */
import Header from '@/components/common/Header'//import 헤더 추가
import HelloWorld from '@/components/HelloWorld.vue'
import Footer from '@/components/common/Footer'
import request from "request";
//import 풋터 추가

export default {
  name: 'App',
  components: {
    Header          //헤더 컴포넌트 추가
    , HelloWorld
    , Footer         //풋터 컴포넌트 추가

  },
  mounted() {
    request('http://localhost:8082/api/hello', function (error, response, body) {
      window.console.log('error:', error); //Print the error if one occurred
      window.console.log('statusCode:', response && response.statusCode); //Print the error if one occurred
      window.console.log('body:', body); //Print the error if one occurred
    });
  }
};
</script>

<style>
html, body {
  padding: 0;
  margin: 0;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin: 0;
  padding: 0;
}
</style>