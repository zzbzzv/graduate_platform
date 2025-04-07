package com.ruoyi.dispatient.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 出院患者对象 his_patient_info
 * 
 * @author czs
 * @date 2025-04-06
 */
public class OutPatientInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 流水号 */
    private String fHisId;

    /** 住院号 */
    @Excel(name = "住院号")
    private String fHisNo;

    /** 床号 */
    @Excel(name = "床号")
    private String fBedNo;

    /** 病人性质编号 */
    private String fPatientType;

    /** 病人性质名称 */
    @Excel(name = "病人性质名称")
    private String fPatientTypeCn;

    /** 病案号 */
    private String fPatientNo;

    /** 住院次数 */
    private Long fTimes;

    /** 参保号 */
    private String fInsuranceNo;

    /** 姓名 */
    @Excel(name = "姓名")
    private String fPatientName;

    /** 生日 */
    private Date fPatientBirthday;

    /** 年龄 */
    private String fPatientAge;

    /** 身份证号 */
    private String fPatientCardno;

    /** 性别 */
    private String fPatientSex;

    /** 职业 */
    private String fPatientJob;

    /** 地址 */
    private String fPatientAddress;

    /** 主管医生编号 */
    private String fDoctorNoZg;

    /** 主管医生 */
    private String fDoctorNameZg;

    /** 科室编号 */
    private String fDeptNo;

    /** 科室 */
    @Excel(name = "科室")
    private String fDeptName;

    /** 入院日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入院日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fDatetimeIn;

    /** 出院日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出院日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fDatetimeOut;

    /** 结算日期 */
    private Date fBalanceDate;

    /** 住院天数 */
    @Excel(name = "住院天数")
    private Integer fDays;

    /** 入院诊断 ICD */
    private String fDiagnosisInIcd;

    /** 入院手术ICD */
    private String fOperationInIcd;

    /** 出院诊断编码（最终） */
    private String fDiagnosisOutIcd;

    /** 出院手术编码（最终） */
    private String fOperationOutIcd;

    /** 门诊诊断编码-病案 */
    private String fDiagnosisMzIcd;

    /** 入院诊断名-病案 */
    private String fDiagnosisIn;

    /** 入院手术名-病案 */
    private String fOperationIn;

    /** 出院诊断名（最终） */
    private String fDiagnosisOut;

    /** 出院手术名（最终） */
    private String fOperationOut;

    /** 门诊诊断名-病案 */
    private String fDiagnosisMz;

    /** 出院诊断编码（EMR） */
    private String fEmrDiagCode;

    /** 出院诊断名称（EMR） */
    private String fEmrDiagName;

    /** 出院手术编码（EMR） */
    private String fEmrOprnCode;

    /** 出院手术名称（EMR） */
    private String fEmrOprnName;

    /** 出院诊断编码（病案） */
    private String fBaDiagCode;

    /** 出院诊断名称（病案） */
    private String fBaDiagName;

    /** 出院手术编码（病案） */
    private String fBaOprnCode;

    /** 出院手术名称（病案） */
    private String fBaOprnName;

    /** 出院诊断编码（结算清单） */
    private String fYbDiagCode;

    /** 出院诊断名称（结算清单） */
    @Excel(name = "出院诊断名称", readConverterExp = "结=算清单")
    private String fYbDiagName;

    /** 出院手术编码（结算清单） */
    private String fYbOprnCode;

    /** 出院手术名称（结算清单） */
    private String fYbOprnName;

    /** 编码员工号 */
    private String fBmybh;

    /** 编码员 */
    private String fBmy;

    /** 诊治方式编号 */
    private String fTreatmentType;

    /** 诊治方式名称 */
    @Excel(name = "诊治方式名称")
    private String fTreatmentName;

    /** 社保诊断亚目ICD5 */
    private String fDiagnosisIcdCal;

    /** 社保诊断亚目ICD名称 */
    private String fDiagnosisCal;

    /** 社保手术码 */
    private String fOperationIcdCal;

    /** 社保手术名称 */
    private String fOperationCal;

    /** 社保治疗方式 */
    private String fTreatmentTypeCal;

    /** 社保治疗方式名称 */
    private String fTreatmentNameCal;

    /** 病种级别（1、基层病种，2、普通病种，3、综合病种） */
    private Integer fDiseaseType;

    /** 病种级别转换前备份 */
    private Integer fDiseaseTypeBefor;

    /** 年份-社保诊断亚目ICD */
    private Integer fYears;

    /** 分值参照物（去年的分值价钱） */
    private BigDecimal fParQ0;

    /** 分值价钱：今年分值价钱（废弃字段） */
    private BigDecimal fParQ1;

    /** 分值价钱：今年分值价钱（医院预估价钱） */
    private BigDecimal fParQ1H;

    /** 医院等级系数（医保报销比率） */
    private BigDecimal fParB;

    /** R值:基准率 */
    @Excel(name = "R值:基准率")
    private BigDecimal fParR;

    /** 标准分值 */
    private BigDecimal fStandardScore;

    /** 实际得分 */
    private BigDecimal fScore;

    /** 住院总费用 */
    @Excel(name = "住院总费用")
    private BigDecimal fAmount;

    /** 医保费用 */
    @Excel(name = "医保费用")
    private BigDecimal fSbAmount;

    /** 医保金额(医保返回) */
    private BigDecimal fSbTotal;

    /** 盈亏额（结余） */
    private BigDecimal fBalance;

    /** 成本合计 */
    private BigDecimal fCostTotal;

    /** 预估医保费用（在院患者，临床助手使用，住院患者，每天都有新的费用产生）

预计医保费用 =【总费用-自费额-起付额】* 报销比例 */
    private BigDecimal fClinicalSbAmount;

    /** 盈亏额（结余） */
    private BigDecimal fPreSbTotal;

    /** 住院总费用（在院） */
    private BigDecimal fPreAmount;

    /** 自费合计（在院） */
    private BigDecimal fPreZfhj;

    /** 总药费（在院） */
    private BigDecimal fPreZyf;

    /** $column.columnComment */
    private BigDecimal fPreZfyf;

    /** 总材料费（在院） */
    private Long fPreZclf;

    /** $column.columnComment */
    private BigDecimal fPreZfcl;

    /** 分值匹配标志 */
    private Integer fMatchFlag;

    /** 住院医生编号 */
    private String fDoctorNoZy;

    /** 住院医生 */
    @Excel(name = "住院医生")
    private String fDoctorNameZy;

    /** 主治医生编号 */
    private String fDoctorNoZz;

    /** 主治医生 */
    private String fDoctorNameZz;

    /** 社保返回标志 */
    private Long fReportFlag;

    /** 病案科室编号 */
    private String fDeptNoBa;

    /** 病案科室名称 */
    private String fDeptNameBa;

    /** 结算方式 
11	普通门诊
12	门诊特殊病种
13	城乡居民门诊
21	医疗住院
31	工伤住院
32	工伤康复住院
35	工伤门诊
36	工伤康复门诊
41	生育住院(基本医疗保险)
43	产前检查
44	计生手术门诊
45	职工生育保险
46	生育未就业配偶住院
47	计生手术住院
48	生育保险住院(基本医疗满12月)
49	生育保险住院(基本医疗满12月)
71	住保特殊病种 */
    private Long fJsfs;

    /** 手术费用 */
    private BigDecimal fCostOperation;

    /** 非手术治疗费 */
    private BigDecimal fCostZl;

    /** 更新标志 */
    private Long fUpdateFlag;

    /** 出院诊断编码标志：0未编码，1已编码 */
    private Integer fDiagnosisOutFlag;

    /** 出院手术编码标志：0未编码，1已编码 */
    private Integer fOperationOutFlag;

    /** 门诊诊断编码标志：0未编码，1已编码 */
    private Integer fDiagnosisMzFlag;

    /** 病理诊断编码标志 */
    private Integer fDiagnosisBlFlag;

    /** 创建时间 */
    private Date createdAt;

    /** 修改更新时间 */
    private Date updatedAt;

    /** 出院标志 */
    private String fHisInFlag;

    /** 社保疾病分值库版本 */
    private String sbIcdScoreVersionNo;

    /** 社保诊治编码库版本 */
    private String sbOpTreatmentVersionNo;

    /** 患者类型 */
    private Integer fIsMt;

    /** 医保结算方式标志 */
    private Integer fIsYb;

    /** his备注 */
    private String fHisBz;

    /** 在院状态 */
    private Integer fInStatus;

    /** 医保考核 */
    private BigDecimal fAppraiseScore;

    /** 预估评定 */
    private BigDecimal fAppraiseScoreH;

    /** 目录内自费 */
    private BigDecimal fPreMlnZf;

    /** 目录外自费 */
    private BigDecimal fPreMlwZf;

    /** 在院方案选择的基准值 */
    private BigDecimal fPreParR;

    /** 盈亏额（结余） */
    private BigDecimal fPreBalance;

    /** 就诊记录号 */
    private String fJzjlh;

    /** 结算序号 */
    private String fJsxh;

    /** 患者类别 */
    private String fHzlb;

    /** 险种类型 */
    @Excel(name = "险种类型")
    private String fXzlx;

    /** 医疗类别 */
    private String fYllb;

    /** 入院科室编号 */
    private String fDeptInNo;

    /** 入院科室 */
    private String fDeptInName;

    /** 有效收入 */
    private BigDecimal fEffectiveIncome;

    /** 治疗费 */
    private BigDecimal fCostTreat;

    /** 西药 */
    private BigDecimal fWesternMedicine;

    /** 检查费 */
    private BigDecimal fJcf;

    /** 中药 */
    @Excel(name = "中药")
    private BigDecimal fChineseMedicine;

    /** 耗材 */
    private BigDecimal fCostMaterial;

    /** 检验费=化验费+检查费 */
    private BigDecimal fInspection;

    /** 麻醉费 */
    private BigDecimal fMzf;

    /** 归档标识(0未规定，1已归档) */
    private Integer gdType;

    /** 医生归档时间 */
    private Date gdDocttime;

    /** 护士归档时间 */
    private Date gdNursetime;

    /** 在院预警数量 */
    @Excel(name = "在院预警数量")
    private Integer preRuleCount;

    /** 当前病区编号 */
    private String fWardNo;

    /** 当前病区 */
    private String fWardName;

    /** DIP所有手术编号，加号分割 */
    private String fOperationOutIcdDip;

    /** DIP所有手术，加号分割 */
    private String fOperationOutDip;

    /** 医疗组编码 */
    private String ylzcode;

    /** 医疗组名称 */
    private String ylzname;

    /** 医生 */
    private String doctor;

    /** 单病种入组状态 */
    private Integer sdrStatus;

    /** 医疗总费用 */
    private BigDecimal fYlAmount;

    /** $column.columnComment */
    private Integer isDay15;

    /** 病种组别 */
    private String diseaseGroup;

    /** 疾病严重程度 */
    private String diseaseSeverity;

    /** 病种调节系数 */
    private BigDecimal diseaseAdjustment;

    /** 非基层病种加成系数 */
    private BigDecimal additiveCoefficient;

    /** $column.columnComment */
    private String fTreatmentInfo;

    /** 是否高精尖 */
    private Integer isHighPrecision;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setfHisId(String fHisId) 
    {
        this.fHisId = fHisId;
    }

    public String getfHisId() 
    {
        return fHisId;
    }
    public void setfHisNo(String fHisNo) 
    {
        this.fHisNo = fHisNo;
    }

    public String getfHisNo() 
    {
        return fHisNo;
    }
    public void setfBedNo(String fBedNo) 
    {
        this.fBedNo = fBedNo;
    }

    public String getfBedNo() 
    {
        return fBedNo;
    }
    public void setfPatientType(String fPatientType) 
    {
        this.fPatientType = fPatientType;
    }

    public String getfPatientType() 
    {
        return fPatientType;
    }
    public void setfPatientTypeCn(String fPatientTypeCn) 
    {
        this.fPatientTypeCn = fPatientTypeCn;
    }

    public String getfPatientTypeCn() 
    {
        return fPatientTypeCn;
    }
    public void setfPatientNo(String fPatientNo) 
    {
        this.fPatientNo = fPatientNo;
    }

    public String getfPatientNo() 
    {
        return fPatientNo;
    }
    public void setfTimes(Long fTimes) 
    {
        this.fTimes = fTimes;
    }

    public Long getfTimes() 
    {
        return fTimes;
    }
    public void setfInsuranceNo(String fInsuranceNo) 
    {
        this.fInsuranceNo = fInsuranceNo;
    }

    public String getfInsuranceNo() 
    {
        return fInsuranceNo;
    }
    public void setfPatientName(String fPatientName) 
    {
        this.fPatientName = fPatientName;
    }

    public String getfPatientName() 
    {
        return fPatientName;
    }
    public void setfPatientBirthday(Date fPatientBirthday) 
    {
        this.fPatientBirthday = fPatientBirthday;
    }

    public Date getfPatientBirthday() 
    {
        return fPatientBirthday;
    }
    public void setfPatientAge(String fPatientAge) 
    {
        this.fPatientAge = fPatientAge;
    }

    public String getfPatientAge() 
    {
        return fPatientAge;
    }
    public void setfPatientCardno(String fPatientCardno) 
    {
        this.fPatientCardno = fPatientCardno;
    }

    public String getfPatientCardno() 
    {
        return fPatientCardno;
    }
    public void setfPatientSex(String fPatientSex) 
    {
        this.fPatientSex = fPatientSex;
    }

    public String getfPatientSex() 
    {
        return fPatientSex;
    }
    public void setfPatientJob(String fPatientJob) 
    {
        this.fPatientJob = fPatientJob;
    }

    public String getfPatientJob() 
    {
        return fPatientJob;
    }
    public void setfPatientAddress(String fPatientAddress) 
    {
        this.fPatientAddress = fPatientAddress;
    }

    public String getfPatientAddress() 
    {
        return fPatientAddress;
    }
    public void setfDoctorNoZg(String fDoctorNoZg) 
    {
        this.fDoctorNoZg = fDoctorNoZg;
    }

    public String getfDoctorNoZg() 
    {
        return fDoctorNoZg;
    }
    public void setfDoctorNameZg(String fDoctorNameZg) 
    {
        this.fDoctorNameZg = fDoctorNameZg;
    }

    public String getfDoctorNameZg() 
    {
        return fDoctorNameZg;
    }
    public void setfDeptNo(String fDeptNo) 
    {
        this.fDeptNo = fDeptNo;
    }

    public String getfDeptNo() 
    {
        return fDeptNo;
    }
    public void setfDeptName(String fDeptName) 
    {
        this.fDeptName = fDeptName;
    }

    public String getfDeptName() 
    {
        return fDeptName;
    }
    public void setfDatetimeIn(Date fDatetimeIn) 
    {
        this.fDatetimeIn = fDatetimeIn;
    }

    public Date getfDatetimeIn() 
    {
        return fDatetimeIn;
    }
    public void setfDatetimeOut(Date fDatetimeOut) 
    {
        this.fDatetimeOut = fDatetimeOut;
    }

    public Date getfDatetimeOut() 
    {
        return fDatetimeOut;
    }
    public void setfBalanceDate(Date fBalanceDate) 
    {
        this.fBalanceDate = fBalanceDate;
    }

    public Date getfBalanceDate() 
    {
        return fBalanceDate;
    }
    public void setfDays(Integer fDays) 
    {
        this.fDays = fDays;
    }

    public Integer getfDays() 
    {
        return fDays;
    }
    public void setfDiagnosisInIcd(String fDiagnosisInIcd) 
    {
        this.fDiagnosisInIcd = fDiagnosisInIcd;
    }

    public String getfDiagnosisInIcd() 
    {
        return fDiagnosisInIcd;
    }
    public void setfOperationInIcd(String fOperationInIcd) 
    {
        this.fOperationInIcd = fOperationInIcd;
    }

    public String getfOperationInIcd() 
    {
        return fOperationInIcd;
    }
    public void setfDiagnosisOutIcd(String fDiagnosisOutIcd) 
    {
        this.fDiagnosisOutIcd = fDiagnosisOutIcd;
    }

    public String getfDiagnosisOutIcd() 
    {
        return fDiagnosisOutIcd;
    }
    public void setfOperationOutIcd(String fOperationOutIcd) 
    {
        this.fOperationOutIcd = fOperationOutIcd;
    }

    public String getfOperationOutIcd() 
    {
        return fOperationOutIcd;
    }
    public void setfDiagnosisMzIcd(String fDiagnosisMzIcd) 
    {
        this.fDiagnosisMzIcd = fDiagnosisMzIcd;
    }

    public String getfDiagnosisMzIcd() 
    {
        return fDiagnosisMzIcd;
    }
    public void setfDiagnosisIn(String fDiagnosisIn) 
    {
        this.fDiagnosisIn = fDiagnosisIn;
    }

    public String getfDiagnosisIn() 
    {
        return fDiagnosisIn;
    }
    public void setfOperationIn(String fOperationIn) 
    {
        this.fOperationIn = fOperationIn;
    }

    public String getfOperationIn() 
    {
        return fOperationIn;
    }
    public void setfDiagnosisOut(String fDiagnosisOut) 
    {
        this.fDiagnosisOut = fDiagnosisOut;
    }

    public String getfDiagnosisOut() 
    {
        return fDiagnosisOut;
    }
    public void setfOperationOut(String fOperationOut) 
    {
        this.fOperationOut = fOperationOut;
    }

    public String getfOperationOut() 
    {
        return fOperationOut;
    }
    public void setfDiagnosisMz(String fDiagnosisMz) 
    {
        this.fDiagnosisMz = fDiagnosisMz;
    }

    public String getfDiagnosisMz() 
    {
        return fDiagnosisMz;
    }
    public void setfEmrDiagCode(String fEmrDiagCode) 
    {
        this.fEmrDiagCode = fEmrDiagCode;
    }

    public String getfEmrDiagCode() 
    {
        return fEmrDiagCode;
    }
    public void setfEmrDiagName(String fEmrDiagName) 
    {
        this.fEmrDiagName = fEmrDiagName;
    }

    public String getfEmrDiagName() 
    {
        return fEmrDiagName;
    }
    public void setfEmrOprnCode(String fEmrOprnCode) 
    {
        this.fEmrOprnCode = fEmrOprnCode;
    }

    public String getfEmrOprnCode() 
    {
        return fEmrOprnCode;
    }
    public void setfEmrOprnName(String fEmrOprnName) 
    {
        this.fEmrOprnName = fEmrOprnName;
    }

    public String getfEmrOprnName() 
    {
        return fEmrOprnName;
    }
    public void setfBaDiagCode(String fBaDiagCode) 
    {
        this.fBaDiagCode = fBaDiagCode;
    }

    public String getfBaDiagCode() 
    {
        return fBaDiagCode;
    }
    public void setfBaDiagName(String fBaDiagName) 
    {
        this.fBaDiagName = fBaDiagName;
    }

    public String getfBaDiagName() 
    {
        return fBaDiagName;
    }
    public void setfBaOprnCode(String fBaOprnCode) 
    {
        this.fBaOprnCode = fBaOprnCode;
    }

    public String getfBaOprnCode() 
    {
        return fBaOprnCode;
    }
    public void setfBaOprnName(String fBaOprnName) 
    {
        this.fBaOprnName = fBaOprnName;
    }

    public String getfBaOprnName() 
    {
        return fBaOprnName;
    }
    public void setfYbDiagCode(String fYbDiagCode) 
    {
        this.fYbDiagCode = fYbDiagCode;
    }

    public String getfYbDiagCode() 
    {
        return fYbDiagCode;
    }
    public void setfYbDiagName(String fYbDiagName) 
    {
        this.fYbDiagName = fYbDiagName;
    }

    public String getfYbDiagName() 
    {
        return fYbDiagName;
    }
    public void setfYbOprnCode(String fYbOprnCode) 
    {
        this.fYbOprnCode = fYbOprnCode;
    }

    public String getfYbOprnCode() 
    {
        return fYbOprnCode;
    }
    public void setfYbOprnName(String fYbOprnName) 
    {
        this.fYbOprnName = fYbOprnName;
    }

    public String getfYbOprnName() 
    {
        return fYbOprnName;
    }
    public void setfBmybh(String fBmybh) 
    {
        this.fBmybh = fBmybh;
    }

    public String getfBmybh() 
    {
        return fBmybh;
    }
    public void setfBmy(String fBmy) 
    {
        this.fBmy = fBmy;
    }

    public String getfBmy() 
    {
        return fBmy;
    }
    public void setfTreatmentType(String fTreatmentType) 
    {
        this.fTreatmentType = fTreatmentType;
    }

    public String getfTreatmentType() 
    {
        return fTreatmentType;
    }
    public void setfTreatmentName(String fTreatmentName) 
    {
        this.fTreatmentName = fTreatmentName;
    }

    public String getfTreatmentName() 
    {
        return fTreatmentName;
    }
    public void setfDiagnosisIcdCal(String fDiagnosisIcdCal) 
    {
        this.fDiagnosisIcdCal = fDiagnosisIcdCal;
    }

    public String getfDiagnosisIcdCal() 
    {
        return fDiagnosisIcdCal;
    }
    public void setfDiagnosisCal(String fDiagnosisCal) 
    {
        this.fDiagnosisCal = fDiagnosisCal;
    }

    public String getfDiagnosisCal() 
    {
        return fDiagnosisCal;
    }
    public void setfOperationIcdCal(String fOperationIcdCal) 
    {
        this.fOperationIcdCal = fOperationIcdCal;
    }

    public String getfOperationIcdCal() 
    {
        return fOperationIcdCal;
    }
    public void setfOperationCal(String fOperationCal) 
    {
        this.fOperationCal = fOperationCal;
    }

    public String getfOperationCal() 
    {
        return fOperationCal;
    }
    public void setfTreatmentTypeCal(String fTreatmentTypeCal) 
    {
        this.fTreatmentTypeCal = fTreatmentTypeCal;
    }

    public String getfTreatmentTypeCal() 
    {
        return fTreatmentTypeCal;
    }
    public void setfTreatmentNameCal(String fTreatmentNameCal) 
    {
        this.fTreatmentNameCal = fTreatmentNameCal;
    }

    public String getfTreatmentNameCal() 
    {
        return fTreatmentNameCal;
    }
    public void setfDiseaseType(Integer fDiseaseType) 
    {
        this.fDiseaseType = fDiseaseType;
    }

    public Integer getfDiseaseType() 
    {
        return fDiseaseType;
    }
    public void setfDiseaseTypeBefor(Integer fDiseaseTypeBefor) 
    {
        this.fDiseaseTypeBefor = fDiseaseTypeBefor;
    }

    public Integer getfDiseaseTypeBefor() 
    {
        return fDiseaseTypeBefor;
    }
    public void setfYears(Integer fYears) 
    {
        this.fYears = fYears;
    }

    public Integer getfYears() 
    {
        return fYears;
    }
    public void setfParQ0(BigDecimal fParQ0) 
    {
        this.fParQ0 = fParQ0;
    }

    public BigDecimal getfParQ0() 
    {
        return fParQ0;
    }
    public void setfParQ1(BigDecimal fParQ1) 
    {
        this.fParQ1 = fParQ1;
    }

    public BigDecimal getfParQ1() 
    {
        return fParQ1;
    }
    public void setfParQ1H(BigDecimal fParQ1H) 
    {
        this.fParQ1H = fParQ1H;
    }

    public BigDecimal getfParQ1H() 
    {
        return fParQ1H;
    }
    public void setfParB(BigDecimal fParB) 
    {
        this.fParB = fParB;
    }

    public BigDecimal getfParB() 
    {
        return fParB;
    }
    public void setfParR(BigDecimal fParR) 
    {
        this.fParR = fParR;
    }

    public BigDecimal getfParR() 
    {
        return fParR;
    }
    public void setfStandardScore(BigDecimal fStandardScore) 
    {
        this.fStandardScore = fStandardScore;
    }

    public BigDecimal getfStandardScore() 
    {
        return fStandardScore;
    }
    public void setfScore(BigDecimal fScore) 
    {
        this.fScore = fScore;
    }

    public BigDecimal getfScore() 
    {
        return fScore;
    }
    public void setfAmount(BigDecimal fAmount) 
    {
        this.fAmount = fAmount;
    }

    public BigDecimal getfAmount() 
    {
        return fAmount;
    }
    public void setfSbAmount(BigDecimal fSbAmount) 
    {
        this.fSbAmount = fSbAmount;
    }

    public BigDecimal getfSbAmount() 
    {
        return fSbAmount;
    }
    public void setfSbTotal(BigDecimal fSbTotal) 
    {
        this.fSbTotal = fSbTotal;
    }

    public BigDecimal getfSbTotal() 
    {
        return fSbTotal;
    }
    public void setfBalance(BigDecimal fBalance) 
    {
        this.fBalance = fBalance;
    }

    public BigDecimal getfBalance() 
    {
        return fBalance;
    }
    public void setfCostTotal(BigDecimal fCostTotal) 
    {
        this.fCostTotal = fCostTotal;
    }

    public BigDecimal getfCostTotal() 
    {
        return fCostTotal;
    }
    public void setfClinicalSbAmount(BigDecimal fClinicalSbAmount) 
    {
        this.fClinicalSbAmount = fClinicalSbAmount;
    }

    public BigDecimal getfClinicalSbAmount() 
    {
        return fClinicalSbAmount;
    }
    public void setfPreSbTotal(BigDecimal fPreSbTotal) 
    {
        this.fPreSbTotal = fPreSbTotal;
    }

    public BigDecimal getfPreSbTotal() 
    {
        return fPreSbTotal;
    }
    public void setfPreAmount(BigDecimal fPreAmount) 
    {
        this.fPreAmount = fPreAmount;
    }

    public BigDecimal getfPreAmount() 
    {
        return fPreAmount;
    }
    public void setfPreZfhj(BigDecimal fPreZfhj) 
    {
        this.fPreZfhj = fPreZfhj;
    }

    public BigDecimal getfPreZfhj() 
    {
        return fPreZfhj;
    }
    public void setfPreZyf(BigDecimal fPreZyf) 
    {
        this.fPreZyf = fPreZyf;
    }

    public BigDecimal getfPreZyf() 
    {
        return fPreZyf;
    }
    public void setfPreZfyf(BigDecimal fPreZfyf) 
    {
        this.fPreZfyf = fPreZfyf;
    }

    public BigDecimal getfPreZfyf() 
    {
        return fPreZfyf;
    }
    public void setfPreZclf(Long fPreZclf) 
    {
        this.fPreZclf = fPreZclf;
    }

    public Long getfPreZclf() 
    {
        return fPreZclf;
    }
    public void setfPreZfcl(BigDecimal fPreZfcl) 
    {
        this.fPreZfcl = fPreZfcl;
    }

    public BigDecimal getfPreZfcl() 
    {
        return fPreZfcl;
    }
    public void setfMatchFlag(Integer fMatchFlag) 
    {
        this.fMatchFlag = fMatchFlag;
    }

    public Integer getfMatchFlag() 
    {
        return fMatchFlag;
    }
    public void setfDoctorNoZy(String fDoctorNoZy) 
    {
        this.fDoctorNoZy = fDoctorNoZy;
    }

    public String getfDoctorNoZy() 
    {
        return fDoctorNoZy;
    }
    public void setfDoctorNameZy(String fDoctorNameZy) 
    {
        this.fDoctorNameZy = fDoctorNameZy;
    }

    public String getfDoctorNameZy() 
    {
        return fDoctorNameZy;
    }
    public void setfDoctorNoZz(String fDoctorNoZz) 
    {
        this.fDoctorNoZz = fDoctorNoZz;
    }

    public String getfDoctorNoZz() 
    {
        return fDoctorNoZz;
    }
    public void setfDoctorNameZz(String fDoctorNameZz) 
    {
        this.fDoctorNameZz = fDoctorNameZz;
    }

    public String getfDoctorNameZz() 
    {
        return fDoctorNameZz;
    }
    public void setfReportFlag(Long fReportFlag) 
    {
        this.fReportFlag = fReportFlag;
    }

    public Long getfReportFlag() 
    {
        return fReportFlag;
    }
    public void setfDeptNoBa(String fDeptNoBa) 
    {
        this.fDeptNoBa = fDeptNoBa;
    }

    public String getfDeptNoBa() 
    {
        return fDeptNoBa;
    }
    public void setfDeptNameBa(String fDeptNameBa) 
    {
        this.fDeptNameBa = fDeptNameBa;
    }

    public String getfDeptNameBa() 
    {
        return fDeptNameBa;
    }
    public void setfJsfs(Long fJsfs) 
    {
        this.fJsfs = fJsfs;
    }

    public Long getfJsfs() 
    {
        return fJsfs;
    }
    public void setfCostOperation(BigDecimal fCostOperation) 
    {
        this.fCostOperation = fCostOperation;
    }

    public BigDecimal getfCostOperation() 
    {
        return fCostOperation;
    }
    public void setfCostZl(BigDecimal fCostZl) 
    {
        this.fCostZl = fCostZl;
    }

    public BigDecimal getfCostZl() 
    {
        return fCostZl;
    }
    public void setfUpdateFlag(Long fUpdateFlag) 
    {
        this.fUpdateFlag = fUpdateFlag;
    }

    public Long getfUpdateFlag() 
    {
        return fUpdateFlag;
    }
    public void setfDiagnosisOutFlag(Integer fDiagnosisOutFlag) 
    {
        this.fDiagnosisOutFlag = fDiagnosisOutFlag;
    }

    public Integer getfDiagnosisOutFlag() 
    {
        return fDiagnosisOutFlag;
    }
    public void setfOperationOutFlag(Integer fOperationOutFlag) 
    {
        this.fOperationOutFlag = fOperationOutFlag;
    }

    public Integer getfOperationOutFlag() 
    {
        return fOperationOutFlag;
    }
    public void setfDiagnosisMzFlag(Integer fDiagnosisMzFlag) 
    {
        this.fDiagnosisMzFlag = fDiagnosisMzFlag;
    }

    public Integer getfDiagnosisMzFlag() 
    {
        return fDiagnosisMzFlag;
    }
    public void setfDiagnosisBlFlag(Integer fDiagnosisBlFlag) 
    {
        this.fDiagnosisBlFlag = fDiagnosisBlFlag;
    }

    public Integer getfDiagnosisBlFlag() 
    {
        return fDiagnosisBlFlag;
    }
    public void setCreatedAt(Date createdAt) 
    {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() 
    {
        return createdAt;
    }
    public void setUpdatedAt(Date updatedAt) 
    {
        this.updatedAt = updatedAt;
    }

    public Date getUpdatedAt() 
    {
        return updatedAt;
    }
    public void setfHisInFlag(String fHisInFlag) 
    {
        this.fHisInFlag = fHisInFlag;
    }

    public String getfHisInFlag() 
    {
        return fHisInFlag;
    }
    public void setSbIcdScoreVersionNo(String sbIcdScoreVersionNo) 
    {
        this.sbIcdScoreVersionNo = sbIcdScoreVersionNo;
    }

    public String getSbIcdScoreVersionNo() 
    {
        return sbIcdScoreVersionNo;
    }
    public void setSbOpTreatmentVersionNo(String sbOpTreatmentVersionNo) 
    {
        this.sbOpTreatmentVersionNo = sbOpTreatmentVersionNo;
    }

    public String getSbOpTreatmentVersionNo() 
    {
        return sbOpTreatmentVersionNo;
    }
    public void setfIsMt(Integer fIsMt) 
    {
        this.fIsMt = fIsMt;
    }

    public Integer getfIsMt() 
    {
        return fIsMt;
    }
    public void setfIsYb(Integer fIsYb) 
    {
        this.fIsYb = fIsYb;
    }

    public Integer getfIsYb() 
    {
        return fIsYb;
    }
    public void setfHisBz(String fHisBz) 
    {
        this.fHisBz = fHisBz;
    }

    public String getfHisBz() 
    {
        return fHisBz;
    }
    public void setfInStatus(Integer fInStatus) 
    {
        this.fInStatus = fInStatus;
    }

    public Integer getfInStatus() 
    {
        return fInStatus;
    }
    public void setfAppraiseScore(BigDecimal fAppraiseScore) 
    {
        this.fAppraiseScore = fAppraiseScore;
    }

    public BigDecimal getfAppraiseScore() 
    {
        return fAppraiseScore;
    }
    public void setfAppraiseScoreH(BigDecimal fAppraiseScoreH) 
    {
        this.fAppraiseScoreH = fAppraiseScoreH;
    }

    public BigDecimal getfAppraiseScoreH() 
    {
        return fAppraiseScoreH;
    }
    public void setfPreMlnZf(BigDecimal fPreMlnZf) 
    {
        this.fPreMlnZf = fPreMlnZf;
    }

    public BigDecimal getfPreMlnZf() 
    {
        return fPreMlnZf;
    }
    public void setfPreMlwZf(BigDecimal fPreMlwZf) 
    {
        this.fPreMlwZf = fPreMlwZf;
    }

    public BigDecimal getfPreMlwZf() 
    {
        return fPreMlwZf;
    }
    public void setfPreParR(BigDecimal fPreParR) 
    {
        this.fPreParR = fPreParR;
    }

    public BigDecimal getfPreParR() 
    {
        return fPreParR;
    }
    public void setfPreBalance(BigDecimal fPreBalance) 
    {
        this.fPreBalance = fPreBalance;
    }

    public BigDecimal getfPreBalance() 
    {
        return fPreBalance;
    }
    public void setfJzjlh(String fJzjlh) 
    {
        this.fJzjlh = fJzjlh;
    }

    public String getfJzjlh() 
    {
        return fJzjlh;
    }
    public void setfJsxh(String fJsxh) 
    {
        this.fJsxh = fJsxh;
    }

    public String getfJsxh() 
    {
        return fJsxh;
    }
    public void setfHzlb(String fHzlb) 
    {
        this.fHzlb = fHzlb;
    }

    public String getfHzlb() 
    {
        return fHzlb;
    }
    public void setfXzlx(String fXzlx) 
    {
        this.fXzlx = fXzlx;
    }

    public String getfXzlx() 
    {
        return fXzlx;
    }
    public void setfYllb(String fYllb) 
    {
        this.fYllb = fYllb;
    }

    public String getfYllb() 
    {
        return fYllb;
    }
    public void setfDeptInNo(String fDeptInNo) 
    {
        this.fDeptInNo = fDeptInNo;
    }

    public String getfDeptInNo() 
    {
        return fDeptInNo;
    }
    public void setfDeptInName(String fDeptInName) 
    {
        this.fDeptInName = fDeptInName;
    }

    public String getfDeptInName() 
    {
        return fDeptInName;
    }
    public void setfEffectiveIncome(BigDecimal fEffectiveIncome) 
    {
        this.fEffectiveIncome = fEffectiveIncome;
    }

    public BigDecimal getfEffectiveIncome() 
    {
        return fEffectiveIncome;
    }
    public void setfCostTreat(BigDecimal fCostTreat) 
    {
        this.fCostTreat = fCostTreat;
    }

    public BigDecimal getfCostTreat() 
    {
        return fCostTreat;
    }
    public void setfWesternMedicine(BigDecimal fWesternMedicine) 
    {
        this.fWesternMedicine = fWesternMedicine;
    }

    public BigDecimal getfWesternMedicine() 
    {
        return fWesternMedicine;
    }
    public void setfJcf(BigDecimal fJcf) 
    {
        this.fJcf = fJcf;
    }

    public BigDecimal getfJcf() 
    {
        return fJcf;
    }
    public void setfChineseMedicine(BigDecimal fChineseMedicine) 
    {
        this.fChineseMedicine = fChineseMedicine;
    }

    public BigDecimal getfChineseMedicine() 
    {
        return fChineseMedicine;
    }
    public void setfCostMaterial(BigDecimal fCostMaterial) 
    {
        this.fCostMaterial = fCostMaterial;
    }

    public BigDecimal getfCostMaterial() 
    {
        return fCostMaterial;
    }
    public void setfInspection(BigDecimal fInspection) 
    {
        this.fInspection = fInspection;
    }

    public BigDecimal getfInspection() 
    {
        return fInspection;
    }
    public void setfMzf(BigDecimal fMzf) 
    {
        this.fMzf = fMzf;
    }

    public BigDecimal getfMzf() 
    {
        return fMzf;
    }
    public void setGdType(Integer gdType) 
    {
        this.gdType = gdType;
    }

    public Integer getGdType() 
    {
        return gdType;
    }
    public void setGdDocttime(Date gdDocttime) 
    {
        this.gdDocttime = gdDocttime;
    }

    public Date getGdDocttime() 
    {
        return gdDocttime;
    }
    public void setGdNursetime(Date gdNursetime) 
    {
        this.gdNursetime = gdNursetime;
    }

    public Date getGdNursetime() 
    {
        return gdNursetime;
    }
    public void setPreRuleCount(Integer preRuleCount) 
    {
        this.preRuleCount = preRuleCount;
    }

    public Integer getPreRuleCount() 
    {
        return preRuleCount;
    }
    public void setfWardNo(String fWardNo) 
    {
        this.fWardNo = fWardNo;
    }

    public String getfWardNo() 
    {
        return fWardNo;
    }
    public void setfWardName(String fWardName) 
    {
        this.fWardName = fWardName;
    }

    public String getfWardName() 
    {
        return fWardName;
    }
    public void setfOperationOutIcdDip(String fOperationOutIcdDip) 
    {
        this.fOperationOutIcdDip = fOperationOutIcdDip;
    }

    public String getfOperationOutIcdDip() 
    {
        return fOperationOutIcdDip;
    }
    public void setfOperationOutDip(String fOperationOutDip) 
    {
        this.fOperationOutDip = fOperationOutDip;
    }

    public String getfOperationOutDip() 
    {
        return fOperationOutDip;
    }
    public void setYlzcode(String ylzcode) 
    {
        this.ylzcode = ylzcode;
    }

    public String getYlzcode() 
    {
        return ylzcode;
    }
    public void setYlzname(String ylzname) 
    {
        this.ylzname = ylzname;
    }

    public String getYlzname() 
    {
        return ylzname;
    }
    public void setDoctor(String doctor) 
    {
        this.doctor = doctor;
    }

    public String getDoctor() 
    {
        return doctor;
    }
    public void setSdrStatus(Integer sdrStatus) 
    {
        this.sdrStatus = sdrStatus;
    }

    public Integer getSdrStatus() 
    {
        return sdrStatus;
    }
    public void setfYlAmount(BigDecimal fYlAmount) 
    {
        this.fYlAmount = fYlAmount;
    }

    public BigDecimal getfYlAmount() 
    {
        return fYlAmount;
    }
    public void setIsDay15(Integer isDay15) 
    {
        this.isDay15 = isDay15;
    }

    public Integer getIsDay15() 
    {
        return isDay15;
    }
    public void setDiseaseGroup(String diseaseGroup) 
    {
        this.diseaseGroup = diseaseGroup;
    }

    public String getDiseaseGroup() 
    {
        return diseaseGroup;
    }
    public void setDiseaseSeverity(String diseaseSeverity) 
    {
        this.diseaseSeverity = diseaseSeverity;
    }

    public String getDiseaseSeverity() 
    {
        return diseaseSeverity;
    }
    public void setDiseaseAdjustment(BigDecimal diseaseAdjustment) 
    {
        this.diseaseAdjustment = diseaseAdjustment;
    }

    public BigDecimal getDiseaseAdjustment() 
    {
        return diseaseAdjustment;
    }
    public void setAdditiveCoefficient(BigDecimal additiveCoefficient) 
    {
        this.additiveCoefficient = additiveCoefficient;
    }

    public BigDecimal getAdditiveCoefficient() 
    {
        return additiveCoefficient;
    }
    public void setfTreatmentInfo(String fTreatmentInfo) 
    {
        this.fTreatmentInfo = fTreatmentInfo;
    }

    public String getfTreatmentInfo() 
    {
        return fTreatmentInfo;
    }
    public void setIsHighPrecision(Integer isHighPrecision) 
    {
        this.isHighPrecision = isHighPrecision;
    }

    public Integer getIsHighPrecision() 
    {
        return isHighPrecision;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("fHisId", getfHisId())
            .append("fHisNo", getfHisNo())
            .append("fBedNo", getfBedNo())
            .append("fPatientType", getfPatientType())
            .append("fPatientTypeCn", getfPatientTypeCn())
            .append("fPatientNo", getfPatientNo())
            .append("fTimes", getfTimes())
            .append("fInsuranceNo", getfInsuranceNo())
            .append("fPatientName", getfPatientName())
            .append("fPatientBirthday", getfPatientBirthday())
            .append("fPatientAge", getfPatientAge())
            .append("fPatientCardno", getfPatientCardno())
            .append("fPatientSex", getfPatientSex())
            .append("fPatientJob", getfPatientJob())
            .append("fPatientAddress", getfPatientAddress())
            .append("fDoctorNoZg", getfDoctorNoZg())
            .append("fDoctorNameZg", getfDoctorNameZg())
            .append("fDeptNo", getfDeptNo())
            .append("fDeptName", getfDeptName())
            .append("fDatetimeIn", getfDatetimeIn())
            .append("fDatetimeOut", getfDatetimeOut())
            .append("fBalanceDate", getfBalanceDate())
            .append("fDays", getfDays())
            .append("fDiagnosisInIcd", getfDiagnosisInIcd())
            .append("fOperationInIcd", getfOperationInIcd())
            .append("fDiagnosisOutIcd", getfDiagnosisOutIcd())
            .append("fOperationOutIcd", getfOperationOutIcd())
            .append("fDiagnosisMzIcd", getfDiagnosisMzIcd())
            .append("fDiagnosisIn", getfDiagnosisIn())
            .append("fOperationIn", getfOperationIn())
            .append("fDiagnosisOut", getfDiagnosisOut())
            .append("fOperationOut", getfOperationOut())
            .append("fDiagnosisMz", getfDiagnosisMz())
            .append("fEmrDiagCode", getfEmrDiagCode())
            .append("fEmrDiagName", getfEmrDiagName())
            .append("fEmrOprnCode", getfEmrOprnCode())
            .append("fEmrOprnName", getfEmrOprnName())
            .append("fBaDiagCode", getfBaDiagCode())
            .append("fBaDiagName", getfBaDiagName())
            .append("fBaOprnCode", getfBaOprnCode())
            .append("fBaOprnName", getfBaOprnName())
            .append("fYbDiagCode", getfYbDiagCode())
            .append("fYbDiagName", getfYbDiagName())
            .append("fYbOprnCode", getfYbOprnCode())
            .append("fYbOprnName", getfYbOprnName())
            .append("fBmybh", getfBmybh())
            .append("fBmy", getfBmy())
            .append("fTreatmentType", getfTreatmentType())
            .append("fTreatmentName", getfTreatmentName())
            .append("fDiagnosisIcdCal", getfDiagnosisIcdCal())
            .append("fDiagnosisCal", getfDiagnosisCal())
            .append("fOperationIcdCal", getfOperationIcdCal())
            .append("fOperationCal", getfOperationCal())
            .append("fTreatmentTypeCal", getfTreatmentTypeCal())
            .append("fTreatmentNameCal", getfTreatmentNameCal())
            .append("fDiseaseType", getfDiseaseType())
            .append("fDiseaseTypeBefor", getfDiseaseTypeBefor())
            .append("fYears", getfYears())
            .append("fParQ0", getfParQ0())
            .append("fParQ1", getfParQ1())
            .append("fParQ1H", getfParQ1H())
            .append("fParB", getfParB())
            .append("fParR", getfParR())
            .append("fStandardScore", getfStandardScore())
            .append("fScore", getfScore())
            .append("fAmount", getfAmount())
            .append("fSbAmount", getfSbAmount())
            .append("fSbTotal", getfSbTotal())
            .append("fBalance", getfBalance())
            .append("fCostTotal", getfCostTotal())
            .append("fClinicalSbAmount", getfClinicalSbAmount())
            .append("fPreSbTotal", getfPreSbTotal())
            .append("fPreAmount", getfPreAmount())
            .append("fPreZfhj", getfPreZfhj())
            .append("fPreZyf", getfPreZyf())
            .append("fPreZfyf", getfPreZfyf())
            .append("fPreZclf", getfPreZclf())
            .append("fPreZfcl", getfPreZfcl())
            .append("fMatchFlag", getfMatchFlag())
            .append("fDoctorNoZy", getfDoctorNoZy())
            .append("fDoctorNameZy", getfDoctorNameZy())
            .append("fDoctorNoZz", getfDoctorNoZz())
            .append("fDoctorNameZz", getfDoctorNameZz())
            .append("fReportFlag", getfReportFlag())
            .append("fDeptNoBa", getfDeptNoBa())
            .append("fDeptNameBa", getfDeptNameBa())
            .append("fJsfs", getfJsfs())
            .append("fCostOperation", getfCostOperation())
            .append("fCostZl", getfCostZl())
            .append("fUpdateFlag", getfUpdateFlag())
            .append("fDiagnosisOutFlag", getfDiagnosisOutFlag())
            .append("fOperationOutFlag", getfOperationOutFlag())
            .append("fDiagnosisMzFlag", getfDiagnosisMzFlag())
            .append("fDiagnosisBlFlag", getfDiagnosisBlFlag())
            .append("createdAt", getCreatedAt())
            .append("updatedAt", getUpdatedAt())
            .append("fHisInFlag", getfHisInFlag())
            .append("sbIcdScoreVersionNo", getSbIcdScoreVersionNo())
            .append("sbOpTreatmentVersionNo", getSbOpTreatmentVersionNo())
            .append("fIsMt", getfIsMt())
            .append("fIsYb", getfIsYb())
            .append("fHisBz", getfHisBz())
            .append("fInStatus", getfInStatus())
            .append("fAppraiseScore", getfAppraiseScore())
            .append("fAppraiseScoreH", getfAppraiseScoreH())
            .append("fPreMlnZf", getfPreMlnZf())
            .append("fPreMlwZf", getfPreMlwZf())
            .append("fPreParR", getfPreParR())
            .append("fPreBalance", getfPreBalance())
            .append("fJzjlh", getfJzjlh())
            .append("fJsxh", getfJsxh())
            .append("fHzlb", getfHzlb())
            .append("fXzlx", getfXzlx())
            .append("fYllb", getfYllb())
            .append("fDeptInNo", getfDeptInNo())
            .append("fDeptInName", getfDeptInName())
            .append("fEffectiveIncome", getfEffectiveIncome())
            .append("fCostTreat", getfCostTreat())
            .append("fWesternMedicine", getfWesternMedicine())
            .append("fJcf", getfJcf())
            .append("fChineseMedicine", getfChineseMedicine())
            .append("fCostMaterial", getfCostMaterial())
            .append("fInspection", getfInspection())
            .append("fMzf", getfMzf())
            .append("gdType", getGdType())
            .append("gdDocttime", getGdDocttime())
            .append("gdNursetime", getGdNursetime())
            .append("preRuleCount", getPreRuleCount())
            .append("fWardNo", getfWardNo())
            .append("fWardName", getfWardName())
            .append("fOperationOutIcdDip", getfOperationOutIcdDip())
            .append("fOperationOutDip", getfOperationOutDip())
            .append("ylzcode", getYlzcode())
            .append("ylzname", getYlzname())
            .append("doctor", getDoctor())
            .append("sdrStatus", getSdrStatus())
            .append("fYlAmount", getfYlAmount())
            .append("isDay15", getIsDay15())
            .append("diseaseGroup", getDiseaseGroup())
            .append("diseaseSeverity", getDiseaseSeverity())
            .append("diseaseAdjustment", getDiseaseAdjustment())
            .append("additiveCoefficient", getAdditiveCoefficient())
            .append("fTreatmentInfo", getfTreatmentInfo())
            .append("isHighPrecision", getIsHighPrecision())
            .toString();
    }
}
