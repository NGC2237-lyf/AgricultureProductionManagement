<template>
  <div>
    <Chat
      title="智能决策"
      :height="400"
      :width="1200"
      background-color="#1f2d3d"
      @send="sendMessage"
      ref="chatRef"
      chat-user="建议"
    />
  </div>
</template>

<script>
import Chat from "@/components/Chat/index.vue";
import Navbar from '@/layout/components/Navbar.vue'
import { AIQuestion } from '@/api/data/getInfoData'

export default {
  components: {
    Navbar,
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

