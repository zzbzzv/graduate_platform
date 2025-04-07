package com.ruoyi.inpatient.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.inpatient.mapper.HisPatientInfoMapper;
import com.ruoyi.inpatient.domain.HisPatientInfo;
import com.ruoyi.inpatient.service.IHisPatientInfoService;

/**
 * 在院患者Service业务层处理
 * 
 * @author czs
 * @date 2025-04-06
 */
@Service
public class HisPatientInfoServiceImpl implements IHisPatientInfoService 
{
    @Autowired
    private HisPatientInfoMapper hisPatientInfoMapper;

    /**
     * 查询在院患者
     * 
     * @param id 在院患者主键
     * @return 在院患者
     */
    @Override
    public HisPatientInfo selectHisPatientInfoById(Long id)
    {
        return hisPatientInfoMapper.selectHisPatientInfoById(id);
    }

    /**
     * 查询在院患者列表
     * 
     * @param hisPatientInfo 在院患者
     * @return 在院患者
     */
    @Override
    public List<HisPatientInfo> selectHisPatientInfoList(HisPatientInfo hisPatientInfo)
    {
        return hisPatientInfoMapper.selectHisPatientInfoList(hisPatientInfo);
    }

    /**
     * 新增在院患者
     * 
     * @param hisPatientInfo 在院患者
     * @return 结果
     */
    @Override
    public int insertHisPatientInfo(HisPatientInfo hisPatientInfo)
    {
        return hisPatientInfoMapper.insertHisPatientInfo(hisPatientInfo);
    }

    /**
     * 修改在院患者
     * 
     * @param hisPatientInfo 在院患者
     * @return 结果
     */
    @Override
    public int updateHisPatientInfo(HisPatientInfo hisPatientInfo)
    {
        return hisPatientInfoMapper.updateHisPatientInfo(hisPatientInfo);
    }

    /**
     * 批量删除在院患者
     * 
     * @param ids 需要删除的在院患者主键
     * @return 结果
     */
    @Override
    public int deleteHisPatientInfoByIds(Long[] ids)
    {
        return hisPatientInfoMapper.deleteHisPatientInfoByIds(ids);
    }

    /**
     * 删除在院患者信息
     * 
     * @param id 在院患者主键
     * @return 结果
     */
    @Override
    public int deleteHisPatientInfoById(Long id)
    {
        return hisPatientInfoMapper.deleteHisPatientInfoById(id);
    }
}
