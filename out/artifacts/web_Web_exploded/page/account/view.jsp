<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>个人信息详细</title>
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
                        账户信息详情
                    </li>

                    <li class="list-group-item">
                        姓名:${account.englishName}
                    </li>
                    <li class="list-group-item">
                        登陆次数:${account.loginCount}
                    </li>
                    <li class="list-group-item">
                        登陆IP:${account.loginIp}
                    </li>
                    <li class="list-group-item">
                        联系QQ:${account.qq}
                    </li>
                    <li class="list-group-item">
                        角色:
                        <c:if test="${account.authorithy == 'user'}">
                            用户角色
                        </c:if>
                        <c:if test="${account.authorithy == 'user'}">
                            管理员角色
                        </c:if>
                    </li>
                    <li class="list-group-item">
                        登陆时间:  <fmt:formatDate value="${account.loginTime}" type="date" dateStyle="long"/>
                    </li>
                    <li class="list-group-item">
                        说明:<textarea id="ccomment" name="describe" class="form-control" >${account.describes}</textarea>
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
        var id = ${account.id};
        var url = "http://localhost:8080/account/delete.do";
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            data:{id:id},
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
                    window.location.href = "http://localhost:8080/account/list.do";
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
                    window.location.href = "http://localhost:8080/account/list.do";
                });
    }
</script>
</body>
</html>
