<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="科室" prop="fDeptName">
        <el-input
          v-model="queryParams.fDeptName"
          placeholder="请输入科室"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="住院医生" prop="fDoctorNameZy">
        <el-input
          v-model="queryParams.fDoctorNameZy"
          placeholder="请输入住院医生"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="患者类别" prop="fHzlb">
        <el-select v-model="queryParams.fHzlb" placeholder="请选择患者类别" clearable>
          <el-option
            v-for="dict in dict.type.f_is_mt"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="险种类型" prop="fXzlx">
        <el-input
          v-model="queryParams.fXzlx"
          placeholder="请输入险种类型"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="在院预警数量" prop="preRuleCount">
        <el-input
          v-model="queryParams.preRuleCount"
          placeholder="请输入在院预警数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['dispatient:dispatient:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['dispatient:dispatient:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['dispatient:dispatient:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['dispatient:dispatient:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="dispatientList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="${comment}" align="center" prop="id" />
      <el-table-column label="住院号" align="center" prop="fHisNo" />
      <el-table-column label="床号" align="center" prop="fBedNo" />
      <el-table-column label="病人性质名称" align="center" prop="fPatientTypeCn" />
      <el-table-column label="姓名" align="center" prop="fPatientName" />
      <el-table-column label="科室" align="center" prop="fDeptName" />
      <el-table-column label="入院日期" align="center" prop="fDatetimeIn" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.fDatetimeIn, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="出院日期" align="center" prop="fDatetimeOut" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.fDatetimeOut, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="住院天数" align="center" prop="fDays" />
      <el-table-column label="出院诊断名称" align="center" prop="fYbDiagName" />
      <el-table-column label="诊治方式名称" align="center" prop="fTreatmentName" />
      <el-table-column label="R值:基准率" align="center" prop="fParR" />
      <el-table-column label="住院总费用" align="center" prop="fAmount" />
      <el-table-column label="医保费用" align="center" prop="fSbAmount" />
      <el-table-column label="住院医生" align="center" prop="fDoctorNameZy" />
      <el-table-column label="险种类型" align="center" prop="fXzlx" />
      <el-table-column label="中药" align="center" prop="fChineseMedicine" />
      <el-table-column label="在院预警数量" align="center" prop="preRuleCount" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['dispatient:dispatient:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['dispatient:dispatient:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改出院患者对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listDispatient, getDispatient, delDispatient, addDispatient, updateDispatient } from "@/api/dispatient/dispatient";

export default {
  name: "Dispatient",
  dicts: ['f_is_mt'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 出院患者表格数据
      dispatientList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        fDeptName: null,
        fDoctorNameZy: null,
        fHzlb: null,
        fXzlx: null,
        preRuleCount: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        preRuleCount: [
          { required: true, message: "在院预警数量不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询出院患者列表 */
    getList() {
      this.loading = true;
      listDispatient(this.queryParams).then(response => {
        this.dispatientList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        fHisId: null,
        fHisNo: null,
        fBedNo: null,
        fPatientType: null,
        fPatientTypeCn: null,
        fPatientNo: null,
        fTimes: null,
        fInsuranceNo: null,
        fPatientName: null,
        fPatientBirthday: null,
        fPatientAge: null,
        fPatientCardno: null,
        fPatientSex: null,
        fPatientJob: null,
        fPatientAddress: null,
        fDoctorNoZg: null,
        fDoctorNameZg: null,
        fDeptNo: null,
        fDeptName: null,
        fDatetimeIn: null,
        fDatetimeOut: null,
        fBalanceDate: null,
        fDays: null,
        fDiagnosisInIcd: null,
        fOperationInIcd: null,
        fDiagnosisOutIcd: null,
        fOperationOutIcd: null,
        fDiagnosisMzIcd: null,
        fDiagnosisIn: null,
        fOperationIn: null,
        fDiagnosisOut: null,
        fOperationOut: null,
        fDiagnosisMz: null,
        fEmrDiagCode: null,
        fEmrDiagName: null,
        fEmrOprnCode: null,
        fEmrOprnName: null,
        fBaDiagCode: null,
        fBaDiagName: null,
        fBaOprnCode: null,
        fBaOprnName: null,
        fYbDiagCode: null,
        fYbDiagName: null,
        fYbOprnCode: null,
        fYbOprnName: null,
        fBmybh: null,
        fBmy: null,
        fTreatmentType: null,
        fTreatmentName: null,
        fDiagnosisIcdCal: null,
        fDiagnosisCal: null,
        fOperationIcdCal: null,
        fOperationCal: null,
        fTreatmentTypeCal: null,
        fTreatmentNameCal: null,
        fDiseaseType: null,
        fDiseaseTypeBefor: null,
        fYears: null,
        fParQ0: null,
        fParQ1: null,
        fParQ1H: null,
        fParB: null,
        fParR: null,
        fStandardScore: null,
        fScore: null,
        fAmount: null,
        fSbAmount: null,
        fSbTotal: null,
        fBalance: null,
        fCostTotal: null,
        fClinicalSbAmount: null,
        fPreSbTotal: null,
        fPreAmount: null,
        fPreZfhj: null,
        fPreZyf: null,
        fPreZfyf: null,
        fPreZclf: null,
        fPreZfcl: null,
        fMatchFlag: null,
        fDoctorNoZy: null,
        fDoctorNameZy: null,
        fDoctorNoZz: null,
        fDoctorNameZz: null,
        fReportFlag: null,
        fDeptNoBa: null,
        fDeptNameBa: null,
        fJsfs: null,
        fCostOperation: null,
        fCostZl: null,
        fUpdateFlag: null,
        fDiagnosisOutFlag: null,
        fOperationOutFlag: null,
        fDiagnosisMzFlag: null,
        fDiagnosisBlFlag: null,
        createdAt: null,
        updatedAt: null,
        fHisInFlag: null,
        sbIcdScoreVersionNo: null,
        sbOpTreatmentVersionNo: null,
        fIsMt: null,
        fIsYb: null,
        fHisBz: null,
        fInStatus: null,
        fAppraiseScore: null,
        fAppraiseScoreH: null,
        fPreMlnZf: null,
        fPreMlwZf: null,
        fPreParR: null,
        fPreBalance: null,
        fJzjlh: null,
        fJsxh: null,
        fHzlb: null,
        fXzlx: null,
        fYllb: null,
        fDeptInNo: null,
        fDeptInName: null,
        fEffectiveIncome: null,
        fCostTreat: null,
        fWesternMedicine: null,
        fJcf: null,
        fChineseMedicine: null,
        fCostMaterial: null,
        fInspection: null,
        fMzf: null,
        gdType: null,
        gdDocttime: null,
        gdNursetime: null,
        preRuleCount: null,
        fWardNo: null,
        fWardName: null,
        fOperationOutIcdDip: null,
        fOperationOutDip: null,
        ylzcode: null,
        ylzname: null,
        doctor: null,
        sdrStatus: null,
        fYlAmount: null,
        isDay15: null,
        diseaseGroup: null,
        diseaseSeverity: null,
        diseaseAdjustment: null,
        additiveCoefficient: null,
        fTreatmentInfo: null,
        isHighPrecision: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加出院患者";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getDispatient(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改出院患者";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateDispatient(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addDispatient(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除出院患者编号为"' + ids + '"的数据项？').then(function() {
        return delDispatient(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('dispatient/dispatient/export', {
        ...this.queryParams
      }, `dispatient_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
