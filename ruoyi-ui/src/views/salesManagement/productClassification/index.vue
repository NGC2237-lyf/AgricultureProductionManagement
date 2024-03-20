<template>
  <div>
    <!-- 使用产品分类与定价表格组件 -->
    <ProductPriceTable
      title="产品分类与定价"
      :totalNum="totalNum"
      :columns="tableColumns"
      :data="productPriceData"
      :show-edit="false"
      @delete="handleDelete"
      @currentPageChange="handleCurrentPageChange"
      @save="handleSave"
      @add="handleAdd"
    />
  </div>
</template>

<script>
import ProductPriceTable from '/src/components/Table/Table.vue'

export default {
  components: {
    ProductPriceTable
  },
  data() {
    return {
      productPriceData: [ // 假数据
        {
          productId: 1,
          productName: 'Product A',
          harvestDate: '2024-03-20',
          quantity: 100,
          totality: 200,
          unit: 'kg',
          price: 10.5,
          recommendedPrice:1.00,
          expirationDate: '2024-05-19',
          storageConditions: 'Dry place'
        },
        {
          productId: 2,
          productName: 'Product B',
          harvestDate: '2024-03-21',
          quantity: 150,
          totality: 300,
          unit: 'kg',
          recommendedPrice:1.00,
          price: 8.75,
          expirationDate: '2024-05-20',
          storageConditions: 'Cool place'
        }
      ],
      totalNum: 20, // 总数据条数
      tableColumns: [
        { prop: 'productId', label: '产品编号', type: 'number' },
        { prop: 'productName', label: '产品名称', type: 'input' },
        { prop: 'harvestDate', label: '收获日期', type: 'date' },
        { prop: 'quantity', label: '当前数量', type: 'number' },
        { prop: 'totality', label: '总量', type: 'number' },
        { prop: 'unit', label: '单位', type: 'input' },
        { prop: 'price', label: '单价（元）', type: 'number' },
        { prop: 'recommendedPrice', label: '推荐价格（元）', type: 'number' },
        { prop: 'expirationDate', label: '过期日期', type: 'date' },
        { prop: 'storageConditions', label: '存储条件', type: 'input' }
      ]
    }
  },
  methods: {
    // 删除产品分类与定价记录
    handleDelete(index) {
      this.productPriceData.splice(index, 1) // 从 productPriceData 中删除指定索引的记录
    },
    // 保存产品分类与定价记录
    handleSave(data) {
      // 根据数据中的信息进行保存操作，这里可以发送请求给后端或者进行其他操作
      console.log('保存产品分类与定价记录:', data)
    },
    // 添加产品分类与定价记录
    handleAdd(data) {
      // 将新增的记录添加到 productPriceData 中
      this.productPriceData.push(data)
    },
    // 处理当前页变化事件
    handleCurrentPageChange(currentPage) {
      console.log(currentPage)
    }
  }
}
</script>
