package com.ruoyi.web.controller.YbWorkbench.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 医保工作台实体类
 */
public class YbWorkbench extends BaseEntity {
    private static final long serialVersionUID = 1L;

    // 患者信息字段
    @Excel(name = "结算人次")
    private Integer cureNum;  // 对应 COUNT(1) as cure_num

    @Excel(name = "患者人数")
    private Integer person;
    @Excel(name = "患者ID")
    private String hisId;

    @Excel(name = "患者编号")
    private String hisNo;

    @Excel(name = "是否医保", readConverterExp = "0=否,1=是,6=是")
    private Integer isYb;

    @Excel(name = "是否门特", readConverterExp = "0=否,1=是")
    private Integer isMt;

    @Excel(name = "结算日期")
    private Date balanceDate;

    @Excel(name = "出院日期")
    private Date dateTimeOut;

    @Excel(name = "住院天数")
    private Integer days;

    @Excel(name = "总费用")
    private BigDecimal amount;

    @Excel(name = "医保费用")
    private BigDecimal sbAmount;

    @Excel(name = "结余")
    private BigDecimal balance;

    @Excel(name = "分值")
    private BigDecimal score;

    @Excel(name = "自费金额")
    private BigDecimal insuranceSelfPaid;

    @Excel(name = "自费率")
    private BigDecimal selfRatio;

    // 病种相关字段
    @Excel(name = "病种编码")
    private String diagnosisIcdCal;

    @Excel(name = "病种名称")
    private String diagnosisCal;

    @Excel(name = "治疗方式编码")
    private String treatmentType;

    @Excel(name = "治疗方式名称")
    private String treatmentName;

    @Excel(name = "标准分值")
    private BigDecimal standardScore;

    @Excel(name = "总人次")
    private Integer totalRc;

    @Excel(name = "次均费用")
    private BigDecimal avgAmount;

    @Excel(name = "次均结余")
    private BigDecimal avgBalance;

    // 科室相关字段
    @Excel(name = "科室编号")
    private String deptNo;

    @Excel(name = "科室名称")
    private String deptName;

    @Excel(name = "科室预算总额")
    private BigDecimal deptTotal;

    @Excel(name = "预算年度")
    private String budgetDate;

    @Excel(name = "使用率")
    private BigDecimal used;

    // 查询参数字段
    private String balanceDateStart;
    private String balanceDateEnd;
    private String year;
    private Integer caseCount;
    private String sortField;
    private String sortDirection;
    private Integer month;
    private String date;
    private Integer num;
    private BigDecimal zfl;

    // 构造函数
    public YbWorkbench() {
    }

    public YbWorkbench(String hisId, String hisNo, Integer isYb, Integer isMt, Date balanceDate,
                       Date dateTimeOut, Integer days, BigDecimal amount, BigDecimal sbAmount,
                       BigDecimal balance, BigDecimal score, BigDecimal insuranceSelfPaid,
                       BigDecimal selfRatio) {
        this.hisId = hisId;
        this.hisNo = hisNo;
        this.isYb = isYb;
        this.isMt = isMt;
        this.balanceDate = balanceDate;
        this.dateTimeOut = dateTimeOut;
        this.days = days;
        this.amount = amount;
        this.sbAmount = sbAmount;
        this.balance = balance;
        this.score = score;
        this.insuranceSelfPaid = insuranceSelfPaid;
        this.selfRatio = selfRatio;
    }

    public YbWorkbench(String diagnosisIcdCal, String diagnosisCal, String treatmentType,
                       String treatmentName, BigDecimal standardScore, Integer totalRc,
                       BigDecimal avgAmount, BigDecimal avgBalance, BigDecimal balance) {
        this.diagnosisIcdCal = diagnosisIcdCal;
        this.diagnosisCal = diagnosisCal;
        this.treatmentType = treatmentType;
        this.treatmentName = treatmentName;
        this.standardScore = standardScore;
        this.totalRc = totalRc;
        this.avgAmount = avgAmount;
        this.avgBalance = avgBalance;
        this.balance = balance;
    }

    public YbWorkbench(String deptNo, String deptName, BigDecimal deptTotal, String budgetDate,
                       Integer num, BigDecimal sbAmount, BigDecimal avgAmount, BigDecimal balance,
                       BigDecimal used) {
        this.deptNo = deptNo;
        this.deptName = deptName;
        this.deptTotal = deptTotal;
        this.budgetDate = budgetDate;
        this.num = num;
        this.sbAmount = sbAmount;
        this.avgAmount = avgAmount;
        this.balance = balance;
        this.used = used;
    }

