<template>
  <div class="app-container home">
    <el-row :gutter="20">
      <!-- 统计数据面板 -->
      <el-col :span="6" v-for="(item, index) in summaryItems" :key="index">
        <el-card>
          <div class="card-title">{{ item.title }}</div>
          <div class="card-value" :class="item.valueClass">{{ item.value }}</div>
        </el-card>
      </el-col>
    </el-row>

    <!-- 统计图表 -->
    <el-row :gutter="20" style="margin-top: 20px;">
      <el-col :span="12">
        <el-card>
          <div ref="settlementChart" style="height: 300px;"></div>
        </el-card>
      </el-col>
      <el-col :span="12">
        <el-card>
          <div ref="profitLossChart" style="height: 300px;"></div>
        </el-card>
      </el-col>
    </el-row>

    <!-- 医保年度报表 -->
    <el-row :gutter="20" style="margin-top: 20px;">
      <el-col :span="24">
        <el-card>
          <div slot="header" class="clearfix">
            <span>医保年度报表</span>
          </div>
          <el-table :data="reportData" border style="width: 100%">
            <el-table-column prop="category" label="类别" width="150"></el-table-column>
            <el-table-column prop="description" label="描述"></el-table-column>
            <el-table-column prop="count" label="人数" width="180"></el-table-column>
            <el-table-column prop="percentage" label="占比" width="120"></el-table-column>
          </el-table>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import * as echarts from "echarts";

export default {
  name: "Index",
  data() {
    return {
      summaryItems: [
        { title: "医保患者总费用(万元)", value: "10791.07", valueClass: "" },
        { title: "医保患者医保费用(万元)", value: "9541.69", valueClass: "positive" },
        { title: "总医保结余(万元)", value: "-1415.71", valueClass: "negative" },
        { title: "总分值(万分)", value: "147.54", valueClass: "positive" },
        { title: "人均医保结余(元)", value: "432.5", valueClass: "" },
        { title: "人均分值(分)", value: "89.6", valueClass: "" },
        { title: "人均住院日(天)", value: "8.3", valueClass: "" },
        { title: "人均医保费用(元)", value: "2763.8", valueClass: "" }
      ],
      reportData: [
        { category: "偏低病组", description: "实际支出，不盈不亏", count: 1087, percentage: "11.48%" },
        { category: "正常病组1", description: "按一倍R值报销，未超一倍部分为盈利", count: 4288, percentage: "45.3%" },
        { category: "正常病组2", description: "按一倍R值报销，超过一倍部分为亏损", count: 3019, percentage: "31.89%" },
        { category: "偏高病组", description: "最高于一倍R值", count: 532, percentage: "5.62%" }
      ]
    };
  },
  mounted() {
    this.initSettlementChart();
    this.initProfitLossChart();
  },
  methods: {
    initSettlementChart() {
      const chart = echarts.init(this.$refs.settlementChart);
      chart.setOption({
        tooltip: { trigger: 'axis', axisPointer: { type: 'cross' } },
        legend: { data: ['结算人次', '自费率'] },
        xAxis: { type: 'category', data: ['2024-01', '2024-02', '2024-03', '2024-04'] },
        yAxis: [
          { type: 'value', name: '结算人次' },
          { type: 'value', name: '自费率', axisLabel: { formatter: '{value}%' } }
        ],
        series: [
          { name: '结算人次', type: 'bar', data: [1500, 1600, 1700, 1800] },
          { name: '自费率', type: 'line', yAxisIndex: 1, data: [5.1, 4.8, 4.5, 4.2] }
        ]
      });
    },
    initProfitLossChart() {
      const chart = echarts.init(this.$refs.profitLossChart);
      chart.setOption({
        tooltip: { trigger: 'axis', axisPointer: { type: 'cross' } },
        legend: { data: ['盈利病种', '亏损病种', '结余'] },
        xAxis: { type: 'category', data: ['2024-01', '2024-02', '2024-03', '2024-04'] },
        yAxis: [
          { type: 'value', name: '盈利/亏损' },
          { type: 'value', name: '结余', axisLabel: { formatter: '{value}' } }
        ],
        series: [
          { name: '盈利病种', type: 'bar', data: [200, 300, 250, 400] },
          { name: '亏损病种', type: 'bar', data: [-100, -150, -200, -250] },
          { name: '结余', type: 'line', yAxisIndex: 1, data: [100, 150, 50, 200] }
        ]
      });
    }
  }
};
</script>

<style scoped>
.card-title {
  font-size: 14px;
  color: #666;
}
.card-value {
  font-size: 20px;
  font-weight: bold;
  margin-top: 10px;
}
.positive {
  color: green;
}
.negative {
  color: red;
}
</style>
