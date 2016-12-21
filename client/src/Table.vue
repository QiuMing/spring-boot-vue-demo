<template>
<div id="app">
  <el-table :data="tableData" highlight-current-row  @current-change="handleCurrentChange" stripe border style="width: 100%">
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
         currentRow: null
      }
    },

    methods: {
      handleCurrentChange(val) {
        this.currentRow = val;
        console.log(val)
        console.log(this.currentRow.address )
      },
      handleEdit(index, row) {
        console.log(index, row);
      },
      handleDelete(index, row) {
        console.log(index, row);
      }
    }
  }
</script>
