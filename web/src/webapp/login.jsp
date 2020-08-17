<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+
                request.getServerName()+":"+
                request.getServerPort()+path+"/";
    %>
    <base href="<%=basePath%>"/>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>健身信息系统 - 登录</title>
    <link href="/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
    <link href="css/font-awesome.min.css?v=4.3.0" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min.css?v=3.2.0" rel="stylesheet">
    <link href="css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <link href="css/login.css" rel="stylesheet">
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>
</head>
<br/><br/><br/>
<!-- 轮播广告 -->
<div id="banner_tabs" class="flexslider">
    <ul class="slides">
        <li>
            <a title=""  href="#">
                <img width="1394" height="482" alt="" style="background: url(img/login.jpg) no-repeat center;" >
            </a>
        </li>
        <li>
            <a title="" href="#">
                <img width="1394" height="482" alt="" style="background: url(img/login2.jpg) no-repeat center;" >
            </a>
        </li>
    </ul>
    <ul class="flex-direction-nav">
        <li><a class="flex-prev" href="javascript:;">Previous</a></li>
        <li><a class="flex-next" href="javascript:;">Next</a></li>
    </ul>
    <ol id="bannerCtrl" class="flex-control-nav flex-control-paging">
        <li><a>1</a></li>
        <li><a>2</a></li>

    </ol>
    <div style="float: right; margin: 0px 20px;">
        <div class="middle-box text-center loginscreen login-pos animated lightSpeedIn">
            <div>
                <form class="m-t" role="form" id="form">
                    <div class="form-group">
                        <input type="text" name="englishName" class="form-control" placeholder="用户名" required="required">
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" class="form-control" placeholder="密码">
                    </div>
                    <div class="form-group">
                        <input type="text" name="verification" class="form-control" placeholder="验证码">
                    </div>
                    <div class="form-group" >
                        <img src="/verification/crimg.do" onclick="changeImg()" id="validateCodeImg"
                             style="height: 34px;width: 200px;margin-right:48px" >
                        <a href="javascript:void(0)" onclick="changeImg()">换一张</a>
                    </div>
                    <button type="button" class="btn btn-primary block full-width m-b" onclick="ajaxSubmit()">登 录</button>
                </form>
            </div>

        </div>
    </div>
</div>

<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/slider.js"></script>
<script src="js/bootstrap.min.js?v=3.4.0"></script>
<!-- Sweet alert -->
<script src="js/plugins/sweetalert/sweetalert.min.js"></script>
<script type="text/javascript">
    $(function() {
        var bannerSlider = new Slider($('#banner_tabs'), {
            time: 5000,
            delay: 400,
            event: 'hover',
            auto: true,
            mode: 'fade',
            controller: $('#bannerCtrl'),
            activeControllerCls: 'active'
        });
        $('#banner_tabs .flex-prev').click(function() {
            bannerSlider.prev()
        });
        $('#banner_tabs .flex-next').click(function() {
            bannerSlider.next()
        });
    })

    function changeImg(){
        var a=document.getElementById("validateCodeImg").src="/verification/crimg.do?a="+Math.random();
    }

    <!-- 异步请求表单提交-->
    function ajaxSubmit() {
        var url = "/login/login.do";
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            data: $('#form').serialize(),
            async: false,
            success: function (data) {
                if (data.success) {
                    window.location.href = "index2.jsp";
                } else {
                    swalError(data);
                    changeImg();
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
                    window.location.href = "/login/authorithy.do";
                });
    }
    function swalError(data) {
        swal({
            title: "登陆错误",
            text: data.description,
            type: "info",
            showCancelButton: false,
            closeOnConfirm: false,
            showLoaderOnConfirm: true
        });
    }
</script>

<div style="text-align:center;margin:50px 0; font:normal 18px/36px 'MicroSoft YaHei';">
    <p>地址：武汉市洪山区珞喻路461号</p>
    <p>体育工程与信息技术学院 旗下产品  健身信息管理系统</p>
</div>
</body>
</html>
