package com.ruoyi.web.controller.patient.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.web.controller.patient.domain.HisPatientInfo;
import com.ruoyi.web.controller.patient.service.IHisPatientInfoService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 在院患者Controller
 * 
 * @author czs
 * @date 2025-04-02
 */
@RestController
@RequestMapping("/system/inpatient")
public class HisPatientInfoController extends BaseController
{
    @Autowired
    private IHisPatientInfoService hisPatientInfoService;

    /**
     * 查询在院患者列表
     */
    @PreAuthorize("@ss.hasPermi('system:inpatient:list')")
    @GetMapping("/list")
    public TableDataInfo list(HisPatientInfo hisPatientInfo)
    {
        startPage();
        List<HisPatientInfo> list = hisPatientInfoService.selectHisPatientInfoList(hisPatientInfo);
        return getDataTable(list);
    }

    /**
     * 导出在院患者列表
     */
    @PreAuthorize("@ss.hasPermi('system:inpatient:export')")
    @Log(title = "在院患者", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HisPatientInfo hisPatientInfo)
    {
        List<HisPatientInfo> list = hisPatientInfoService.selectHisPatientInfoList(hisPatientInfo);
        ExcelUtil<HisPatientInfo> util = new ExcelUtil<HisPatientInfo>(HisPatientInfo.class);
        util.exportExcel(response, list, "在院患者数据");
    }

    /**
     * 获取在院患者详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:inpatient:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(hisPatientInfoService.selectHisPatientInfoById(id));
    }

    /**
     * 新增在院患者
     */
    @PreAuthorize("@ss.hasPermi('system:inpatient:add')")
    @Log(title = "在院患者", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HisPatientInfo hisPatientInfo)
    {
        return toAjax(hisPatientInfoService.insertHisPatientInfo(hisPatientInfo));
    }

    /**
     * 修改在院患者
     */
    @PreAuthorize("@ss.hasPermi('system:inpatient:edit')")
    @Log(title = "在院患者", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HisPatientInfo hisPatientInfo)
    {
        return toAjax(hisPatientInfoService.updateHisPatientInfo(hisPatientInfo));
    }

    /**
     * 删除在院患者
     */
    @PreAuthorize("@ss.hasPermi('system:inpatient:remove')")
    @Log(title = "在院患者", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(hisPatientInfoService.deleteHisPatientInfoByIds(ids));
    }
}
