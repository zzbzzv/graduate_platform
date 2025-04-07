import request from '@/utils/request'

// 获取医保工作台数据
export function getYbWorkbenchData(params) {
  return request({
    url: '/yb/workbench/data',
    method: 'get',
    params
  })
}

// 获取盈利病种
export function getProfitDiseases(params) {
  return request({
    url: '/yb/workbench/profit-diseases',
    method: 'get',
    params
  })
}

// 获取亏损病种
export function getLossDiseases(params) {
  return request({
    url: '/yb/workbench/loss-diseases',
    method: 'get',
    params
  })
}

// 导出盈利病种
export function exportProfitDiseases(params) {
  return request({
    url: '/yb/workbench/export-profit-diseases',
    method: 'get',
    params,
    responseType: 'blob'
  })
}

// 导出亏损病种
export function exportLossDiseases(params) {
  return request({
    url: '/yb/workbench/export-loss-diseases',
    method: 'get',
    params,
    responseType: 'blob'
  })
}
