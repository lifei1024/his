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
<form action="${path}/doctorMenu/updateSelective.action">
    <h1>修改套餐管理</h1> 
    <input type="hidden" name="menuId" value="${doctorMenu.menuId}"> 
    <div class="update"> 
        <div class="left"> 
            <span>套餐名称</span> 
            <%--<input type="text" name="menuName" value="${doctorMenu.menuName}">--%>
            <span>${doctorMenu.menuName}</span>
        </div> 
        <div class="right"> 
            <span>用户</span> 
            <input type="text" name="userId" value="${doctorMenu.userId}"> 
        </div> 
        <div class="left"> 
            <span>套餐描述</span> 
            <input type="text" name="description" value="${doctorMenu.description}"> 
        </div> 
        <div class="right"> 
            <span>套餐类型</span>
            <select name="type">
                <option value="${doctorMenu.type}">
                    <c:choose>
                        <c:when test="${doctorMenu.type==1}">自用</c:when>
                        <c:when test="${doctorMenu.type==2}">科内使用</c:when>
                        <c:when test="${doctorMenu.type==3}">所有人</c:when>
                    </c:choose>
                </option>
                <option value="1">自用</option>
                <option value="2">科内使用</option>
                <option value="3">所有人</option>
            </select>
            <%--<input type="text" name="type" value="${doctorMenu.type}"> --%>
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
 
