import request from '@/utils/request'
import { splicingStrings } from '@/utils/splicingStrings'
export const Land = ["farm","land"]
export const CropPlanting = ["farm","cropPlanting"]
export const IrrigationRecord =["farm","irrigationRecord"]
export const AgricultureSoil =["agriculture","soil"]
export const AgricultureCrop =["agriculture","crop"]
export const MarketAdministration =["market","products"]
export const MarketRecommendation =["market","products","price"]
export const MarketSales =["market","products","sales"]

// 获取路由
export const getPlanList = (routerArr,pageNum, pageSize) => {
  return request({
    url: `${splicingStrings(routerArr)}/${pageNum}/${pageSize}`,
    method: 'get',
  })
}

export const getShopList = (routerArr,pageNum, pageSize,p) => {
  return request({
    url: `${splicingStrings(routerArr)}/${pageNum}/${pageSize}`,
    method: 'get',
    params:{
      p:p
    }
  })
}
export const getProductList = (routerArr,pageNum, pageSize,w) => {
  return request({
    url: `${splicingStrings(routerArr)}/${pageNum}/${pageSize}`,
    method: 'get',
    params:{
      w:w
    }
  })
}
export const insertPlan = (routerArr,data) => {
  return request({
    url: `${splicingStrings(routerArr)}/insert`,
    method: 'post',
    data: data
  })
}

export const deletePlan = (routerArr,data) => {
  return request({
    url: `${splicingStrings(routerArr)}/delete`,
    method: 'post',
    data:data
  })
}

export const updatePlan = (routerArr,data) => {
  return request({
    url: `${splicingStrings(routerArr)}/update`,
    method: 'post',
    data: data
  })
}

export const AIQuestion = (question) => {
  return request({
    url: `/agriculture/question`,
    method: 'get',
    params:{
      q:question
    }
  })
}
