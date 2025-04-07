package com.ruoyi.web.controller.YbWorkbench.mapper;

import com.ruoyi.web.controller.YbWorkbench.domain.YbWorkbench;
import java.util.List;

public interface YbWorkbenchMapper {
    // 原有方法
    YbWorkbench selectPatientStats(YbWorkbench params);
    List<YbWorkbench> selectTopDiseases(YbWorkbench params);
    List<YbWorkbench> selectMaxRangeOfIncDrop(YbWorkbench params);
    List<YbWorkbench> selectTcqkData(YbWorkbench params);

    // 新增方法
    List<YbWorkbench> selectMonthlyData(YbWorkbench params);
    List<YbWorkbench> selectDiagData(YbWorkbench params);
    List<YbWorkbench> selectDeptData(YbWorkbench params);
}