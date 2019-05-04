<%-- 
  Created by IntelliJ IDEA. 
  2018/12/19 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%>
<%
    String menuId = request.getParameter("menuId");
%>
<html> 
<head> 
    <title>Title</title>
    <script>
        $(function () {
            $.get("${path}/medicineCode/ajaxList.action",function (data) {
                var $select = $("#codeId");
                $(data).each(function () {
                    var $option = $("<option value='"+this.codeId+"'>"+this.medicineName+"</option>")
                    $option.appendTo($select);
                })
            },"json")
        })
    </script>
</head> 

<body class="main"> 
<form action="${path}/doctorMenuMedicine/insert.action"> 
    <h1>添加药品</h1> 
    <div class="update"> 
        <div class="left">
            <span>药品</span> 
            <%--<input type="text" name="codeId" value="">--%>
            <select name="codeId" id="codeId"></select>
        </div> 
        <div class="right">
            <span>数量</span> 
            <input type="text" name="amt" value=""> 
        </div>
        <div class="left">
            <%--<span>套餐</span> --%>
            <input type="hidden" name="menuId" value="<%=menuId%>">
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
 
