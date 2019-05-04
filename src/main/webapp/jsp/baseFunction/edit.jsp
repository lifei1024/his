<%-- 
  Created by IntelliJ IDEA. 
  2018/12/11 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <title>Title</title>
</head> 

<body class="main"> 
<form action="${path}/baseFunction/update.action"> 
    <h1>修改功能管理</h1> 
    <input type="hidden" name="fid" value="${baseFunction.fid}"> 
    <div class="update"> 
        <div class="left"> 
            <span>功能名称</span> 
            <input type="text" name="fname" value="${baseFunction.fname}"> 
        </div> 
        <div class="right"> 
            <span>模块ID</span> 
            <input type="text" name="mid" value="${baseFunction.mid}"> 
        </div> 
        <div class="left"> 
            <span>url地址</span> 
            <input type="text" name="url" value="${baseFunction.url}"> 
        </div> 
        <div class="right"> 
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
 
