<template>
  <div class="app-container">
    <el-row :gutter="20">
      <!-- 头部搜索区域 -->
      <el-col :span="24">
        <el-card shadow="hover" class="search-card">
          <el-form :inline="true" :model="queryParams" class="demo-form-inline">
            <el-form-item label="年份">
              <el-date-picker
                v-model="queryParams.year"
                type="year"
                format="yyyy"
                value-format="yyyy"
                placeholder="选择年份">
              </el-date-picker>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="handleQuery">查询</el-button>
            </el-form-item>
          </el-form>
        </el-card>
      </el-col>

      <!-- 顶部统计卡片 -->
      <el-col :span="24">
        <el-row :gutter="20">
          <el-col :xs="24" :sm="12" :md="8">
            <el-card shadow="hover" class="stat-card">
              <div class="stat-item">
                <div class="stat-label">医保患者总费用(万元)</div>
                <div class="stat-value">{{ stats.F_Amount }}</div>
              </div>
              <div class="stat-item">
                <div class="stat-label">医保患者医保费用(万元)</div>
                <div class="stat-value">{{ stats.F_SB_Amount }}</div>
              </div>
              <el-divider></el-divider>
              <el-row :gutter="20">
                <el-col :span="12">
                  <div class="stat-sub-item">
                    <div>次均医保费用(元)</div>
                    <div class="sub-value">{{ stats.cj_Amount }}</div>
                  </div>
                </el-col>
                <el-col :span="12">
                  <div class="stat-sub-item">
                    <div>人均医保费用(元)</div>
                    <div class="sub-value">{{ stats.rj_Amount }}</div>
                  </div>
                </el-col>
                <el-col :span="12">
                  <div class="stat-sub-item">
                    <div>人均住院日(日)</div>
                    <div class="sub-value">{{ stats.rj_Days }}</div>
                  </div>
                </el-col>
                <el-col :span="12">
                  <div class="stat-sub-item">
                    <div>自费率</div>
                    <div class="sub-value">{{ stats.self_ratio }}</div>
                  </div>
                </el-col>
              </el-row>
            </el-card>
          </el-col>

          <el-col :xs="24" :sm="12" :md="8">
            <el-card shadow="hover" class="stat-card">
              <div class="stat-title">结余</div>
              <div class="stat-item">
                <div>总医保结余(万元)</div>
                <div class="stat-value">{{ stats.F_Balance }}</div>
              </div>
              <div class="stat-item">
                <div>人均医保结余(元)</div>
                <div class="stat-value">{{ stats.rj_Balance }}</div>
              </div>
              <el-divider></el-divider>
              <div class="stat-title">分值</div>
              <div class="stat-item">
                <div>总分值(万分)</div>
                <div class="stat-value">{{ stats.F_Score }}</div>
              </div>
              <div class="stat-item">
                <div>人均分值(分)</div>
                <div class="stat-value">{{ stats.rj_Score }}</div>
              </div>
            </el-card>
          </el-col>

          <el-col :xs="24" :sm="24" :md="8">
            <el-card shadow="hover" class="stat-card">
              <div class="stat-header">
                <span>医保年度</span>
                <el-tooltip effect="dark" placement="top">
                  <template #content>
                    <div>时间跨度: {{ sbConfig.effectDateRange }}</div>
                    <div>分值参考: 居民:{{ sbConfig.jmParQ0 }} 职工:{{ sbConfig.zgParQ0 }}</div>
                    <div>(分值参考：上年结算分值)</div>
                    <div>分值预估: 居民:{{ sbConfig.jmParQ1 }} 职工:{{ sbConfig.zgParQ1 }}</div>
                    <div>(分值预估：根据上年度结算分值，估算本年的预计结算分值)</div>
                  </template>
                  <i class="el-icon-info"></i>
                </el-tooltip>
              </div>
              <el-table
                :data="sbConfig.rConf"
                height="250"
                style="width: 100%"
                @row-click="handleSbConfigClick">
                <el-table-column prop="F_R_Title" label="R值" width="80"></el-table-column>
                <el-table-column prop="kewei" label="报销说明"></el-table-column>
                <el-table-column prop="count" label="出院总人次" width="100"></el-table-column>
                <el-table-column prop="ratio" label="占比" width="80">
                  <template #default="{row}">{{ row.ratio }}%</template>
                </el-table-column>
              </el-table>
            </el-card>
          </el-col>
        </el-row>
      </el-col>

      <!-- 图表区域 -->
      <el-col :span="24">
        <el-row :gutter="20">
          <el-col :span="12">
            <el-card shadow="hover">
              <div slot="header" class="chart-header">
                <span>医保结算人次(人) {{ stats.cure_num }}</span>
                <el-button type="text" @click="openYbjs">
                  <i class="el-icon-data-line"></i>
                </el-button>
              </div>
              <div id="ybcyrc-chart" style="height: 300px;"></div>
            </el-card>
          </el-col>
          <el-col :span="12">
            <el-card shadow="hover">
              <div slot="header" class="chart-header">
                <span>盈利亏损统计</span>
                <div>
                  <el-radio-group v-model="profitLossType" size="small">
                    <el-radio-button label="1">病种</el-radio-button>
                    <el-radio-button label="2">科室</el-radio-button>
                  </el-radio-group>
                  <el-button type="text" @click="openYlks">
                    <i class="el-icon-data-line"></i>
                  </el-button>
                </div>
              </div>
              <div id="ylksbz-chart" style="height: 300px;"></div>
            </el-card>
          </el-col>
        </el-row>
      </el-col>

      <!-- TOP病种区域 -->
      <el-col :span="24">
        <el-row :gutter="20">
          <el-col :span="12">
            <el-card shadow="hover">
              <div slot="header" class="chart-header">
                <span class="profit-text">盈利-Top 20 医保病种</span>
                <div>
                  <el-radio-group v-model="profitCaseCount" size="small" @change="updateProfitDiseases">
                    <el-radio-button :label="10">10例</el-radio-button>
                    <el-radio-button :label="30">30例</el-radio-button>
                    <el-radio-button :label="50">50例</el-radio-button>
                  </el-radio-group>
                  <el-radio-group v-model="profitSortField" size="small" @change="updateProfitDiseases" style="margin-left: 10px">
                    <el-radio-button label="avg_F_Balance">次均结余</el-radio-button>
                    <el-radio-button label="F_Balance">总结余</el-radio-button>
                  </el-radio-group>
                  <el-button type="text" @click="exportProfitDiseases">
                    <i class="el-icon-download"></i>
                  </el-button>
                </div>
              </div>
              <el-table
                :data="profitDiseases"
                height="300"
                highlight-current-row
                @row-dblclick="handleDiseaseClick">
                <el-table-column label="医保病种" min-width="180">
                  <template #default="{row}">
                    {{ row.F_Diagnosis_Icd_Cal }}({{ row.F_Diagnosis_Cal }})：{{ row.F_Treatment_Type }}({{ row.F_Treatment_Name }})
                  </template>
                </el-table-column>
                <el-table-column prop="F_Standard_Score" label="标准分" width="80" align="center"></el-table-column>
                <el-table-column prop="total_rc" label="总人次" width="70" align="center"></el-table-column>
                <el-table-column prop="F_Score" label="总分值" width="80" align="center"></el-table-column>
                <el-table-column prop="F_Balance" label="总结余" width="90" align="right">
                  <template #default="{row}">
                    <span :style="{color: row.F_Balance > 0 ? '#259b24' : '#e51c23'}">{{ row.F_Balance }}</span>
                  </template>
                </el-table-column>
                <el-table-column prop="avg_F_Amount" label="次均费用" width="90" align="right"></el-table-column>
                <el-table-column prop="avg_F_Balance" label="次均结余" width="90" align="right">
                  <template #default="{row}">
                    <span :style="{color: row.avg_F_Balance > 0 ? '#259b24' : '#e51c23'}">{{ row.avg_F_Balance }}</span>
                  </template>
                </el-table-column>
              </el-table>
            </el-card>
          </el-col>
          <el-col :span="12">
            <el-card shadow="hover">
              <div slot="header" class="chart-header">
                <span class="loss-text">亏损-Top 20 医保病种</span>
                <div>
                  <el-radio-group v-model="lossCaseCount" size="small" @change="updateLossDiseases">
                    <el-radio-button :label="10">10例</el-radio-button>
                    <el-radio-button :label="30">30例</el-radio-button>
                    <el-radio-button :label="50">50例</el-radio-button>
                  </el-radio-group>
                  <el-radio-group v-model="lossSortField" size="small" @change="updateLossDiseases" style="margin-left: 10px">
                    <el-radio-button label="avg_F_Balance">次均结余</el-radio-button>
                    <el-radio-button label="F_Balance">总结余</el-radio-button>
                  </el-radio-group>
                  <el-button type="text" @click="exportLossDiseases">
                    <i class="el-icon-download"></i>
                  </el-button>
                </div>
              </div>
              <el-table
                :data="lossDiseases"
                height="300"
                highlight-current-row
                @row-dblclick="handleDiseaseClick">
                <el-table-column label="医保病种" min-width="180">
                  <template #default="{row}">
                    {{ row.F_Diagnosis_Icd_Cal }}({{ row.F_Diagnosis_Cal }})：{{ row.F_Treatment_Type }}({{ row.F_Treatment_Name }})
                  </template>
                </el-table-column>
                <el-table-column prop="F_Standard_Score" label="标准分" width="80" align="center"></el-table-column>
                <el-table-column prop="total_rc" label="总人次" width="70" align="center"></el-table-column>
                <el-table-column prop="F_Score" label="总分值" width="80" align="center"></el-table-column>
                <el-table-column prop="F_Balance" label="总结余" width="90" align="right">
                  <template #default="{row}">
                    <span :style="{color: row.F_Balance > 0 ? '#259b24' : '#e51c23'}">{{ row.F_Balance }}</span>
                  </template>
                </el-table-column>
                <el-table-column prop="avg_F_Amount" label="次均费用" width="90" align="right"></el-table-column>
                <el-table-column prop="avg_F_Balance" label="次均结余" width="90" align="right">
                  <template #default="{row}">
                    <span :style="{color: row.avg_F_Balance > 0 ? '#259b24' : '#e51c23'}">{{ row.avg_F_Balance }}</span>
                  </template>
                </el-table-column>
              </el-table>
            </el-card>
          </el-col>
        </el-row>
      </el-col>

      <!-- 象限图区域 -->
      <el-col :span="24">
        <el-card shadow="hover">
          <div slot="header" class="chart-header">
            <span>病种/科室象限图</span>
            <el-radio-group v-model="quadrantType" size="small">
              <el-radio-button label="1">病种</el-radio-button>
              <el-radio-button label="2">科室</el-radio-button>
            </el-radio-group>
          </div>
          <div id="quadrant-chart" style="height: 500px;"></div>
        </el-card>
      </el-col>

      <!-- 智能预警区域 -->
      <el-col :span="24">
        <el-card shadow="hover">
          <div slot="header" class="chart-header">
            <span>智能预警</span>
          </div>
          <el-row :gutter="20">
            <el-col :span="6">
              <div id="znyj-chart" style="height: 300px;"></div>
            </el-col>
            <el-col :span="18">
              <el-tabs v-model="activeWarningTab">
                <el-tab-pane v-for="item in warningTypes" :key="item" :label="item" :name="item">
                  <el-row :gutter="20">
                    <el-col v-for="(warning, index) in warnings[item]" :key="index" :span="8">
                      <el-card shadow="hover" class="warning-card" @click.native="openWarning(warning)">
                        <div class="warning-content">{{ warning.note }}</div>
                        <div class="warning-footer">
                          <el-tag :type="getWarningLevelClass(warning.rule_level)" size="small">
                            {{ getWarningLevelName(warning.rule_level) }}
                          </el-tag>
                          <span class="warning-count">{{ warning.num }}条疑问数据</span>
                        </div>
                      </el-card>
                    </el-col>
                    <el-col :span="8" v-if="warnings[item] && warnings[item].length > 6">
                      <el-card shadow="hover" class="warning-more-card" @click.native="moreWarnings">
                        <div class="warning-more-content">更多<br>预警</div>
                      </el-card>
                    </el-col>
                  </el-row>
                </el-tab-pane>
              </el-tabs>
            </el-col>
          </el-row>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import * as echarts from 'echarts'
