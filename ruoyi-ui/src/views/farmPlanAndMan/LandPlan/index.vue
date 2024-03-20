<template>
  <div>
    <!-- 使用土地信息表格组件 -->
    <Table  title="土地信息" :totalNum="totalNum" :columns="tableColumns" :data="landData" @delete="handleDelete" @currentpagechange="handleCurrentPageChange" @save="handleSave" @add="handleAdd" />
  </div>
</template>

<script>
import Table from '/src/components/Table/Table.vue';
import { deletePlan, getPlanList, Land, updatePlan } from '@/api/data/getInfoData'

export default {
  components: {
    Table
  },
  data() {
    return {
      landData: [],
      totalNum:20,
      tableColumns: [
        { prop: 'landId', label: '土地编号',type: "input",show:false },
        { prop: 'location', label: '地理位置' ,type: "input"},
        { prop: 'area', label: '土地面积（平方米）',type: "input" },
        { prop: 'topography', label: '土地形态' ,type: "input"},
        { prop: 'soilType', label: '土壤类型' ,type: "input"},
        { prop: 'ownership', label: '土地所有者',type: "input" },
        { prop: 'landUse', label: '土地用途',type: "input" },
        { prop: 'ecologicalEnvironment', label: '土地生态环境描述',type: "input" },
        { prop: 'marketValue', label: '土地市场价值' ,type: "input"},
        { prop: 'planningUse', label: '土地规划用途',type: "input" },
        { prop: 'ownerIntent', label: '土地所有者的意愿和目标',type: "input" }
      ]
    };
  },
 async created() {
   await this.getInfo();
  },
  methods: {
    async getInfo(){
      const res = await getPlanList(Land,1,10)
      this.landData = res.data.list
      this.totalNum = res.data.total
    },
    // 删除土地信息
   async handleDelete(index) {
      const res = await deletePlan(Land,[this.landData[index].landId])
     if(res.code === 200){
       this.$message.success('删除成功')
     }else {
       this.$message.error('删除失败')
     }
      await this.getInfo()
    },
    // 保存土地信息
    async handleSave(data) {
      // 根据数据中的信息进行保存操作，这里可以发送请求给后端或者进行其他操作
      const res = await updatePlan(Land,data)
      if(res.code === 200){
        this.$message.success('更新成功')
      }else {
        this.$message.error('更新失败')
      }
      await this.getInfo()
    },
    // 添加土地信息
    handleAdd(data) {
      // 将新增的土地信息添加到 landData 中
      console.log(data)
      this.landData.push(data);
    },
    handleCurrentPageChange(currentPage){
      console.log(currentPage)
    },
  }
};
</script>
