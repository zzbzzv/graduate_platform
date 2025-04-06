<template>
  <el-dialog :title="title" :visible.sync="visible" width="80%" append-to-body>
    <el-tabs v-model="activeName" @tab-click="handleClick">
      <!-- 医保匹配选项卡 -->
      <el-tab-pane label="医保匹配" name="insuranceMatch">
        <div class="dialog-content">
          <!-- 临床ICD区域 -->
          <div class="match-section">
            <p><span>临床ICD：</span>{{ data.clinicalIcd }}</p>
            <p><span>医保ICD：</span>{{ data.medicalIcd }}</p>
            <div class="empty-box"></div> <!-- 空白框，用来填充8行数据 -->
          </div>
          <!-- DIP手术组区域 -->
          <div class="match-section">
            <p><span>DIP手术组：</span>{{ data.dipSurgeryCategory }}</p>
            <p><span>手术组查询：</span>{{ data.surgeryGroupQuery }}</p>
            <div class="empty-box"></div> <!-- 空白框，用来填充8行数据 -->
          </div>
        </div>
      </el-tab-pane>

      <!-- 费用结构选项卡 -->
      <el-tab-pane label="费用结构" name="costStructure">
        <div class="dialog-content">
          <p><span>分值单价：</span>{{ data.scoreUnitPrice }}</p>
          <p><span>标准分值：</span>{{ data.standardScore }}</p>
          <p><span>最终得分：</span>{{ data.finalScore }}</p>
          <p><span>分值费用：</span>{{ data.scoreCost }}</p>
          <p><span>预计结余：</span>{{ data.estimatedBalance }}</p>
        </div>
      </el-tab-pane>

      <!-- 首页质控选项卡 -->
      <el-tab-pane label="首页质控" name="homeQualityControl">
        <div class="dialog-content">
          <p><span>质量控制指标：</span>{{ data.qualityControlIndicators }}</p>
          <p><span>风险等级：</span>{{ data.riskLevel }}</p>
          <p><span>质控评分：</span>{{ data.qualityScore }}</p>
        </div>
      </el-tab-pane>

      <!-- 收费监控选项卡 -->
      <el-tab-pane label="收费监控" name="chargeMonitoring">
        <div class="dialog-content">
          <p><span>收费项目：</span>{{ data.chargeItems }}</p>
          <p><span>收费金额：</span>{{ data.chargeAmount }}</p>
          <p><span>监控状态：</span>{{ data.monitoringStatus }}</p>
        </div>
      </el-tab-pane>

      <!-- 医嘱预警选项卡 -->
      <el-tab-pane label="医嘱预警" name="orderWarning">
        <div class="dialog-content">
          <p><span>预警类型：</span>{{ data.warningType }}</p>
          <p><span>医嘱内容：</span>{{ data.orderContent }}</p>
          <p><span>预警级别：</span>{{ data.warningLevel }}</p>
        </div>
      </el-tab-pane>
    </el-tabs>

    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取 消</el-button>
      <el-button type="primary" @click="visible = false">确 定</el-button>
    </span>
  </el-dialog>
</template>

<script>
export default {
  props: {
    visible: {
      type: Boolean,
      default: false,
    },
    title: {
      type: String,
      default: '',
    },
    data: {
      type: Object,
      default: () => ({}),
    },
  },
  data() {
    return {
      activeName: 'insuranceMatch', // 默认选中的标签页
    };
  },
  methods: {
    handleClick(tab, event) {
      console.log(tab, event);
    },
  },
  watch: {
    visible(val) {
      this.$emit('update:visible', val);
    },
  },
};
</script>

<style scoped>
.dialog-content {
  display: flex;
  flex-direction: column;
  margin: 10px;
}

.dialog-content p {
  margin: 5px 0;
}

.match-section {
  margin-bottom: 20px;
}

.empty-box {
  height: 160px; /* 这里设置空白框的高度，大概8行数据长度 */
  width: 100px;
  border: 1px dashed #ccc; /* 给空白框添加虚线边框 */

}
</style>
