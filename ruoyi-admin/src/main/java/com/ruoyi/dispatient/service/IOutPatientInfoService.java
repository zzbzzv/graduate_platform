package com.ruoyi.dispatient.service;

import java.util.List;
import com.ruoyi.dispatient.domain.OutPatientInfo;

/**
 * 出院患者Service接口
 * 
 * @author czs
 * @date 2025-04-06
 */
public interface IOutPatientInfoService
{
    /**
     * 查询出院患者
     * 
     * @param id 出院患者主键
     * @return 出院患者
     */
    public OutPatientInfo selectHisPatientInfoById(Long id);

    /**
     * 查询出院患者列表
     * 
     * @param outPatientInfo 出院患者
     * @return 出院患者集合
     */
    public List<OutPatientInfo> selectHisPatientInfoList(OutPatientInfo outPatientInfo);

    /**
     * 新增出院患者
     * 
     * @param outPatientInfo 出院患者
     * @return 结果
     */
    public int insertHisPatientInfo(OutPatientInfo outPatientInfo);

    /**
     * 修改出院患者
     * 
     * @param outPatientInfo 出院患者
     * @return 结果
     */
    public int updateHisPatientInfo(OutPatientInfo outPatientInfo);

    /**
     * 批量删除出院患者
     * 
     * @param ids 需要删除的出院患者主键集合
     * @return 结果
     */
    public int deleteHisPatientInfoByIds(Long[] ids);

    /**
     * 删除出院患者信息
     * 
     * @param id 出院患者主键
     * @return 结果
     */
    public int deleteHisPatientInfoById(Long id);
}
