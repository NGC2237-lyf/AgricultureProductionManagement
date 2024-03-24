<template>
  <div>
    <!-- 使用生长状况跟踪表格组件 -->
    <Table
      title="生长状况跟踪"
      :totalNum="page.totalNum"
      :columns="tableColumns"
      :data="trackingData"
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
import { AgricultureCrop, deletePlan, getPlanList, insertPlan, Land, updatePlan } from '@/api/data/getInfoData'
import { listUser } from '@/api/system/user'

export default {
  components: {
    Table
  },
  data() {
    return {
      trackingData: [],
      page:{
        pageNum:1,
        pageSize:10,
        totalNum:0,
      },
      loading:false,
      tableColumns: [
        { prop: 'trackingId', label: '跟踪编号', type: 'number',close:true },
        { prop: 'farmId', label: '农场/农户编号', type: 'select' },
        { prop: 'landId', label: '地块编号', type: 'select' },
        { prop: 'cropType', label: '作物种类', type: 'select' },
        { prop: 'growthStage', label: '生长阶段', type: 'select', options: this.getGrowthStageOptions() },
        { prop: 'observationDate', label: '观测日期', type: 'date' },
        { prop: 'height', label: '高度（厘米）', type: 'number' },
        { prop: 'canopyWidth', label: '冠幅宽度（厘米）', type: 'number' },
        { prop: 'leafColor', label: '叶片颜色', type: 'input' },
        { prop: 'pestPresence', label: '害虫存在情况', type: 'input' },
        { prop: 'diseasePresence', label: '病害存在情况', type: 'input' },
        { prop: 'nutrientDeficiency', label: '养分缺乏情况', type: 'input' },
        { prop: 'notes', label: '备注', type: 'input' }
      ],
      land:[],
      user:[],
      cropType:[
        { label: '小麦', value: '小麦' },
        { label: '水稻', value: '水稻' },
        { label: '玉米', value: '玉米' },
        { label: '大豆', value: '大豆' },
        { label: '油菜', value: '油菜' },
        { label: '马铃薯', value: '马铃薯' },
        { label: '黄瓜', value: '黄瓜' },
        { label: '番茄', value: '番茄' },
        { label: '西兰花', value: '西兰花' },
        { label: '胡萝卜', value: '胡萝卜' },
        { label: '其他', value: '其他' },
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
        if (column.prop === 'farmId') {
          column.options = this.user
        }
        if (column.prop === 'cropType') {
          column.options = this.cropType
        }
      })
    },
    async getInfo() {
      this.loading =true
      const res = await getPlanList(AgricultureCrop, this.page.pageNum, this.page.pageSize)
      this.trackingData = res.data.list
      this.page.totalNum = res.data.total
      this.loading = false
    },
    // 删除土地信息
    async handleDelete(index) {
      const res = await deletePlan(AgricultureCrop, [this.trackingData[index].trackingId])
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
      const res = await updatePlan(AgricultureCrop, data)
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
      const res = await insertPlan(AgricultureCrop, data)
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
    },
    // 获取生长阶段选项
    getGrowthStageOptions() {
      return [
        { value: '发芽期', label: '发芽期' },
        { value: '生长期', label: '生长期' },
        { value: '抽穗期', label: '抽穗期' },
        { value: '成熟期', label: '成熟期' }
      ];
    }
  }
};
</script>
