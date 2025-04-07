package com.ruoyi.inpatient.service;

import java.util.List;
import com.ruoyi.inpatient.domain.HisPatientInfo;

/**
 * 在院患者Service接口
 * 
 * @author czs
 * @date 2025-04-06
 */
public interface IHisPatientInfoService 
{
    /**
     * 查询在院患者
     * 
     * @param id 在院患者主键
     * @return 在院患者
     */
    public HisPatientInfo selectHisPatientInfoById(Long id);

    /**
     * 查询在院患者列表
     * 
     * @param hisPatientInfo 在院患者
     * @return 在院患者集合
     */
    public List<HisPatientInfo> selectHisPatientInfoList(HisPatientInfo hisPatientInfo);

    /**
     * 新增在院患者
     * 
     * @param hisPatientInfo 在院患者
     * @return 结果
     */
    public int insertHisPatientInfo(HisPatientInfo hisPatientInfo);

    /**
     * 修改在院患者
     * 
     * @param hisPatientInfo 在院患者
     * @return 结果
     */
    public int updateHisPatientInfo(HisPatientInfo hisPatientInfo);

    /**
     * 批量删除在院患者
     * 
     * @param ids 需要删除的在院患者主键集合
     * @return 结果
     */
    public int deleteHisPatientInfoByIds(Long[] ids);

    /**
     * 删除在院患者信息
     * 
     * @param id 在院患者主键
     * @return 结果
     */
    public int deleteHisPatientInfoById(Long id);
}
