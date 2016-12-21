<template>
<div id="test">
  <el-table :data="tableData" highlight-current-row  @current-change="handleCurrentChange" stripe border style="width: 100%">
    <el-table-column type="index" width="50"> </el-table-column>
    <el-table-column property="date" label="菜名"> </el-table-column>
    <el-table-column property="name" label="价格" ></el-table-column>
    <el-table-column property="address" label="购买数量"> </el-table-column>
     <el-table-column :context="_self" inline-template label="操作">
      <div>
        <el-button size="small" @click="handleEdit($index, row)">
          点餐
        </el-button>
        <el-button size="small" @click="open3" >
          点餐1
        </el-button>
      </div>
    </el-table-column>
 </el-table>
 <br/>
 <hr/>
 <br/>
 <el-table :data="tableData2" highlight-current-row    stripe border style="width: 100%">
    <el-table-column type="index" width="50"> </el-table-column>
    <el-table-column property="date" label="菜名"> </el-table-column>
    <el-table-column property="name" label="价格" ></el-table-column>
    <el-table-column property="address" label="购买数量"> </el-table-column>
 </el-table>
 </div>
</template>

<script>
  export default {
    data() {
      return {
        tableData: [{
          date: '2016-05-02',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          date: '2016-05-04',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1517 弄'
        }, {
          date: '2016-05-01',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1519 弄'
        }, {
          date: '2016-05-03',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1516 弄'
        }],

        tableData2: [{
          date: '2016-05-02',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          date: '2016-05-04',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1517 弄'
        }, {
          date: '2016-05-01',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1519 弄'
        }, {
          date: '2016-05-03',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1516 弄'
        }],
         currentRow: null
      } 
    },

    methods: {
      handleCurrentChange(val) {
        this.currentRow = val;

        console.log(val)
        console.log(this.currentRow.address )
	    this.tableData2.push(val); 
      },
      handleEdit(index, row) {
        console.log(index, row);
      },
       open3() {
        this.$prompt('请输入邮箱', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          inputPattern: /[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?/,
          inputErrorMessage: '邮箱格式不正确'
        }).then(({ value }) => {
          this.$message({
            type: 'success',
            message: '你的邮箱是: ' + value
          });
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '取消输入'
          });       
        });
      }
    }
  }
</script>
