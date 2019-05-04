<%-- 
  Created by IntelliJ IDEA. 
  2018/12/19 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <title>Title</title>
</head> 

<body class="main"> 
<form action="${path}/doctorMenu/insert.action"> 
    <h1>添加套餐管理</h1> 
    <div class="update"> 
        <div class="left"> 
            <span>套餐名称</span> 
            <input type="text" name="menuName" value=""> 
        </div> 
        <%--<div class="right"> --%>
            <%--<span>用户</span> --%>
            <%--<input type="text" name="userId" value=""> --%>
        <%--</div> --%>
        <div class="left"> 
            <span>套餐描述</span> 
            <input type="text" name="description" value=""> 
        </div> 
        <div class="right"> 
            <span>套餐类型</span>
            <select name="type">
                <option>请选择使用范围</option>
                <option value="1">自用</option>
                <option value="2">科内使用</option>
                <option value="3">所有人</option>
            </select>
            <%--<input type="text" name="type" value=""> --%>
        </div> 
        <div id="error"></div> 
        <div class="buttons"> 
            <input type="submit" value="提交"> 
            <input type="button" onclick="history.back()" value="返回"> 
        </div> 
    </div> 
</form> 
</body> 
</html> 
 
