<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>登陆账号录入</title>
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
                <form class="form-horizontal m-t" id="commentForm" action="/user/create.do">

                    <div class="form-group">
                        <label class="col-sm-2 control-label">账户：</label>
                        <div class="col-sm-4 single">
                            <input id="englishName" name="englishName" type="text" class="form-control">
                        </div>
                        <label class="col-sm-2 control-label">密码：</label>
                        <div class="col-sm-4 single">
                            <input id="password" name="password" type="password" class="form-control">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">角色：</label>
                        <div class="col-sm-4">
                            <select class="form-control m-b" name="authorithy">
                                <option value="admin">管理员</option>
                                <option value="user">普通用户</option>
                            </select>
                        </div>

                        <label class="col-sm-2 control-label">联系QQ：</label>
                        <div class="col-sm-4 single">
                            <input id="qq" name="qq" type="text" class="form-control">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">说明：</label>

                        <div class="col-sm-10">
                            <textarea id="describes" name="describes" class="form-control"></textarea>
                        </div>
                    </div>


                    <div class="form-group">
                        <div class="col-sm-4 col-sm-offset-3">
                            <button class="btn btn-default" type="reset" onclick="window.history.go(-1)">
                                <i class="fa fa-check"></i>
                                取消
                            </button>
                        </div>
                        <div class="col-sm-4 ">
                            <button class="btn btn-primary" type="submit">
                                <i class="fa fa-check"></i>
                                提交
                            </button>
                        </div>
                    </div>
                </form>
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
    $(function () {
        $.ajax({
            url: "/city/list.do",
            type: "get",
            dataType: "json",
            timeout: 120e3,
            success: function (data) {
                loadTree(data);
            },
            error: function (data) {
                alert("加载失败");
            }

        });
        MyValidator.init();
    });

    function loadTree(e) {
        $("#treeview").treeview({
            levels: 1,
            color: "#428bca",
            data: e,
            onNodeSelected: function (e, o) {
                $("#nativePlace").val(o.text);
                $("#modal").modal('hide');
            }
        });
    }
    ;

    function showCity() {
        $('#modal').modal('show');
    }


    <!-- 表单验证-->
    var MyValidator = function () {
        var handleSubmit = function () {
            $('.form-horizontal').validate({
                errorElement: 'span',
                errorClass: 'help-block',
                focusInvalid: false,
                rules: {
                    "englishName": {
                        required: true
                    },
                    "password": {
                        required: true
                    },
                    "authorithy": {
                        required: true
                    },
                    "qq": {
                        required: true,
                        number: true
                    }
                },
                messages: {
                    "englishName": {
                        required: "账户不能为空."
                    },
                    "password": {
                        required: "密码不能为空."
                    },
                    "authorithy": {
                        required: "角色不能为空."
                    },
                    "qq": {
                        required: "QQ不能为空.",
                        number: "请输入合法QQ号"
                    }
                },
                highlight: function (element) {
                    $(element).closest('.single').addClass('has-error');
                },
                success: function (label) {
                    label.closest('.single').removeClass('has-error');
                    label.remove();
                },
                errorPlacement: function (error, label) {
                    label.closest('.single').append(error).attr("style", "float:left");
                },
                submitHandler: function (form) {
                    //form.submit();
                    ajaxSubmit();
                }
            });
            $('.form-horizontal input').keypress(function (e) {
                if (e.which == 13) {
                    return false
                }
            });
        }
        return {
            init: function () {
                handleSubmit();
            }
        };
    }();

    //时间控件
    ;
    !function () {
        laydate.skin('danlan');
        laydate({
            elem: '#demo',
            format: 'hh:mm:ss'
        })
    }();

    <!-- 异步请求表单提交-->
    function ajaxSubmit() {
        var url = "/account/create.do";
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            data: $('#commentForm').serialize(),
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
