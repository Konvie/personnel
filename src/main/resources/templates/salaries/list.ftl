<html>
<#--引入头文件-->
<#include "../common/header.ftl">

<body>
<div id="wrapper" class="toggled">
    <#--边栏sidebar-->
    <#include "../common/nav.ftl">
    <#--主要内容 content start-->
    <div class="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <#--主要内容 content start-->
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>序号</th>
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
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list salariesPageList.content as salaries>
                            <tr>
                                <td>${salaries_index+1}</td>
                                <td>${salaries.empId}</td>
                                <td>${salaries.empName}</td>
                                <td>${salaries.salBase}</td>
                                <td>${salaries.salBonus}</td>
                                <td>${salaries.salBonusDescribes}</td>
                                <td>${salaries.salFine}</td>
                                <td>${salaries.salFineDescribes}</td>
                                <td>${salaries.salBenefits}</td>
                                <td>${salaries.salFinal}</td>
                                <td>${salaries.salRemarks}</td>
                                <td><a href="/personnel/salaries/index?empId=${salaries.empId}">修改</a></td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                    <#--主要内容 content end-->
                </div>
                <#--分页 start-->
                <div class="col-md-12 column">
                    <ul class="pagination pull-right">  <#--让分页居右-->
                        <#--上一页处理 start-->
                        <#if currentPage lte 1>
                            <li>
                                <a href="#">上一页</a>
                            </li>
                        <#else>
                            <li>
                                <a href="/personnel/salaries/list?page=${currentPage - 1}&size=${size}">上一页</a>
                            </li>
                        </#if>
                        <#--上一页处理 end-->
                        <#--代循环遍历(根据DB中查询出来的带分页查询所有订单列表)-->
                        <#list 1..salariesPageList.getTotalPages() as index>
                        <#--当前页面置灰-->
                            <#if currentPage == index>
                                <li class="disabled">
                                    <a href="/personnel/salaries/list?page=${index}&size=${size}">${index}</a>
                                </li>
                            <#else>
                                <li>
                                    <a href="/personnel/salaries/list?page=${index}&size=${size}">${index}</a>
                                </li>
                            </#if>
                        </#list>
                        <#--代循环遍历(根据DB中查询出来的带分页查询所有订单列表)-->
                        <#-- 下一页处理 start-->
                        <#if currentPage gte salariesPageList.getTotalPages()>
                            <li>
                                <a href="#">下一页</a>
                            </li>
                        <#else>
                            <li>
                                <a href="/personnel/salaries/list?page=${currentPage + 1}&size=${size}">上一页</a>
                            </li>
                        </#if>
                        <#-- 下一页处理 end-->
                    </ul>
                </div>
                <#--分页 end-->
            </div>
        </div>
    </div>
    <#--主要内容 content start-->
</div>
</body>
</html>