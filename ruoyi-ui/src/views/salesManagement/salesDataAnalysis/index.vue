<template>
  <div class="parent-component">
    <h2>折线图示例</h2>
    <line-chart
      :chart-width="'800px'"
      :chart-height="'500px'"
      :chart-data="chartData"
      :chart-title="'销售额趋势图'"
      :x-axis-name="'月份'"
      :y-axis-name="'销售额'"
      :animation="true"
    ></line-chart>
  </div>
</template>

<script>
import LineChart from '@/components/LineChart/index.vue'; // 导入折线图组件

export default {
  components: {
    LineChart // 注册折线图组件
  },
  data() {
    return {
      chartData: [ // 折线图数据
        { name: '一月', value: 120 },
        { name: '二月', value: 200 },
        { name: '三月', value: 150 },
        { name: '四月', value: 380 },
        { name: '五月', value: 250 },
        { name: '六月', value: 300 }
      ]
    };
  }
};
</script>

<style scoped>
.parent-component {
  text-align: center;
  margin-top: 50px;
}
</style>
