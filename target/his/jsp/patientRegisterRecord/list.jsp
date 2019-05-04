<%-- 
  Created by IntelliJ IDEA. 
  2018/12/21 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <script type="text/javascript"> 
        $(function () { 
            $("#addBtn").click(function () { 
                location.href="${path}/jsp/patientRegisterRecord/add.jsp";
             })
            $("#btns").click(function () {
                location.href="../Visit/visit.jsp";
            })
            $(".update").click(function () { 
                var registerId = $(this).attr("name");
                location.href="${path}/patientRegisterRecord/load.action?registerId="+registerId;
             })
            $(".delete").click(function () { 
                var registerId = $(this).attr("name");
                location.href="${path}/patientRegisterRecord/delete.action?registerId="+registerId;
             })
            $("#search").click(function () { 
                var patientId = $("#patientId").val();
                location.href = "${path}/patientRegisterRecord/search.action?patientId="+patientId;
             })
        })  
    </script> 
</head> 
<body class="main"> 
    <div class="search"> 
        <span> 
            病人：<input type="text" id="patientId" value="${searchObject.patientId}"> 
        </span> 
        <span> 
            <button id="search">查询</button> 
        </span> 
        <span> 
            <button id="addBtn">增加</button> 
        </span>
        <span>
            <button id="btns">sss</button>
        </span>
    </div> 
    <table> 
        <thead> 
            <td>序号</td> 
            <td>病人</td> 
            <td>部门</td> 
            <td>挂号时间</td>
            <td>医生</td>
            <td>状态</td> 
            <td>编辑</td> 
            <td>删除</td> 
        </thead> 
        <c:forEach items="${list}" var="patientRegisterRecord" varStatus="status"> 
            <tr> 
                <td>${status.index+1}</td> 
                <td>${patientRegisterRecord.basePatientInfo.patientName}</td>
                <td>${patientRegisterRecord.baseDept.deptName}</td>
                <td>${patientRegisterRecord.registerDate}</td>
                <td>${patientRegisterRecord.baseUser.cname}</td>
                <td>
                    <c:choose>
                        <c:when test="${patientRegisterRecord.status==1}">已挂号</c:when>
                        <c:when test="${patientRegisterRecord.status==2}">已就诊</c:when>
                    </c:choose>
                </td>
                <td><img src="${path}/images/edit.gif" class="update" name="${patientRegisterRecord.registerId}"></td> 
                <td><img src="${path}/images/del.gif" class="delete" name="${patientRegisterRecord.registerId}"></td> 
            </tr> 
        </c:forEach> 
    </table> 
</body> 
</html> 
