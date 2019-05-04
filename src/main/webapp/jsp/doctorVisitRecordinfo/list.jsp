<%-- 
  Created by IntelliJ IDEA. 
  2018/12/27 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <script type="text/javascript"> 
        $(function () { 
            $("#addBtn").click(function () { 
                location.href="${path}/jsp/doctorVisitRecordinfo/add.jsp";
             })
            $(".update").click(function () { 
                var infoId = $(this).attr("name");
                location.href="${path}/doctorVisitRecordinfo/load.action?infoId="+infoId;
             })
            $(".delete").click(function () { 
                var infoId = $(this).attr("name");
                location.href="${path}/doctorVisitRecordinfo/delete.action?infoId="+infoId;
             })
            $("#search").click(function () { 
                var vrId = $("#vrId").val();
                location.href = "${path}/doctorVisitRecordinfo/search.action?vrId="+vrId;
             })
        })  
    </script> 
</head> 
<body class="main"> 
    <div class="search"> 
        <span> 
            就诊记录ID：<input type="text" id="vrId" value="${searchObject.vrId}"> 
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
            <td>就诊记录ID</td> 
            <td>药品</td> 
            <td>药品数量</td> 
            <td>编辑</td> 
            <td>删除</td> 
        </thead> 
        <c:forEach items="${list}" var="doctorVisitRecordinfo" varStatus="status"> 
            <tr> 
                <td>${status.index+1}</td> 
                <td>${doctorVisitRecordinfo.vrId}</td> 
                <td>${doctorVisitRecordinfo.codeId}</td> 
                <td>${doctorVisitRecordinfo.amt}</td> 
                <td><img src="${path}/images/edit.gif" class="update" name="${doctorVisitRecordinfo.infoId}"></td> 
                <td><img src="${path}/images/del.gif" class="delete" name="${doctorVisitRecordinfo.infoId}"></td> 
            </tr> 
        </c:forEach> 
    </table> 
</body> 
</html> 
