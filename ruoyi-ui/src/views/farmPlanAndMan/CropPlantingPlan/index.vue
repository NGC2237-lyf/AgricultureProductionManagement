<template>
  <div>
    <!-- 使用作物种植计划表格组件 -->
    <Table title="作物种植计划" :totalNum="page.totalNum" :columns="tableColumns" :data="planData"
           @delete="handleDelete" @currentpagechange="handleCurrentPageChange" @save="handleSave" @add="handleAdd"
           :loading="loading"
    />
  </div>
</template>

<script>
import Table from '/src/components/Table/Table.vue'
import { listUser } from '@/api/system/user'
import { deletePlan, getPlanList, insertPlan, CropPlanting, updatePlan, Land } from '@/api/data/getInfoData'

export default {
  components: {
    Table
  },
  data() {
    return {
      planData: [],
      page: {
        pageNum: 1,
        pageSize: 10,
        totalNum: 0
      },
      loading:false,
      tableColumns: [
        { prop: 'planId', label: '计划编号', type: 'input', close: true },
        { prop: 'farmId', label: '农场/农户编号', type: 'select' },
        { prop: 'year', label: '年度', type: 'input' },
        { prop: 'season', label: '季节', type: 'select' },
        { prop: 'landId', label: '地块编号', type: 'select' },
        { prop: 'cropType', label: '作物种类', type: 'input' },
        { prop: 'plantingArea', label: '种植面积（平方米）', type: 'input' },
        { prop: 'expectedYield', label: '预计产量（公斤）', type: 'input' },
        { prop: 'plantingDate', label: '种植日期', type: 'date' },
        { prop: 'harvestDate', label: '预计收获日期', type: 'date' },
        { prop: 'plantingMethod', label: '种植方法', type: 'input' },
        { prop: 'fertilizerUsage', label: '肥料使用情况', type: 'input' },
        { prop: 'pesticideUsage', label: '农药使用情况', type: 'input' },
        { prop: 'notes', label: '其他备注', type: 'input' }
      ],
      land: [],
      user:[],
      season: [{ label: '春季', value: '春季' }
        , { label: '夏季', value: '夏季' }
        , { label: '秋季', value: '秋季' }
        , { label: '冬季', value: '冬季' }]
    }
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
      const user = await listUser(this.queryParams)
      this.user = user.rows.map(item => {
        return { label: item.userName, value: item.userId }
      })
      this.updateOptions()
    },
    // 更新选项数据
    updateOptions() {
      // 在这里更新选项数据
      this.tableColumns.forEach(column => {
        if (column.prop === 'landId') {
          column.options = this.land
        }
        if(column.prop === 'season'){
          column.options = this.season
        }
        if (column.prop === 'farmId') {
          column.options = this.user
        }
      })
    },
    async getInfo() {
      this.loading = true
      const res = await getPlanList(CropPlanting, this.page.pageNum, this.page.pageSize)
      this.planData = res.data.list
      this.page.totalNum = res.data.total
      this.loading = false
    },
    // 删除土地信息
    async handleDelete(index) {
      const res = await deletePlan(CropPlanting, [this.planData[index].planId])
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
      const res = await updatePlan(CropPlanting, data)
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
      const res = await insertPlan(CropPlanting, data)
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
