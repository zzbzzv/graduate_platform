package com.ruoyi.web.controller.YbWorkbench.service.impl;

import java.util.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.web.controller.YbWorkbench.domain.YbWorkbench;
import com.ruoyi.web.controller.YbWorkbench.mapper.YbWorkbenchMapper;
import com.ruoyi.web.controller.YbWorkbench.service.IYbWorkbenchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

@Service
public class YbWorkbenchServiceImpl implements IYbWorkbenchService {
    @Autowired
    private YbWorkbenchMapper workbenchMapper;

    // 安全除以10000并保留2位小数
    private BigDecimal safeDivideToTenThousand(BigDecimal value) {
        if (value == null) {
            return BigDecimal.ZERO;
        }
        return value.divide(new BigDecimal(10000), 2, RoundingMode.HALF_UP);
    }

    // 安全计算平均值
    private BigDecimal calculateAverage(BigDecimal total, Integer divisor) {
        if (total == null || divisor == null || divisor == 0) {
            return BigDecimal.ZERO;
        }
        return total.divide(new BigDecimal(divisor), 2, RoundingMode.HALF_UP);
    }

    @Override
    public Map<String, Object> getPatientStatistics(String year) {
        final String finalyear = StringUtils.isEmpty(year) ? DateUtils.getYear() : year;
        String sTime = finalyear + "-01-01";
        String eTime = finalyear + "-12-31 23:59:59";

        YbWorkbench params = new YbWorkbench();
        params.setBalanceDateStart(sTime);
        params.setBalanceDateEnd(eTime);

        // 患者基本情况
        YbWorkbench stats = workbenchMapper.selectPatientStats(params);
        Map<String, Object> result = new LinkedHashMap<>();

        if (stats != null) {
            Map<String, Object> patientData = new HashMap<>();
            patientData.put("cureNum", stats.getCureNum()); // 总人次
            patientData.put("F_Amount", safeDivideToTenThousand(stats.getAmount())); // 住院总费用(万元)
            patientData.put("F_SB_Amount", safeDivideToTenThousand(stats.getSbAmount())); // 总医保费用(万元)
            patientData.put("F_Balance", safeDivideToTenThousand(stats.getBalance())); // 结余(万元)
            patientData.put("F_Score", safeDivideToTenThousand(stats.getScore())); // 得分(万元)
            patientData.put("cjzy_Amount", calculateAverage(stats.getAmount(), stats.getCureNum())); // 年度次均住院费用(元)
            patientData.put("cj_Amount", calculateAverage(stats.getSbAmount(), stats.getCureNum())); // 次均医保费用(元)
            patientData.put("rj_Amount", calculateAverage(stats.getSbAmount(), stats.getPerson())); // 人均医保费用(人)
            patientData.put("rj_Days", calculateAverage(stats.getDays(), stats.getPerson())); // 人均住院日(人)
            patientData.put("rj_Balance", calculateAverage(stats.getBalance(), stats.getPerson())); // 人均结余(人)
            patientData.put("rj_Score", calculateAverage(stats.getScore(), stats.getPerson())); // 人均得分(人)
            patientData.put("self_ratio", stats.getSelfRatio().multiply(new BigDecimal(100)).setScale(2, RoundingMode.HALF_UP)); // 自费率(%)

            result.put("data", patientData);
        }

        // 按月统计数据
        List<YbWorkbench> monthlyData = workbenchMapper.selectMonthlyData(params);
        Map<String, Object> chart = new HashMap<>();
        List<Map<String, Object>> zdData = new ArrayList<>();
        List<Map<String, Object>> zxData = new ArrayList<>();

        for (YbWorkbench item : monthlyData) {
            zdData.add(new HashMap<String, Object>() {{
                put("date", item.getDate());
                put("month", item.getMonth());
                put("num", item.getNum());
            }});

            zxData.add(new HashMap<String, Object>() {{
                put("date", item.getDate());
                put("month", item.getMonth());
                put("kw", item.getZfl().multiply(new BigDecimal(100)).setScale(2, RoundingMode.HALF_UP));
            }});
        }

        // 填充缺失月份
        int maxMonth = monthlyData.stream().mapToInt(YbWorkbench::getMonth).max().orElse(0);
        while (maxMonth < 12) {
            maxMonth++;
            String date = year + "-" + (maxMonth < 10 ? "0" + maxMonth : maxMonth);

            int finalMaxMonth1 = maxMonth;
            zdData.add(new HashMap<String, Object>() {{
                put("date", date);
                put("month", finalMaxMonth1);
                put("num", 0);
            }});

            int finalMaxMonth = maxMonth;
            zxData.add(new HashMap<String, Object>() {{
                put("date", date);
                put("month", finalMaxMonth);
                put("kw", BigDecimal.ZERO);
            }});
        }

        chart.put("zd_data", zdData);
        chart.put("zx_data", zxData);
        result.put("chart", chart);

        // 病种增跌幅
        List<YbWorkbench> rangeIcd = workbenchMapper.selectMaxRangeOfIncDrop(params);
        Map<String, List<YbWorkbench>> rangeIcdMap = new HashMap<>();
        rangeIcdMap.put("icd_inc", rangeIcd.stream().filter(item -> item.getAvgBalance().compareTo(BigDecimal.ZERO) > 0).collect(Collectors.toList()));
        rangeIcdMap.put("icd_drop", rangeIcd.stream().filter(item -> item.getAvgBalance().compareTo(BigDecimal.ZERO) < 0).collect(Collectors.toList()));
        result.put("rangeIcd", rangeIcdMap);

        // 盈利亏损病种统计
        List<YbWorkbench> diagData = workbenchMapper.selectDiagData(params);
        Map<String, Object> diagDataMap = new HashMap<>();
        List<Map<String, Object>> diagZdData = new ArrayList<>();
        List<Map<String, Object>> diagZxData = new ArrayList<>();

        for (int i = 1; i <= 12; i++) {
            final int month = i;
            List<YbWorkbench> monthDiag = diagData.stream().filter(item -> item.getMonth() == month).collect(Collectors.toList());

            diagZdData.add(new HashMap<String, Object>() {{
                put("date", year + "-" + month);
                put("name", "盈利病种");
                put("value", monthDiag.stream().filter(item -> item.getBalance().compareTo(BigDecimal.ZERO) > 0).count());
            }});

            diagZdData.add(new HashMap<String, Object>() {{
                put("date", year + "-" + month);
                put("name", "不盈不亏病种");
                put("value", monthDiag.stream().filter(item -> item.getBalance().compareTo(BigDecimal.ZERO) == 0).count());
            }});

            diagZdData.add(new HashMap<String, Object>() {{
                put("date", year + "-" + month);
                put("name", "亏损病种");
                put("value", monthDiag.stream().filter(item -> item.getBalance().compareTo(BigDecimal.ZERO) < 0).count());
            }});

            diagZxData.add(new HashMap<String, Object>() {{
                put("date", year + "-" + month);
                put("F_Balance", monthDiag.stream().map(YbWorkbench::getBalance).reduce(BigDecimal.ZERO, BigDecimal::add));
            }});
        }

        diagDataMap.put("zd_data", diagZdData);
        diagDataMap.put("zx_data", diagZxData);
        result.put("diag_data", diagDataMap);

        // 盈利亏损科室统计
        List<YbWorkbench> deptData = workbenchMapper.selectDeptData(params);
        Map<String, Object> deptDataMap = new HashMap<>();
        List<Map<String, Object>> deptZdData = new ArrayList<>();
        List<Map<String, Object>> deptZxData = new ArrayList<>();

        for (int i = 1; i <= 12; i++) {
            final int month = i;
            List<YbWorkbench> monthDept = deptData.stream().filter(item -> item.getMonth() == month).collect(Collectors.toList());

            deptZdData.add(new HashMap<String, Object>() {{
                put("date", year + "-" + month);
                put("name", "盈利科室");
                put("value", monthDept.stream().filter(item -> item.getBalance().compareTo(BigDecimal.ZERO) > 0).count());
            }});

            deptZdData.add(new HashMap<String, Object>() {{
                put("date", year + "-" + month);
                put("name", "不盈不亏科室");
                put("value", monthDept.stream().filter(item -> item.getBalance().compareTo(BigDecimal.ZERO) == 0).count());
            }});

            deptZdData.add(new HashMap<String, Object>() {{
                put("date", year + "-" + month);
                put("name", "亏损科室");
                put("value", monthDept.stream().filter(item -> item.getBalance().compareTo(BigDecimal.ZERO) < 0).count());
            }});

            deptZxData.add(new HashMap<String, Object>() {{
                put("date", year + "-" + month);
                put("F_Balance", monthDept.stream().map(YbWorkbench::getBalance).reduce(BigDecimal.ZERO, BigDecimal::add));
            }});
        }

        deptDataMap.put("zd_data", deptZdData);
        deptDataMap.put("zx_data", deptZxData);
        result.put("dept_data", deptDataMap);

        return result;
    }

