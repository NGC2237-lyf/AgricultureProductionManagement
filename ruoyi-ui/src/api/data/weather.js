import { Axios } from 'axios'

 export const getWeather=() => {
  const url = `https://devapi.qweather.com/v7/weather/3d?location=101010100&key=e0c0881b2b37484e96cef30854a46755`
  return new  Axios({}).get(url)
 }
