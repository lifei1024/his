<%-- 
  Created by IntelliJ IDEA. 
  2018/12/05 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%>
<%
    String cid = request.getParameter("cid");
%>
<html> 
<head> 
    <title>Title</title>
</head> 

<body class="main"> 
<form action="${path}/telvisit/insert.action"> 
    <h1>添加回访记录</h1> 
    <div class="update"> 
        <div class="left"> 
            <span>回访人姓名</span> 
            <input type="text" name="telname" value=""> 
        </div> 
        <div class="right"> 
            <span>回访时间</span> 
            <input type="date" name="teltime" value=""> 
        </div> 
        <div class="left"> 
            <span>回访分类</span>
            <select name="visitreason">
                <option></option>
                <option value="售后回访">售后回访</option>
                <option value="销售意向回访">销售意向回访</option>
                <option value="满意度回访">满意度回访</option>
            </select>
        </div>
        <div class="right"> 
            <span>回访结果</span> 
            <input type="text" name="visitreturn" value=""> 
        </div> 
        <div class="left"> 
            <span>回访方式</span> 
            <input type="text" name="visittype" value=""> 
        </div> 
        <div class="right"> 
            <input type="hidden" name="cid" value="<%=cid%>">
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
 
