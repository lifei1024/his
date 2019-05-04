<%-- 
  Created by IntelliJ IDEA. 
  2018/12/21 
  To change this template use File | Settings | File Templates. 
--%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@include file="/common/common.jsp"%> 
<html> 
<head> 
    <title>Title</title>
</head> 
<script>
    $(function () {
        $.get("${path}/basePatientInfo/ajaxList.action",function (data) {
            var $select = $("#patientId");
            $(data).each(function () {
                var $option = $("<option value='"+this.patientId+"'>"+this.patientName+"</option>");
                $option.appendTo($select);
            })
        },"json")
        $.get("${path}/baseDept/ajaxList.action",function (data) {
            var $select = $("#deptId");
            $(data).each(function () {
                var $option = $("<option value='"+this.deptId+"'>"+this.deptName+"</option>");
                $option.appendTo($select);
            })
        },"json")
        $("#deptId").change(function () {
            $("#doctorId").find(".option").remove();
            var deptId =  $("#deptId").val();
            $.get("${path}/baseUser/ajaxLists.action",{deptId:deptId},function (data) {
                var $select = $("#doctorId");
                $(data).each(function () {
                    var $option = $("<option value='"+this.userId+"' class='option'>"+this.cname+"</option>");
                    $option.appendTo($select);
                })
            },"json")
        })
        $("#patientId").change(function () {
            var a = $(this).val();
            if (a!=null && a!=""){
                $.get("${path}/basePatientInfo/ajaxload.action",{a:a},function (data) {
                    var $update = $("#information");
                    $update.html("");
                    var $2 = $("<span class='left'>日期：<span style='color: red'>"+data.birth+"</span></span>");
                    $update.append($2);
                    var $3 = $("<span class='right'>性别：<span style='color: red'>"+data.sex+"</span></span>");
                    $update.append($3);
                    var $4 = $("<span class='left'>地址：<span style='color: red'>"+data.address+"</span></span>");
                    $update.append($4);
                    var $5 = $("<span class='right'>电话：<span style='color: red'>"+data.phonenum+"</span></span>");
                    $update.append($5);
                    var $6 = $("<span class='left'>身份证号：<span style='color: red'>"+data.personid+"</span></span>");
                    $update.append($6);
                },"json")
            }
        })

        $("#b").keyup(function () {
            var c = $("#patientId").val();
            if (c!=null&&c!=""){
                $.get("${path}/basePatientInfo/ajaxload.action",{a:c},function (data) {
                    var $update = $("#information");
                    $update.html("");
                    var $2 = $("<span class='left'>日期：<span style='color: red'>"+data.birth+"</span></span>");
                    $update.append($2);
                    var $3 = $("<span class='right'>性别：<span style='color: red'>"+data.sex+"</span></span>");
                    $update.append($3);
                    var $4 = $("<span class='left'>地址：<span style='color: red'>"+data.address+"</span></span>");
                    $update.append($4);
                    var $5 = $("<span class='right'>电话：<span style='color: red'>"+data.phonenum+"</span></span>");
                    $update.append($5);
                    var $6 = $("<span class='left'>身份证号：<span style='color: red'>"+data.personid+"</span></span>");
                    $update.append($6);
                },"json")
            }
        })

    })
</script>
<style>
    #patientId{
        width: 100px;
    }
    #b{
        width:100px;
    }
</style>
<body class="main"> 
<form action="${path}/patientRegisterRecord/insert.action"> 
    <h1>添加挂号</h1> 
    <div class="update"> 
        <div class="left">
            <span>病人</span>
            <%--<select name="patientId" id="patientId"></select>--%>
            <select name="patientId" id="patientId">
                <option value=""></option>
            </select>
            <input type="text" name="b" id="b" onkeyup="init(this)" />
            <%--<label id="label"></label>--%>
            <%--<input type="text" name="patientId" value=""> --%>
        </div>
        <script>
            function init(o){
                var a =document.getElementById('patientId');
                var b =document.getElementById('label');
                for(var i=0;i<a.options.length;i++)
                    if (a.options[i].innerHTML==o.value){
                        a.selectedIndex=i;
//                        b.innerHTML= "value="+a.options[i].value;
                        return;
                        break;
                    }
                a.selectedIndex=0;
//                b.innerHTML= "";
            }
        </script>
        <div class="right"> 
            <span>部门</span>
            <select name="deptId" id="deptId"><option value=""></option></select>
            <%--<input type="text" name="deptId" value="">--%>
        </div> 
        <%--<div class="left"> --%>
            <%--<span>挂号时间</span> --%>
            <%--<input type="date" name="registerDate" value=""> --%>
        <%--</div> --%>
        <%--<div class="right"> --%>
            <%--<span>挂号人</span> --%>
            <%--<input type="text" name="recordUser" value=""> --%>
        <%--</div> --%>
        <div class="left"> 
            <span>医生</span>
            <select name="doctorId" id="doctorId"><option value=""></option></select>
            <%--<input type="text" name="doctorId" value=""> --%>
        </div> 
        <%--<div class="right"> --%>
            <%--<span>状态</span> --%>
            <%--<input type="text" name="status" value=""> --%>
        <%--</div> --%>
        <div id="error"></div> 
        <div class="buttons"> 
            <input type="submit" value="提交"> 
            <input type="button" onclick="history.back()" value="返回"> 
        </div>
        <div id="information" style="margin-left: 75px;margin-top: 40px"></div>
    </div>
</form> 
</body> 
</html> 
 
