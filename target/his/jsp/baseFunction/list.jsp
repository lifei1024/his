<%-- 
  Created by IntelliJ IDEA. 
  2018/12/11 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <script type="text/javascript"> 
        $(function () { 
            $("#addBtn").click(function () { 
                location.href="${path}/jsp/baseFunction/add.jsp";
             })
            $(".update").click(function () { 
                var fid = $(this).attr("name");
                location.href="${path}/baseFunction/load.action?fid="+fid;
             })
            $(".delete").click(function () { 
                var fid = $(this).attr("name");
                location.href="${path}/baseFunction/delete.action?fid="+fid;
             })
            $("#search").click(function () { 
                var fname = $("#fname").val();
                location.href = "${path}/baseFunction/search.action?fname="+fname;
             })
        })  
    </script> 
</head> 
<body class="main"> 
    <div class="search"> 
        <span> 
            功能名称：<input type="text" id="fname" value="${searchObject.fname}"> 
        </span> 
        <span> 
            <button id="search">查询</button> 
        </span> 
        <span> 
            <button id="addBtn">增加</button> 
        </span> 
    </div> 
    <table> 
        <thead> 
            <td>序号</td> 
            <td>功能名称</td> 
            <td>模块ID</td> 
            <td>url地址</td> 
            <td>编辑</td> 
            <td>删除</td> 
        </thead> 
        <c:forEach items="${list}" var="baseFunction" varStatus="status"> 
            <tr> 
                <td>${status.index+1}</td> 
                <td>${baseFunction.fname}</td> 
                <td>${baseFunction.mid}</td> 
                <td>${baseFunction.url}</td> 
                <td><img src="${path}/images/edit.gif" class="update" name="${baseFunction.fid}"></td> 
                <td><img src="${path}/images/del.gif" class="delete" name="${baseFunction.fid}"></td> 
            </tr> 
        </c:forEach> 
    </table> 
</body> 
</html> 
