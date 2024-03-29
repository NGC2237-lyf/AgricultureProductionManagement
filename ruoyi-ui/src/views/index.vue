<template>
  <div style="margin: 20px">
    <div class="left-section">
      <!-- 热门农产品介绍 -->
      <div class="product-introduction">
        <h2>热门农产品介绍</h2>
        <div class="product-list">
          <div class="product-item" v-for="product in hotProducts" :key="product.id">
            <h3>{{ product.name }}</h3>
            <p>{{ product.description }}</p>
          </div>
        </div>
      </div>

      <!-- 农业资讯 -->
      <div class="other-information">
        <h2>农业资讯</h2>
        <div class="news-list">
          <div class="news-item" v-for="news in agriculturalNews" :key="news.id">
            <h3>{{ news.title }}</h3>
            <p>{{ news.description }}</p>
          </div>
        </div>
      </div>
      <div class="other-information">
        <h2>销售数据</h2>
        <div>
          <line-chart
            :chart-width="'70vw'"
            :chart-height="'600px'"
            :chart-data="chartData"
            :chart-title="'销售额趋势图'"
            :x-axis-name="'月份'"
            :y-axis-name="'销售额'"
            :animation="true"
          ></line-chart>
        </div>
      </div>
    </div>


    <!-- 右侧的天气组件 -->
    <div class="right-section">
      <WeatherWidget
        :title="widgetTitle"
        :location="widgetLocation"
        :refreshable="widgetRefreshable"
        :humidityLabel="widgetHumidityLabel"
        :windSpeedLabel="widgetWindSpeedLabel"
        :weatherData="weatherData"
        @refresh-weather="handleRefreshWeather"
      />
    </div>


  </div>
</template>

<script>
import WeatherWidget from '@/components/Weather/index.vue'
import LineChart from '@/components/LineChart/index.vue'
import { getWeather } from '@/api/data/weather'
import { listUser } from '@/api/system/user'
import { getPlanList, MarketSales } from '@/api/data/getInfoData'

export default {
  components: {
    LineChart,
    WeatherWidget
  },
  data() {
    return {
      widgetTitle: '天气预报',
      widgetLocation: '北京',
      widgetRefreshable: true,
      widgetHumidityLabel: '湿度',
      widgetWindSpeedLabel: '风速',
      weatherData: {},
      chartData: [],
      hotProducts: [
        { id: 1, name: '苹果', description: '新鲜美味的苹果，产自华北平原地区。' },
        { id: 2, name: '橙子', description: '酸甜可口的橙子，适合各种场合食用。' }
        // 可以继续添加更多热门农产品
      ],
      agriculturalNews: [
        { id: 1, title: '农业技术进步', description: '最新的农业技术为农民带来了丰收的希望。' },
        { id: 2, title: '农产品市场行情', description: '近期农产品价格波动较大，需要密切关注市场动态。' }
        // 可以继续添加更多农业资讯
      ]

    }
  },
  async created() {
    await this.fetchWeatherData()
    await this.getInfo()
  },
  methods: {
    async getInfo() {
      const res = await getPlanList(MarketSales, 1, 9999)
      this.chartData = res.data.list.map(item => {
        return { name: item.productName, value: item.totalPrice }
      })
      this.chartData.unshift({name: '', value: 0})
      this.chartData.push({name: '', value: 0})
    },
    async fetchWeatherData() {
      // 模拟天气数据获取
      const res = await getWeather()
      const weather = JSON.parse(res.data).daily[0]
      this.weatherData = {
        iconCode: weather.iconDay,
        condition: weather.textDay,
        temperatureMax: weather.tempMax,
        temperatureMin: weather.tempMin,
        humidity: weather.humidity,
        windSpeed: weather.windSpeedDay,
        sunrise: weather.sunrise,
        sunset: weather.sunset
      }
    },
    handleRefreshWeather() {
      this.fetchWeatherData()
    }
  }
}
</script>

<style scoped>
.left-section {
  float: left;
  width: 70%; /* 调整左侧区域宽度 */
}

.right-section {
  float: right;
  margin-right: 20px;
  //width: 30%; /* 调整右侧区域宽度 */
}

.product-introduction,
.other-information {
  margin-bottom: 50px;
}

.product-list,
.news-list {
  display: flex;
  justify-content: space-around;
}

.product-item,
.news-item {
  width: 45%; /* 调整单个项目宽度 */
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.product-item img {
  width: 100%;
  height: auto;
}

.product-item h3,
.news-item h3 {
  margin-top: 10px;
  margin-bottom: 5px;
}
</style>
