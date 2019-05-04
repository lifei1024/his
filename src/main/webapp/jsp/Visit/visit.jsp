<%--
  Created by IntelliJ IDEA.
  User: 18203709505
  Date: 2018/12/26
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/common.jsp"%>
<html>
<head>
    <title>Title</title>
    <script>
        $(function () {
            $.get("${path}/medicineCode/ajaxList.action",function (data) {
                var $select = $("#medicineCodeid");
                $(data).each(function () {
                    var $option = $("<option value='" + this.codeId + "' name='"+this.medicineName+"'>" + this.medicineName + "</option>")
                    $option.appendTo($select);
                })
            },"json")
            $(".a1").click(function () {
                if(confirm('是否治疗该患者？')){
                    $(".a1").removeClass("current1");
                    $(this).addClass("current1");
                    var c = $(this).attr("name");
                    if (c!=null&&c!=""){
                        $.get("${path}/basePatientInfo/ajaxload.action",{a:c},function (data) {
                            var $update = $("#center-left");
                            $update.html("");
                            var $1 = $("<span class='left'>姓名：<span style='color: red'>"+data.patientName+"</span></span><br>");
                            $update.append($1);
                            var $2 = $("<span class='left'>日期：<span style='color: red'>"+data.birth+"</span></span><br>");
                            $update.append($2);
                            var $3 = $("<span class='right'>性别：<span style='color: red'>"+data.sex+"</span></span><br>");
                            $update.append($3);
                            var $4 = $("<span class='left'>地址：<span style='color: red'>"+data.address+"</span></span><br>");
                            $update.append($4);
                            var $5 = $("<span class='right'>电话：<span style='color: red'>"+data.phonenum+"</span></span><br>");
                            $update.append($5);
                            var $6 = $("<span class='left'>身份证号：<span style='color: red'>"+data.personid+"</span></span><br>");
                            $update.append($6);
                        },"json")
                    }
                }

             })
            $(".a2").click(function () {
                $(".a2").removeClass("current2");
                $(this).addClass("current2");
                $("#tables").find(".tables-tr").remove();
                var menuId = $(this).attr("name");
                $.get("${path}/doctorMenuMedicine/ajaxload.action",{a:menuId},function (data) {
                    var $table=$("#tables");
                    $(data).each(function () {
                        var $tr = $('<tr class="tables-tr" name="'+this.codeId+'"> <td>'+this.medicineCode.medicineName+'</td> <td class="ths"><input type="number" class="inW" value="'+this.amt+'" name="'+this.medicineStockinfo.amt+'"></td> <td>'+this.medicineStockinfo.amt+'</td> <td class="tss"><img src="${path}/images/del.gif" class="delete"></td> </tr>');
                        $tr.appendTo($table);
                    })
                },"json")
            })
            $("#tables").delegate(".delete","click",function () {
                $(this).parent().parent().remove();
            })

            $("#codeBtn").click(function () {
                var codeId =$("#medicineCodeid").val();
                var medicineName = $("#medicineCodeid option:selected").attr("name");
                $.get("${path}/medicineStockinfo/ajaxLoad.action",{codeId:codeId},function (data) {
                    var $table=$("#tables");
                    var $tr = $('<tr class="tables-tr" name="'+codeId+'"> <td>'+medicineName+'</td> <td class="ths"><input type="number" class="inW" name="'+data.amt+'" value="1"></td> <td>'+data.amt+'</td> <td class="tss"><img src="${path}/images/del.gif" class="delete"></td> </tr>');
                    $tr.appendTo($table);
                },"json")
            });
            $("#tables").on("change",".inW",function () {
                var attr = $(this).attr("name");
                var val = $(this).val();
                if (attr<val){
                    alert("数量不可以大于库存")
                    $(this).val(attr);
                }
                if(val<0){
                    $(this).val(0);
                }
            })

            $("#btns").click(function () {
                var registerId =$(".reId").attr("name")
                //获取病人id
                var patientId = $(".current1").attr("name");
                //医生id从session里取
                //就诊时间为当前时间
                //获取病人症状
                var symptom = $("#symptom").val();
                //获取医生嘱托
                var advice = $("#advice").val();
                //遍历数量和药品id
                var url = "${path}/doctorVisitRecord/insert.action?patientId="+patientId+"&symptom="+symptom+"&advice="+advice+"&registerId="+registerId+"&a=a";
                $(".tables-tr").each(function () {
                    url+="&codeId="+$(this).attr("name")+"&amt="+$(this).find(".ths").children(".inW").val();
                });
                if(patientId==null){
                    alert("请选择病人！")
                }else if($(".tables-tr").find(".ths").children(".inW").val()==null){
                    alert("请开药！")
                }else {
                    location.href= url;
                }

            })
        })
    </script>
    <style>
        .text{
            width:100%;
            height:30%;
            font-size:18px;
            font-weight: bolder ;
        }
        .current1{
            background-color: red;
        }
        .inW{
            width:50px;
        }
        .current2{
            background-color: green;
        }
        div {border: 1px solid #57CDFF;margin:5px;}
        #page_container {
            border: 0px;
            width:95%;
            margin:0 auto;
            text-align:left;
        }
        #banner {
            text-align: center;
            height:70px;
        }
        #left {
            width:10%;
            height:559px;
            float:left;
            overflow-y:auto;

        }
        #center {
            width:60%;
            height:259px;
            float:left;
            padding: 0;
        }
        #right {
            float:right;
            width:27%;
            height:259px;
            overflow-y:auto
        }
        #bottom {
            width:60%;
            height:289px;
            float:left;
            overflow-y:auto
        }
        #btns{
            width: 19%;
            height: 80px;
            margin-top: 23px;
            margin-left: 75px;
            font-size: 40px;
            color: white;
            background-color: lightskyblue;
            border-radius: 20px;
        }
        .t{
            margin-right: 60px;
        }
        body{
            background-color: #B4EDFF;
        }
        #center-left{
            float: left;
            width:49%;
            height:259px;
            margin: 0;
        }
        #center-right{
            float: right;
            width:50%;
            height:259px;
            margin: 0;
        }
        #right-button{
            text-align: center;
            float:right;
            width:27%;
            height:150px;
        }
        #medicineCodeid{
            width:90%;
            height:45px;
            font-size: 25px;
        }
        #codeBtn{
            width:20%;
            height:35px;
            font-size: 25px;
        }
    </style>
