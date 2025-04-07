package com.ruoyi.dispatient.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.dispatient.domain.OutPatientInfo;
import com.ruoyi.dispatient.service.IOutPatientInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 出院患者Controller
 * 
 * @author czs
 * @date 2025-04-06
 */
@RestController
@RequestMapping("/dispatient/dispatient")
public class OutPatientInfoController extends BaseController
{
    @Autowired
    private IOutPatientInfoService hisPatientInfoService;

    /**
     * 查询出院患者列表
     */
    @PreAuthorize("@ss.hasPermi('dispatient:dispatient:list')")
    @GetMapping("/list")
    public TableDataInfo list(OutPatientInfo outPatientInfo)
    {
        startPage();
        List<OutPatientInfo> list = hisPatientInfoService.selectHisPatientInfoList(outPatientInfo);
        return getDataTable(list);
    }

    /**
     * 导出出院患者列表
     */
    @PreAuthorize("@ss.hasPermi('dispatient:dispatient:export')")
    @Log(title = "出院患者", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OutPatientInfo outPatientInfo)
    {
        List<OutPatientInfo> list = hisPatientInfoService.selectHisPatientInfoList(outPatientInfo);
        ExcelUtil<OutPatientInfo> util = new ExcelUtil<OutPatientInfo>(OutPatientInfo.class);
        util.exportExcel(response, list, "出院患者数据");
    }

    /**
     * 获取出院患者详细信息
     */
    @PreAuthorize("@ss.hasPermi('dispatient:dispatient:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(hisPatientInfoService.selectHisPatientInfoById(id));
    }

    /**
     * 新增出院患者
     */
    @PreAuthorize("@ss.hasPermi('dispatient:dispatient:add')")
    @Log(title = "出院患者", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OutPatientInfo outPatientInfo)
    {
        return toAjax(hisPatientInfoService.insertHisPatientInfo(outPatientInfo));
    }

    /**
     * 修改出院患者
     */
    @PreAuthorize("@ss.hasPermi('dispatient:dispatient:edit')")
    @Log(title = "出院患者", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OutPatientInfo outPatientInfo)
    {
        return toAjax(hisPatientInfoService.updateHisPatientInfo(outPatientInfo));
    }

    /**
     * 删除出院患者
     */
    @PreAuthorize("@ss.hasPermi('dispatient:dispatient:remove')")
    @Log(title = "出院患者", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(hisPatientInfoService.deleteHisPatientInfoByIds(ids));
    }
}
