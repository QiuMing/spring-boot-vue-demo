<template>
<div id="test">
  <el-table :data="cookbooks" highlight-current-row  @current-change="handleCurrentChange" stripe border style="width: 100%">
    <el-table-column type="index" width="50"> </el-table-column>
    <el-table-column property="name" label="菜名"> </el-table-column>
    <el-table-column property="price" label="价格" ></el-table-column>
    <el-table-column property="buyNum" label="购买数量"> </el-table-column>
    <el-table-column :context="_self" inline-template label="操作">
      <div>
        <el-button size="small" @click="addUserDishes($index, row)">
          点餐
        </el-button>
      </div>
    </el-table-column>
 </el-table>

 <br/>
 <hr/>
 <br/>

  <el-table :data="userDishes" highlight-current-row    stripe border style="width: 100%">
      <el-table-column type="index" width="50"> </el-table-column>
      <el-table-column property="userName" label="用户名"> </el-table-column>
      <el-table-column property="dishesName" label="菜名" ></el-table-column>
      <el-table-column property="price" label="价格"> </el-table-column>
      <el-table-column :context="_self" inline-template label="操作">
        <div>
          <el-button size="small" @click="deleteDishes($index,row,userDishes)">
            删除
          </el-button>
        </div>
      </el-table-column>
  </el-table>
 
  <br/>
  <hr/>
  <br/>

 <h1>总价格:{{msg}}
  </h1>
 </div>
</template>

<script>
  export default {
    data() {
      return {
        cookbooks: [],
        userDishes: [],
        msg: '0',
      }
    },

    computed: {
        allPrice:function () {
          var all=0;
          var data = this.userDishes;
          for(var o in data){  
              all += data[o].price;
          } 
          this.msg=all;
          return this.mag;
        }
    },
    mounted: function() {
        this.getCookbooks();
        this.getUserDishes();
    },
    methods: {
      handleCurrentChange(val) {
        this.currentRow = val;
        console.log(val)
        console.log(this.currentRow.address )
	      this.tableData2.push(val); 
      },

      getCookbooks(){
        console.log("to getCookbooks")
        fetch('http://localhost:8082/cookbooks', {mode: 'cors'})  
            .then((response) => {
                if (response.ok) {
                    return response.json()
                } else {
                    console.error('服务器繁忙，请稍后再试；\r\nCode:' + response.status)
                }
            })
            .then((data) => {
                console.log(data)
                this.cookbooks=data;
            this.msg=data;
            })
            .catch((err)=> {
                console.error(err)
            })  	 
      },

      getUserDishes(){
        console.log("to getUserDishes")
        fetch('http://localhost:8082/userDishes', {mode: 'cors'})  
            .then((response) => {
                if (response.ok) {
                    return response.json()
                } else {
                    console.error('服务器繁忙，请稍后再试；\r\nCode:' + response.status)
                }
            })
            .then((data) => {
                console.log(data)
                this.userDishes=data;
            })
            .catch((err)=> {
                console.error(err)
            })  	 
      },


      addUserDishes(index,row) {
        var dishesName = row.name;
        console.log("----dishesName:",  );
        this.$prompt('你的名字', '名字', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
         // inputPattern: /[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?/,
         // inputErrorMessage: '邮箱格式不正确'
        }).then(({ value }) => {
          this.$message({
            type: 'success',
            message: '你的名字: ' + value
          });

          console.log("dishesName:",dishesName);
          console.log("userName:",value);
          fetch('http://localhost:8082/addDishes', {
              mode: 'cors',
              method: 'POST',
              headers: {
                'Content-Type': 'application/json'
              },
              body: JSON.stringify({
                dishesName:dishesName,
                userName: value,
              })
            })  
            .then((response) => {
                if (response.ok) {
                    return response.json()
                } else {
                    console.error('服务器繁忙，请稍后再试；\r\nCode:' + response.status)
                }
            })
            .then((data) => {
                console.log("添加成功")
                console.log(data)
                this.userDishes.push(data); 
            })
            .catch((err)=> {
                console.error(err)
            })  
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '取消输入'
          });       
        });
      },

      deleteDishes(index,row,userDishes){
          var userDishesId = row.id;
          console.log("id",userDishesId);
          fetch('http://localhost:8082/userDishes/'+userDishesId,{
               method: 'DELETE',
           })  
            .then((response) => {
                if (response.ok) {
                  console.log("删除成功")
                } else {
                    console.error('服务器繁忙，请稍后再试；\r\nCode:' + response.status)
                }
            })
            .catch((err)=> {
                console.error(err)
            })  	
      },
    }
  }
</script>
