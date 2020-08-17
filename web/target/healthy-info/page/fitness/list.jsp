<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" />
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>健身信息列表</title>
    <link href="../../css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="../../css/font-awesome.min.css?v=4.3.0" rel="stylesheet">
    <link href="../../css/animate.min.css" rel="stylesheet">
    <link href="../../css/style.min.css?v=3.2.0" rel="stylesheet">
    <link href="../../css/plugins/footable/footable.core.css" rel="stylesheet">
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">

        <button type="button"  id="btn_add" class="btn col-sm-1 btn-outline btn-success">新增</button>



    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>健身信息列表</h5>

                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a class="dropdown-toggle" data-toggle="dropdown" href="table_foo_table.html#">
                            <i class="fa fa-wrench"></i>
                        </a>
                        <a class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">
                    <input type="text" class="form-control input-sm m-b-xs" id="filter"
                           placeholder="搜索表格...">

                    <table class="footable table table-stripped" data-page-size="8" data-filter=#filter>
                        <thead>
                        <tr>
                            <th>行为名称</th>
                            <th>类型</th>
                            <th>试用人群</th>
                            <th>卡路里</th>
                            <th>天气</th>
                            <th>温度</th>
                            <th>日期</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${list}" var="fitness">
                            <tr class="gradeX">
                                <td>${fitness.actionName}</td>
                                <td>
                                    <c:if test="${fitness.style == 0}">
                                        有氧行为
                                    </c:if>
                                    <c:if test="${fitness.style == 1}">
                                        无养运动
                                    </c:if>
                                    <c:if test="${fitness.style == 2}">
                                        耐力运动
                                    </c:if>
                                </td>
                                <td class="center">${fitness.fitPeople}</td>
                                <td class="center">${fitness.calorie}</td>
                                <td >${fitness.weather}</td>
                                <td >${fitness.temperature}</td>
                                <td >${fitness.data}</td>
                                <td>
                                    <a href="/fitness/view.do?id=${fitness.fitnessId}" class="btn btn-white btn-sm"><i class="fa fa-folder"></i> 查看 </a>
                                    <a href="/fitness/modifyShow.do?id=${fitness.fitnessId}" class="btn btn-white btn-sm"><i class="fa fa-pencil"></i> 编辑 </a>
                                </td>
                            </tr>
                        </c:forEach>


                        </tbody>
                        <tfoot>
                        <tr>
                            <td colspan="10">
                                <ul class="pagination pull-right"></ul>
                            </td>
                        </tr>
                        </tfoot>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 全局js -->
<script src="../../js/jquery-2.1.1.min.js"></script>
<script src="../../js/bootstrap.min.js?v=3.4.0"></script>


<!-- 自定义js -->
<script src="../../js/content.min.js?v=1.0.0"></script>

<!-- jQuery Validation plugin javascript-->
<script src="../../js/plugins/validate/jquery.validate.min.js"></script>

<!-- 树状js-->
<script src="../../js/plugins/treeview/bootstrap-treeview.js"></script>
<script src="../../js/plugins/laydate/laydate.js"></script>
<script src="../../js/plugins/footable/footable.all.min.js"></script>
<script  type="text/javascript">
    $(document).ready(function() {
        <!-- 加载表单-->
        $('.footable').footable();
        <!-- 新增按钮点击-->
        $("#btn_add").click(function(){
            document.location.href="/page/fitness/add.jsp";
        });
    });

</script>
</body>
</html>
