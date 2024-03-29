<template>
  <div>
    <!-- 使用产品分类与定价表格组件 -->
    <ProductPriceTable
      title="产品分类与定价"
      :totalNum="page.totalNum"
      :columns="tableColumns"
      :data="productPriceData"
      :show-edit="true"
      :showSearch="true"
      @currentPageChange="handleCurrentPageChange"
      @search='handleSearch'
      @save="handleSave"
      @add="handleAdd"
      @delete="handleDelete"
      :loading="loading"
    />
  </div>
</template>

<script>
import ProductPriceTable from '/src/components/Table/Table.vue'
import {
  MarketAdministration,
  getShopList
} from '@/api/data/getInfoData'
import Table from '@/components/Table/Table.vue'
import {deletePlan, insertPlan, updatePlan} from '../../../api/data/getInfoData'

export default {
  components: {
    Table,
    ProductPriceTable
  },
  data() {
    return {
      productPriceData: [],
      loading: false,
      tableColumns: [
        {prop: 'productId', label: '产品编号', type: 'number', close: true},
        {prop: 'productName', label: '产品名称', type: 'input'},
        {prop: 'quantity', label: '当前数量', type: 'number'},
        {prop: 'totality', label: '总量', type: 'number'},
        {prop: 'unit', label: '单位', type: 'input'},
        {prop: 'price', label: '单价（元）', type: 'number'},
        {prop: 'harvestDate', label: '收获日期', type: 'date'},
        {prop: 'expirationDate', label: '过期日期', type: 'date'},
        {prop: 'storageConditions', label: '存储条件', type: 'input'}
      ],
      page: {
        pageNum: 1,
        pageSize: 10,
        totalNum: 0,
      },
    }
  },
  async created() {
    await this.getInfo("")
  },
  methods: {
    // 删除土地信息
    async handleDelete(index) {
      const res = await deletePlan(MarketAdministration, [this.productPriceData[index].productId])
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
      const res = await updatePlan(MarketAdministration, data)
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
      const res = await insertPlan(MarketAdministration, data)
      if (res.code === 200) {
        this.$message.success('添加成功')
      } else {
        this.$message.error('添加失败')
      }
      await this.getInfo()
    },
    async getInfo(question) {
      this.loading = true
      const res = await getShopList(MarketAdministration, this.page.pageNum, this.page.pageSize, question)
      this.productPriceData = res.data.list
      this.page.totalNum = res.data.total
      this.loading = false
    },
    handleCurrentPageChange(currentPage) {
      this.page.pageNum = currentPage
      this.getInfo()
    },
    async handleSearch(question) {
      await this.getInfo(question)
    }
  },
}
</script>
