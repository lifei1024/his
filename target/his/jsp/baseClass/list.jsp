<%-- 
  Created by IntelliJ IDEA. 
  2019/01/14 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <script type="text/javascript"> 
        $(function () { 
            $("#addBtn").click(function () { 
                location.href="${path}/jsp/baseClass/add.jsp";
             })
            $(".update").click(function () { 
                var classId = $(this).attr("name");
                location.href="${path}/baseClass/load.action?classId="+classId;
             })
            $(".delete").click(function () { 
                var classId = $(this).attr("name");
                location.href="${path}/baseClass/delete.action?classId="+classId;
             })
            $("#search").click(function () { 
                var className = $("#className").val();
                location.href = "${path}/baseClass/search.action?className="+className;
             })
            var a = 0;
            $('#pai').click(function(){
                a++;
                if(a%2!=0){
                    location.href = "${path}/baseClass/searchs1.action";
                }else{
                    location.href = "${path}/baseClass/searchs2.action";
                }

            })

        })  
    </script> 
</head> 
<body class="main"> 
    <div class="search"> 
        <span> 
            班级姓名：<input type="text" id="className" value="${searchObject.className}"> 
        </span> 
        <span> 
            <button id="search">查询</button> 
        </span> 
        <span> 
            <button id="addBtn">增加</button> 
        </span>
        <span>
            <button id="pai">排序</button>
        </span>
    </div> 
    <table> 
        <thead> 
            <td>序号</td> 
            <td>班级姓名</td> 
            <td>编辑</td> 
            <td>删除</td> 
        </thead> 
        <c:forEach items="${list}" var="baseClass" varStatus="status"> 
            <tr> 
                <td>${status.index+1}</td> 
                <td>${baseClass.className}</td> 
                <td><img src="${path}/images/edit.gif" class="update" name="${baseClass.classId}"></td> 
                <td><img src="${path}/images/del.gif" class="delete" name="${baseClass.classId}"></td> 
            </tr> 
        </c:forEach> 
    </table> 
</body> 
</html> 
