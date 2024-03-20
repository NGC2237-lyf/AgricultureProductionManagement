<template>
  <div class="chat-container" :style="{ maxWidth: `${width}px`, minWidth: `${width}px` }">
    <h2 class="chat-title">{{ title }}</h2>
    <el-row>
      <el-col :span="24">
        <div class="message-box" :style="{ maxHeight: `${height}px`, minHeight: `${height}px` }">
          <div v-for="(message, index) in messages" :key="index"
               :class="message.sender === 'user' ? 'user-message' : 'response-message'"
          >
            <el-avatar v-if="message.sender === 'response'" class="avatar" alt="Response Avatar">客服</el-avatar>
            <div class="message-content"  :style="{ maxWidth: `${width/3}px`, minWidth: `${width/3}px` }">
              {{ message.text }}
            </div>
            <el-avatar v-if="message.sender === 'user'" class="avatar" alt="User Avatar">我</el-avatar>
          </div>
        </div>
      </el-col>
    </el-row>
    <el-row>
      <el-col>
        <div class="input-box">
          <el-input v-model="newMessage" :placeholder="placeholder" @keyup.enter.native="sendMessage">
            <el-button :disabled="sendDisabled" slot="append" icon="el-icon-chat-line-round" @click="sendMessage">
              {{ buttonText }}
            </el-button>
          </el-input>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  props: {
    title: {
      type: String,
      default: 'Chat'
    },
    width: {
      type: Number,
      default: 800
    },
    height: {
      type: Number,
      default: 600
    },
    placeholder: {
      type: String,
      default: '请输入文字...'
    },
    buttonText: {
      type: String,
      default: '发送'
    }
  },
  data() {
    return {
      messages: [],
      newMessage: '',
      sendDisabled: false
    }
  },
  methods: {
    sendMessage() {
      if (this.newMessage.trim() === '' || this.sendDisabled) return
      this.addMessage({ text: this.newMessage, sender: 'user' })
      this.$emit('send', { text: this.newMessage, sender: 'user' })
      this.newMessage = ''
      this.sendDisabled = true
    },
    addMessage(message) {
      this.messages.push(message)
    }
  },
  mounted() {
    this.$on('receive', (message) => {
      this.messages.push(message)
      this.sendDisabled = false
    })
  }
}
</script>

<style scoped>
.chat-container {
  min-width: 800px;
  width: 900px;
  margin: 30px auto;
}

.chat-title {
  font-size: 24px;
  margin-bottom: 20px;
}

.message-box {
  padding: 20px;
  //background: #d5d4d4;
  overflow: auto;
}

.avatar {
  width: 45px;
  height: 45px;
  border-radius: 50%;
  margin-right: 10px;
  background: #466991;
}

.user-message {
  display: flex;
  align-items: center;
  justify-content: flex-end;
  margin-bottom: 10px;
}

.response-message {
  display: flex;
  align-items: center;
  margin-bottom: 10px;
}

.message-content {
  background-color: #7ce374;
  padding: 10px;
  margin-right: 10px;
  border-radius: 10px;
  word-wrap: break-word;
}

.input-box {
}
</style>
