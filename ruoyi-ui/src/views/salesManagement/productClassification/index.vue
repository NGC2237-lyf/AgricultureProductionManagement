<template>
  <div>
    <!-- 使用产品分类与定价表格组件 -->
    <ProductPriceTable
      title="产品分类与定价"
      :totalNum="page.totalNum"
      :columns="tableColumns"
      :data="productPriceData"
      :show-edit="false"
      :showSearch="true"
      @currentPageChange="handleCurrentPageChange"
      @search ='handleSearch'
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

export default {
  components: {
    Table,
    ProductPriceTable
  },
  data() {
    return {
      productPriceData: [],
      tableColumns: [
        { prop: 'productId', label: '产品编号', type: 'number' },
        { prop: 'productName', label: '产品名称', type: 'input' },
        { prop: 'harvestDate', label: '收获日期', type: 'date' },
        { prop: 'quantity', label: '当前数量', type: 'number' },
        { prop: 'totality', label: '总量', type: 'number' },
        { prop: 'unit', label: '单位', type: 'input' },
        { prop: 'price', label: '单价（元）', type: 'number' },
        { prop: 'expirationDate', label: '过期日期', type: 'date' },
        { prop: 'storageConditions', label: '存储条件', type: 'input' }
      ],
      page:{
        pageNum:1,
        pageSize:10,
        totalNum:0,
      },
    }
  },
  async created() {
    // await this.getPlanInfo()
    await this.getInfo(" ")
  },
  methods: {
    async getInfo(question) {
      const res = await getShopList(MarketAdministration, this.page.pageNum, this.page.pageSize,question)
      this.productPriceData = res.data.list
      this.page.totalNum = res.data.total
    },
    handleCurrentPageChange(currentPage) {
      this.page.pageNum = currentPage
      this.getInfo()
    },
    async handleSearch(question){
      await this.getInfo(question)
    }
  }
}
</script>
