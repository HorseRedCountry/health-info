
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>个人信息管理</title>
    <link href="../../css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="../../css/font-awesome.min.css?v=4.3.0" rel="stylesheet">
    <link href="../../css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="../../css/plugins/steps/jquery.steps.css" rel="stylesheet">
    <link href="../../css/animate.min.css" rel="stylesheet">
    <link href="../../css/style.min.css?v=3.2.0" rel="stylesheet">
    <link href="../../css/DateTimePicker.css" rel="stylesheet">
    <link href="../../css/date.css" rel="stylesheet">
    <link href="../../css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox">
                <div class="ibox-content">
                    <h2>
                        健身信息向导
                    </h2>

                    <form id="form" action="/fitness/create.do" class="wizard-big">
                        <input name="fitnessId" value="${fitness.fitnessId}" style="display:none;">
                        <input name="actionId" value="${fitness.actionId}" style="display:none;">
                        <input name="userId" value="${fitness.userId}" style="display:none;">

                        <h1>健身行为</h1>
                        <fieldset>
                            <h2>健身行为录入</h2>
                            <div class="row">
                                <div class="col-sm-8">
                                    <div class="form-group">
                                        <label>行为名称 *</label>
                                        <input id="actionName" name="actionName" type="text" class="form-control required" value="${fitness.actionName}">
                                    </div>
                                    <div class="form-group">
                                        <label>行为类型 *</label>
                                        <select class="form-control required" name="style">
                                            <option value="0"
                                                   <c:if test="${fitness.style == 0}">selected="true"</c:if>
                                                    >有氧行为</option>
                                            <option value="1"
                                                    <c:if test="${fitness.style == 1}">selected="true"</c:if>
                                                    >无养行为</option>
                                            <option value="2"
                                                    <c:if test="${fitness.style == 2}">selected="true"</c:if>
                                                    >耐力行为</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>行为适用人群 *</label>
                                        <input id="fitPeople" name="fitPeople" type="text" class="form-control required" value="${fitness.fitPeople}">
                                    </div>
                                    <div class="form-group">
                                        <label>消耗卡路里 *</label>
                                        <input id="calorie" name="calorie" type="text" class="form-control required" value="${fitness.calorie}">
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="text-center">
                                        <div style="margin-top: 20px">
                                            <i class="fa fa-sign-in" style="font-size: 180px;color: #e5e5e5 "></i>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </fieldset>
                        <h1>健身行为详情</h1>
                        <fieldset>
                            <h2>行为详情录入</h2>
                            <div class="row ">
                                <div class="col-sm-8">
                                    <div    class="form-group">
                                        <label>行为日期 *</label>
                                        <input type="text"  id="date-input"  class="form-control" name="data" value="${fitness.data}">
                                    </div>

                                    <div id="timePicker " class="form-group">
                                        <label>开始时间 *</label>
                                        <input type="text" data-field="time" class="form-control required" name="beginTime" value="${fitness.beginTime}">
                                    </div>
                                    <div id="dtBox"></div>

                                    <div id="timePickers " class="form-group">
                                        <label>开始时间 *</label>
                                        <input type="text" data-field="time" class="form-control required" name="endTime" value="${fitness.endTime
                                        }">
                                    </div>
                                    <div id="dtBoxs"></div>

                                    <div class="form-group">
                                        <label>天气 *</label>
                                        <input id="weather" name="weather" type="text" class="form-control required" value="${fitness.weather}">
                                    </div>
                                    <div class="form-group">
                                        <label>气温 *</label>
                                        <input id="temperature" name="temperature" type="text" class="form-control required" value="${fitness.temperature}">
                                    </div>

                                </div>
                                <div class="col-sm-4">
                                    <div class="text-center">
                                        <div style="margin-top: 20px">
                                            <i class="fa fa-sign-in" style="font-size: 180px;color: #e5e5e5 "></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </fieldset>

                        <h1>友情提示</h1>
                        <fieldset>
                            <div class="text-center" style="margin-top: 120px">
                                <h2>您录入的信息本系统将有权分析以及分享，感谢！ :-)</h2>
                            </div>
                        </fieldset>

                        <h1>完成</h1>
                        <fieldset>
                            <h2>您的信息录入完成，感谢您对本系统的支持</h2>
                        </fieldset>
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
<!-- Steps -->
<script src="../../js/plugins/staps/jquery.steps.min.js"></script>
<!-- Jquery Validate -->
<script src="../../js/plugins/validate/jquery.validate.min.js"></script>
<script src="../../js/plugins/validate/messages_zh.min.js"></script>
<script src="../../js/date.js"></script>
<script src="../../js/DateTimePicker.js"></script>
<!-- Sweet alert -->
<script src="../../js/plugins/sweetalert/sweetalert.min.js"></script>
<script>
    $(document).ready(function(){
        $("#wizard").steps();
        $("#form").steps({
            bodyTag:"fieldset",
            onStepChanging:function(d,a,b){
                if(a>b){
                    return true
                }
                if(b===3&&Number($("#age").val())<18){
                    return false
                }
                var c=$(this);
                if(a<b){
                    $(".body:eq("+b+") label.error",c).remove();
                    $(".body:eq("+b+") .error",c).removeClass("error")
                }
                c.validate().settings.ignore=":disabled,:hidden";
                return c.valid()},onStepChanged:function(b,a,c){
                if(a===2&&Number($("#age").val())>=18){
                    $(this).steps("next")}
                if(a===2&&c===3){
                    $(this).steps("previous")
                }},
            onFinishing:function(c,a){
                var b=$(this);
                b.validate().settings.ignore=":disabled";
                return b.valid()},
            onFinished:function(c,a){
                var b=$(this);
                // b.submit();
                ajaxSubmit();
            }}).validate({
            errorPlacement:function(a,b){
                b.before(a)},
            rules:{
                confirm:{
                    equalTo:"#password"
                }
            }
        });

        $("#dtBox").DateTimePicker(
                {
                    addEventHandlers : function() {
                        var dtPickerObj = this;
                        $(
                                "#datePicker .pickerButton")
                                .click(
                                function(
                                        e) {
                                    e
                                            .stopPropagation();
                                    dtPickerObj
                                            .showDateTimePicker($("#datePicker input"));
                                });

                        $(
                                "#timePicker .pickerButton")
                                .click(
                                function(
                                        e) {
                                    e
                                            .stopPropagation();
                                    dtPickerObj
                                            .showDateTimePicker($("#timePicker input"));
                                });

                        $(
                                "#dateTimePicker .pickerButton")
                                .click(
                                function(
                                        e) {
                                    e
                                            .stopPropagation();
                                    dtPickerObj
                                            .showDateTimePicker($("#dateTimePicker input"));
                                });
                    }

                });
    });

    <!-- 异步请求表单提交-->
    function ajaxSubmit() {
        var url = "/fitness/modify.do";
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            data: $('#form').serialize(),
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