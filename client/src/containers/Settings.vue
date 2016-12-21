<template>
    
     <div id="app">
	     <el-button type="text" @click="test">文字按钮</el-button>
	      <h1>{{ msg }}</h1> 
     </div>
</template>

<script>
export default {
  name: 'Settings',
  data () {
    return {
      msg: '菜单管理列表'
    }
  },
  methods: {
  	test(){
  		console.log("------------")
		 fetch('http://localhost:8081/users', {mode: 'cors'})  
		    .then((response) => {
		        if (response.ok) {
		            return response.json()
		        } else {
		            console.error('服务器繁忙，请稍后再试；\r\nCode:' + response.status)
		        }
		    })
		    .then((data) => {
		        console.log(data)
		    })
		    .catch((err)=> {
		        console.error(err)
		    })  	 
  		}
	}
};
</script>

<style>
body {
  font-family: Helvetica, sans-serif;
}
</style>
