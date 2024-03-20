<template>
  <div id="app">
    <router-view/>
    <theme-picker/>
    <!-- 固定在右下角的按钮 -->
    <div class="fixed-button-container">
      <!-- 气泡效果 -->
      <el-popover
        v-model="showBubble"
        placement="top"
        width="450"
        trigger="click"
        :popper-class="['bubble-popover', showBubble ? 'bubble-popover-show' : ''].join(' ')"
      >
        <Chat
          title="智能助手"
          :height="400"
          :width="400"
          @send="sendMessage"
          ref="chatRef"
          chatUser="助手"
        />
        <el-button type="text"  icon="el-icon-chat-line-round" slot="reference">智能助手</el-button>
      </el-popover>
    </div>
  </div>
</template>

<script>
import ThemePicker from '@/components/ThemePicker'
import Chat from "@/components/Chat/index.vue";

export default {
  name: 'App',
  components: { ThemePicker,Chat },
  data() {
    return {
      showBubble: false
    }
  },
  methods: {
    // 切换气泡的显示状态
    sendMessage(message) {
      // 模拟异步发送消息的过程
      setTimeout(() => {
        // 向 Chat 组件发送消息
        this.$refs.chatRef.$emit('receive', { text: 'This is an automated response.', sender: 'response' })
      }, 3000)

      // 实际项目中，您可以在这里调用后端API发送消息
      console.log("Message sent:", message);
    }
  },
  metaInfo() {
    return {
      title: this.$store.state.settings.dynamicTitle && this.$store.state.settings.title,
      titleTemplate: title => {
        return title ? `${title} - ${process.env.VUE_APP_TITLE}` : process.env.VUE_APP_TITLE
      }

    }
  }
}
</script>
<style scoped>
#app .theme-picker {
  display: none;
}


.fixed-button-container {
  position: fixed;
  bottom: 50px;
  right: 50px;
  z-index: 1000; /* 确保按钮位于页面最上层 */
}

.bubble-popover-show {
  visibility: visible !important;
  opacity: 1 !important;
}

/* 自定义气泡效果样式 */
.bubble-popover .el-popover__title {
  display: none; /* 隐藏标题栏 */
}

.bubble-popover .el-popover__content {
  padding: 10px;
  border-radius: 5px;
  background-color: #409eff;
  color: #fff;
}
</style>

