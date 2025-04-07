package com.ruoyi.dispatient.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.dispatient.mapper.OutPatientInfoMapper;
import com.ruoyi.dispatient.domain.OutPatientInfo;
import com.ruoyi.dispatient.service.IOutPatientInfoService;

/**
 * 出院患者Service业务层处理
 * 
 * @author czs
 * @date 2025-04-06
 */
@Service
public class OutPatientInfoServiceImpl implements IOutPatientInfoService
{
    @Autowired
    private OutPatientInfoMapper outPatientInfoMapper;

    /**
     * 查询出院患者
     * 
     * @param id 出院患者主键
     * @return 出院患者
     */
    @Override
    public OutPatientInfo selectHisPatientInfoById(Long id)
    {
        return outPatientInfoMapper.selectHisPatientInfoById(id);
    }

    /**
     * 查询出院患者列表
     * 
     * @param outPatientInfo 出院患者
     * @return 出院患者
     */
    @Override
    public List<OutPatientInfo> selectHisPatientInfoList(OutPatientInfo outPatientInfo)
    {
        return outPatientInfoMapper.selectHisPatientInfoList(outPatientInfo);
    }

    /**
     * 新增出院患者
     * 
     * @param outPatientInfo 出院患者
     * @return 结果
     */
    @Override
    public int insertHisPatientInfo(OutPatientInfo outPatientInfo)
    {
        return outPatientInfoMapper.insertHisPatientInfo(outPatientInfo);
    }

    /**
     * 修改出院患者
     * 
     * @param outPatientInfo 出院患者
     * @return 结果
     */
    @Override
    public int updateHisPatientInfo(OutPatientInfo outPatientInfo)
    {
        return outPatientInfoMapper.updateHisPatientInfo(outPatientInfo);
    }

    /**
     * 批量删除出院患者
     * 
     * @param ids 需要删除的出院患者主键
     * @return 结果
     */
    @Override
    public int deleteHisPatientInfoByIds(Long[] ids)
    {
        return outPatientInfoMapper.deleteHisPatientInfoByIds(ids);
    }

    /**
     * 删除出院患者信息
     * 
     * @param id 出院患者主键
     * @return 结果
     */
    @Override
    public int deleteHisPatientInfoById(Long id)
    {
        return outPatientInfoMapper.deleteHisPatientInfoById(id);
    }
}
