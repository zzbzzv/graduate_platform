import request from '@/utils/request'

// 查询在院患者列表
export function listInpatient(query) {
  return request({
    url: '/inpatient/inpatient/list',
    method: 'get',
    params: query
  })
}

// 查询在院患者详细
export function getInpatient(id) {
  return request({
    url: '/inpatient/inpatient/' + id,
    method: 'get'
  })
}

// 新增在院患者
export function addInpatient(data) {
  return request({
    url: '/inpatient/inpatient',
    method: 'post',
    data: data
  })
}

// 修改在院患者
export function updateInpatient(data) {
  return request({
    url: '/inpatient/inpatient',
    method: 'put',
    data: data
  })
}

// 删除在院患者
export function delInpatient(id) {
  return request({
    url: '/inpatient/inpatient/' + id,
    method: 'delete'
  })
}
