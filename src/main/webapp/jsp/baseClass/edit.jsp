<%-- 
  Created by IntelliJ IDEA. 
  2019/01/14 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <title>Title</title>
</head> 

<body class="main"> 
<form action="${path}/baseClass/update.action"> 
    <h1>修改班级</h1> 
    <input type="hidden" name="classId" value="${baseClass.classId}"> 
    <div class="update"> 
        <div class="left"> 
            <span>班级姓名</span> 
            <input type="text" name="className" value="${baseClass.className}"> 
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
 
