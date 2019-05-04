<%--
  Created by IntelliJ IDEA. 
  2018/12/10 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <script type="text/javascript"> 
        $(function () { 
            $("#addBtn").click(function () { 
                location.href="${path}/jsp/medicinePurchaseInfo/add.jsp";
             })
            $("#purBtn").click(function () {
                location.href="${path}/medicinePurchaseInfo/purchaseInfo.action";
             });
            $(".update").click(function () { 
                var pchId = $(this).attr("name");
                location.href="${path}/medicinePurchaseInfo/load.action?pchId="+pchId;
             })
            $(".delete").click(function () { 
                var pchId = $(this).attr("name");
                location.href="${path}/medicinePurchaseInfo/delete.action?pchId="+pchId;
             })
            $("#search").click(function () { 
                var medicineCodeid = $("#medicineCodeid").val();
                location.href = "${path}/medicinePurchaseInfo/search.action?medicineCodeid="+medicineCodeid;
             })
            $("#WHBtn").click(function () {
                var url = "${path}/medicinePurchaseInfo/instock.action?a=a";
                $(":checked").each(function () {
                    var invno = $(this).parents("tr").find(".invno").val();
                    url+="&pchId="+$(this).val();
                    if(invno!=null){
                        url+="&invno="+invno;
                    }
                })
                location.href = url;
            })


        })  
    </script> 
</head> 
<body class="main"> 
    <div class="search"> 
        <span> 
            药品：<input type="text" id="medicineCodeid" value="${searchObject.medicineCodeid}"> 
        </span> 
        <span> 
            <button id="search">查询</button> 
        </span> 
        <span> 
            <button id="addBtn">增加</button> 
        </span>
        <span>
            <button id="purBtn">汇总</button>
        </span>
        <span>
            <button id="WHBtn">添加入库</button>
        </span>
    </div> 
    <table> 
        <thead>
            <td></td>
            <td>序号</td> 
            <td>药品</td> 
            <td>供应商</td> 
            <td>采购数量</td> 
            <td>采购单价</td> 
            <td>采购总价</td> 
            <td>状态</td>
            <td>汇总日期</td> 
            <td>审批人</td> 
            <td>审批日期</td>
            <td>发票号</td>
            <td>编辑</td> 
            <td>删除</td> 
        </thead>
        <c:forEach items="${list}" var="medicinePurchaseInfo" varStatus="status"> 
            <tr>
                <td><input type="checkbox" class="pchid" value="${medicinePurchaseInfo.pchId}"></td>
                <td>${status.index+1}</td>
                <td>${medicinePurchaseInfo.medicineCode.medicineName}</td>
                <td>${medicinePurchaseInfo.baseManufacturer.manChnName}</td>
                <td>${medicinePurchaseInfo.pchAmt}</td> 
                <td>${medicinePurchaseInfo.pchPrice}</td> 
                <td>${medicinePurchaseInfo.pchTotal}</td>
                <c:choose>
                    <c:when test="${medicinePurchaseInfo.status==1}">
                        <td>未审批</td>
                    </c:when>
                    <c:when test="${medicinePurchaseInfo.status==2}">
                        <td>已审批</td>
                    </c:when>
                    <c:when test="${medicinePurchaseInfo.status==3}">
                        <td>已汇总</td>
                    </c:when>
                    <c:when test="${medicinePurchaseInfo.status==5}">
                        <td>已入库</td>
                    </c:when>
                    <c:otherwise>
                        <td>已采购</td>
                    </c:otherwise>
                </c:choose>
                <td>${medicinePurchaseInfo.pchDate}</td> 
                <td>${medicinePurchaseInfo.baseUser.cname}</td>
                <td>${medicinePurchaseInfo.apprvDate}</td>
                <td><input type="text" class="invno"></td>
                <td><img src="${path}/images/edit.gif" class="update" name="${medicinePurchaseInfo.pchId}"></td> 
                <td><img src="${path}/images/del.gif" class="delete" name="${medicinePurchaseInfo.pchId}"></td> 
            </tr> 
        </c:forEach> 
    </table> 
</body> 
</html> 
