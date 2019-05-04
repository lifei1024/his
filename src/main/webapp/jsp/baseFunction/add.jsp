<%-- 
  Created by IntelliJ IDEA. 
  2018/12/11 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@ include file="/common/common.jsp"%>
<html> 
<head> 
    <title>Title</title>
    <script>
        $(function () {
            $.get("${path}/baseModule/toplist.action",function (data) {
                var $select = $("#mid");
                $(data).each(function () {
                    var $option = $("<option value='"+this.mid+"'>"+this.mname+"</option>")
                    $option.appendTo($select);
                })
            },"json")
        })
    </script>
</head> 

<body class="main"> 
<form action="${path}/baseFunction/insert.action"> 
    <h1>添加功能管理</h1> 
    <div class="update"> 
        <div class="left"> 
            <span>功能名称</span> 
            <input type="text" name="fname" value=""> 
        </div> 
        <div class="right"> 
            <span>模块名称</span>
            <select name="mid" id="mid">
                <option></option>
            </select>
            <%--<input type="text" name="mid" value=""> --%>
        </div> 
        <div class="left"> 
            <span>url地址</span> 
            <input type="text" name="url" value=""> 
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
 
