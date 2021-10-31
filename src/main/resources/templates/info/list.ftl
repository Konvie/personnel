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
                    <#--显示系统时间-->
                    <div class="showTime">当前时间：2021年8月17-12时35分16秒</div>
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
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list salariesPageList.content as information>
                            <tr>
                                <td>${salaries_index+1}</td>
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
                                <a href="/personnel/information/list?page=${currentPage - 1}&size=${size}">上一页</a>
                            </li>
                        </#if>
                        <#--上一页处理 end-->
                        <#--代循环遍历(根据DB中查询出来的带分页查询所有订单列表)-->
                        <#list 1..salariesPageList.getTotalPages() as index>
                        <#--当前页面置灰-->
                            <#if currentPage == index>
                                <li class="disabled">
                                    <a href="/personnel/information/list?page=${index}&size=${size}">${index}</a>
                                </li>
                            <#else>
                                <li>
                                    <a href="/personnel/information/list?page=${index}&size=${size}">${index}</a>
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
                                <a href="/personnel/information/list?page=${currentPage + 1}&size=${size}">上一页</a>
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