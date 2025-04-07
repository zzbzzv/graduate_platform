package com.ruoyi.inpatient.mapper;

import java.util.List;
import com.ruoyi.inpatient.domain.HisPatientInfo;

/**
 * 在院患者Mapper接口
 *
 * @author czs
 * @date 2025-04-06
 */
public interface HisPatientInfoMapper
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
     * 删除在院患者
     *
     * @param id 在院患者主键
     * @return 结果
     */
    public int deleteHisPatientInfoById(Long id);

    /**
     * 批量删除在院患者
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHisPatientInfoByIds(Long[] ids);
}
