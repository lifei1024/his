<%-- 
  Created by IntelliJ IDEA. 
  2018/12/10 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <title>Title</title>
</head> 

<body class="main"> 
<form action="${path}/medicinePurchaseInfo/insert.action"> 
    <h1>添加采购信息</h1> 
    <div class="update"> 
        <div class="left"> 
            <span>药品</span> 
            <input type="text" name="medicineCodeid" value=""> 
        </div> 
        <div class="right"> 
            <span>供应商</span> 
            <input type="text" name="manCode" value=""> 
        </div> 
        <div class="left"> 
            <span>采购数量</span> 
            <input type="text" name="pchAmt" value=""> 
        </div> 
        <div class="right"> 
            <span>采购单价</span> 
            <input type="text" name="pchPrice" value=""> 
        </div> 
        <div class="left"> 
            <span>采购总价</span> 
            <input type="text" name="pchTotal" value=""> 
        </div> 
        <div class="right"> 
            <span>状态</span> 
            <input type="text" name="status" value=""> 
        </div> 
        <div class="left"> 
            <span>汇总人</span> 
            <input type="text" name="pchUserid" value=""> 
        </div> 
        <div class="right"> 
            <span>汇总日期</span> 
            <input type="date" name="pchDate" value=""> 
        </div> 
        <div class="left"> 
            <span>审批人</span> 
            <input type="text" name="apprvUserid" value=""> 
        </div> 
        <div class="right"> 
            <span>审批日期</span> 
            <input type="date" name="apprvDate" value=""> 
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
 
