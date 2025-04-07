package com.ruoyi.web.controller.YbWorkbench.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.web.controller.YbWorkbench.service.IYbWorkbenchService;
import com.ruoyi.web.controller.YbWorkbench.domain.YbWorkbench;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import java.util.Map;

/**
 * 在院患者Controller
 * 
 * @author czs
 * @date 2025-04-02
 */
@RestController
@RequestMapping("/system/inpatient")
public class YbWorkbenchController extends BaseController
{
    @Autowired
    private IYbWorkbenchService workbenchService;

    @GetMapping("/patientSituation")
    public AjaxResult patientSituation(@RequestParam(required = false) String year) {
        Map<String, Object> data = workbenchService.getPatientStatistics(year);
        return AjaxResult.success(data);
    }

    @GetMapping("/tcqk")
    public AjaxResult tcqk(@RequestParam(required = false) String year) {
        Map<String, Object> data = workbenchService.getTcqkData(year);
        return AjaxResult.success(data);
    }

    @GetMapping("/topDiseases")
    public AjaxResult getTopDiseases(@RequestParam(required = false) String year,
                                     @RequestParam(defaultValue = "10") int caseCount,
                                     @RequestParam(defaultValue = "avg_F_Amount") String sortField,
                                     @RequestParam(defaultValue = "desc") String sortDirection) {
        List<YbWorkbench> list = workbenchService.getTopDiseases(year, caseCount, sortField, sortDirection);
        return AjaxResult.success(list);
    }

    @PostMapping("/exportProfitDiseases")
    public void exportProfitDiseases(HttpServletResponse response,
                                     @RequestParam(required = false) String year,
                                     @RequestParam(defaultValue = "10") int caseCount,
                                     @RequestParam(defaultValue = "avg_F_Amount") String sortField) {
        List<YbWorkbench> list = workbenchService.getTopDiseases(year, caseCount, sortField, "desc");
        ExcelUtil<YbWorkbench> util = new ExcelUtil<>(YbWorkbench.class);
        util.exportExcel(response, list, "盈利病种");
    }

    @PostMapping("/exportLossDiseases")
    public void exportLossDiseases(HttpServletResponse response,
                                   @RequestParam(required = false) String year,
                                   @RequestParam(defaultValue = "10") int caseCount,
                                   @RequestParam(defaultValue = "avg_F_Amount") String sortField) {
        List<YbWorkbench> list = workbenchService.getTopDiseases(year, caseCount, sortField, "asc");
        ExcelUtil<YbWorkbench> util = new ExcelUtil<>(YbWorkbench.class);
        util.exportExcel(response, list, "亏损病种");
    }
}
