<template>
  <div class="parent-component">
    <line-chart
      style="float: left"
      :chart-width="'800px'"
      :chart-height="'500px'"
      :chart-data="totalPrice"
      :chart-title="'产品销售总价图'"
      :x-axis-name="'种类'"
      :y-axis-name="'销售额'"
      :animation="true"
    ></line-chart>
    <line-chart
      style="float: left;margin-left: 100px"
      :chart-width="'800px'"
      :chart-height="'500px'"
      :chart-data="quantity"
      :chart-title="'产品销售数量图'"
      :x-axis-name="'种类'"
      :y-axis-name="'销售额'"
      :animation="true"
    ></line-chart>
    <line-chart
      style="float: left"
      :chart-width="'800px'"
      :chart-height="'500px'"
      :chart-data="unitPrice"
      :chart-title="'产品销售单价图'"
      :x-axis-name="'种类'"
      :y-axis-name="'销售额'"
      :animation="true"
    ></line-chart>
  </div>
</template>

<script>
import LineChart from '@/components/LineChart/index.vue';
import { getPlanList, MarketSales } from '@/api/data/getInfoData' // 导入折线图组件

export default {
  components: {
    LineChart // 注册折线图组件
  },
  async created() {
    // await this.getPlanInfo()
    await this.getInfo()
  },
  data() {
    return {
      totalPrice: [],
      quantity:[],
      unitPrice:[],
      page:{
        pageNum:1,
        pageSize:999999,
      },
    };
  },
  methods:{
    async getInfo() {
      const res = await getPlanList(MarketSales, this.page.pageNum, this.page.pageSize)
      this.totalPrice = res.data.list.map(item => {
        return {name: item.productName, value: item.totalPrice }
      })
      this.totalPrice.unshift({name: '', value: 0})
      this.totalPrice.push({name: '', value: 0})
      this.quantity = res.data.list.map(item => {
        return {name: item.productName, value: item.quantity }
      })
      this.quantity.unshift({name: '', value: 0})
      this.quantity.push({name: '', value: 0})
      this.unitPrice = res.data.list.map(item => {
        return {name: item.productName, value: item.unitPrice }
      })
      this.unitPrice.unshift({name: '', value: 0})
      this.unitPrice.push({name: '', value: 0})
    },
  }
};
</script>

<style scoped>
.parent-component {
  text-align: center;
  margin-top: 50px;
}
</style>
