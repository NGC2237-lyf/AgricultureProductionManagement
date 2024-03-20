import request from '@/utils/request'

// 获取路由
export const getPlanList = (pageNum,pageSize) => {
  return request({
    url: `/farm/land/${pageNum}/${pageSize}`,
    method: 'get'
  })
}
