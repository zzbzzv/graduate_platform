import request from '@/utils/request'

// 查询出院患者列表
export function listDispatient(query) {
  return request({
    url: '/dispatient/dispatient/list',
    method: 'get',
    params: query
  })
}

// 查询出院患者详细
export function getDispatient(id) {
  return request({
    url: '/dispatient/dispatient/' + id,
    method: 'get'
  })
}

// 新增出院患者
export function addDispatient(data) {
  return request({
    url: '/dispatient/dispatient',
    method: 'post',
    data: data
  })
}

// 修改出院患者
export function updateDispatient(data) {
  return request({
    url: '/dispatient/dispatient',
    method: 'put',
    data: data
  })
}

// 删除出院患者
export function delDispatient(id) {
  return request({
    url: '/dispatient/dispatient/' + id,
    method: 'delete'
  })
}
