<template>
  <div>
    <!-- 使用作灌溉系统表格组件 -->
    <Table
      title="灌溉系统"
      :totalNum="totalNum"
      :columns="tableColumns"
      :data="irrigationSystemData"
      :options="selectOptions"
      @delete="handleDelete"
      @currentpagechange="handleCurrentPageChange"
      @save="handleSave"
      @add="handleAdd"
    />
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
      irrigationSystemData: [ // 假数据
        { trackingId: 1, farmId: 101, landId: 201, cropType: 'option1', growthStage: 'Seedling', observationDate: '2024-03-20', height: 20, canopyWidth: 30, leafColor: 'Green', pestPresence: 'None', diseasePresence: 'None', nutrientDeficiency: 'None', notes: 'Some notes' },
        { trackingId: 2, farmId: 102, landId: 202, cropType: 'option2', growthStage: 'Flowering', observationDate: '2024-03-21', height: 25, canopyWidth: 35, leafColor: 'Yellow', pestPresence: 'Some pests', diseasePresence: 'None', nutrientDeficiency: 'None', notes: 'Some notes' },
        { trackingId: 3, farmId: 103, landId: 203, cropType: 'option3', growthStage: 'Fruiting', observationDate: '2024-03-22', height: 30, canopyWidth: 40, leafColor: 'Brown', pestPresence: 'None', diseasePresence: 'Some disease', nutrientDeficiency: 'None', notes: 'Some notes' }
      ],
      totalNum: 3, // 数据总数
      tableColumns: [ // 表格列配置
        { prop: 'trackingId', label: '跟踪编号',type: "input" },
        { prop: 'farmId', label: '农场/农户编号' ,type: "input"},
        { prop: 'landId', label: '地块编号' ,type: "input"},
        { prop: 'cropType', label: '作物种类', type: 'select', options: this.getSelectOptions() },
        { prop: 'growthStage', label: '生长阶段' ,type: "input"},
        { prop: 'observationDate', label: '观测日期',type: "input" },
        { prop: 'height', label: '高度（厘米）',type: "input" },
        { prop: 'canopyWidth', label: '冠幅宽度（厘米）',type: "input" },
        { prop: 'leafColor', label: '叶片颜色',type: "input" },
        { prop: 'pestPresence', label: '害虫存在情况' ,type: "input"},
        { prop: 'diseasePresence', label: '病害存在情况' ,type: "input"},
        { prop: 'nutrientDeficiency', label: '养分缺乏情况',type: "input" },
        { prop: 'notes', label: '备注' ,type: "input"}
      ],

    };
  },
  computed: {
    selectOptions() {
      return [
        { value: 'option1', label: '选项1' },
        { value: 'option2', label: '选项2' },
        { value: 'option3', label: '选项3' }
      ];
    }
  },
  methods: {
    getSelectOptions() {
      return [
        { value: 'option1', label: '选项1' },
        { value: 'option2', label: '选项2' },
        { value: 'option3', label: '选项3' }
      ];
    },
    // 处理删除事件
    handleDelete(index) {
      // 处理删除操作
    },
    // 处理保存事件
    handleSave(data) {
      // 处理保存操作
    },
    // 处理添加事件
    handleAdd(data) {
      // 处理添加操作
    },
    // 处理当前页变化事件
    handleCurrentPageChange(currentPage) {
      // 处理当前页变化操作
    }
  }
};
</script>