import { getYbWorkbenchData, getProfitDiseases, getLossDiseases, exportProfitDiseases, exportLossDiseases } from '@/api/yb/workbench'

export default {
  name: 'YbWorkbench',
  data() {
    return {
      // 查询参数
      queryParams: {
        year: new Date().getFullYear().toString()
      },
      
      // 统计数据
      stats: {
        F_Amount: 0,
        F_SB_Amount: 0,
        cj_Amount: 0,
        rj_Amount: 0,
        rj_Days: 0,
        self_ratio: 0,
        F_Balance: 0,
        rj_Balance: 0,
        F_Score: 0,
        rj_Score: 0,
        cure_num: 0
      },
      
      // 图表数据
      chartData: {
        zd_data: [],
        zx_data: []
      },
      
      // 社保配置
      sbConfig: {
        effectDateRange: '',
        jmParQ0: '',
        zgParQ0: '',
        jmParQ1: '',
        zgParQ1: '',
        rConf: []
      },
      
      // 盈利亏损病种统计
      diagData: {
        zd_data: [],
        zx_data: []
      },
      
      // 盈利亏损科室统计
      deptData: {
        zd_data: [],
        zx_data: []
      },
      
      // 盈利病种
      profitDiseases: [],
      profitCaseCount: 10,
      profitSortField: 'avg_F_Balance',
      
      // 亏损病种
      lossDiseases: [],
      lossCaseCount: 10,
      lossSortField: 'avg_F_Balance',
      
      // 盈利亏损统计类型
      profitLossType: '1',
      
      // 象限图类型
      quadrantType: '1',
      
      // 智能预警
      activeWarningTab: '医保目录',
      warningTypes: ['医保目录', '收费监控'],
      warnings: {},
      ruleGrades: [],
      
      // 图表实例
      ybcyrcChart: null,
      ylksbzChart: null,
      znyjChart: null,
      quadrantChart: null
    }
  },
  mounted() {
    this.getData()
    window.addEventListener('resize', this.resizeCharts)
  },
  beforeDestroy() {
    window.removeEventListener('resize', this.resizeCharts)
    if (this.ybcyrcChart) {
      this.ybcyrcChart.dispose()
    }
    if (this.ylksbzChart) {
      this.ylksbzChart.dispose()
    }
    if (this.znyjChart) {
      this.znyjChart.dispose()
    }
    if (this.quadrantChart) {
      this.quadrantChart.dispose()
    }
  },
  methods: {
    // 获取数据
    getData() {
      this.loading = true
      getYbWorkbenchData(this.queryParams).then(response => {
        this.stats = response.data.data
        this.chartData = response.data.chart
        this.diagData = response.data.diag_data
        this.deptData = response.data.dept_data
        this.sbConfig = response.data.sb_config
        this.warnings = response.data.znyj_list.znyj_list
        this.ruleGrades = response.data.RuleGrade
        
        // 初始化图表
        this.$nextTick(() => {
          this.initYbcyrcChart()
          this.initYlksbzChart()
          this.initZnyjChart()
          this.initQuadrantChart()
        })
        
        // 获取盈利和亏损病种
        this.updateProfitDiseases()
        this.updateLossDiseases()
      }).finally(() => {
        this.loading = false
      })
    },
    
    // 初始化医保结算人次图表
    initYbcyrcChart() {
      this.ybcyrcChart = echarts.init(document.getElementById('ybcyrc-chart'))
      
      const option = {
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'cross',
            crossStyle: {
              color: '#999'
            }
          },
          formatter: params => {
            const data = params[0].data
            return `
              <div class="yb-tip">
                <div class="tb-til">${data.date}</div>
                <div class="yb-tip-line">
                  <div class="yb-tip-left">结算人次:</div>
                  <div class="yb-tip-rig">${data.num}</div>
                </div>
                <div class="yb-tip-line">
                  <div class="yb-tip-left">人均住院日:</div>
                  <div class="yb-tip-rig">${data.rj_Days}</div>
                </div>
                <div class="yb-tip-line">
                  <div class="yb-tip-left">次均医保费用:</div>
                  <div class="yb-tip-rig">${data.cj_Amount}</div>
                </div>
                <div class="yb-tip-line">
                  <div class="yb-tip-left">人均医保费用:</div>
                  <div class="yb-tip-rig">${data.rj_Amount}</div>
                </div>
                <div class="yb-tip-line">
                  <div class="yb-tip-left">结算总费用:</div>
                  <div class="yb-tip-rig">${data.F_Amount}</div>
                </div>
                <div class="yb-tip-line">
                  <div class="yb-tip-left">盈亏:</div>
                  <div class="yb-tip-rig">${data.F_Balance}</div>
                </div>
                <div class="yb-tip-line">
                  <div class="yb-tip-left">自费率:</div>
                  <div class="yb-tip-rig">${data.kw}</div>
                </div>
              </div>
            `
          }
        },
        legend: {
          data: ['结算人次', '自费率']
        },
        xAxis: [
          {
            type: 'category',
            data: this.chartData.zd_data.map(item => item.date),
            axisPointer: {
              type: 'shadow'
            }
          }
        ],
        yAxis: [
          {
            type: 'value',
            name: '结算人次',
            min: 0,
            axisLabel: {
              formatter: '{value}'
            }
          },
          {
            type: 'value',
            name: '自费率',
            min: 0,
            axisLabel: {
              formatter: '{value}%'
            }
          }
        ],
        series: [
          {
            name: '结算人次',
            type: 'bar',
            data: this.chartData.zd_data.map(item => item.num)
          },
          {
            name: '自费率',
            type: 'line',
            yAxisIndex: 1,
            data: this.chartData.zx_data.map(item => item.kw)
          }
        ]
      }
      
      this.ybcyrcChart.setOption(option)
    },
    
    // 初始化盈利亏损统计图表
    initYlksbzChart() {
      this.ylksbzChart = echarts.init(document.getElementById('ylksbz-chart'))
      
      const data = this.profitLossType === '1' ? this.diagData : this.deptData
      const seriesData = data.zd_data.reduce((acc, item) => {
        const index = acc.findIndex(i => i.name === item.name)
        if (index === -1) {
          acc.push({
            name: item.name,
            type: 'bar',
            stack: 'total',
            data: data.zd_data.filter(i => i.name === item.name).map(i => i.value)
          })
        }
        return acc
      }, [])
      
      seriesData.push({
        name: '结余',
        type: 'line',
        data: data.zx_data.map(item => item.F_Balance)
      })
      
      const option = {
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'cross',
            label: {
              backgroundColor: '#6a7985'
            }
          }
        },
        legend: {
          data: [...new Set(data.zd_data.map(item => item.name)), '结余']
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        xAxis: {
          type: 'category',
          boundaryGap: true,
          data: [...new Set(data.zd_data.map(item => item.date))]
        },
        yAxis: [
          {
            type: 'value',
            name: '数量'
          },
          {
            type: 'value',
            name: '结余'
          }
        ],
        series: seriesData
      }
      
      this.ylksbzChart.setOption(option)
    },
    
    // 初始化智能预警图表
    initZnyjChart() {
      this.znyjChart = echarts.init(document.getElementById('znyj-chart'))
      
      const data = this.warnings.znyj_chart || []
      
      const option = {
        tooltip: {
          trigger: 'item',
          formatter: '{a} <br/>{b}: {c} ({d}%)'
        },
        legend: {
          orient: 'vertical',
          left: 10,
          data: data.map(item => item.type)
        },
        series: [
          {
            name: '预警类型',
            type: 'pie',
            radius: ['50%', '70%'],
            avoidLabelOverlap: false,
            label: {
              show: false,
              position: 'center'
            },
            emphasis: {
              label: {
                show: true,
                fontSize: '30',
                fontWeight: 'bold'
              }
            },
            labelLine: {
              show: false
            },
            data: data.map(item => ({
              value: item.value,
              name: item.type
            }))
          }
        ]
      }
      
      this.znyjChart.setOption(option)
    },
    
    // 初始化象限图
    initQuadrantChart() {
      this.quadrantChart = echarts.init(document.getElementById('quadrant-chart'))
      
      // 这里需要根据实际数据调整
      const option = {
        xAxis: {
          name: '人均结余(元)',
          nameLocation: 'middle',
          nameGap: 30,
          axisLine: { onZero: false }
        },
        yAxis: {
          name: this.quadrantType === '1' ? '病种例数' : '科室例数',
          nameLocation: 'middle',
          nameGap: 30,
          axisLine: { onZero: false }
        },
        series: [{
          type: 'scatter',
          symbolSize: function(data) {
            return Math.sqrt(data[2]) * 5
          },
          data: [
            [10.0, 8.04, 10],
            [8.0, 6.95, 20],
            // 更多数据...
          ],
          markArea: {
            silent: true,
            itemStyle: {
              color: 'transparent',
              borderWidth: 1,
              borderType: 'dashed'
            },
            data: [[{
              name: '优势区域',
              xAxis: 'max',
              yAxis: 'max',
              itemStyle: {
                color: 'rgba(91, 216, 166, 0.1)'
              }
            }, {
              xAxis: '0',
              yAxis: '0'
            }]]
          }
        }]
      }
      
      this.quadrantChart.setOption(option)
    },
    
    // 更新盈利病种
    updateProfitDiseases() {
      getProfitDiseases({
        year: this.queryParams.year,
        case_count: this.profitCaseCount,
        sort_field: this.profitSortField
      }).then(response => {
        this.profitDiseases = response.data
      })
    },
    
    // 更新亏损病种
    updateLossDiseases() {
      getLossDiseases({
        year: this.queryParams.year,
        case_count: this.lossCaseCount,
        sort_field: this.lossSortField
      }).then(response => {
        this.lossDiseases = response.data
      })
    },
    
    // 导出盈利病种
    exportProfitDiseases() {
      exportProfitDiseases({
        year: this.queryParams.year,
        case_count: this.profitCaseCount,
        sort_field: this.profitSortField
      }).then(response => {
        const url = window.URL.createObjectURL(new Blob([response]))
        const link = document.createElement('a')
        link.href = url
        link.setAttribute('download', `盈利病种-${this.queryParams.year}.xlsx`)
        document.body.appendChild(link)
        link.click()
      })
    },
    
    // 导出亏损病种
    exportLossDiseases() {
      exportLossDiseases({
        year: this.queryParams.year,
        case_count: this.lossCaseCount,
        sort_field: this.lossSortField
      }).then(response => {
        const url = window.URL.createObjectURL(new Blob([response]))
        const link = document.createElement('a')
        link.href = url
        link.setAttribute('download', `亏损病种-${this.queryParams.year}.xlsx`)
        document.body.appendChild(link)
        link.click()
      })
    },
    
    // 处理查询
    handleQuery() {
      this.getData()
    },
    
    // 打开医保结算人次页面
    openYbjs() {
      this.$router.push('/statis/depart_statistics')
    },
    
    // 打开盈利亏损统计页面
    openYlks() {
      if (this.profitLossType === '1') {
        this.$router.push('/statis/disease_statistics')
      } else {
        this.$router.push('/statis/depart_statistics')
      }
    },
    
    // 打开病种详情
    handleDiseaseClick(row) {
      const routeData = this.$router.resolve({
        path: '/dashboard/disDetail',
        query: {
          icd: row.F_Diagnosis_Icd_Cal,
          time: this.queryParams.year,
          type: row.F_Treatment_Type
        }
      })
      window.open(routeData.href, '_blank')
    },
    
    // 打开社保配置详情
    handleSbConfigClick(row) {
      const routeData = this.$router.resolve({
        path: '/dashboard/dipPatient',
        query: {
          s_time: `${this.queryParams.year}-01`,
          e_time: `${this.queryParams.year}-12`,
          s_r: `${row.F_R_L},${row.F_R_R}`
        }
      })
      window.open(routeData.href, '_blank')
    },
    
    // 打开预警详情
    openWarning(warning) {
      const routeData = this.$router.resolve({
        path: '/jkList/patient',
        query: {
          note: warning.note,
          time_val: `${this.queryParams.year}-01,${this.queryParams.year}-12`,
          date_type: 'F_Balance_Date',
          flag: 'dashboard'
        }
      })
      window.open(routeData.href, '_blank')
    },
    
    // 更多预警
    moreWarnings() {
      this.$router.push('/monitorList')
    },
    
    // 获取预警级别名称
    getWarningLevelName(level) {
      const rule = this.ruleGrades.find(item => item.id === level)
      return rule ? rule.name : ''
    },
    
    // 获取预警级别样式类
    getWarningLevelClass(level) {
      const rule = this.ruleGrades.find(item => item.id === level)
      if (!rule) return ''
      
      switch (rule.class_name) {
        case 'yj1': return 'success'
        case 'yj2': return 'warning'
        case 'yj3': return 'danger'
        default: return 'info'
      }
    },
    
    // 调整图表大小
    resizeCharts() {
      if (this.ybcyrcChart) {
        this.ybcyrcChart.resize()
      }
      if (this.ylksbzChart) {
        this.ylksbzChart.resize()
      }
      if (this.znyjChart) {
        this.znyjChart.resize()
      }
      if (this.quadrantChart) {
        this.quadrantChart.resize()
      }
    }
  }
}
</script>

