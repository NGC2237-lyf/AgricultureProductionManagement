<template>
  <div class="background">
    <!-- 添加按钮 -->
    <el-button type="primary" class="button" @click="showAddDialog" v-if="showEdit">{{'添加'+this.title}}</el-button>
    <!-- 表格 -->
    <el-table :data="currentPageData" class="table">
      <el-table-column v-for="(column, index) in columns" :key="index" :prop="column.prop" :label="column.label"></el-table-column>
      <el-table-column label="操作" v-if="showEdit">
        <template slot-scope="scope" >
          <el-button @click="handleEdit(scope.$index, scope.row)" type="text" size="small">编辑</el-button>
          <el-button @click="confirmDelete(scope.$index)" style="color: red" type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <el-pagination
      class="pagination"
      v-if="total > 0"
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-size="pageSize"
      :total="total"
    ></el-pagination>
    <!-- 编辑/添加对话框 -->
    <el-dialog :visible.sync="dialogVisible" :title="dialogTitle" width="50%" :close-on-press-escape="false" :close-on-click-modal="false">
      <el-form :model="formData" :rules="formRules" ref="formData" label-width="200px">
        <el-form-item v-for="(column, index) in formColumns" :key="index" :label="column.label" :prop="column.prop" v-if="!column.show"
                      :rules="[{ required: true, message: '请输入' + column.label, trigger: 'blur' }]">
          <!-- 根据输入框类型判断使用哪种组件 -->
          <template v-if="column.type === 'input'">
            <el-input v-model="formData[column.prop]" :type="column.inputType"></el-input>
          </template>
          <template v-else-if="column.type === 'select'">
            <el-select v-model="formData[column.prop]" placeholder="请选择">
              <el-option v-for="option in column.options" :key="option.value" :label="option.label" :value="option.value"></el-option>
            </el-select>
          </template>
          <template v-else-if="column.type === 'date'">
            <el-date-picker v-model="formData[column.prop]" type="date" placeholder="选择日期"></el-date-picker>
          </template>
          <template v-else-if="column.type === 'number'  ">
            <el-input-number v-model="formData[column.prop]" controls-position="right"></el-input-number>
          </template>
        </el-form-item>
      </el-form>
      <!-- 对话框底部按钮 -->
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="saveForm">{{ isEditMode ? '保存' : '添加' }}</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  props: {
    showEdit:{
      type:Boolean,
      default:true
    },
    columns: {
      type: Array,
      required: true
    },
    data: {
      type: Array,
      required: true
    },
    title: {
      type: String,
      required: true
    },
    totalNum: {
      type: Number,
      required: true
    }
  },
  data() {
    return {
      dialogVisible: false, // 控制对话框显示
      dialogTitle: '', // 对话框标题
      formData: {}, // 表单数据
      formRules: {}, // 表单验证规则
      formColumns: this.columns.filter(column => column.prop), // 用于表单的列，不包括 landId
      currentPage: 1,
      pageSize: 10,
      isEditMode: false, // 编辑模式标志
      deleteIndex: null // 要删除的数据的索引
    }
  },
  computed: {
    total() {
      return this.totalNum
    },
    currentPageData() {
      return this.data
    }
  },
  methods: {
    // 显示添加对话框
    showAddDialog() {
      this.dialogTitle = '添加' + this.title
      this.formData = {} // 清空表单数据
      this.dialogVisible = true // 显示对话框
      this.isEditMode = false // 进入添加模式
    },
    // 保存表单数据
    saveForm() {
      // 表单验证
      this.$refs.formData.validate(valid => {
        if (valid) {
          // 在这里处理表单提交逻辑，根据需要发送请求或者进行本地数据操作
          // 传递编辑/添加的数据给父组件
          if (this.isEditMode) {
            // 编辑模式
            this.$emit('save', this.formData)
          } else {
            // 添加模式
            this.$emit('add', this.formData)
          }
          // 关闭对话框
          this.dialogVisible = false
        } else {
          // 如果表单验证不通过，则不进行保存操作
          return false
        }
      })
    },
    // 显示编辑对话框
    handleEdit(index, row) {
      this.dialogTitle = '编辑' + this.title
      this.formData = Object.assign({}, row) // 编辑时填充表单数据
      this.dialogVisible = true // 显示对话框
      this.isEditMode = true // 进入编辑模式
    },
    // 删除按钮点击事件
    confirmDelete(index) {
      this.deleteIndex = index // 设置要删除的数据的索引
      // 弹出确认删除的对话框
      this.$confirm('确认删除吗？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        // 用户点击确定后执行删除操作
        this.handleDelete()
      }).catch(() => {
        // 用户点击取消后不做任何操作
      })
    },
    // 删除土地信息
    handleDelete() {
      const start = (this.currentPage - 1) * this.pageSize
      const index = start + this.deleteIndex
      this.$emit('delete', index) // 向父组件发送删除事件
    },
    // 当前页变化
    handleCurrentChange(currentPage) {
      this.currentPage = currentPage
      this.$emit('currentpagechange', currentPage) // 向父组件发送当前页变化事件
    }
  }
}
</script>

<style>
.background {
  padding: 20px
}

.button {
  float: right
}

.table {
  width: 100%;
  margin-top: 40px;
}

.pagination {
  margin-top: 20px;
  text-align: right;
}
</style>
