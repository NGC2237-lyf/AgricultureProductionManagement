<template>
  <div class="weather-widget">
    <el-card class="weather-card">
      <div slot="header" class="weather-header">
        <span class="weather-title">{{ title }}</span>
        <el-button v-if="refreshable" type="text" icon="el-icon-refresh" @click="refreshWeather"></el-button>
      </div>
      <div class="weather-info">
        <div class="weather-location">
          <el-icon name="location"></el-icon>
          <span>{{ location }}</span>
        </div>
        <div  style="margin-top: 10px;margin-bottom: 10px">
          <i style="font-size: 50px" :class="'qi-'+weather.iconCode"></i>
          <span style="margin-left: 20px;line-height: 50px;">{{ weather.condition }}</span>
        </div>
        <div class="weather-temperature">
          <span>{{ weather.temperatureMax }}</span>
          <span>°C</span>
          <span style="margin-left: 10px;margin-right: 10px">——</span>
          <span>{{ weather.temperatureMin }}</span>
          <span>°C</span>
        </div>
        <div class="weather-details">
          <span>{{ humidityLabel }}: {{ weather.humidity }}</span>
          <span>{{ windSpeedLabel }}: {{ weather.windSpeed }}</span>
        </div>
        <div class="weather-details">
          <span>{{ sunrise }}: {{ weather.sunrise }}</span>
          <span>{{ sunset }}: {{ weather.sunset }}</span>
        </div>
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  props: {
    title: {
      type: String,
      default: '天气预报'
    },
    location: {
      type: String,
      default: '上海'
    },
    refreshable: {
      type: Boolean,
      default: true
    },
    humidityLabel: {
      type: String,
      default: '湿度'
    },
    windSpeedLabel: {
      type: String,
      default: '风速'
    },
    sunrise: {
      type: String,
      default: '日出'
    },
    sunset: {
      type: String,
      default: '日落'
    },
    weatherData: {
      type: Object,
      default: () => ({
        iconCode: '',
        condition: '',
        temperatureMax: '',
        temperatureMin:"",
        humidity: '',
        windSpeed: '',
        sunset:"",
        sunrise:""
      })
    }
  },
  computed: {
    weather() {
      return this.weatherData;
    }
  },
  methods: {
    refreshWeather() {
      this.$emit('refresh-weather');
    }
  }
};
</script>

<style scoped>
.weather-widget {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
}

.weather-card {
  width: 300px;
}

.weather-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.weather-title {
  font-size: 18px;
  font-weight: bold;
}

.weather-info {
  margin-top: 5px;
}

.weather-location {
  display: flex;
  align-items: center;
}

.weather-icon {
  width: 50px;
  height: 50px;
  margin-right: 10px;
}

.weather-condition {
  display: flex;
  align-items: center;
}

.weather-condition span {
  margin-left: 5px;
}

.weather-temperature {
  font-size: 24px;
  margin-top: 10px;
}

.weather-details {
  margin-top: 10px;
}

.weather-details span {
  margin-right: 10px;
}
</style>