</head>
<body>
<div id="page_container">
    <div id="banner"><h1>医生就诊</h1></div>
    <div id="left" class="main">
        <table style="width:100%;margin-top: 0px;border: none;text-align: center;">
            <thead>
            <td style="text-align: center; font-size: 20px;">病人姓名</td>
            </thead>
            <c:forEach items="${patient}" var="pat" varStatus="status">
                <tr class="a1" name="${pat.patientId}">
                    <td class="reId" style="text-align: center; font-size: 20px;" name="${pat.registerId}">${pat.basePatientInfo.patientName}</td>
                </tr>
            </c:forEach>

        </table>
    </div>
    <div id="center">
        <div id="center-left">
        </div>
        <div id="center-right" class="main">
            <table style="width:100%;margin-top: 0px;">
                <thead>
                <td>序号</td>
                <td>套餐名称</td>
                <td>套餐描述</td>
                </thead>
                <c:forEach items="${doctorMenus}" var="docM" varStatus="status">
                    <tr class="a2" name="${docM.menuId}">
                        <td>${status.index+1}</td>
                        <td>${docM.menuName}</td>
                        <td>${docM.description}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div id="right" class="main">
        <table style="width:100%;margin-top: 0px;" id="tables">
                <thead>
                <td>药品名称</td>
                <td>数量</td>
                <td>库存数量</td>
                <td>删除</td>
                </thead>
        </table>
    </div>
    <div id="right-button">
        <H2>添加药品</H2>
        <select id="medicineCodeid"></select><br>
        <button id="codeBtn">添加</button>
    </div>
    <div id="bottom" class="main">
        <h3>病人症状</h3>
        <textarea class="text" id="symptom" maxlength="100"></textarea>
        <h3>医生嘱托</h3>
        <textarea class="text" id="advice" maxlength="100"></textarea>
    </div>
    <button id="btns"><span class="t">确</span><span class="j">定</span></button>
</div>
</body>
</html>
