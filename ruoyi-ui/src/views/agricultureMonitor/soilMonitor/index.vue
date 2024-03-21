<template>
  <div>
    <!-- 使用土壤监测表格组件 -->
    <Table
      title="土壤监测"
      :totalNum="page.totalNum"
      :columns="tableColumns"
      :data="soilTestData"
      @delete="handleDelete"
      @currentPageChange="handleCurrentPageChange"
      @save="handleSave"
      @add="handleAdd"
      :loading="loading"
    />
  </div>
</template>

<script>
import Table from '/src/components/Table/Table.vue';
import { AgricultureSoil, deletePlan, getPlanList, insertPlan, Land, updatePlan } from '@/api/data/getInfoData'

export default {
  components: {
    Table
  },
  data() {
    return {
      soilTestData: [],
      page:{
        pageNum:1,
        pageSize:10,
        totalNum:0,
      },
      loading:false,
      tableColumns: [
        { prop: 'testId', label: '检测编号', type: 'number' ,close: true},
        { prop: 'location', label: '检测地块', type: 'select' },
        { prop: 'testDate', label: '检测日期', type: 'date' },
        { prop: 'phLevel', label: 'pH值', type: 'number' },
        { prop: 'nitrogen', label: '氮含量（mg/kg）', type: 'number' },
        { prop: 'phosphorus', label: '磷含量（mg/kg）', type: 'number' },
        { prop: 'potassium', label: '钾含量（mg/kg）', type: 'number' },
        { prop: 'organicMatter', label: '有机物含量（百分比）', type: 'number' },
        { prop: 'texture', label: '土壤质地', type: 'input' },
        { prop: 'salinity', label: '盐分含量（毫克/千克）', type: 'number' },
        { prop: 'soilMoisture', label: '土壤湿度（百分比）', type: 'number' },
        { prop: 'soilType', label: '土壤类型', type: 'input' },
        { prop: 'notes', label: '备注', type: 'input' }
      ],
      land:[],
      soilType:[
        {label: '红壤', value: '红壤'},
        {label: '黄壤', value: '黄壤'},
        {label: '黑土', value: '黑土'},
        {label: '砂壤土', value: '砂壤土'},
        {label: '潮土', value: '潮土'},
        {label: '砂土', value: '砂土'},
        {label: '粘土', value: '粘土'},
      ]
    };
  },
  async created() {
    await this.getPlanInfo()
    await this.getInfo()
  },
  methods: {
    async getPlanInfo() {
      const res = await getPlanList(Land, 1, 999999)
      this.land = res.data.list.map(item => {
        return { label: item.landId, value: item.landId }
      })
      this.updateOptions()
    },
    // 更新选项数据
    updateOptions() {
      // 在这里更新选项数据
      this.tableColumns.forEach(column => {
        if (column.prop === 'location') {
          column.options = this.land
        }
        if (column.prop === 'soilType') {
          column.options = this.soilType
        }
      })
    },
    async getInfo() {
      this.loading = true
      const res = await getPlanList(AgricultureSoil, this.page.pageNum, this.page.pageSize)
      this.soilTestData = res.data.list
      this.page.totalNum = res.data.total
      this.loading = false
    },
    // 删除土地信息
    async handleDelete(index) {
      const res = await deletePlan(AgricultureSoil, [this.soilTestData[index].testId])
      if (res.code === 200) {
        this.$message.success('删除成功')
      } else {
        this.$message.error('删除失败')
      }
      await this.getInfo()
    },
    // 保存土地信息
    async handleSave(data) {
      // 根据数据中的信息进行保存操作，这里可以发送请求给后端或者进行其他操作
      const res = await updatePlan(AgricultureSoil, data)
      if (res.code === 200) {
        this.$message.success('更新成功')
      } else {
        this.$message.error('更新失败')
      }
      await this.getInfo()
    },
    // 添加土地信息
    async handleAdd(data) {
      // 将新增的土地信息添加到 landData 中
      console.log(data)
      const res = await insertPlan(AgricultureSoil, data)
      if (res.code === 200) {
        this.$message.success('添加成功')
      } else {
        this.$message.error('添加失败')
      }
      await this.getInfo()
    },
    handleCurrentPageChange(currentPage) {
      this.page.pageNum = currentPage
      this.getInfo()
    }
  }
};
</script>
