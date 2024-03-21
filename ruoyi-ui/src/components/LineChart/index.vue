<template>
  <!-- ECharts 图表容器 -->
  <div class="echarts-chart" :style="{ width: chartWidth, height: chartHeight }" ref="echartsChart"></div>
</template>

<script>
import * as echarts from "echarts";

export default {
  props: {
    // 图表宽度
    chartWidth: {
      type: String,
      default: '600px'
    },
    // 图表高度
    chartHeight: {
      type: String,
      default: '400px'
    },
    // 图表数据
    chartData: {
      type: Array,
      default: () => []
    },
    // 图表标题
    chartTitle: {
      type: String,
      default: 'Combined Chart'
    },
    // 是否启用动画
    animation: {
      type: Boolean,
      default: true
    }
  },
  mounted() {
    // 组件挂载时绘制图表
    this.drawChart();
  },
  watch: {
    // 监听图表数据的变化，重新绘制图表
    chartData: {
      handler() {
        this.drawChart();
      },
      deep: true
    }
  },
  methods: {
    // 绘制图表的方法
    drawChart() {
      // 初始化 ECharts 实例
      const chart = echarts.init(this.$refs.echartsChart);

      // 图表配置项
      const options = {
        // 标题配置
        title: {
          text: this.chartTitle,
          left: 'center',
          textStyle: {
            color: '#333',
            fontSize: 18,
            fontWeight: 'bold'
          }
        },
        // 提示框配置
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'cross',
            label: {
              backgroundColor: '#6a7985'
            }
          }
        },
        // 网格配置
        grid: {
          right: '10%',
          bottom: '3%',
          containLabel: true
        },
        // X 轴配置
        xAxis: {
          type: 'category',
          boundaryGap: false,
          data: this.chartData.map(item => item.name),
          axisLine: {
            lineStyle: {
              color: '#999'
            }
          }
        },
        // Y 轴配置
        yAxis: {
          type: 'value',
          axisLine: {
            lineStyle: {
              color: '#999'
            }
          },
          splitLine: {
            lineStyle: {
              type: 'dashed',
              color: '#ddd'
            }
          },
          // 确保柱子不压在 Y 轴上
          min: 0
        },
        // 系列数据配置
        series: [
          {
            name: '柱状图',
            type: 'bar',
            barWidth: '7%',
            itemStyle: {
              color: '#15294d'
            },
            data: this.chartData.map(item => item.value * 1.5)
          }
        ]
      };

      // 是否启用动画
      if (this.animation) {
        options.animationDuration = 1000;
        options.animationEasing = 'cubicInOut';
      } else {
        options.animation = false;
      }
      // 设置图表配置项
      chart.setOption(options);
    }
  }
}
</script>

<style scoped>
.echarts-chart {
  margin: 20px auto;
}
</style>
