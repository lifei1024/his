<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/29 0029
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/common.jsp"%>
<%
    String mid = request.getParameter("mid");
%>
<html>
<head>
    <script type="text/javascript">
        $(function () {
            /*$("li").click(function () {
                window.parent.mainFrame.location.href = "/baseUser/list.action";
            })*/
            
            $(".current").click(function () {
                window.parent.mainFrame.location.href="${path}/baseUser/list.action";
            })
            $("#module").click(function () {
                window.parent.mainFrame.location.href="${path}/baseModule/list.action";
            })
            $("#function").click(function () {
                window.parent.mainFrame.location.href="${path}/baseFunction/list.action";
            })
            $("li").click(function () {
                $("li").removeClass("current");
                $(this).addClass("current");
                var url = $(this).attr("name");
                window.parent.mainFrame.location.href = "${path}/"+url+".action";
            })

        })
    </script>
</head>
<body class="left">
<div class="page">
    <div class="margin_div">
        <div class="page_main">
            <ul class="left_nav">
                <c:forEach items="${list}" var="baseFunction">
                    <li name="${baseFunction.url}">${baseFunction.fname}</li>
                </c:forEach>
                <%--<li class="current">用户管理</li>--%>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