<style lang="scss" scoped>
.app-container {
  padding: 20px;
}

.search-card {
  margin-bottom: 20px;
}

.stat-card {
  margin-bottom: 20px;
  height: 100%;
  
  .stat-title {
    font-weight: bold;
    margin-bottom: 15px;
    color: #333;
  }
  
  .stat-item {
    margin-bottom: 15px;
    
    .stat-label {
      font-size: 14px;
      color: #666;
      margin-bottom: 5px;
    }
    
    .stat-value {
      font-size: 24px;
      font-weight: bold;
      color: #333;
    }
  }
  
  .stat-sub-item {
    margin-bottom: 10px;
    
    .sub-value {
      font-size: 18px;
      font-weight: bold;
      color: #333;
    }
  }
}

.chart-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  
  .profit-text {
    color: #259b24;
  }
  
  .loss-text {
    color: #e51c23;
  }
}

.warning-card {
  margin-bottom: 20px;
  cursor: pointer;
  transition: all 0.3s;
  
  &:hover {
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.2);
  }
  
  .warning-content {
    margin-bottom: 10px;
    height: 60px;
    overflow: hidden;
    text-overflow: ellipsis;
    display: -webkit-box;
    -webkit-line-clamp: 3;
    -webkit-box-orient: vertical;
  }
  
  .warning-footer {
    display: flex;
    justify-content: space-between;
    align-items: center;
    
    .warning-count {
      font-size: 12px;
      color: #999;
    }
  }
}

.warning-more-card {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 120px;
  cursor: pointer;
  transition: all 0.3s;
  
  &:hover {
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.2);
  }
  
  .warning-more-content {
    text-align: center;
    font-size: 16px;
    color: #666;
  }
}
</style>