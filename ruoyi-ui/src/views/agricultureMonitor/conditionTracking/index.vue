<template>
  <div>
    <!-- 使用生长状况跟踪表格组件 -->
    <Table title="生长状况跟踪" :totalNum="totalNum" :columns="tableColumns" :data="trackingData" @delete="handleDelete" @currentPageChange="handleCurrentPageChange" @save="handleSave" @add="handleAdd" />
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
      trackingData: [ // 假数据
        { trackingId: 1, farmId: 101, landId: 201, cropType: '小麦', growthStage: '发芽期', observationDate: '2024-03-20', height: 10.5, canopyWidth: 30.2, leafColor: 'Green', pestPresence: '无', diseasePresence: '无', nutrientDeficiency: '无', notes: 'Some notes' },
        { trackingId: 2, farmId: 102, landId: 202, cropType: '玉米', growthStage: '生长期', observationDate: '2024-03-21', height: 20.3, canopyWidth: 40.1, leafColor: 'Green', pestPresence: '少量', diseasePresence: '无', nutrientDeficiency: '缺钾', notes: 'Some notes' },
        { trackingId: 3, farmId: 103, landId: 203, cropType: '水稻', growthStage: '抽穗期', observationDate: '2024-03-22', height: 30.8, canopyWidth: 50.5, leafColor: 'Green', pestPresence: '中等', diseasePresence: '轻微', nutrientDeficiency: '缺氮', notes: 'Some notes' }
      ],
      totalNum: 20, // 总数据条数
      tableColumns: [
        { prop: 'trackingId', label: '跟踪编号', type: 'number' },
        { prop: 'farmId', label: '农场/农户编号', type: 'number' },
        { prop: 'landId', label: '地块编号', type: 'number' },
        { prop: 'cropType', label: '作物种类', type: 'input' },
        { prop: 'growthStage', label: '生长阶段', type: 'select', options: this.getGrowthStageOptions() },
        { prop: 'observationDate', label: '观测日期', type: 'date' },
        { prop: 'height', label: '高度（厘米）', type: 'number' },
        { prop: 'canopyWidth', label: '冠幅宽度（厘米）', type: 'number' },
        { prop: 'leafColor', label: '叶片颜色', type: 'input' },
        { prop: 'pestPresence', label: '害虫存在情况', type: 'input' },
        { prop: 'diseasePresence', label: '病害存在情况', type: 'input' },
        { prop: 'nutrientDeficiency', label: '养分缺乏情况', type: 'input' },
        { prop: 'notes', label: '备注', type: 'input' }
      ]
    };
  },
  methods: {
    // 删除生长状况跟踪记录
    handleDelete(index) {
      this.trackingData.splice(index, 1); // 从 trackingData 中删除指定索引的生长状况跟踪记录
    },
    // 保存生长状况跟踪记录
    handleSave(data) {
      // 根据数据中的信息进行保存操作，这里可以发送请求给后端或者进行其他操作
      console.log('保存生长状况跟踪记录:', data);
    },
    // 添加生长状况跟踪记录
    handleAdd(data) {
      // 将新增的生长状况跟踪记录添加到 trackingData 中
      this.trackingData.push(data);
    },
    // 处理当前页变化事件
    handleCurrentPageChange(currentPage) {
      console.log(currentPage);
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
