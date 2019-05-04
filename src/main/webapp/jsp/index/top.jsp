
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/29 0029
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/common.jsp"%>

<html>
<head>
    <script type="text/javascript">
        $(function () {
            $("#logout").click(function () {
                window.parent.location.href = "${path}/baseUser/logout.action";
            })
            $("#changePassWord").click(function () {
                window.open('${path}/jsp/index/changePassword.jsp', '修改密码', 'height=400, width=800, top=200, left=300');
            })
            $.get("${path}/baseModule/toplist.action",function (data) {
                var $nav = $(".nav");
                $(data).each(function () {
                    var $a = $('<a ' +
                        'href="${path}/baseFunction/findByMid.action?mid='+this.mid+'"  target="leftFrame"><SPAN class=STYLE2>'+this.mname+'</SPAN></a>');
                    $a.appendTo($nav);
                })

            },"json")
        })
    </script>
    <style>
        span{
            margin-left: 10px;
            font-size: 16px;
        }
    </style>
</head>

<body>
<div class="page">
        <div class="nav">
                <%--<a href="#"  target="_self"><SPAN class=STYLE2>收费管理</SPAN></a>--%>
        </div>
</div>
<%--<script  type="text/javascript">--%>
    <%--$(function(){--%>
        <%--document.getElementById("time").innerHTML = new Date().toLocaleString();--%>
        <%--window.setInterval("getTime();",1000); //每隔1s取一次函数值--%>
    <%--})--%>
    <%--window.onload = getTime();--%>
<%--</script>--%>
<div class="userInfo">
    <span>${sessionUser.cname}</span>
    <span id="time"></span>
    <span><a href="" id="logout">退出</a></span>
    <span><a href="" id="changePassWord">修改密码</a></span>
</div>
<script>
    document.getElementById('time').innerHTML = new Date().toLocaleString()
        + ' 星期' + '日一二三四五六'.charAt(new Date().getDay());
    setInterval(
        "document.getElementById('time').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",
        1000);
</script>
</body>
</html>
