<%-- 
  Created by IntelliJ IDEA. 
  2018/12/27 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <title>Title</title>
</head> 

<body class="main"> 
<form action="${path}/doctorVisitRecordinfo/insert.action"> 
    <h1>添加医生就诊访问</h1> 
    <div class="update"> 
        <div class="left"> 
            <span>就诊记录ID</span> 
            <input type="text" name="vrId" value=""> 
        </div> 
        <div class="right"> 
            <span>药品</span> 
            <input type="text" name="codeId" value=""> 
        </div> 
        <div class="left"> 
            <span>药品数量</span> 
            <input type="text" name="amt" value=""> 
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
 
