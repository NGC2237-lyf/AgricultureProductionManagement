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
      :loading="loading"
      :loadingText ="loadingText"
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
      loading:false,
      loadingText:"",
      page:{
        pageNum:1,
        pageSize:10,
        totalNum:0,
      },
      question :"",
      tableColumns: [
        { prop: 'productId', label: '产品编号', type: 'number' ,close: true},
        { prop: 'productName', label: '产品名称', type: 'input' },
        { prop: 'description', label: '描述', type: 'input' },
        { prop: 'price', label: '新鲜小麦价格', type: 'number' },
        { prop: 'unit', label: '单位', type: 'input' },

      ],
    };
  },
  async created() {
    await this.getInfo(this.question)
  },
  methods: {
    async getInfo(question) {
      this.loading = true
      this.loadingText = "正在查询请稍后"
      const res = await getProductList(MarketRecommendation, this.page.pageNum, this.page.pageSize,question)
      console.log(res)
      this.soilTestData = res.data.list || res.data
      this.page.totalNum = res.data.total || 0
      this.loading = false
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
