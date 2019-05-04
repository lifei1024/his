<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/26
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/common.jsp"%>
<html>
<head>
    
    <title>Title</title>
    <script>
        $(function () {
            $("#addBtn").click(function () {
                location.href = "${path}/jsp/baseUser/add.jsp";
            })
            $(".del").click(function () {
                var userId = $(this).attr("name");
                location.href="${path}/baseUser/del.action?userId="+userId;
            })
            $(".edit").click(function () {
                var userId = $(this).attr("name");
                location.href="${path}/baseUser/load.action?userId="+userId;
            })
            $(".distribute").click(function () {
                var userId = $(this).attr("name");
                location.href="${path}/baseUser/distributeLoad.action?userId="+userId;
            })
            $("#searchBtn").click(function () {
                var userName = $("#userName").val();
                var cname = $("#cname").val();
                var sex = $("#sex").val();
                location.href = "${path}/baseUser/search.action?userName="+userName+"&cname="+cname+"&sex="+sex;
            })
        })
    </script>
</head>
<body class="main">
    <div class="search">
        <span>
            用户名<input type="text" id="userName" value="${searchObjcet.userName}">
        </span>
        <span>
            姓名<input type="text" id="cname" value="${searchObjcet.cname}">
        </span>
        <span>
            性别<input type="text" id="sex" value="${searchObjcet.sex}">
        </span>
        <span>
            <button id="searchBtn">查询</button>
        </span>
        <span>
            <button id="addBtn">增加</button>
        </span>
    </div>
    <table cellpadding="0" cellspacing="0">
        <thead>
            <td>序号</td>
            <td>用户名</td>
            <td>姓名</td>
            <td>性别</td>
            <td>科室</td>
            <td>编辑</td>
            <td>删除</td>
        </thead>
        <tbody>
            <c:forEach items="${list}" var="baseUser" varStatus="status">
                <tr>
                    <td>${status.index+1}</td>
                    <td>${baseUser.userName}</td>
                    <td>${baseUser.cname}</td>
                    <td>${baseUser.sex}</td>
                    <td>${baseUser.deptId}</td>
                    <td><img src="${path}/images/edit.gif" alt="" class="edit" name="${baseUser.userId}"></td>
                    <td><img src="${path}/images/del.gif" class="del" name="${baseUser.userId}"></td>
                    <td><img src="${path}/images/distribute.gif" class="distribute" name="${baseUser.userId}"></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
