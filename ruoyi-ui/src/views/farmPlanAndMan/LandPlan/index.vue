<template>
  <div>
    <!-- 使用土地信息表格组件 -->
    <Table title="土地信息" :totalNum="page.totalNum" :columns="tableColumns" :data="landData" @delete="handleDelete"
           @currentpagechange="handleCurrentPageChange" @save="handleSave" @add="handleAdd" :loading="loading"
    />
  </div>
</template>

<script>
import Table from '/src/components/Table/Table.vue'
import { deletePlan, getPlanList, insertPlan, Land, updatePlan } from '@/api/data/getInfoData'
import { listUser } from '@/api/system/user'

export default {
  components: {
    Table
  },
  data() {
    return {
      landData: [],
      totalNum: 20,
      queryParams: {
        pageNum: 1,
        pageSize: 9999
      },
      page: {
        pageNum: 1,
        pageSize: 10,
        totalNum: 0
      },
      user: [],
      loading: false,
      tableColumns: [
        { prop: 'landId', label: '土地编号', type: 'input', close: true },
        { prop: 'location', label: '地理位置', type: 'input' },
        { prop: 'area', label: '土地面积（平方米）', type: 'input' },
        { prop: 'topography', label: '土地形态', type: 'input' },
        { prop: 'soilType', label: '土壤类型', type: 'input' },
        { prop: 'ownership', label: '土地所有者', type: 'select' },
        { prop: 'landUse', label: '土地用途', type: 'input' },
        { prop: 'ecologicalEnvironment', label: '土地生态环境描述', type: 'input' },
        { prop: 'marketValue', label: '土地市场价值', type: 'input' },
        { prop: 'planningUse', label: '土地规划用途', type: 'input' },
        { prop: 'ownerIntent', label: '土地所有者的意愿和目标', type: 'input' }
      ]
    }
  },
  async created() {
    await this.getUserInfo()
    await this.getInfo()
  },
  methods: {
    async getUserInfo() {
      const res = await listUser(this.queryParams)
      this.user = res.rows.map(item => {
        return { label: item.userName, value: item.userId }
      })
      this.updateOptions()
    },
    // 更新选项数据
    updateOptions() {
      // 在这里更新选项数据
      this.tableColumns.forEach(column => {
        if (column.prop === 'ownership') {
          column.options = this.user
        }
      })
    },
    async getInfo() {
      this.loading = true
      const res = await getPlanList(Land, this.page.pageNum, this.page.pageSize)
      this.landData = res.data.list
      this.page.totalNum = res.data.total
      this.loading = false
    },
    // 删除土地信息
    async handleDelete(index) {
      const res = await deletePlan(Land, [this.landData[index].landId])
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
      const res = await updatePlan(Land, data)
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
      const res = await insertPlan(Land, data)
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
}
</script>
