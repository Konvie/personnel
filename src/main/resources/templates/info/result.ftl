<html>

<#-- (1) 引入头文件 -->
<#include  "../common/header.ftl">

<body>
<!-- (2)复制  -->
<!-- 自己写的div start -->
<div id="wrapper" class="toggled">

    <#-- (3)边栏sidebar-->
    <#include  "../common/nav.ftl">
    <!-- (4) 主要内容content start -->
    <div class="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <#--显示系统时间-->
                <div class="showTime">当前时间：2021年8月17-12时35分16秒</div>
                <!-- 表格内容 start  -->
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <th>员工编号</th>
                        <th>员工姓名</th>
                        <th>基本金额</th>
                        <th>奖金金额</th>
                        <th>奖金描述</th>
                        <th>扣除金额</th>
                        <th>扣除描述</th>
                        <th>保险福利</th>
                        <th>最终金额</th>
                        <th>备注</th>
                        <th colspan="2">操作</th>
                        </thead>

                        <tbody>
                        <tr>
                            <td>${information.empId}</td>
                            <td>${information.empName}</td>
                            <td>${information.salBase}</td>
                            <td>${information.salBonus}</td>
                            <td>${information.salBonusDescribes}</td>
                            <td>${information.salFine}</td>
                            <td>${information.salFineDescribes}</td>
                            <td>${information.salBenefits}</td>
                            <td>${information.salFinal}</td>
                            <td>${information.salRemarks}</td>
                            <td><a href="/personnel/information/index?empId=${information.empId}">修改</a></td>
                            <td><a href="/personnel/information/delete?empId=${information.empId}">删除</a></td>
                        </tr>
                        </tbody>

                        <#--主要内容content end -->
                    </table>
                </div>
                <!-- 表格内容 end  -->


            </div>
        </div>
    </div>
    <!-- (4) 主要内容content end -->
</div>
<!-- (2)自己写的div end -->
</body>
</html>
