<%--
  Created by IntelliJ IDEA.
  User: 18203709505
  Date: 2019/3/25
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <!-- 插件使用的样式表文件，分bootstrap2和bootstrap3两个环境使用，根据使用环境引用 -->
    <!-- bootstrap2环境使用 -->
    <link rel="stylesheet" type="text/css" href="css/b.page.css" />
    <!-- bootstrap3环境使用 -->
    <link rel="stylesheet" type="text/css" href="css/b.page.bootstrap3.css" />
    <!-- 引入js -->
    <script type="text/javascript" src="js/b.page.js"></script>
</head>
<body>
<!-- 页面跳转模式为例 -->
<!-- 前提条件为服务端已将分页数据设置到request中 -->
<!-- 设置表格，内容区域中使用服务端的el表达式循环生成表格内容 -->
<table class="bTable table table-striped table-bordered table-hover table-condensed">
    <thead>
    <tr>
        <th class="selectColumn">选择</th>
        <th>登录名</th>
        <th>姓名</th>
        <th>性别</th>
        <th>出生年月</th>
        <th>电话</th>
        <th>电子邮箱</th>
        <th>状态</th>
        <th>更新时间</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${userList.list != null}">
        <c:forEach var="d" items="${userList.list}">
            <tr class="<c:if test=" ${d.status==0}">error
				</c:if>" id="${d.id}">
                <td class="selectColumn"><input type="radio" name="userSelect" value="${d.id}" /></td>
                <td>${d.login_name}</td>
                <td>${d.name}</td>
                <td>${d.sexName}</td>
                <td>
                    <fmt:formatDate pattern="yyyy-MM-dd" value="${d.birthday}" type="date" />
                </td>
                <td>${d.phone1}</td>
                <td>${d.email}</td>
                <td>${d.statusName}</td>
                <td>
                    <fmt:formatDate pattern="yyyy-MM-dd" value="${d.update_time}" type="date" />
                </td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
<!-- 必须设置以下分页信息设置，否则插件将无法读取分页数据-->
<!-- 隐藏内容设置后，在插件初始化时进行读取-->
<c:if test="${userList != null}">
    <input type="hidden" id="pageNumber" value="${userList.pageNumber}">
    <input type="hidden" id="pageSize" value="${userList.pageSize}">
    <input type="hidden" id="totalPage" value="${userList.totalPage}">
    <input type="hidden" id="totalRow" value="${userList.totalRow}">
</c:if>
</body>
<script>
    $('#page1').bPage({
        //分页目标链接
        url : $webroot + 'demo/manage/page',
        //读取页面设置的分页参数
        totalPage : $('#totalPage').val(),
        totalRow : $('#totalRow').val(),
        pageSize : $('#pageSize').val(),
        pageNumber : $('#pageNumber').val(),
        //自定义传递到服务端的参数
        params : function(){
            return {
                userName : 'zhangsan',
                age : 42
            };
        }
    });
</script>
</html>

<!--Bpage/index.jsp-->