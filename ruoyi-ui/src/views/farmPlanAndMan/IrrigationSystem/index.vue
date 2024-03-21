<template>
  <div>
    <!-- 使用作灌溉系统表格组件 -->
    <Table
      title="灌溉系统"
      :totalNum="page.totalNum"
      :columns="tableColumns"
      :data="irrigationSystemData"
      @delete="handleDelete"
      @currentpagechange="handleCurrentPageChange"
      @save="handleSave"
      @add="handleAdd"
    />
  </div>
</template>

<script>
import Table from '/src/components/Table/Table.vue'
import { IrrigationRecord, deletePlan, getPlanList, insertPlan, Land, updatePlan } from '@/api/data/getInfoData'
import { listUser } from '@/api/system/user'

export default {
  components: {
    Table
  },
  data() {
    return {
      irrigationSystemData: [],
      page: {
        pageNum: 1,
        pageSize: 10,
        totalNum: 0
      },
      tableColumns: [ // 表格列配置
        { prop: 'irrigationId', label: '跟踪编号', type: 'input', close: true },
        { prop: 'farmId', label: '农场/农户编号', type: 'select' },
        { prop: 'landId', label: '地块编号', type: 'select' },
        { prop: 'farmName', label: '灌溉用户', type: 'input', close: true },
        { prop: 'irrigationDate', label: '灌溉日期', type: 'date' },
        { prop: 'irrigationMethod', label: '灌溉方法', type: 'input' },
        { prop: 'irrigationDuration', label: '灌溉时间(h)', type: 'number' },
        { prop: 'waterConsumption', label: '灌溉水量(m³)', type: 'number' },
        { prop: 'notes', label: '备注', type: 'input' }
      ],
      user: [],
      land: []
    }
  },
  async created() {
    await this.getPlanInfo()
    await this.getInfo()
  },
  methods: {
    async getPlanInfo() {
      const user = await listUser(this.queryParams)
      this.user = user.rows.map(item => {
        return { label: item.userName, value: item.userId }
      })
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
        if (column.prop === 'landId') {
          column.options = this.land
        }
        if (column.prop === 'farmId') {
          column.options = this.user
        }
      })
    },
    async getInfo() {
      const res = await getPlanList(IrrigationRecord, this.page.pageNum, this.page.pageSize)
      this.irrigationSystemData = res.data.list
      this.page.totalNum = res.data.total
    },
    // 删除土地信息
    async handleDelete(index) {
      const res = await deletePlan(IrrigationRecord, [this.irrigationSystemData[index].irrigationId])
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
      const res = await updatePlan(IrrigationRecord, data)
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
      const res = await insertPlan(IrrigationRecord, data)
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
