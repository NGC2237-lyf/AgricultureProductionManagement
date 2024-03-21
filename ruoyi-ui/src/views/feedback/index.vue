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
import { AIQuestion } from '@/api/data/getInfoData'

export default {
  components: {
    Chat
  },
  methods: {
    async sendMessage(message) {
      const res =  await AIQuestion(message.text)
      this.$refs.chatRef.$emit('receive', { text: res.data, sender: 'response' })
    }
  }
}
</script>

<!-- 样式可以根据需要添加 -->