    @Override
    public Map<String, Object> getTcqkData(String year) {
        if (year == null || year.isEmpty()) {
            year = DateUtils.getYear();
        }

        YbWorkbench params = new YbWorkbench();
        params.setBalanceDateStart(year + "-01-01");
        params.setBalanceDateEnd(year + "-12-31 23:59:59");
        params.setYear(year);

        List<YbWorkbench> budgetData = workbenchMapper.selectTcqkData(params);
        Map<String, Object> result = new HashMap<>();

        BigDecimal totalTc = budgetData.stream().map(YbWorkbench::getDeptTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal totalSbAmount = budgetData.stream().map(YbWorkbench::getSbAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal used = BigDecimal.ZERO.compareTo(totalTc) != 0 ?
                totalSbAmount.divide(totalTc, 3, RoundingMode.HALF_UP) : BigDecimal.ZERO;

        result.put("data", budgetData);
        result.put("used", used);
        result.put("total_tc", totalTc);

        return result;
    }

    @Override
    public List<YbWorkbench> getTopDiseases(String year, int caseCount, String sortField, String sortDirection) {
        if (year == null || year.isEmpty()) {
            year = DateUtils.getYear();
        }

        YbWorkbench params = new YbWorkbench();
        params.setBalanceDateStart(year + "-01-01");
        params.setBalanceDateEnd(year + "-12-31 23:59:59");
        params.setCaseCount(caseCount);
        params.setSortField(sortField);
        params.setSortDirection(sortDirection);

        return workbenchMapper.selectTopDiseases(params);
    }
}