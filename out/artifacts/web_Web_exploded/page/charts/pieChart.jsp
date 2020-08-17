
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

<script src="../../js/jquery-2.1.1.min.js"></script>
<script src="../../test/echarts.min.js"></script>
<script type="text/javascript">
    var myChart = echarts.init(document.getElementById('main'));
    $.get('/chart/SportType.do').done(function(data){
        data = data.data;
        console.log(data);
        myChart.setOption({
            title : {
                text: '运动类型饼状图',
                subtext: '数据来源于健身信息网',
                x:'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: ['有氧运动','无氧运动','耐力运动']
            },
            series : [
                {
                    name: '访问来源',
                    type: 'pie',
                    radius : '55%',
                    center: ['60%', '60%'],
                    data:[
                        data[0],
                        data[1],
                        data[2]
                    ],
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        });
    });


</script>
</body>
</html>
