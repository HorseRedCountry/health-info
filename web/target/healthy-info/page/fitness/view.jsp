<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>健身信息详细</title>
    <link href="../../css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="../../css/font-awesome.min.css?v=4.3.0" rel="stylesheet">
    <link href="../../css/animate.min.css" rel="stylesheet">
    <link href="../../css/style.min.css?v=3.2.0" rel="stylesheet">
    <link href="../../css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox-content">


                <ul class="list-group">
                    <li class="list-group-item active">
                        健身信息详情
                    </li>

                    <li class="list-group-item">
                        用户名:${fitness.userName}
                    </li>
                    <li class="list-group-item">
                        行为名称:${fitness.actionName}
                    </li>
                    <li class="list-group-item">
                        适用人群:${fitness.fitPeople}
                    </li>
                    <li class="list-group-item">
                        消耗卡路里:${fitness.calorie}
                    </li>
                    <li class="list-group-item">
                        行为类型:
                        <c:if test="${fitness.style == 0}">
                            有氧行为
                        </c:if>
                        <c:if test="${fitness.style == 1}">
                            无养运动
                        </c:if>
                        <c:if test="${fitness.style == 2}">
                            耐力运动
                        </c:if>
                    </li>
                    <li class="list-group-item">
                        当天天气:${fitness.weather}
                    </li>
                    <li class="list-group-item">
                        当天气温:${fitness.temperature}
                    </li>
                    <li class="list-group-item">
                        发生日期:${fitness.data}
                    </li>
                    <li class="list-group-item">
                        开始时间:${fitness.beginTime}
                    </li>
                    <li class="list-group-item">
                        结束时间:${fitness.endTime}
                    </li>

                </ul>




            </div>
            <div class="form-group">
                <div class="col-sm-4 col-sm-offset-4">
                    <button class="btn btn-default" onclick="window.history.go(-1)">
                        <i class="fa fa-check"></i>
                        取消
                    </button>
                </div>
                <div class="col-sm-4 ">
                    <button class="btn btn-success active" type="submit" onclick="ajaxDelete();">
                        <i class="fa fa-check"></i>
                        删除
                    </button>
                </div>
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
<!-- Sweet alert -->
<script src="../../js/plugins/sweetalert/sweetalert.min.js"></script>
<script type="text/javascript">

    <!-- 异步请求表单提交-->
    function ajaxDelete() {
        var id = ${fitness.actionId};
        var url = "http://localhost:8080/fitness/delete.do";
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            data:{actionId:id},
            async: false,
            success: function (data) {
                if (data.success) {
                    swalSuccess(data);
                } else {
                    swalError(data);
                }
            },
            error: function () {
                swal("请求异常!");
            }
        });
    }

    <!-- 成功 异常弹出框-->
    function swalSuccess(data) {
        swal({
                    title: "成功",
                    text: data.description,
                    type: "success",
                    howCancelButton: false,
                    closeOnConfirm: false,
                    showLoaderOnConfirm: true
                },
                function () {
                    window.location.href = "http://localhost:8080/fitness/list.do";
                });
    }
    function swalError(data) {
        swal({
                    title: "异常",
                    text: data.description,
                    type: "error",
                    showCancelButton: false,
                    closeOnConfirm: false,
                    showLoaderOnConfirm: true
                },
                function () {
                    window.location.href = "http://localhost:8080/fitness/list.do";
                });
    }
</script>
</body>
</html>
