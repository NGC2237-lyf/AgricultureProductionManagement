<template>
  <div>
    <!-- 使用作物种植计划表格组件 -->
    <Table title="作物种植计划" :totalNum="totalNum" :columns="tableColumns" :data="planData" @delete="handleDelete" @currentpagechange="handleCurrentPageChange" @save="handleSave" @add="handleAdd" />
  </div>
</template>

<script>
import Table from '/src/components/Table/Table.vue';

export default {
  components: {
    Table
  },
  data() {
    return {
      planData: [ // 假数据
        { planId: 1, farmId: 1, year: 2024, season: "春季", landId: 1, cropType: "小麦", plantingArea: 1000, expectedYield: 5000, plantingDate: "2024-03-20", harvestDate: "2024-06-30", plantingMethod: "直播", fertilizerUsage: "化肥A: 10kg, 化肥B: 5kg", pesticideUsage: "农药X: 2kg", notes: "无" },
        { planId: 2, farmId: 2, year: 2024, season: "春季", landId: 2, cropType: "玉米", plantingArea: 2000, expectedYield: 10000, plantingDate: "2024-03-25", harvestDate: "2024-08-15", plantingMethod: "播种", fertilizerUsage: "化肥C: 15kg", pesticideUsage: "农药Y: 3kg", notes: "需注意病虫害防治" },
        { planId: 3, farmId: 3, year: 2024, season: "春季", landId: 3, cropType: "水稻", plantingArea: 1500, expectedYield: 8000, plantingDate: "2024-03-30", harvestDate: "2024-07-20", plantingMethod: "插秧", fertilizerUsage: "无", pesticideUsage: "无", notes: "无" }
      ],
      totalNum: 20,
      tableColumns: [
        { prop: 'planId', label: '计划编号' ,type: "input"},
        { prop: 'farmId', label: '农场/农户编号' ,type: "input"},
        { prop: 'year', label: '年度' ,type: "input"},
        { prop: 'season', label: '季节' ,type: "input"},
        { prop: 'landId', label: '地块编号',type: "input" },
        { prop: 'cropType', label: '作物种类',type: "input" },
        { prop: 'plantingArea', label: '种植面积（平方米）' ,type: "input"},
        { prop: 'expectedYield', label: '预计产量（公斤）',type: "input" },
        { prop: 'plantingDate', label: '种植日期',type: "date" },
        { prop: 'harvestDate', label: '预计收获日期' ,type: "date"},
        { prop: 'plantingMethod', label: '种植方法' ,type: "input"},
        { prop: 'fertilizerUsage', label: '肥料使用情况' ,type: "input"},
        { prop: 'pesticideUsage', label: '农药使用情况',type: "input" },
        { prop: 'notes', label: '其他备注' ,type: "input"}
      ]
    };
  },
  methods: {
    // 删除作物种植计划
    handleDelete(index) {
      this.planData.splice(index, 1); // 从 planData 中删除指定索引的作物种植计划
    },
    // 保存作物种植计划
    handleSave(data) {
      // 根据数据中的信息进行保存操作，这里可以发送请求给后端或者进行其他操作
      console.log('保存作物种植计划:', data);
    },
    // 添加作物种植计划
    handleAdd(data) {
      // 将新增的作物种植计划添加到 planData 中
      console.log(data);
      this.planData.push(data);
    },
    handleCurrentPageChange(currentPage) {
      console.log(currentPage);
    },
  }
};
</script>
