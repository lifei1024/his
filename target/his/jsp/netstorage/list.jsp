<%-- 
  Created by IntelliJ IDEA. 
  2018/12/24 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <script type="text/javascript"> 
        $(function () { 
            $("#addBtn").click(function () { 
                location.href="${path}/jsp/netstorage/add.jsp";
             })
            $(".update").click(function () { 
                var fileid = $(this).attr("name");
                location.href="${path}/netstorage/load.action?fileid="+fileid;
             })
            $(".delete").click(function () { 
                var fileid = $(this).attr("name");
                location.href="${path}/netstorage/delete.action?fileid="+fileid;
             })
            $("#search").click(function () { 
                var filename = $("#filename").val();
                location.href = "${path}/netstorage/search.action?filename="+filename;
             })
            $("#deleteBtn").click(function () {
                var url = "${path}/netstorage/deleteBantch.action?a=a";
                $(":checked").each(function () {
                    url+="&fileid="+$(this).val();
                })
                location.href = url;
            })
        })  
    </script> 
</head> 
<body class="main"> 
    <div class="search"> 
        <span> 
            文件名：<input type="text" id="filename" value="${searchObject.filename}"> 
        </span> 
        <span> 
            <button id="search">查询</button> 
        </span> 
        <span> 
            <button id="addBtn">增加</button> 
        </span>
        <span>
            <button id="deleteBtn">批量删除</button>
        </span>
    </div> 
    <table> 
        <thead>
            <td></td>
            <td>序号</td> 
            <td>文件名</td> 
            <td>文件长度</td> 
            <td>上传时间</td> 
            <td>用户id</td> 
            <td>编辑</td> 
            <td>删除</td> 
        </thead> 
        <c:forEach items="${list}" var="netstorage" varStatus="status"> 
            <tr>
                <td><input type="checkbox" value="${netstorage.fileid}"></td>
                <td>${status.index+1}</td> 
                <td>${netstorage.filename}</td> 
                <td>${netstorage.filesize}</td> 
                <td>${netstorage.uploaddate}</td> 
                <td>${netstorage.baseUser.cname}</td>
                <td><img src="${path}/images/edit.gif" class="update" name="${netstorage.fileid}"></td> 
                <td><img src="${path}/images/del.gif" class="delete" name="${netstorage.fileid}"></td> 
            </tr> 
        </c:forEach> 
    </table> 
</body> 
</html> 
