<html>
<#-- (1) 引入头文件 -->
<#include  "../common/header.ftl">

<body>
<!-- (2)复制 从 http://www.ibootstrap.cn 里面下载的内容 -->
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
                        <th>员工ID</th>
                        <th>员工出勤</th>
                        <th>员工迟到</th>
                        <th>员工评级</th>
                        <th>加班工时</th>
                        <th>员工备注</th>

                        <th colspan="2">操作</th>
                        </thead>

                        <tbody>
                        <#if evaluationPageList.content??>
                            <#list evaluationPageList.content as evaluation>
                                <tr>
                                    <td>${evaluation.empId}</td>
                                    <td>${evaluation.evaAttendance}</td>
                                    <td>${evaluation.evaLate}</td>
                                    <td>${evaluation.evaLevel}</td>
                                    <td>${evaluation.evaOvertime}</td>
                                    <td>${evaluation.evaRemarks}</td>

                                    <td><a href="/personnel/evaluation/index?empId=${evaluation.empId}">修改</a></td>
                                    <td><a href="/personnel/evaluation/delete?empId=${evaluation.empId}">删除</a></td>
                                </tr>
                            </#list>
                        </#if>
                        </tbody>
                        <#--主要内容content end -->
                    </table>
                </div>
                <!-- 表格内容 start  -->

                <!-- 分页 start -->
                <div class="col-md-12 column">
                    <ul class="pagination pull-right"> <!-- 让分页居右-->
                        <!-- 上一页处理  start-->
                        <#if currentPage lte 1>
                            <li class="disabled">
                                <a href="#">上一页</a>
                            </li>
                        <#else>
                            <li>
                                <a href="/personnel/evaluation/list?page=${currentPage - 1}&size=${pageSize}">上一页</a>
                            </li>
                        </#if>

                        <!-- 上一页处理  end-->
                        <!-- 代循环遍历(根据DB中查询出来的 带分页查询所有的订单列表) start-->
                        <#list 1..evaluationPageList.getTotalPages() as index>
                            <!--  让当前页置灰  -->
                            <#if currentPage == index>
                                <li class="disabled">
                                    <a href="/personnel/evaluation/list?page=${index}&size=${pageSize}">${index}</a>
                                </li>
                            <#else>
                                <li>
                                    <a href="/personnel/evaluation/list?page=${index}&size=${pageSize}">${index}</a>
                                </li>
                            </#if>
                        </#list>

                        <!-- 代循环遍历(根据DB中查询出来的 带分页查询所有的订单列表) start-->
                        <!-- 下一页处理  start-->
                        <#if currentPage gte evaluationPageList.getTotalPages()>
                            <li class="disabled">
                                <a href="#">下一页</a>
                            </li>
                        <#else>
                            <li>
                                <a href="/personnel/evaluation/list?page=${currentPage + 1}&size=${pageSize}">下一页</a>
                            </li>
                        </#if>
                        <!-- 下一页处理  end-->
                    </ul>
                    <!-- 分页 end -->
                </div>
            </div>
        </div>
        <!-- (4) 主要内容content end -->
    </div>
    <!-- (2)自己写的div end -->
</div>
</body>
</html>