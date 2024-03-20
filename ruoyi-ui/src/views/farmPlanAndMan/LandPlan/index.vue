<template>
  <div>
    <!-- 使用土地信息表格组件 -->
    <Table  title="土地信息" :totalNum="totalNum" :columns="tableColumns" :data="landData" @delete="handleDelete" @currentpagechange="handleCurrentPageChange" @save="handleSave" @add="handleAdd" />
  </div>
</template>

<script>
import Table from '/src/components/Table/Table.vue';
import { getPlanList } from '@/api/data/LandPlaning'

export default {
  components: {
    Table
  },
  data() {
    return {
      landData: [ // 假数据
        { landId: 1, location: "地点A", area: 1000, topography: "山地", soilType: "黄土", ownership: "张三", landUse: "农田", ecologicalEnvironment: "生态良好", marketValue: 50000, planningUse: "农业", ownerIntent: "发展农业" },
        { landId: 2, location: "地点B", area: 2000, topography: "平原", soilType: "沙土", ownership: "李四", landUse: "工地", ecologicalEnvironment: "环境污染", marketValue: 100000, planningUse: "工业", ownerIntent: "建设工厂" },
        { landId: 3, location: "地点C", area: 1500, topography: "湿地", soilType: "泥土", ownership: "王五", landUse: "公园", ecologicalEnvironment: "生态保护", marketValue: 80000, planningUse: "公共", ownerIntent: "绿化城市" }
      ],
      totalNum:20,
      tableColumns: [
        { prop: 'landId', label: '土地编号',type: "input" },
        { prop: 'location', label: '地理位置' ,type: "input"},
        { prop: 'area', label: '土地面积（平方米）',type: "input" },
        { prop: 'topography', label: '土地形态' ,type: "input"},
        { prop: 'soilType', label: '土壤类型' ,type: "input"},
        { prop: 'ownership', label: '土地所有者',type: "input" },
        { prop: 'landUse', label: '土地用途',type: "input" },
        { prop: 'ecologicalEnvironment', label: '土地生态环境描述',type: "input" },
        { prop: 'marketValue', label: '土地市场价值' ,type: "input"},
        { prop: 'planningUse', label: '土地规划用途',type: "input" },
        { prop: 'ownerIntent', label: '土地所有者的意愿和目标',type: "input" }
      ]
    };
  },
 async created() {
   const res = await getPlanList(1,10)
   console.log(res)
   this.landData = res.data
  },
  methods: {
    // 删除土地信息
    handleDelete(index) {
      this.landData.splice(index, 1); // 从 landData 中删除指定索引的土地信息
    },
    // 保存土地信息
    handleSave(data) {
      // 根据数据中的信息进行保存操作，这里可以发送请求给后端或者进行其他操作
      console.log('保存土地信息:', data);
    },
    // 添加土地信息
    handleAdd(data) {
      // 将新增的土地信息添加到 landData 中
      console.log(data)
      this.landData.push(data);
    },
    handleCurrentPageChange(currentPage){
      console.log(currentPage)
    },
  }
};
</script>