    // Getter和Setter方法
    public String getHisId() {
        return hisId;
    }

    public void setHisId(String hisId) {
        this.hisId = hisId;
    }

    public String getHisNo() {
        return hisNo;
    }

    public void setHisNo(String hisNo) {
        this.hisNo = hisNo;
    }

    public Integer getIsYb() {
        return isYb;
    }

    public void setIsYb(Integer isYb) {
        this.isYb = isYb;
    }

    public Integer getIsMt() {
        return isMt;
    }

    public void setIsMt(Integer isMt) {
        this.isMt = isMt;
    }

    public Date getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(Date balanceDate) {
        this.balanceDate = balanceDate;
    }

    public Date getDateTimeOut() {
        return dateTimeOut;
    }

    public void setDateTimeOut(Date dateTimeOut) {
        this.dateTimeOut = dateTimeOut;
    }

    public BigDecimal getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getSbAmount() {
        return sbAmount;
    }

    public void setSbAmount(BigDecimal sbAmount) {
        this.sbAmount = sbAmount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public BigDecimal getInsuranceSelfPaid() {
        return insuranceSelfPaid;
    }

    public void setInsuranceSelfPaid(BigDecimal insuranceSelfPaid) {
        this.insuranceSelfPaid = insuranceSelfPaid;
    }

    public BigDecimal getSelfRatio() {
        return selfRatio;
    }

    public void setSelfRatio(BigDecimal selfRatio) {
        this.selfRatio = selfRatio;
    }

    public String getDiagnosisIcdCal() {
        return diagnosisIcdCal;
    }

    public void setDiagnosisIcdCal(String diagnosisIcdCal) {
        this.diagnosisIcdCal = diagnosisIcdCal;
    }

    public String getDiagnosisCal() {
        return diagnosisCal;
    }

    public void setDiagnosisCal(String diagnosisCal) {
        this.diagnosisCal = diagnosisCal;
    }

    public String getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentType(String treatmentType) {
        this.treatmentType = treatmentType;
    }

    public String getTreatmentName() {
        return treatmentName;
    }

    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }

    public BigDecimal getStandardScore() {
        return standardScore;
    }

    public void setStandardScore(BigDecimal standardScore) {
        this.standardScore = standardScore;
    }

    public Integer getTotalRc() {
        return totalRc;
    }

    public void setTotalRc(Integer totalRc) {
        this.totalRc = totalRc;
    }

    public BigDecimal getAvgAmount() {
        return avgAmount;
    }

    public void setAvgAmount(BigDecimal avgAmount) {
        this.avgAmount = avgAmount;
    }

    public BigDecimal getAvgBalance() {
        return avgBalance;
    }

    public void setAvgBalance(BigDecimal avgBalance) {
        this.avgBalance = avgBalance;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public BigDecimal getDeptTotal() {
        return deptTotal;
    }

    public void setDeptTotal(BigDecimal deptTotal) {
        this.deptTotal = deptTotal;
    }

    public String getBudgetDate() {
        return budgetDate;
    }

    public void setBudgetDate(String budgetDate) {
        this.budgetDate = budgetDate;
    }

    public BigDecimal getUsed() {
        return used;
    }

    public void setUsed(BigDecimal used) {
        this.used = used;
    }

    public String getBalanceDateStart() {
        return balanceDateStart;
    }

    public void setBalanceDateStart(String balanceDateStart) {
        this.balanceDateStart = balanceDateStart;
    }

    public String getBalanceDateEnd() {
        return balanceDateEnd;
    }

    public void setBalanceDateEnd(String balanceDateEnd) {
        this.balanceDateEnd = balanceDateEnd;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getCaseCount() {
        return caseCount;
    }

    public void setCaseCount(Integer caseCount) {
        this.caseCount = caseCount;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public String getDate() {
        return date;
    }
    public Integer getCureNum() {
        return cureNum;
    }

    public void setCureNum(Integer cureNum) {
        this.cureNum = cureNum;
    }

    public Integer getPerson() {
        return person;
    }

    public void setPerson(Integer person) {
        this.person = person;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getZfl() {
        return zfl;
    }

    public void setZfl(BigDecimal zfl) {
        this.zfl = zfl;
    }
}