package com.ruoyi.web.controller.YbWorkbench.service;

import java.util.List;
import java.util.Map;
import com.ruoyi.web.controller.YbWorkbench.domain.YbWorkbench;

public interface IYbWorkbenchService {
    Map<String, Object> getPatientStatistics(String year);

    Map<String, Object> getTcqkData(String year);

    List<YbWorkbench> getTopDiseases(String year, int caseCount, String sortField, String sortDirection);
}