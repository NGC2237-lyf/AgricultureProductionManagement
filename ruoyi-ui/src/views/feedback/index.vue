<template>
  <div>
    <Chat
      title="客服聊天"
      :height="400"
      :width="1200"
      background-color="#1f2d3d"
      @send="sendMessage"
      ref="chatRef" />
  </div>
</template>

<script>
import Chat from "@/components/Chat/index.vue";

export default {
  components: {
    Chat
  },
  methods: {
    sendMessage(message) {
      // 模拟异步发送消息的过程
      setTimeout(() => {
        // 向 Chat 组件发送消息
        this.$refs.chatRef.$emit('receive', { text: 'This is an automated response.', sender: 'response' })
      }, 3000)

      // 实际项目中，您可以在这里调用后端API发送消息
      console.log("Message sent:", message);
    }
  }
}
</script>

<!-- 样式可以根据需要添加 -->

