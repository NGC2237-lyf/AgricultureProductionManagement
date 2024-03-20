<template>
  <div>
    <!-- 使用土壤监测表格组件 -->
    <Table title="土壤监测" :totalNum="totalNum" :columns="tableColumns" :data="soilTestData" @delete="handleDelete" @currentPageChange="handleCurrentPageChange" @save="handleSave" @add="handleAdd" />
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
      soilTestData: [ // 假数据
        { testId: 1, location: 101, testDate: '2024-03-20', pHLevel: 6.5, nitrogen: 20.5, phosphorus: 10.2, potassium: 15.8, organicMatter: 3.2, texture: 'Loamy', salinity: 0.3, soilMoisture: 20, soilType: 'Sandy loam', notes: 'Some notes' },
        { testId: 2, location: 102, testDate: '2024-03-21', pHLevel: 7.2, nitrogen: 18.3, phosphorus: 12.6, potassium: 14.7, organicMatter: 2.8, texture: 'Clay', salinity: 0.5, soilMoisture: 25, soilType: 'Silty clay', notes: 'Some notes' },
        { testId: 3, location: 103, testDate: '2024-03-22', pHLevel: 6.8, nitrogen: 22.1, phosphorus: 9.8, potassium: 16.3, organicMatter: 3.5, texture: 'Sandy', salinity: 0.4, soilMoisture: 18, soilType: 'Sandy clay loam', notes: 'Some notes' }
      ],
      totalNum: 20, // 总数据条数
      tableColumns: [
        { prop: 'testId', label: '检测编号', type: 'number' ,show: true},
        { prop: 'location', label: '检测地块', type: 'number' },
        { prop: 'testDate', label: '检测日期', type: 'date' },
        { prop: 'pHLevel', label: 'pH值', type: 'number' },
        { prop: 'nitrogen', label: '氮含量（mg/kg）', type: 'number' },
        { prop: 'phosphorus', label: '磷含量（mg/kg）', type: 'number' },
        { prop: 'potassium', label: '钾含量（mg/kg）', type: 'number' },
        { prop: 'organicMatter', label: '有机物含量（百分比）', type: 'number' },
        { prop: 'texture', label: '土壤质地', type: 'input' },
        { prop: 'salinity', label: '盐分含量（毫克/千克）', type: 'number' },
        { prop: 'soilMoisture', label: '土壤湿度（百分比）', type: 'number' },
        { prop: 'soilType', label: '土壤类型', type: 'input' },
        { prop: 'notes', label: '备注', type: 'input' }
      ]
    };
  },
  methods: {
    // 删除土壤监测记录
    handleDelete(index) {
      this.soilTestData.splice(index, 1); // 从 soilTestData 中删除指定索引的土壤监测记录
    },
    // 保存土壤监测记录
    handleSave(data) {
      // 根据数据中的信息进行保存操作，这里可以发送请求给后端或者进行其他操作
      console.log('保存土壤监测记录:', data);
    },
    // 添加土壤监测记录
    handleAdd(data) {
      // 将新增的土壤监测记录添加到 soilTestData 中
      this.soilTestData.push(data);
    },
    // 处理当前页变化事件
    handleCurrentPageChange(currentPage) {
      console.log(currentPage);
    }
  }
};
</script>
