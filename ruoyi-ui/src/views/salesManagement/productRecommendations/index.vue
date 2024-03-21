<template>
  <div>
    <Table
      title="农产品价格推荐"
      :totalNum="page.totalNum"
      :columns="tableColumns"
      :data="soilTestData"
      :show-edit="false"
      :showSearch="true"
      @currentPageChange="handleCurrentPageChange"
      @search ='handleSearch'
      />
  </div>
</template>

<script>
import Table from '/src/components/Table/Table.vue';
import {
  getProductList,
  MarketRecommendation
} from '@/api/data/getInfoData'
import ProductPriceTable from '@/components/Table/Table.vue'

export default {
  components: {
    ProductPriceTable,
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
      question :"",
      tableColumns: [
        { prop: 'productName', label: '产品名称', type: 'input' },
        { prop: 'description', label: '描述', type: 'input' },
        { prop: 'price', label: '新鲜小麦价格', type: 'number' },
        { prop: 'unit', label: '单位', type: 'input' },
        { prop: 'productId', label: '产品编号', type: 'number' },
      ],
    };
  },
  async created() {
    await this.getInfo(this.question)
  },
  methods: {
    async getInfo(question) {
      const res = await getProductList(MarketRecommendation, this.page.pageNum, this.page.pageSize,question)
      this.soilTestData = res.data.list
      this.page.totalNum = res.data.total
    },
    handleCurrentPageChange(currentPage) {
      this.page.pageNum = currentPage
      this.getInfo(this.question)
    },
    async handleSearch(data){
      console.log(data)
      await this.getInfo(data)
    }
  }
};
</script>
