
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <div>com.wipe.healthy</div>
  <!--Step:1 Prepare a dom for ECharts which (must) has size (width & hight)-->
  <!--Step:1 为ECharts准备一个具备大小（宽高）的Dom-->
  <div id="main" style="height:500px;border:1px solid #ccc;padding:10px;"></div>

  <script src="js/jquery-2.1.1.min.js"></script>
  <script src="test/echarts.min.js"></script>
  <script type="text/javascript">
      var myChart = echarts.init(document.getElementById('main'));
      $.get('/chart/weightVPulmonary.do').done(function(data){
          myChart.setOption({
              title : {
                  text: '体重-肺活量/心率',
                  subtext: '数据来源于健身信息系统'
              },
              tooltip : {
                  trigger: 'axis'
              },
              legend: {
                  data:['心率','肺活量']
              },
              toolbox: {
                  show : true,
                  feature : {
                      mark : {show: true},
                      dataView : {show: true, readOnly: false},
                      magicType : {show: true, type: ['line', 'bar']},
                      restore : {show: true},
                      saveAsImage : {show: true}
                  }
              },
              calculable : true,
              xAxis : [
                  {
                      type : 'category',
                      boundaryGap : false,
                      data : data.data.weightList
                  }
              ],
              yAxis : [
                  {
                      type : 'value',
                      axisLabel : {
                          formatter: '{value} '
                      }
                  }
              ],
              series : [
                  {
                      name:'心率',
                      type:'line',
                      data:data.data.pulmonaryList,
                      markPoint : {
                          data : [
                              {type : 'max', name: '最大值'},
                              {type : 'min', name: '最小值'}
                          ]
                      },
                      markLine : {
                          data : [
                              {type : 'average', name: '平均值'}
                          ]
                      }
                  },
                  {
                      name:'肺活量',
                      type:'line',
                      data:data.data.heartRateList,
                      markPoint : {
                          data : [
                              {type : 'max', name: '最大值'},
                              {type : 'min', name: '最小值'}
                          ]
                      },
                      markLine : {
                          data : [
                              {type : 'average', name : '平均值'}
                          ]
                      }
                  }
              ]
          });
      });


  </script>
  </body>
</html>
