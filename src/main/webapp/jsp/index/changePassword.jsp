<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/3 0003
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/common.jsp"%>
<html>
<head>
    <title>Title</title>
    <style>
        span{
            display: inline-block;
            width: 30%;
        }
        input[type='text'],input[type='datetime']{
            margin-top: 10px;
        }
    </style>
    <script>
        $(function () {
            $("#oldPassword").blur(function () {
                var oldPassword = $("#oldPassword").val();
                $.get("${path}/baseUser/oldPassword.action",{password:oldPassword,userId:"${sessionUser.userId}"},function (data) {
                    if(data=='N'){
                        $("#errorOldPassword").html("旧密码错误").css("color","red");
                    }else{
                        $("#errorOldPassword").html("");
                    }
                })
            })
            $("#repeatPassword").blur(function () {
               var password = $("#password").val();
               var repeatPassword = $("#repeatPassword").val();
               if(password!=repeatPassword){
                   $("#errorRepeatPassword").html("两次密码不一致").css("color","red");
               }else{
                   $("#errorRepeatPassword").html("");
               }
            })
            $("#submit").click(function () {
                var password = $("#password").val();
                var flag = true;
                $("input[type='text']").each(function () {
                    if(!$(this).val()){
                        flag=false;
                    }
                })
                $(".error").each(function () {
                    if($(this).html()){
                        flag=false;
                    }
                })
                if(flag){
                    alert("通过");
                    $.get("${path}/baseUser/updatePassword.action",{password:password,userId:"${sessionUser.userId}"},function () {
                        alert("更改成功");
                        window.close();
                        window.opener.parent.location.href="${path}/baseUser/logout.action";
                    })
                }else{
                    alert("您没有通过验证，请检查输入")
                }
            })
        })

    </script>
</head>

<body class="main">
    <h1>修改密码</h1>
        <div class="update">
            <div class="left">
                <span>请输入旧密码</span>
                <input type="text" id="oldPassword"><span class="error" id="errorOldPassword"></span>
            </div>
            <div class="right">
            </div>
            <div class="left">
                <span>新密码</span>
                <input type="text" name="password" id="password">
            </div>
            <div class="right">
            </div>
            <div class="left">
                <span>确认密码</span>
                <input type="text" id="repeatPassword"><span class="error" id="errorRepeatPassword"></span>
            </div>
            <div class="buttons">
                <input type="submit" value="提交" id="submit">
                <input type="button" onclick="history.back()" value="返回">
            </div>
        </div>
</body>

</html>
